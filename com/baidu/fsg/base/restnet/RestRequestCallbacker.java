package com.baidu.fsg.base.restnet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RestRequestCallbacker {
    public static /* synthetic */ Interceptable $ic;
    public static IRestRequestCallback mCallback;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface IRestRequestCallback {
        boolean isSpecialUrl(String str);

        void onSuccess(String str, String str2);
    }

    public RestRequestCallbacker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IRestRequestCallback getRequestCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? mCallback : (IRestRequestCallback) invokeV.objValue;
    }

    public static void setRequestCallback(IRestRequestCallback iRestRequestCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iRestRequestCallback) == null) {
            mCallback = iRestRequestCallback;
        }
    }
}
