package com.baidu.android.pushservice;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Thread.UncaughtExceptionHandler {
    private final Context a;
    private final Thread.UncaughtExceptionHandler b;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context;
        this.b = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.contains("com.baidu.android.pushservice")) {
            m.a("exception " + stackTraceString + " at Time " + System.currentTimeMillis(), this.a.getApplicationContext());
            new b.c(this.a).a(stackTraceString).a(201002L).a();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
