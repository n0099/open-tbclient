package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8533a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8534b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8535c;

    public static ad a() {
        return f8533a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8535c, th, true);
        if (this.f8534b.equals(this)) {
            return;
        }
        this.f8534b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8535c = context;
        if (this.f8534b == null) {
            this.f8534b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
