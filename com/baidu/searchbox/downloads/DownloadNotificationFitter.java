package com.baidu.searchbox.downloads;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class DownloadNotificationFitter {
    public static final String MIUI_NAME = "ro.miui.ui.version.name";
    public static final String VIVO = "vivo";
    public static String sMiOsName;

    public static boolean checkIsMiuiRom() {
        if (sMiOsName == null) {
            sMiOsName = PrivateApiUtils.getSystemProperty("ro.miui.ui.version.name", "");
        }
        return !TextUtils.isEmpty(sMiOsName);
    }

    public static boolean checkIsVivoRom() {
        String str = Build.MANUFACTURER;
        if (str != null && str.length() > 0) {
            return TextUtils.equals(str.toLowerCase(Locale.getDefault()), "vivo");
        }
        return false;
    }

    public static boolean checkIsVivoVersion25() {
        if (checkIsVivoRom() && checkVersionIs25()) {
            return true;
        }
        return false;
    }

    public static boolean checkVersionIs25() {
        if (DeviceUtil.OSInfo.getSDKLevel() == 25) {
            return true;
        }
        return false;
    }
}
