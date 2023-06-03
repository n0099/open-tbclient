package com.baidu.searchbox.player;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.kernel.EmptyKernelFactory;
import com.baidu.searchbox.player.kernel.IKernelFactory;
import com.baidu.searchbox.player.message.IMessengerFactory;
import com.baidu.searchbox.player.message.MessengerFactory;
/* loaded from: classes4.dex */
public class BDPlayerConfig {
    public static Context sApplication;
    public static boolean sIsDebugMode;
    public static boolean sIsDoveOptEnable;
    public static IKernelFactory sKernelFactory;
    public static IMessengerFactory sMessengerFactory;
    public static int sWindowsHeight;
    public static int sWindowsWidth;

    public static Context getAppContext() {
        return sApplication;
    }

    @NonNull
    public static IKernelFactory getKernelFactory() {
        if (sKernelFactory == null) {
            sKernelFactory = new EmptyKernelFactory();
        }
        return sKernelFactory;
    }

    @NonNull
    public static IMessengerFactory getMessengerFactory() {
        if (sMessengerFactory == null) {
            sMessengerFactory = new MessengerFactory();
        }
        return sMessengerFactory;
    }

    public static boolean getsIsDoveOptEnable() {
        return sIsDoveOptEnable;
    }

    public static void initEnv() {
        Context context = sApplication;
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sWindowsHeight = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            sWindowsWidth = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
    }

    public static boolean isDebug() {
        return sIsDebugMode;
    }

    public static void initEnv(boolean z) {
        setDebugMode(z);
        Context context = sApplication;
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sWindowsHeight = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            sWindowsWidth = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
    }

    public static void setAppContext(@NonNull Context context) {
        sApplication = context;
    }

    public static void setDebugMode(boolean z) {
        sIsDebugMode = z;
    }

    public static void setKernelFactory(@NonNull IKernelFactory iKernelFactory) {
        sKernelFactory = iKernelFactory;
    }

    public static void setMessengerFactory(@NonNull IMessengerFactory iMessengerFactory) {
        sMessengerFactory = iMessengerFactory;
    }

    public static void setsIsDoveOptEnable(boolean z) {
        sIsDoveOptEnable = z;
    }
}
