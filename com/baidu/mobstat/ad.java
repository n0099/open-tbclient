package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f8471a = new ad();

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8472b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8473c;

    public static ad a() {
        return f8471a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.f8473c, th, true);
        if (this.f8472b.equals(this)) {
            return;
        }
        this.f8472b.uncaughtException(thread, th);
    }

    public void a(Context context) {
        this.f8473c = context;
        if (this.f8472b == null) {
            this.f8472b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }
}
