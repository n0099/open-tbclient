package com.baidu.mobads.f;

import android.util.Log;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f8246a;

    public g(f fVar) {
        this.f8246a = fVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
