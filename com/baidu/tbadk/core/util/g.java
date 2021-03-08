package com.baidu.tbadk.core.util;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.switchs.IsFullScreenSwitch;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class g {
    public static boolean bsa() {
        boolean z = true;
        if (IsFullScreenSwitch.isOn()) {
            String trim = Build.MODEL.trim();
            String[] strArr = {"ANE-AL00", "CLT-AL01", "PACM00", "vivo Y85A", "vivo X21A", "SM-G8870"};
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (strArr[i].equalsIgnoreCase(trim)) {
                    break;
                } else {
                    i++;
                }
            }
            return z;
        }
        return false;
    }

    public static boolean bsb() {
        return au.equals(Build.MODEL.trim(), "ANE-AL00");
    }

    public static boolean bsc() {
        return au.equals(Build.MODEL.trim(), "vivo X20A");
    }

    public static boolean bsd() {
        return au.equals(Build.MODEL.trim(), "HMA-AL00");
    }

    public static boolean bse() {
        return au.equals(Build.MODEL.trim(), "PCLM50");
    }

    public static boolean bsf() {
        return au.equals(Build.MODEL.trim(), "MI 5X");
    }

    public static boolean isXiaoMi() {
        return RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static String alJ() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return "NUL";
        }
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static boolean isHuaWei() {
        String str = Build.MODEL;
        return (!TextUtils.isEmpty(str) && str.contains(RomUtils.MANUFACTURER_HUAWEI)) || RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean bsg() {
        String str = Build.MODEL;
        return (!TextUtils.isEmpty(str) && str.contains("honor")) || "honor".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static int bsh() {
        if (isHuaWei() || bsg()) {
            String str = Build.HARDWARE;
            if (!TextUtils.isEmpty(str) && (str.equalsIgnoreCase("kirin980") || str.equalsIgnoreCase("kirin970") || str.equalsIgnoreCase("kirin960") || str.equalsIgnoreCase("kirin950") || str.equalsIgnoreCase("kirin935") || str.equalsIgnoreCase("kirin930") || str.equalsIgnoreCase("kirin928") || str.equalsIgnoreCase("kirin925") || str.equalsIgnoreCase("kirin920") || str.equalsIgnoreCase("kirin910") || str.equalsIgnoreCase("kirin710") || str.equalsIgnoreCase("kirin659"))) {
                return 1000;
            }
        }
        return 0;
    }

    public static boolean eV(Context context) {
        SensorManager sensorManager;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        return sensorManager.getDefaultSensor(4) != null;
    }
}
