package com.baidu.searchbox.player;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.DeviceId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.kernel.DefaultKernelFactory;
import com.baidu.searchbox.player.kernel.IKernelFactory;
import com.baidu.searchbox.player.message.IMessengerFactory;
import com.baidu.searchbox.player.message.MessengerFactory;
import com.baidu.searchbox.player.remote.BDRemotePlayerService;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class BDPlayerConfig {
    private static Context sApplication;
    private static IKernelFactory sKernelFactory;
    private static IMessengerFactory sMessengerFactory;
    public static int sWindowsHeight;
    public static int sWindowsWidth;
    private static boolean sIsDebugMode = false;
    public static int DEFAULT_INSTALL_TYPE = 31;

    @PublicMethod
    public static void initEnv(boolean z) {
        setDebugMode(z);
        if (sApplication != null) {
            DisplayMetrics displayMetrics = sApplication.getResources().getDisplayMetrics();
            sWindowsHeight = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            sWindowsWidth = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
    }

    @PublicMethod
    public static void initCyber() {
        initCyber(true);
    }

    @PublicMethod
    public static void initCyber(boolean z) {
        if (!CyberPlayerManager.isCoreLoaded(DEFAULT_INSTALL_TYPE)) {
            Context appContext = getAppContext();
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
            CyberPlayerManager.install(appContext, DeviceId.getCUID(appContext), null, DEFAULT_INSTALL_TYPE, z ? BDRemotePlayerService.class : null, hashMap, null);
        }
    }

    @PublicMethod
    public static void initCyber(boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        if (!CyberPlayerManager.isCoreLoaded(i)) {
            Context appContext = getAppContext();
            CyberPlayerManager.install(appContext, DeviceId.getCUID(appContext), null, i, z ? BDRemotePlayerService.class : null, map, installListener);
        }
    }

    @PublicMethod
    public static void setAppContext(@NonNull Context context) {
        sApplication = context;
    }

    @PublicMethod
    public static Context getAppContext() {
        return sApplication;
    }

    @PublicMethod
    public static void setDebugMode(boolean z) {
        sIsDebugMode = z;
    }

    @PublicMethod
    public static boolean isDebug() {
        return sIsDebugMode;
    }

    @PublicMethod
    @NonNull
    public static IMessengerFactory getMessengerFactory() {
        if (sMessengerFactory == null) {
            sMessengerFactory = new MessengerFactory();
        }
        return sMessengerFactory;
    }

    @PublicMethod
    public static void setMessengerFactory(@NonNull IMessengerFactory iMessengerFactory) {
        sMessengerFactory = iMessengerFactory;
    }

    @PublicMethod
    @NonNull
    public static IKernelFactory getKernelFactory() {
        if (sKernelFactory == null) {
            sKernelFactory = new DefaultKernelFactory();
        }
        return sKernelFactory;
    }

    @PublicMethod
    public static void setKernelFactory(@NonNull IKernelFactory iKernelFactory) {
        sKernelFactory = iKernelFactory;
    }
}
