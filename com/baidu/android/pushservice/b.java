package com.baidu.android.pushservice;

import android.content.Context;
import android.util.Log;
import com.baidu.adp.framework.cmdRouter.MultiDexHelper;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2691a;

    /* renamed from: b  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f2692b;

    public b(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f2691a = context;
        this.f2692b = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.contains(MultiDexHelper.PUSH_SDK_PREFIX)) {
            m.a("exception " + stackTraceString + " at Time " + System.currentTimeMillis(), this.f2691a.getApplicationContext());
            new b.c(this.f2691a).a(stackTraceString).a(201002L).a();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2692b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
