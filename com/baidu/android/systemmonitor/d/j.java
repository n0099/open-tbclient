package com.baidu.android.systemmonitor.d;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.f674a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Process.setThreadPriority(10);
        context = this.f674a.b;
        e a2 = e.a(context.getApplicationContext());
        context2 = this.f674a.b;
        a2.b(context2.getApplicationContext());
    }
}
