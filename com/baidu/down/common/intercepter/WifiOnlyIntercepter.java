package com.baidu.down.common.intercepter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class WifiOnlyIntercepter implements IIntercepter<Void> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WifiOnlyIntercepter() {
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

    public static NetworkInfo getActiveNetworkInfoSafely(Context context) {
        com.baidu.titan.sdk.runtime.InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean isWifiNetWork(Context context) {
        com.baidu.titan.sdk.runtime.InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo activeNetworkInfoSafely = getActiveNetworkInfoSafely(context);
            return activeNetworkInfoSafely != null && activeNetworkInfoSafely.isAvailable() && activeNetworkInfoSafely.getTypeName().toLowerCase().equalsIgnoreCase("wifi");
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.down.common.intercepter.IIntercepter
    public InterceptResult process(Context context, String str, long j2, Void r9) {
        com.baidu.titan.sdk.runtime.InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j2), r9})) == null) {
            if (isWifiNetWork(context)) {
                return null;
            }
            return new InterceptResult(1);
        }
        return (InterceptResult) invokeCommon.objValue;
    }
}
