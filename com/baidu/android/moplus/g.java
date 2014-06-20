package com.baidu.android.moplus;

import android.util.Log;
import java.lang.Thread;
/* loaded from: classes.dex */
public class g implements Thread.UncaughtExceptionHandler {
    private static g a = null;

    private g() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static g a() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.i("thread", thread.getName() + " uncaughtException ", th);
    }
}
