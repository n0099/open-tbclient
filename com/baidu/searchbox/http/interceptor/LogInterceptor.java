package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
/* loaded from: classes2.dex */
public class LogInterceptor implements Interceptor {
    public static final String TAG = "http";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public volatile Level level;
    public final Logger logger;

    /* loaded from: classes2.dex */
    public class DefaultLogger implements Logger {
        public String tag;

        public DefaultLogger(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.tag = str;
        }

        @Override // com.baidu.searchbox.http.interceptor.LogInterceptor.Logger
        public void log(String str) {
            Log.d(this.tag, str);
        }
    }

    /* loaded from: classes2.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes2.dex */
    public interface Logger {
        void log(String str);
    }

    public LogInterceptor(String str) {
        this(null, str, Level.NONE);
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
    }

    public static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                if (Character.isISOControl(buffer2.readUtf8CodePoint())) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Headers headers;
        boolean z2;
        Level level = this.level;
        Request request = chain.request();
        if (level != null && level != Level.NONE) {
            boolean z3 = level == Level.BODY;
            boolean z4 = z3 || level == Level.HEADERS;
            RequestBody body = request.body();
            boolean z5 = body != null;
            Connection connection = chain.connection();
            String str = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
            if (!z4 && z5) {
                str = str + " (" + body.contentLength() + "-byte body)";
            }
            this.logger.log(str);
            if (z4) {
                if (z5) {
                    if (body.contentType() != null) {
                        this.logger.log(Part.CONTENT_TYPE + body.contentType());
                    }
                    if (body.contentLength() != -1) {
                        this.logger.log("Content-Length: " + body.contentLength());
                    }
                }
                Headers headers2 = request.headers();
                int size = headers2.size();
                int i = 0;
                while (i < size) {
                    String name = headers2.name(i);
                    int i2 = size;
                    if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                        z2 = z4;
                    } else {
                        z2 = z4;
                        this.logger.log(name + ": " + headers2.value(i));
                    }
                    i++;
                    size = i2;
                    z4 = z2;
                }
                z = z4;
                if (z3 && z5) {
                    if (bodyEncoded(request.headers())) {
                        this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                    } else {
                        Buffer buffer = new Buffer();
                        body.writeTo(buffer);
                        Charset charset = UTF8;
                        MediaType contentType = body.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(UTF8);
                        }
                        this.logger.log("");
                        if (isPlaintext(buffer)) {
                            this.logger.log(buffer.readString(charset));
                            this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                        } else {
                            this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                        }
                    }
                } else {
                    this.logger.log("--> END " + request.method());
                }
            } else {
                z = z4;
            }
            long nanoTime = System.nanoTime();
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(' ');
            sb.append(proceed.message());
            sb.append(' ');
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            sb.append(z ? "" : StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + " body");
            sb.append(')');
            logger.log(sb.toString());
            if (z) {
                int size2 = proceed.headers().size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.logger.log(headers.name(i3) + ": " + headers.value(i3));
                }
                if (z3 && HttpHeaders.hasBody(proceed)) {
                    if (bodyEncoded(proceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = body2.source();
                        source.request(Long.MAX_VALUE);
                        Buffer buffer2 = source.buffer();
                        Charset charset2 = UTF8;
                        MediaType contentType2 = body2.contentType();
                        if (contentType2 != null) {
                            try {
                                charset2 = contentType2.charset(UTF8);
                            } catch (UnsupportedCharsetException unused) {
                                this.logger.log("");
                                this.logger.log("Couldn't decode the response body; charset is likely malformed.");
                                this.logger.log("<-- END HTTP");
                                return proceed;
                            }
                        }
                        if (!isPlaintext(buffer2)) {
                            this.logger.log("");
                            this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                            return proceed;
                        }
                        if (contentLength != 0) {
                            this.logger.log("");
                            this.logger.log(buffer2.clone().readString(charset2));
                        }
                        this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    }
                } else {
                    this.logger.log("<-- END HTTP");
                }
            }
            return proceed;
        }
        return chain.proceed(request);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LogInterceptor(String str, Level level) {
        this(null, str, level);
    }

    public LogInterceptor(Logger logger, String str, Level level) {
        this.level = Level.NONE;
        if (logger != null) {
            this.logger = logger;
        } else {
            this.logger = new DefaultLogger(str);
        }
        this.level = level;
    }
}
