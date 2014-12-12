package com.baidu.adp.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h oq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.oq = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.oq.om;
        this.oq.aa((int) (currentTimeMillis - j));
        handler = this.oq.ob;
        runnable = this.oq.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
