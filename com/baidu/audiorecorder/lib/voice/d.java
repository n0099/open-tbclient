package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Bq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Bq = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Bq.Bo;
        this.Bq.az((int) (currentTimeMillis - j));
        handler = this.Bq.pX;
        runnable = this.Bq.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
