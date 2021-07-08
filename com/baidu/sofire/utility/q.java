package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes3.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f10525b;

    /* renamed from: c  reason: collision with root package name */
    public static OkHttpClient f10526c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10527a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443542084, "Lcom/baidu/sofire/utility/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443542084, "Lcom/baidu/sofire/utility/q;");
                return;
            }
        }
        f10525b = new byte[1024];
    }

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10527a = context;
    }

    private OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (f10526c == null) {
                synchronized (q.class) {
                    if (f10526c == null) {
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        builder.hostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        builder.connectTimeout(AppConfig.TIMESTAMP_AVAILABLE_DURATION, TimeUnit.MILLISECONDS);
                        builder.addInterceptor(new Interceptor(this) { // from class: com.baidu.sofire.utility.q.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ q f10528a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f10528a = this;
                            }

                            @Override // okhttp3.Interceptor
                            public final Response intercept(Interceptor.Chain chain) throws IOException {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, chain)) == null) {
                                    System.currentTimeMillis();
                                    Response proceed = chain.proceed(chain.request());
                                    System.currentTimeMillis();
                                    return proceed;
                                }
                                return (Response) invokeL.objValue;
                            }
                        });
                        f10526c = builder.build();
                    }
                }
            }
            return f10526c;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    private Request b(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, bArr)) == null) {
            try {
                MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
                String str2 = c.g(this.f10527a)[0];
                Request.Builder url = new Request.Builder().url(str);
                if (bArr != null) {
                    url.post(RequestBody.create(parse, bArr));
                }
                Request.Builder addHeader = url.addHeader("User-Agent", "eos/" + str2 + "/" + z.a(this.f10527a) + "/3.5.8.7").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
                return addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", o.a(e.b(this.f10527a))).build();
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Request) invokeLL.objValue;
    }

    public final String a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            try {
                if (s.m(this.f10527a)) {
                    Response execute = a().newCall(b(str, bArr)).execute();
                    int code = execute.code();
                    if (code == 200) {
                        return execute.body().string();
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file)) == null) {
            try {
                if (s.m(this.f10527a)) {
                    Response execute = a().newCall(new Request.Builder().url(str).build()).execute();
                    int code = execute.code();
                    if (code == 200) {
                        InputStream byteStream = execute.body().byteStream();
                        boolean a2 = a(byteStream, file);
                        byteStream.close();
                        return a2;
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (inputStream == null) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                int read = inputStream.read(f10525b);
                if (read != -1) {
                    bufferedOutputStream.write(f10525b, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getPackageName().contains("com.baidu.searchbox") : invokeL.booleanValue;
    }
}
