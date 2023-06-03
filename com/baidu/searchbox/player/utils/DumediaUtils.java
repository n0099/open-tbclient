package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.remote.BDRemotePlayerService;
import com.baidu.searchbox.playerserver.PlayerPolicyCfgManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DumediaUtils {
    public static final int DEFAULT_INSTALL_TYPE = 23;
    public static final String KEY_USER_TAG_LIST = "feed_user_tag";
    public static final int LIB_ID_CRYPTO = 102;
    public static final int LIB_ID_FFMPEG = 100;
    public static final int LIB_ID_OPENSSL = 101;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface CyberLibType {
    }

    @NonNull
    public static String getCyberSDKVersion() {
        return "7.39.70.7";
    }

    public static int getPlayQualityScore() {
        return getPlayQualityScore(852, 480);
    }

    @NonNull
    public static String getUserTag() {
        String str;
        PlayerPolicyCfgManager.PlayerPolicyBandwidthConfig playerConfig = PlayerPolicyCfgManager.getInstance().getPlayerConfig();
        if (playerConfig == null) {
            str = "";
        } else {
            str = playerConfig.getString(KEY_USER_TAG_LIST);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static void initCyber() {
        initCyber("", true);
    }

    public String getCyberNativeVersion() {
        return CyberPlayerManager.getCoreVersion();
    }

    @Nullable
    public static String getLibPath(int i) {
        return getLibPath(23, i);
    }

    public static void initCyber(@NonNull String str) {
        initCyber(str, true);
    }

    public static boolean isDumediaLoaded(int i) {
        return CyberPlayerManager.isCoreLoaded(i);
    }

    public static void preResolveHosts(List<String> list) {
        CyberPlayerManager.preResolveHosts(list);
    }

    @Nullable
    public static String getLibPath(int i, int i2) {
        if (isDumediaLoaded(i)) {
            Object libPath = CyberPlayerManager.getLibPath(i2);
            if (libPath instanceof String) {
                return (String) libPath;
            }
            return null;
        }
        return null;
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

    public static void initCyber(@NonNull String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
        try {
            initCyber(str, z, 23, hashMap, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initCyber(@NonNull String str, boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        try {
            initCyber("", z, i, map, installListener, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void initCyber(@NonNull String str, boolean z, int i, Map<String, String> map, @Nullable CyberPlayerManager.InstallListener installListener, @Nullable CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Class<BDRemotePlayerService> cls;
        if (CyberPlayerManager.isCoreLoaded(i)) {
            if (installListener != null) {
                installListener.onInstallSuccess(i, "");
                return;
            }
            return;
        }
        Context appContext = BDPlayerConfig.getAppContext();
        if (z) {
            cls = BDRemotePlayerService.class;
        } else {
            cls = null;
        }
        try {
            CyberPlayerManager.install(appContext, str, (String) null, i, cls, map, installListener, CyberConfigUtils.getPCDNType());
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void installCyber(@NonNull String str, boolean z, int i, Map<String, String> map, @Nullable CyberPlayerManager.InstallListener2 installListener2, @Nullable CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Class<BDRemotePlayerService> cls;
        if (CyberPlayerManager.isCoreLoaded(i)) {
            if (installListener2 != null) {
                installListener2.onInstallSuccess(i, "");
                return;
            }
            return;
        }
        Context appContext = BDPlayerConfig.getAppContext();
        if (z) {
            cls = BDRemotePlayerService.class;
        } else {
            cls = null;
        }
        try {
            CyberPlayerManager.install(appContext, str, (String) null, i, (Class<?>) cls, map, installListener2, CyberConfigUtils.getPCDNType());
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
