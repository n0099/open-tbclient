package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes3.dex */
class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ad f3646a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3647b;
    private Context c;

    public static ad a() {
        return f3646a;
    }

    private ad() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.f3647b == null) {
            this.f3647b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.f3647b.equals(this)) {
            this.f3647b.uncaughtException(thread, th);
        }
    }
}
