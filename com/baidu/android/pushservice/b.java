package com.baidu.android.pushservice;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import java.lang.Thread;
/* loaded from: classes.dex */
public class b implements Thread.UncaughtExceptionHandler {
    public final Thread.UncaughtExceptionHandler a;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    public final void a(Throwable th) {
        Log.getStackTraceString(th).contains(MultiDexHelper.PUSH_SDK_PREFIX);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
