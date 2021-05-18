package com.baidu.android.util.concurrent;

import android.os.Handler;
@Deprecated
/* loaded from: classes.dex */
public class UiThreadUtil {
    public static volatile Handler sMainHandler;

    public static Handler getMainHandler() {
        return UiThreadUtils.getMainHandler();
    }

    public static boolean isOnUiThread() {
        return UiThreadUtils.isOnUiThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        UiThreadUtils.runOnUiThread(runnable);
    }

    public static void runOnUiThreadAtFrontOfQueue(Runnable runnable) {
        UiThreadUtils.runOnUiThreadAtFrontOfQueue(runnable);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        UiThreadUtils.runOnUiThread(runnable, j);
    }
}
