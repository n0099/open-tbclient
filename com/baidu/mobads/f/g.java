package com.baidu.mobads.f;

import android.util.Log;
import java.lang.Thread;
/* loaded from: classes5.dex */
class g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3333a = fVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
