package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
/* loaded from: classes4.dex */
public class LogInterceptor implements Interceptor {
    public static final String TAG = "http";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public volatile Level level;
    public final Logger logger;

    /* loaded from: classes4.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes4.dex */
    public interface Logger {
        void log(String str);
    }

    /* loaded from: classes4.dex */
    public class DefaultLogger implements Logger {
        public String tag;

        public DefaultLogger(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.tag = str;
            }
        }

        @Override // com.baidu.searchbox.http.interceptor.LogInterceptor.Logger
        public void log(String str) {
            Log.d(this.tag, str);
        }
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

    public LogInterceptor(String str) {
        this(null, str, Level.NONE);
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str != null && !str.equalsIgnoreCase("identity")) {
            return true;
        }
        return false;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LogInterceptor(String str, Level level) {
        this(null, str, level);
    }

    public static boolean isPlaintext(Buffer buffer) throws EOFException {
        long j;
        try {
            Buffer buffer2 = new Buffer();
            if (buffer.size() < 64) {
                j = buffer.size();
            } else {
                j = 64;
            }
            buffer.copyTo(buffer2, 0L, j);
            for (int i = 0; i < 16; i++) {
                if (!buffer2.exhausted()) {
                    if (Character.isISOControl(buffer2.readUtf8CodePoint())) {
                        return false;
                    }
                } else {
                    return true;
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
        boolean z2;
        Protocol protocol;
        boolean z3;
        String str;
        String str2;
        Headers headers;
        boolean z4;
        Level level = this.level;
        Request request = chain.request();
        if (level != null && level != Level.NONE) {
            boolean z5 = true;
            if (level == Level.BODY) {
                z = true;
            } else {
                z = false;
            }
            if (!z && level != Level.HEADERS) {
                z2 = false;
            } else {
                z2 = true;
            }
            RequestBody body = request.body();
            if (body == null) {
                z5 = false;
            }
            Connection connection = chain.connection();
            if (connection != null) {
                protocol = connection.protocol();
            } else {
                protocol = Protocol.HTTP_1_1;
            }
            String str3 = "--> " + request.method() + WebvttCueParser.CHAR_SPACE + request.url() + WebvttCueParser.CHAR_SPACE + protocol;
            if (!z2 && z5) {
                str3 = str3 + " (" + body.contentLength() + "-byte body)";
            }
            this.logger.log(str3);
            if (z2) {
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
                    if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                        z4 = z2;
                        this.logger.log(name + ": " + headers2.value(i));
                    } else {
                        z4 = z2;
                    }
                    i++;
                    size = i2;
                    z2 = z4;
                }
                z3 = z2;
                if (z && z5) {
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
                z3 = z2;
            }
            long nanoTime = System.nanoTime();
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(proceed.message());
            sb.append(WebvttCueParser.CHAR_SPACE);
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (z3) {
                str2 = "";
            } else {
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str + " body";
            }
            sb.append(str2);
            sb.append(')');
            logger.log(sb.toString());
            if (z3) {
                int size2 = proceed.headers().size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.logger.log(headers.name(i3) + ": " + headers.value(i3));
                }
                if (z && HttpHeaders.hasBody(proceed)) {
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
}
