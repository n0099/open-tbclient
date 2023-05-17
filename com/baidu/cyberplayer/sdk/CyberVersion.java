package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
@Keep
/* loaded from: classes3.dex */
public class CyberVersion {
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
        String a = d.a();
        return TextUtils.isEmpty(a) ? "0.0.0.0" : a;
    }

    public static String getSDKVersion() {
        return CyberCfgManager.getInstance().a("enable_version_for_short", true) ? "7.32.10" : SDKVersion.VERSION;
    }

    public static String getSDKVersionInternal() {
        return SDKVersion.VERSION;
    }
}
