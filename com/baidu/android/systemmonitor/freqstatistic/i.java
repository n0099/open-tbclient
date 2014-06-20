package com.baidu.android.systemmonitor.freqstatistic;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Process.setThreadPriority(10);
        context = this.a.b;
        c a = c.a(context.getApplicationContext());
        context2 = this.a.b;
        a.b(context2.getApplicationContext());
    }
}
