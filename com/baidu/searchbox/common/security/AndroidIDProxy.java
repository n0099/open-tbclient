package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AndroidIDProxy {
    public static /* synthetic */ Interceptable $ic;
    public static String androidId;
    public static volatile boolean hasInvoked;
    public transient /* synthetic */ FieldHolder $fh;

    public AndroidIDProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return getAndroidId(context, false);
        }
        return (DeviceIdBag) invokeL.objValue;
    }

    public static String realAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag getAndroidId(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
                deviceIdBag.errorCode = -3;
                return deviceIdBag;
            }
            int i = 1;
            if (androidId == null && !hasInvoked) {
                if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
                    i = -1;
                } else {
                    androidId = realAndroidId(context);
                    hasInvoked = true;
                    i = 0;
                }
            } else if (hasInvoked && androidId == null) {
                i = 2;
            }
            deviceIdBag.deviceId = androidId;
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLZ.objValue;
    }
}
