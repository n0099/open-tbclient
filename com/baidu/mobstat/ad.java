package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8883a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8884b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8885c;

    public static ad a() {
        return f8883a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8885c, th, true);
        if (this.f8884b.equals(this)) {
            return;
        }
        this.f8884b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8885c = context;
        if (this.f8884b == null) {
            this.f8884b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
