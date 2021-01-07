package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ad f3681a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3682b;
    private Context c;

    public static ad a() {
        return f3681a;
    }

    private ad() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.f3682b == null) {
            this.f3682b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.f3682b.equals(this)) {
            this.f3682b.uncaughtException(thread, th);
        }
    }
}
