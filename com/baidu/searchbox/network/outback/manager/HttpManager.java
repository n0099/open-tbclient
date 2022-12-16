package com.baidu.searchbox.network.outback.manager;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.network.outback.base.AbstractHttpManager;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HttpManager extends AbstractHttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile HttpManager httpManager;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpManager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static HttpManager getDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (httpManager == null) {
                synchronized (HttpManager.class) {
                    if (httpManager == null) {
                        httpManager = new HttpManager(context);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return new HttpManager(context);
        }
        return (HttpManager) invokeL.objValue;
    }

    public static HttpManager newHttpManager(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            HttpManager httpManager2 = new HttpManager(context);
            httpManager2.chooseEngine(str);
            return httpManager2;
        }
        return (HttpManager) invokeLL.objValue;
    }

    public static HttpManager newHttpManager(Context context, String str, CallFactoryParams callFactoryParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, callFactoryParams)) == null) {
            HttpManager httpManager2 = new HttpManager(context);
            httpManager2.chooseEngine(str, callFactoryParams);
            return httpManager2;
        }
        return (HttpManager) invokeLLL.objValue;
    }
}
