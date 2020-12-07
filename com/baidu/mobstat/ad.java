package com.baidu.mobstat;

import android.content.Context;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ad implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final ad f2522a = new ad();
    private Thread.UncaughtExceptionHandler b;
    private Context c;

    public static ad a() {
        return f2522a;
    }

    private ad() {
    }

    public void a(Context context) {
        this.c = context;
        if (this.b == null) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ExceptionAnalysis.getInstance().saveCrashInfo(this.c, th, true);
        if (!this.b.equals(this)) {
            this.b.uncaughtException(thread, th);
        }
    }
}
