package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.security.ioc.HostAbilityRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
/* loaded from: classes2.dex */
public class DeviceInfoProxy {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEFAULT_PHONE_TYPE = 0;
    public static volatile boolean hasInvokedImei;
    public static volatile boolean[] hasInvokedImeiArray;
    public static volatile boolean hasInvokedImsi;
    public static String[] imeiArray;
    public static String lastImei;
    public static String lastImsi;
    public static int lastPhoneType;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1677241418, "Lcom/baidu/searchbox/common/security/DeviceInfoProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1677241418, "Lcom/baidu/searchbox/common/security/DeviceInfoProxy;");
                return;
            }
        }
        hasInvokedImeiArray = new boolean[2];
        imeiArray = new String[2];
    }

    public DeviceInfoProxy() {
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

    public static boolean checkPermisson(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int i = Build.VERSION.SDK_INT;
            return (i < 23 || i >= 29) ? Build.VERSION.SDK_INT < 29 : context.checkSelfPermission(h.c) == 0;
        }
        return invokeL.booleanValue;
    }

    public static DeviceIdBag getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? getImei(context, false) : (DeviceIdBag) invokeL.objValue;
    }

    public static DeviceIdBag getImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? getImsi(context, false) : (DeviceIdBag) invokeL.objValue;
    }

    public static int getPhoneType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? ((TelephonyManager) context.getSystemService("phone")).getPhoneType() : invokeL.intValue;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String realImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 26) {
                    return telephonyManager.getImei();
                }
                return telephonyManager.getDeviceId();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String realImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static DeviceIdBag getImei(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) ? getImei(context, z, false) : (DeviceIdBag) invokeLZ.objValue;
    }

    public static DeviceIdBag getImsi(Context context, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, context, z)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
                deviceIdBag.errorCode = -3;
                return deviceIdBag;
            }
            String str = null;
            if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
                i = -1;
            } else if (checkPermisson(context)) {
                str = realImsi(context);
                i = 0;
            } else {
                i = -2;
            }
            if (TextUtils.isEmpty(str)) {
                str = lastImsi;
                if (!TextUtils.isEmpty(str)) {
                    i = 1;
                }
            } else {
                lastImsi = str;
            }
            deviceIdBag.deviceId = str;
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLZ.objValue;
    }

    public static DeviceIdBag getImei(Context context, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            if (!HostAbilityRuntime.getHostAbility().hasAgreedPrivacyPolicy()) {
                deviceIdBag.errorCode = -3;
                return deviceIdBag;
            }
            int phoneType = getPhoneType(context);
            int i = 1;
            if (!z2 && ((lastImei != null || hasInvokedImei) && lastPhoneType == phoneType)) {
                if (lastImei == null && hasInvokedImei) {
                    i = 2;
                }
            } else if (!z && !HostAbilityRuntime.getHostAbility().isForeground()) {
                i = -1;
            } else if (checkPermisson(context)) {
                lastImei = realImei(context);
                hasInvokedImei = true;
                lastPhoneType = phoneType;
                i = 0;
            } else {
                i = -2;
            }
            deviceIdBag.deviceId = lastImei;
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeCommon.objValue;
    }

    public static String realImei(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                return telephonyManager.getImei(i);
            }
            if (i2 >= 21) {
                try {
                    return (String) TelephonyManager.class.getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i));
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }
}
