package c.a.p0.a.h;

import android.media.MediaMetadataRetriever;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes.dex */
public class h extends RequestBody {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5417b;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1359052975, "Lc/a/p0/a/h/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1359052975, "Lc/a/p0/a/h/h;");
                return;
            }
        }
        f5417b = c.a.p0.a.a.a;
    }

    public h(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = file;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            str2 = "image/jpeg";
            if (str != null) {
                try {
                    try {
                        try {
                            try {
                                mediaMetadataRetriever.setDataSource(str);
                                String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                                str2 = extractMetadata != null ? extractMetadata : "image/jpeg";
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Exception e2) {
                                    if (f5417b) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Exception e3) {
                                if (f5417b) {
                                    e3.printStackTrace();
                                }
                                return "image/jpeg";
                            }
                        } catch (Exception e4) {
                            if (f5417b) {
                                e4.printStackTrace();
                            }
                            return "image/jpeg";
                        }
                    } catch (Exception e5) {
                        if (f5417b) {
                            e5.printStackTrace();
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    mediaMetadataRetriever.release();
                    return "image/jpeg";
                } catch (IllegalStateException unused2) {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                    mediaMetadataRetriever.release();
                    return "image/jpeg";
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e6) {
                        if (f5417b) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.length() : invokeV.longValue;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MediaType.parse(a(this.a.getPath())) : (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
            Source source = null;
            try {
                source = Okio.source(this.a);
                while (source.read(bufferedSink.buffer(), 2048L) != -1) {
                    bufferedSink.flush();
                }
            } finally {
                c.a.p0.w.d.d(source);
            }
        }
    }
}
