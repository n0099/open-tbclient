package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8571a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8572b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8573c;

    public static ad a() {
        return f8571a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8573c, th, true);
        if (this.f8572b.equals(this)) {
            return;
        }
        this.f8572b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8573c = context;
        if (this.f8572b == null) {
            this.f8572b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
