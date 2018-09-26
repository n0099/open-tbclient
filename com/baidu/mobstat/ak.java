package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ak implements Thread.UncaughtExceptionHandler {
    private static final ak a = new ak();
    private Thread.UncaughtExceptionHandler b;
    private Context c;

    public static ak a() {
        return a;
    }

    private ak() {
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
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.b.equals(this)) {
            this.b.uncaughtException(thread, th);
        }
    }
}
