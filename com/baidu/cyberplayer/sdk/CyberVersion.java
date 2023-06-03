package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
@Keep
/* loaded from: classes3.dex */
public class CyberVersion {
    public static final int LATER_DOWN_COMPILE_START = 1000;

    public static String getSDKVersionInternal() {
        return SDKVersion.VERSION;
    }

    public static String getCoreVersion() {
        String coreVersionInternal = getCoreVersionInternal();
        if (CyberCfgManager.getInstance().a("enable_version_for_short", true)) {
            try {
                return coreVersionInternal.substring(0, coreVersionInternal.lastIndexOf("."));
            } catch (Exception e) {
                e.printStackTrace();
                return coreVersionInternal;
            }
        }
        return coreVersionInternal;
    }

    public static String getCoreVersionInternal() {
        String a = f.a();
        if (TextUtils.isEmpty(a)) {
            return "0.0.0.0";
        }
        return a;
    }

    public static String getSDKVersion() {
        if (CyberCfgManager.getInstance().a("enable_version_for_short", true)) {
            return "7.39.93";
        }
        return SDKVersion.VERSION;
    }

    public static boolean isLaterDownCyber() {
        int i;
        String[] split = getCoreVersionInternal().split("\\.");
        if (split.length < 4) {
            return false;
        }
        try {
            i = Integer.parseInt(split[3]);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        if (i < 1000) {
            return false;
        }
        return true;
    }
}
