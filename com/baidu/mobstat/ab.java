package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes3.dex */
public class ab implements Thread.UncaughtExceptionHandler {
    public static final ab a = new ab();
    public Thread.UncaughtExceptionHandler b;
    public Context c;

    public static ab a() {
        return a;
    }

    public void a(Context context) {
        this.c = context;
        if (this.b == null) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!CooperService.instance().isCloseTrace()) {
            ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        }
        if (!this.b.equals(this)) {
            this.b.uncaughtException(thread, th);
        }
    }
}
