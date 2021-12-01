package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
@Deprecated
/* loaded from: classes8.dex */
public class IMEIRequestUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IMEIRequestUtils() {
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

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (AppRuntime.getAppContext() == null) {
                return str;
            }
            if (!DeviceUtil.OSInfo.hasMarshMallow() || AppRuntime.getAppContext().checkSelfPermission(s.f56838c) == 0) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
                    String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
                    return TextUtils.isEmpty(deviceId) ? str : deviceId;
                } catch (Exception unused) {
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
