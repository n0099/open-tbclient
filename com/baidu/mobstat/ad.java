package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes15.dex */
class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ad f3680a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3681b;
    private Context c;

    public static ad a() {
        return f3680a;
    }

    private ad() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.f3681b == null) {
            this.f3681b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.f3681b.equals(this)) {
            this.f3681b.uncaughtException(thread, th);
        }
    }
}
