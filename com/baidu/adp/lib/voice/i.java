package com.baidu.adp.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h or;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.or = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.or.oo;
        this.or.S((int) (currentTimeMillis - j));
        handler = this.or.ob;
        runnable = this.or.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
