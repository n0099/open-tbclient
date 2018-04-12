package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.j.m;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements Thread.UncaughtExceptionHandler {
    private String a = "DefaultExceptionHandler";
    private Context b;

    public b(Context context) {
        this.b = null;
        this.b = context;
    }

    private void a(Throwable th) {
        String b = o.b(this.b, th);
        m.b("exception " + b + " at Time " + System.currentTimeMillis(), this.b.getApplicationContext());
        o.b(this.b, b);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        m.f(this.b, this.b.getPackageName());
    }
}
