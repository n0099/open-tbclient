package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8759a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8760b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8761c;

    public static ad a() {
        return f8759a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8761c, th, true);
        if (this.f8760b.equals(this)) {
            return;
        }
        this.f8760b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8761c = context;
        if (this.f8760b == null) {
            this.f8760b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
