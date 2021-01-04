package com.baidu.android.pushservice;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1174a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f1175b;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1174a = context;
        this.f1175b = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.contains("com.baidu.android.pushservice")) {
            m.a("exception " + stackTraceString + " at Time " + System.currentTimeMillis(), this.f1174a.getApplicationContext());
            new b.c(this.f1174a).a(stackTraceString).a(201002L).a();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.f1175b != null) {
            this.f1175b.uncaughtException(thread, th);
        }
    }
}
