package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.p;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements Thread.UncaughtExceptionHandler {
    private String a = "DefaultExceptionHandler";
    private Context b;

    public b(Context context) {
        this.b = null;
        this.b = context;
    }

    private void a(Throwable th) {
        String b = q.b(this.b, th);
        p.b("exception " + b + " at Time " + System.currentTimeMillis(), this.b.getApplicationContext());
        q.b(this.b, b);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        p.f(this.b, this.b.getPackageName());
    }
}
