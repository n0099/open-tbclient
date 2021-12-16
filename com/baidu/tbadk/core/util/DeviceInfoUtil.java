package com.baidu.tbadk.core.util;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.switchs.IsFullScreenSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DeviceInfoUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceInfoUtil() {
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

    public static String getDevicesManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static int getMainTabActJumpOtherDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (isHuaWei() || isHonor()) {
                String str = Build.HARDWARE;
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                return (str.equalsIgnoreCase("kirin980") || str.equalsIgnoreCase("kirin970") || str.equalsIgnoreCase("kirin960") || str.equalsIgnoreCase("kirin950") || str.equalsIgnoreCase("kirin935") || str.equalsIgnoreCase("kirin930") || str.equalsIgnoreCase("kirin928") || str.equalsIgnoreCase("kirin925") || str.equalsIgnoreCase("kirin920") || str.equalsIgnoreCase("kirin910") || str.equalsIgnoreCase("kirin710") || str.equalsIgnoreCase("kirin659")) ? 1000 : 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean isHWnova() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "ANE-AL00") : invokeV.booleanValue;
    }

    public static boolean isHonor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = Build.MODEL;
            return (!TextUtils.isEmpty(str) && str.contains("honor")) || "honor".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHonor30NotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return (isHuaWei() || isHonor()) && "OXF-AN00".equalsIgnoreCase(Build.MODEL);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = Build.MODEL;
            return (!TextUtils.isEmpty(str) && str.contains(RomUtils.MANUFACTURER_HUAWEI)) || RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiP40() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "ANA-AN00") || StringHelper.equals(Build.MODEL.trim(), "ANA-TN00") : invokeV.booleanValue;
    }

    public static boolean isHuaWeiP40Pro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "ELS-AN00") || StringHelper.equals(Build.MODEL.trim(), "ELS-TN00") : invokeV.booleanValue;
    }

    public static boolean isHuaWeiU9508Device() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String str = Build.MODEL;
            return !TextUtils.isEmpty(str) && str.contains("Huawei_HUAWEI U9508");
        }
        return invokeV.booleanValue;
    }

    public static boolean isHuaWeiVirtual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "HMA-AL00") : invokeV.booleanValue;
    }

    public static boolean isHuaweiMateX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String str = Build.MODEL;
            String str2 = Build.BRAND;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !"HUAWEI".equalsIgnoreCase(str2)) {
                return false;
            }
            return "RLI-AN00".equalsIgnoreCase(str) || "RLI-N29".equalsIgnoreCase(str) || "TAH-AN00".equalsIgnoreCase(str) || "TAH-N29".equalsIgnoreCase(str);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMate30() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "TAS-L09") || StringHelper.equals(Build.MODEL.trim(), "TAS-L29") || StringHelper.equals(Build.MODEL.trim(), "TAS-AL00") || StringHelper.equals(Build.MODEL.trim(), "TAS-TL00") : invokeV.booleanValue;
    }

    public static boolean isMi5X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "MI 5X") : invokeV.booleanValue;
    }

    public static boolean isMiNotchDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("MI 8") || str.contains("MI8");
        }
        return invokeV.booleanValue;
    }

    public static boolean isOppN5207() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? "n5207".equals(Build.MODEL) : invokeV.booleanValue;
    }

    public static boolean isReno3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "PCLM50") : invokeV.booleanValue;
    }

    public static boolean isSupportGyroScope(Context context) {
        InterceptResult invokeL;
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null || sensorManager.getDefaultSensor(4) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean isVivoX20A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? StringHelper.equals(Build.MODEL.trim(), "vivo X20A") : invokeV.booleanValue;
    }

    public static boolean isXiaoMi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) : invokeV.booleanValue;
    }

    public static boolean isXiaomi10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? "Mi 10".equals(Build.MODEL) : invokeV.booleanValue;
    }

    public static boolean isfullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (IsFullScreenSwitch.isOn()) {
                String trim = Build.MODEL.trim();
                String[] strArr = {"ANE-AL00", "CLT-AL01", "PACM00", "vivo Y85A", "vivo X21A", "SM-G8870"};
                for (int i2 = 0; i2 < 6; i2++) {
                    if (strArr[i2].equalsIgnoreCase(trim)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
