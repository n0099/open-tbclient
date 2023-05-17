package com.baidu.searchbox.player.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.remote.BDRemotePlayerService;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DumediaUtils {
    public static final int DEFAULT_INSTALL_TYPE = 31;

    @NonNull
    public static String getCyberSDKVersion() {
        return "7.31.71.29";
    }

    public static int getPlayQualityScore() {
        return getPlayQualityScore(852, 480);
    }

    @PublicMethod
    public static void initCyber() {
        initCyber("", true);
    }

    public String getCyberNativeVersion() {
        return CyberPlayerManager.getCoreVersion();
    }

    public static int getPlayQualityScore(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return CyberPlayerManager.getDevicePlayQualityScore(MimeTypes.VIDEO_H265, 0, i, i2, null);
    }

    @PublicMethod
    public static void initCyber(@NonNull String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
        try {
            initCyber(str, z, 31, hashMap, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PublicMethod
    public static void initCyber(@NonNull String str) {
        initCyber(str, true);
    }

    public static void preResolveHosts(List<String> list) {
        CyberPlayerManager.preResolveHosts(list);
    }

    @PublicMethod
    public static void initCyber(@NonNull String str, boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        try {
            initCyber("", z, i, map, installListener, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PublicMethod(version = "12.8.0.0")
    public static void initCyber(@NonNull String str, boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener, @Nullable CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Class<BDRemotePlayerService> cls;
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        Context appContext = BDPlayerConfig.getAppContext();
        if (z) {
            cls = BDRemotePlayerService.class;
        } else {
            cls = null;
        }
        try {
            CyberPlayerManager.install(appContext, str, (String) null, i, cls, map, installListener);
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
