package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
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
/* loaded from: classes2.dex */
public class LogInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "http";
    public static final Charset UTF8;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Level level;
    public final Logger logger;

    /* loaded from: classes2.dex */
    public class DefaultLogger implements Logger {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String tag;
        public final /* synthetic */ LogInterceptor this$0;

        public DefaultLogger(LogInterceptor logInterceptor, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logInterceptor, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = logInterceptor;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.tag = str;
        }

        @Override // com.baidu.searchbox.http.interceptor.LogInterceptor.Logger
        public void log(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Log.d(this.tag, str);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Level {
        public static final /* synthetic */ Level[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Level BASIC;
        public static final Level BODY;
        public static final Level HEADERS;
        public static final Level NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-98036157, "Lcom/baidu/searchbox/http/interceptor/LogInterceptor$Level;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-98036157, "Lcom/baidu/searchbox/http/interceptor/LogInterceptor$Level;");
                    return;
                }
            }
            NONE = new Level(HlsPlaylistParser.METHOD_NONE, 0);
            BASIC = new Level("BASIC", 1);
            HEADERS = new Level("HEADERS", 2);
            Level level = new Level("BODY", 3);
            BODY = level;
            $VALUES = new Level[]{NONE, BASIC, HEADERS, level};
        }

        public Level(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Level valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Level) Enum.valueOf(Level.class, str) : (Level) invokeL.objValue;
        }

        public static Level[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Level[]) $VALUES.clone() : (Level[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface Logger {
        void log(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1407088131, "Lcom/baidu/searchbox/http/interceptor/LogInterceptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1407088131, "Lcom/baidu/searchbox/http/interceptor/LogInterceptor;");
                return;
            }
        }
        UTF8 = Charset.forName("UTF-8");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogInterceptor(String str) {
        this(null, str, Level.NONE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Logger) objArr2[0], (String) objArr2[1], (Level) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean bodyEncoded(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, headers)) == null) {
            String str = headers.get("Content-Encoding");
            return (str == null || str.equalsIgnoreCase("identity")) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPlaintext(Buffer buffer) throws EOFException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, buffer)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        boolean z;
        Headers headers;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            Level level = this.level;
            Request request = chain.request();
            if (level != null && level != Level.NONE) {
                boolean z3 = level == Level.BODY;
                boolean z4 = z3 || level == Level.HEADERS;
                RequestBody body = request.body();
                boolean z5 = body != null;
                Connection connection = chain.connection();
                String str = "--> " + request.method() + WebvttCueParser.CHAR_SPACE + request.url() + WebvttCueParser.CHAR_SPACE + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
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
                sb.append(WebvttCueParser.CHAR_SPACE);
                sb.append(proceed.message());
                sb.append(WebvttCueParser.CHAR_SPACE);
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
        return (Response) invokeL.objValue;
    }

    public void setLevel(Level level) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, level) == null) {
            this.level = level;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LogInterceptor(String str, Level level) {
        this(null, str, level);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, level};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Logger) objArr2[0], (String) objArr2[1], (Level) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public LogInterceptor(Logger logger, String str, Level level) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {logger, str, level};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.level = Level.NONE;
        if (logger != null) {
            this.logger = logger;
        } else {
            this.logger = new DefaultLogger(this, str);
        }
        this.level = level;
    }
}
