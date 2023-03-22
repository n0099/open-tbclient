package com.baidu.tbadk.core.util;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.activity.OauthActivity;
import com.baidu.tbadk.switchs.IsFullScreenSwitch;
import com.baidu.tieba.ji;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes3.dex */
public class DeviceInfoUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceInfoUtil() {
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

    public static String getDevicesManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String f = ji.f();
            if (TextUtils.isEmpty(f)) {
                return "NUL";
            }
            return f.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String getHarmonyOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (isHarmonyOs()) {
                return getProp("hw_sc.build.platform.version", "");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isHWnova() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return StringHelper.equals(ji.g(), "ANE-AL00");
        }
        return invokeV.booleanValue;
    }

    public static boolean isHarmonyOs200() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return OauthActivity.N.equals(getHarmonyOSVersion());
        }
        return invokeV.booleanValue;
    }

    public static boolean isHarmonyOs201() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return "2.0.1".equals(getHarmonyOSVersion());
        }
        return invokeV.booleanValue;
    }

    public static boolean isHonor30NotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String g = ji.g();
            if ((isHuaWei() || isHonor()) && "OXF-AN00".equalsIgnoreCase(g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiP40() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (!StringHelper.equals(ji.g(), "ANA-AN00") && !StringHelper.equals(ji.g(), "ANA-TN00")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiP40Pro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (!StringHelper.equals(ji.g(), "ELS-AN00") && !StringHelper.equals(ji.g(), "ELS-TN00")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiU9508Device() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String g = ji.g();
            if (TextUtils.isEmpty(g) || !g.contains("Huawei_HUAWEI U9508")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiVirtual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return StringHelper.equals(ji.g(), "HMA-AL00");
        }
        return invokeV.booleanValue;
    }

    public static boolean isMi5X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return StringHelper.equals(ji.g(), "MI 5X");
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppN5207() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return "n5207".equals(ji.g());
        }
        return invokeV.booleanValue;
    }

    public static boolean isReno3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return StringHelper.equals(ji.g(), "PCLM50");
        }
        return invokeV.booleanValue;
    }

    public static boolean isVivoX20A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return StringHelper.equals(ji.g(), "vivo X20A");
        }
        return invokeV.booleanValue;
    }

    public static boolean isXiaoMi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(ji.f())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isXiaomi10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return "Mi 10".equals(ji.g());
        }
        return invokeV.booleanValue;
    }

    public static int getMainTabActJumpOtherDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (isHuaWei() || isHonor()) {
                String str = Build.HARDWARE;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equalsIgnoreCase("kirin980") || str.equalsIgnoreCase("kirin970") || str.equalsIgnoreCase("kirin960") || str.equalsIgnoreCase("kirin950") || str.equalsIgnoreCase("kirin935") || str.equalsIgnoreCase("kirin930") || str.equalsIgnoreCase("kirin928") || str.equalsIgnoreCase("kirin925") || str.equalsIgnoreCase("kirin920") || str.equalsIgnoreCase("kirin910") || str.equalsIgnoreCase("kirin710") || str.equalsIgnoreCase("kirin659")) {
                        return 1000;
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String getProp(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
                if (TextUtils.isEmpty(str3)) {
                    return str2;
                }
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isHarmonyOs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (invoke == null) {
                    return false;
                }
                return "harmony".equalsIgnoreCase(invoke.toString());
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean isHonor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String g = ji.g();
            String f = ji.f();
            if ((!TextUtils.isEmpty(g) && g.contains("honor")) || "honor".equalsIgnoreCase(f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String g = ji.g();
            String f = ji.f();
            if ((!TextUtils.isEmpty(g) && g.contains(RomUtils.MANUFACTURER_HUAWEI)) || RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMiNotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            String g = ji.g();
            if (TextUtils.isEmpty(g)) {
                return false;
            }
            if (!g.contains("MI 8") && !g.contains("MI8")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isfullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            if (!IsFullScreenSwitch.isOn()) {
                return false;
            }
            String g = ji.g();
            String[] strArr = {"ANE-AL00", "CLT-AL01", "PACM00", "vivo Y85A", "vivo X21A", "SM-G8870"};
            for (int i = 0; i < 6; i++) {
                if (strArr[i].equalsIgnoreCase(g)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaweiMateX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            String g = ji.g();
            String str = Build.BRAND;
            if (TextUtils.isEmpty(g) || TextUtils.isEmpty(str) || !"HUAWEI".equalsIgnoreCase(str)) {
                return false;
            }
            if (!"RLI-AN00".equalsIgnoreCase(g) && !"RLI-N29".equalsIgnoreCase(g) && !"TAH-AN00".equalsIgnoreCase(g) && !"TAH-N29".equalsIgnoreCase(g)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMate30() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (!StringHelper.equals(ji.g(), "TAS-L09") && !StringHelper.equals(ji.g(), "TAS-L29") && !StringHelper.equals(ji.g(), "TAS-AL00") && !StringHelper.equals(ji.g(), "TAS-TL00")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSupportGyroScope(Context context) {
        InterceptResult invokeL;
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null || sensorManager.getDefaultSensor(4) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
