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
        if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_ENABLE_VERSION_FOR_SHORT, true)) {
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
        String coreVersion = CyberPlayerCoreInvoker.getCoreVersion();
        if (TextUtils.isEmpty(coreVersion)) {
            return "0.0.0.0";
        }
        return coreVersion;
    }

    public static String getSDKVersion() {
        if (CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_ENABLE_VERSION_FOR_SHORT, true)) {
            return "7.41.99";
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
