package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8457a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8458b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8459c;

    public static ad a() {
        return f8457a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8459c, th, true);
        if (this.f8458b.equals(this)) {
            return;
        }
        this.f8458b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8459c = context;
        if (this.f8458b == null) {
            this.f8458b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
