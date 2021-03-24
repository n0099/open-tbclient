package com.baidu.searchbox.player;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
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
/* loaded from: classes3.dex */
public class BDPlayerConfig {
    public static int DEFAULT_INSTALL_TYPE = 31;
    public static Context sApplication = null;
    public static boolean sIsDebugMode = false;
    public static IKernelFactory sKernelFactory;
    public static IMessengerFactory sMessengerFactory;
    public static int sWindowsHeight;
    public static int sWindowsWidth;

    @PublicMethod
    public static Context getAppContext() {
        return sApplication;
    }

    @NonNull
    @PublicMethod
    public static IKernelFactory getKernelFactory() {
        if (sKernelFactory == null) {
            sKernelFactory = new DefaultKernelFactory();
        }
        return sKernelFactory;
    }

    @NonNull
    @PublicMethod
    public static IMessengerFactory getMessengerFactory() {
        if (sMessengerFactory == null) {
            sMessengerFactory = new MessengerFactory();
        }
        return sMessengerFactory;
    }

    @PublicMethod
    public static void initCyber() {
        initCyber(true);
    }

    @PublicMethod
    public static void initEnv(boolean z) {
        setDebugMode(z);
        Context context = sApplication;
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sWindowsHeight = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            sWindowsWidth = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
    }

    @PublicMethod
    public static boolean isDebug() {
        return sIsDebugMode;
    }

    @PublicMethod
    public static void setAppContext(@NonNull Context context) {
        sApplication = context;
    }

    @PublicMethod
    public static void setDebugMode(boolean z) {
        sIsDebugMode = z;
    }

    @PublicMethod
    public static void setKernelFactory(@NonNull IKernelFactory iKernelFactory) {
        sKernelFactory = iKernelFactory;
    }

    @PublicMethod
    public static void setMessengerFactory(@NonNull IMessengerFactory iMessengerFactory) {
        sMessengerFactory = iMessengerFactory;
    }

    @PublicMethod
    public static void initCyber(boolean z) {
        if (CyberPlayerManager.isCoreLoaded(DEFAULT_INSTALL_TYPE)) {
            return;
        }
        Context appContext = getAppContext();
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
        CyberPlayerManager.install(appContext, DeviceId.getCUID(appContext), null, DEFAULT_INSTALL_TYPE, z ? BDRemotePlayerService.class : null, hashMap, null);
    }

    @PublicMethod
    public static void initCyber(boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        if (CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        Context appContext = getAppContext();
        CyberPlayerManager.install(appContext, DeviceId.getCUID(appContext), null, i, z ? BDRemotePlayerService.class : null, map, installListener);
    }
}
