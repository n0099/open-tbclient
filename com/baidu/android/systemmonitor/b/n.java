package com.baidu.android.systemmonitor.b;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.f788a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Process.setThreadPriority(10);
        context = this.f788a.b;
        d a2 = d.a(context.getApplicationContext());
        context2 = this.f788a.b;
        a2.b(context2.getApplicationContext());
    }
}
