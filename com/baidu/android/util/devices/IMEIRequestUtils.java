package com.baidu.android.util.devices;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
@Deprecated
/* loaded from: classes.dex */
public class IMEIRequestUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IMEIRequestUtils() {
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

    public static String getIMEI(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (AppRuntime.getAppContext() == null) {
                return str;
            }
            if (DeviceUtil.OSInfo.hasMarshMallow() && AppRuntime.getAppContext().checkSelfPermission(h.c) != 0) {
                return str;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
                if (telephonyManager != null) {
                    str2 = ApiReplaceUtil.getDeviceId(telephonyManager);
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                return str;
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
