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
    public static boolean bpD() {
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

    public static boolean bpE() {
        return au.equals(Build.MODEL.trim(), "ANE-AL00");
    }

    public static boolean bpF() {
        return au.equals(Build.MODEL.trim(), "vivo X20A");
    }

    public static boolean bpG() {
        return au.equals(Build.MODEL.trim(), "PCLM50");
    }

    public static boolean bpH() {
        return au.equals(Build.MODEL.trim(), "MI 5X");
    }

    public static boolean isXiaoMi() {
        return RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static String akI() {
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

    public static boolean eb(Context context) {
        SensorManager sensorManager;
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        return sensorManager.getDefaultSensor(4) != null;
    }
}
