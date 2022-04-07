package com.baidu.sofire.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class OkHttpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] BUF_LEN;
    public static final int TIMEOUT = 120000;
    public static OkHttpClient sClient;
    public static SSLSocketFactory sslSocketFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750840995, "Lcom/baidu/sofire/utility/OkHttpUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750840995, "Lcom/baidu/sofire/utility/OkHttpUtil;");
                return;
            }
        }
        BUF_LEN = new byte[1024];
    }

    public OkHttpUtil(Context context) {
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
        this.context = context;
    }

    private Request buildReuest(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, bArr)) == null) {
            try {
                MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
                String str2 = CommonMethods.selectAppKeyAndSecurityKey(this.context)[0];
                Request.Builder url = new Request.Builder().url(str);
                if (bArr != null) {
                    url.post(RequestBody.create(parse, bArr));
                }
                Request.Builder addHeader = url.addHeader("User-Agent", "eos/" + str2 + "/" + VersionUtil.getVersionName(this.context) + "/3.5.9.3").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
                return addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", MD5Util.getMD5(DbUtil.getCUID(this.context))).build();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Request) invokeLL.objValue;
    }

    private void initSSLSocketFactory(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, builder) == null) {
            try {
                builder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static boolean isOkHttpExists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean responseToFile(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65541, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (inputStream == null) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                int read = inputStream.read(BUF_LEN);
                if (read != -1) {
                    bufferedOutputStream.write(BUF_LEN, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
            return false;
        }
    }

    public static boolean useOkHttp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? context.getPackageName().contains("com.baidu.searchbox") && isOkHttpExists() : invokeL.booleanValue;
    }

    public OkHttpClient buildHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (sClient == null) {
                synchronized (OkHttpUtil.class) {
                    if (sClient == null) {
                        OkHttpClient.Builder builder = new OkHttpClient.Builder();
                        initSSLSocketFactory(builder);
                        builder.connectTimeout(AppConfig.TIMESTAMP_AVAILABLE_DURATION, TimeUnit.MILLISECONDS);
                        builder.addInterceptor(new Interceptor(this) { // from class: com.baidu.sofire.utility.OkHttpUtil.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ OkHttpUtil this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // okhttp3.Interceptor
                            public Response intercept(Interceptor.Chain chain) throws IOException {
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
                        sClient = builder.build();
                    }
                }
            }
            return sClient;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public String requestForGet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (PrivacyOperationUtil.allowNetwork(this.context)) {
                    Response execute = buildHttpClient().newCall(buildReuest(str, null)).execute();
                    int code = execute.code();
                    if (code == 200) {
                        return execute.body().string();
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean requestForGetFile(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, file)) == null) {
            try {
                if (PrivacyOperationUtil.allowNetwork(this.context)) {
                    Response execute = buildHttpClient().newCall(new Request.Builder().url(str).build()).execute();
                    int code = execute.code();
                    if (code == 200) {
                        InputStream byteStream = execute.body().byteStream();
                        boolean responseToFile = responseToFile(byteStream, file);
                        byteStream.close();
                        return responseToFile;
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public String requestForPost(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bArr)) == null) {
            try {
                if (PrivacyOperationUtil.allowNetwork(this.context)) {
                    Response execute = buildHttpClient().newCall(buildReuest(str, bArr)).execute();
                    int code = execute.code();
                    if (code == 200) {
                        return execute.body().string();
                    }
                    throw new NetworkErrorException(String.valueOf(code));
                }
                throw new NetworkErrorException("Not allow background connect.");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
