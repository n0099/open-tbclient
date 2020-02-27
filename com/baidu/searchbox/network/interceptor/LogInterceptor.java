package com.baidu.searchbox.network.interceptor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.Interceptor;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.ResponseBody;
import com.baidu.searchbox.network.core.http.HttpHeaders;
import com.google.android.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
/* loaded from: classes13.dex */
public class LogInterceptor implements Interceptor {
    private static final String TAG = "http";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    /* loaded from: classes13.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: classes13.dex */
    public interface Logger {
        void log(String str);
    }

    public LogInterceptor(String str) {
        this(null, str, Level.NONE);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=5, 90=4] */
    static boolean isPlaintext(Buffer buffer) throws EOFException {
        Buffer buffer2;
        Throwable th;
        try {
            buffer2 = new Buffer();
        } catch (EOFException e) {
            buffer2 = null;
        } catch (Throwable th2) {
            buffer2 = null;
            th = th2;
        }
        try {
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    break;
                } else if (Character.isISOControl(buffer2.readUtf8CodePoint())) {
                    if (buffer2 != null) {
                        buffer2.close();
                    }
                    return false;
                }
            }
            if (buffer2 != null) {
                buffer2.close();
                return true;
            }
            return true;
        } catch (EOFException e2) {
            if (buffer2 != null) {
                buffer2.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (buffer2 != null) {
                buffer2.close();
            }
            throw th;
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override // com.baidu.searchbox.network.core.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Headers headers;
        Level level = this.level;
        Request request = chain.request();
        if (level == null || level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z = level == Level.BODY;
        boolean z2 = z || level == Level.HEADERS;
        RequestBody body = request.body();
        boolean z3 = body != null;
        if (z2) {
            if (z3) {
                if (body.contentType() != null) {
                    this.logger.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers2 = request.headers();
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                String name = headers2.name(i);
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    this.logger.log(name + ": " + headers2.value(i));
                }
            }
            if (!z || !z3) {
                this.logger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
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
        }
        long nanoTime = System.nanoTime();
        Response proceed = chain.proceed(request);
        String str = "--> " + request.method() + ' ' + request.url() + ' ' + proceed.protocol();
        if (!z2 && z3) {
            str = str + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(str);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        ResponseBody body2 = proceed.body();
        long contentLength = body2.contentLength();
        this.logger.log("<-- " + proceed.code() + ' ' + proceed.message() + ' ' + proceed.request().url() + " (" + millis + "ms" + (!z2 ? ", " + (contentLength != -1 ? contentLength + "-byte" : "unknown-length") + " body" : "") + ')');
        if (z2) {
            int size2 = proceed.headers().size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.logger.log(headers.name(i2) + ": " + headers.value(i2));
            }
            if (!z || !HttpHeaders.hasBody(proceed)) {
                this.logger.log("<-- END HTTP");
            } else if (bodyEncoded(proceed.headers())) {
                this.logger.log("<-- END HTTP (encoded body omitted)");
            } else {
                BufferedSource source = body2.source();
                source.request(Format.OFFSET_SAMPLE_RELATIVE);
                Buffer buffer2 = source.buffer();
                Charset charset2 = UTF8;
                MediaType contentType2 = body2.contentType();
                if (contentType2 != null) {
                    try {
                        charset2 = contentType2.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
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
        }
        return proceed;
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
    }

    /* loaded from: classes13.dex */
    public class DefaultLogger implements Logger {
        private String tag;

        public DefaultLogger(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.tag = str;
            }
        }

        @Override // com.baidu.searchbox.network.interceptor.LogInterceptor.Logger
        public void log(String str) {
            Log.d(this.tag, str);
        }
    }
}
