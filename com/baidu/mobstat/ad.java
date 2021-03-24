package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8882a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8883b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8884c;

    public static ad a() {
        return f8882a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8884c, th, true);
        if (this.f8883b.equals(this)) {
            return;
        }
        this.f8883b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8884c = context;
        if (this.f8883b == null) {
            this.f8883b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
