package com.baidu.searchbox.http;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class HttpManager extends AbstractHttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile HttpManager httpManager;
    public static ExtraInfoDispatcher sExtraInfoDispatcher;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156098915, "Lcom/baidu/searchbox/http/HttpManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156098915, "Lcom/baidu/searchbox/http/HttpManager;");
                return;
            }
        }
        sExtraInfoDispatcher = new ExtraInfoDispatcher();
    }

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sExtraInfoDispatcher;
        }
        return (ExtraInfoDispatcher) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpManager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static HttpManager getDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (httpManager == null) {
                synchronized (HttpManager.class) {
                    if (httpManager == null) {
                        httpManager = new HttpManager(context);
                        httpManager.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return httpManager;
        }
        return (HttpManager) invokeL.objValue;
    }

    public static HttpManager newHttpManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            HttpManager httpManager2 = new HttpManager(context);
            httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
            return httpManager2;
        }
        return (HttpManager) invokeL.objValue;
    }

    public static HttpManager newHttpManager(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, list)) == null) {
            return newHttpManager(context, list, null);
        }
        return (HttpManager) invokeLL.objValue;
    }

    public static HttpManager newHttpManager(Context context, List<String> list, List<String> list2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, list, list2)) == null) {
            HttpManager httpManager2 = new HttpManager(context);
            httpManager2.openPreConnect(list, list2);
            httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
            return httpManager2;
        }
        return (HttpManager) invokeLLL.objValue;
    }
}
