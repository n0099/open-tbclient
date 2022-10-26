package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class PassHttpClient implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final AtomicInteger c;
    public static final ThreadFactory d;
    public static final ThreadPoolExecutor e;
    public static final PassHttpClient f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        int i;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1338862688, "Lcom/baidu/pass/http/PassHttpClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1338862688, "Lcom/baidu/pass/http/PassHttpClient;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        if (availableProcessors > 16) {
            i = availableProcessors / 2;
        } else {
            i = 8;
        }
        b = i;
        c = new AtomicInteger();
        d = new c();
        f = new PassHttpClient();
        int i2 = b;
        e = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue(), d);
        if (Build.VERSION.SDK_INT >= 9) {
            e.allowCoreThreadTimeOut(true);
        }
    }

    public PassHttpClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PassHttpClient getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f;
        }
        return (PassHttpClient) invokeV.objValue;
    }

    private PassHttpClientRequest a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, method, context, passHttpParamDTO, httpResponseHandler)) == null) {
            PassHttpClientRequest passHttpClientRequest = new PassHttpClientRequest(method, context, passHttpParamDTO, c.incrementAndGet(), httpResponseHandler);
            e.execute(passHttpClientRequest);
            return passHttpClientRequest;
        }
        return (PassHttpClientRequest) invokeLLLL.objValue;
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, passHttpParamDTO) == null) {
            if (context != null) {
                if (passHttpParamDTO != null && !TextUtils.isEmpty(passHttpParamDTO.url)) {
                    return;
                }
                throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
            }
            throw new IllegalArgumentException("Invalid context argument");
        }
    }

    public PassHttpClientRequest get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, passHttpParamDTO, httpResponseHandler)) == null) {
            try {
                a(context, passHttpParamDTO);
                return a(Method.GET, context, passHttpParamDTO, httpResponseHandler);
            } catch (Exception e2) {
                Log.e(Log.TAG, "get ex=" + e2.getMessage());
                if (httpResponseHandler != null) {
                    httpResponseHandler.a(e2, e2.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (PassHttpClientRequest) invokeLLL.objValue;
    }

    public PassHttpClientRequest post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, passHttpParamDTO, httpResponseHandler)) == null) {
            try {
                a(context, passHttpParamDTO);
                return a(Method.POST, context, passHttpParamDTO, httpResponseHandler);
            } catch (Exception e2) {
                if (httpResponseHandler != null) {
                    httpResponseHandler.a(e2, e2.getMessage());
                    return null;
                }
                return null;
            }
        }
        return (PassHttpClientRequest) invokeLLL.objValue;
    }
}
