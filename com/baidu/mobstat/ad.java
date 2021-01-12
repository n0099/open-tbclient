package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ad f3643a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3644b;
    private Context c;

    public static ad a() {
        return f3643a;
    }

    private ad() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.f3644b == null) {
            this.f3644b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.f3644b.equals(this)) {
            this.f3644b.uncaughtException(thread, th);
        }
    }
}
