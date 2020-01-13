package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.i.l;
import java.lang.Thread;
/* loaded from: classes6.dex */
class b implements Thread.UncaughtExceptionHandler {
    private final Context a;
    private final Thread.UncaughtExceptionHandler b;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context;
        this.b = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        String b = m.b(this.a, th);
        if (b.contains("com.baidu.android.pushservice")) {
            l.b("exception " + b + " at Time " + System.currentTimeMillis(), this.a.getApplicationContext());
            m.a(this.a, b);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        l.f(this.a, this.a.getPackageName());
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }
}
