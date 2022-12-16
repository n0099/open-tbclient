package com.baidu.sofire.k;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
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
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] b;
    public static OkHttpClient c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes3.dex */
    public class a implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                System.currentTimeMillis();
                Request request = chain.request();
                Context context = this.a.a;
                Response proceed = chain.proceed(request);
                System.currentTimeMillis();
                return proceed;
            }
            return (Response) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259202, "Lcom/baidu/sofire/k/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259202, "Lcom/baidu/sofire/k/l;");
                return;
            }
        }
        b = new byte[1024];
    }

    public l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return context.getPackageName().contains("com.baidu.searchbox");
        }
        return invokeL.booleanValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (m.a(this.a)) {
                    Response execute = a().newCall(a(str, (byte[]) null)).execute();
                    int code = execute.code();
                    if (code == 200) {
                        return execute.body().string();
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (c == null) {
                synchronized (l.class) {
                    if (c == null) {
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        builder.hostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        builder.connectTimeout(AppConfig.TIMESTAMP_AVAILABLE_DURATION, TimeUnit.MILLISECONDS);
                        builder.addInterceptor(new a(this));
                        c = builder.build();
                    }
                }
            }
            return c;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public final Request a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr)) == null) {
            try {
                MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
                String str2 = com.baidu.sofire.k.a.p(this.a)[0];
                Request.Builder url = new Request.Builder().url(str);
                if (bArr != null) {
                    url.post(RequestBody.create(parse, bArr));
                }
                Request.Builder addHeader = url.addHeader("User-Agent", "eos/" + str2 + "/" + q.a(this.a) + "/3.5.9.6").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
                return addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", j.a(c.a(this.a))).build();
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Request) invokeLL.objValue;
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, file)) == null) {
            try {
                if (m.a(this.a)) {
                    Response execute = a().newCall(new Request.Builder().url(str).build()).execute();
                    int code = execute.code();
                    if (code == 200) {
                        InputStream byteStream = execute.body().byteStream();
                        if (byteStream != null) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            while (true) {
                                byte[] bArr = b;
                                int read = byteStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                                bufferedOutputStream.flush();
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            z = true;
                        } else {
                            z = false;
                        }
                        byteStream.close();
                        return z;
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public String b(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bArr)) == null) {
            try {
                if (m.a(this.a)) {
                    Response execute = a().newCall(a(str, bArr)).execute();
                    int code = execute.code();
                    if (code == 200) {
                        return execute.body().string();
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
