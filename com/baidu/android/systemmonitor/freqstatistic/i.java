package com.baidu.android.systemmonitor.freqstatistic;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Process.setThreadPriority(10);
        context = this.a.b;
        e a = e.a(context.getApplicationContext());
        context2 = this.a.b;
        a.b(context2.getApplicationContext());
    }
}
