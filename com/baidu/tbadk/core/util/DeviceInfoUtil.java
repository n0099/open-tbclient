package com.baidu.tbadk.core.util;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.switchs.IsFullScreenSwitch;
/* loaded from: classes3.dex */
public class DeviceInfoUtil {
    public static String getDevicesManufacturer() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static int getMainTabActJumpOtherDelayTime() {
        if (isHuaWei() || isHonor()) {
            String str = Build.HARDWARE;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return (str.equalsIgnoreCase("kirin980") || str.equalsIgnoreCase("kirin970") || str.equalsIgnoreCase("kirin960") || str.equalsIgnoreCase("kirin950") || str.equalsIgnoreCase("kirin935") || str.equalsIgnoreCase("kirin930") || str.equalsIgnoreCase("kirin928") || str.equalsIgnoreCase("kirin925") || str.equalsIgnoreCase("kirin920") || str.equalsIgnoreCase("kirin910") || str.equalsIgnoreCase("kirin710") || str.equalsIgnoreCase("kirin659")) ? 1000 : 0;
        }
        return 0;
    }

    public static boolean isHWnova() {
        return StringHelper.equals(Build.MODEL.trim(), "ANE-AL00");
    }

    public static boolean isHonor() {
        String str = Build.MODEL;
        return (!TextUtils.isEmpty(str) && str.contains("honor")) || "honor".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isHuaWei() {
        String str = Build.MODEL;
        return (!TextUtils.isEmpty(str) && str.contains(RomUtils.MANUFACTURER_HUAWEI)) || RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isHuaWeiP40() {
        return StringHelper.equals(Build.MODEL.trim(), "ANA-AN00") || StringHelper.equals(Build.MODEL.trim(), "ANA-TN00");
    }

    public static boolean isHuaWeiVirtual() {
        return StringHelper.equals(Build.MODEL.trim(), "HMA-AL00");
    }

    public static boolean isMate30() {
        return StringHelper.equals(Build.MODEL.trim(), "TAS-L09") || StringHelper.equals(Build.MODEL.trim(), "TAS-L29") || StringHelper.equals(Build.MODEL.trim(), "TAS-AL00") || StringHelper.equals(Build.MODEL.trim(), "TAS-TL00");
    }

    public static boolean isMi5X() {
        return StringHelper.equals(Build.MODEL.trim(), "MI 5X");
    }

    public static boolean isReno3() {
        return StringHelper.equals(Build.MODEL.trim(), "PCLM50");
    }

    public static boolean isSupportGyroScope(Context context) {
        SensorManager sensorManager;
        return (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    public static boolean isVivoX20A() {
        return StringHelper.equals(Build.MODEL.trim(), "vivo X20A");
    }

    public static boolean isXiaoMi() {
        return RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isfullScreen() {
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
}
