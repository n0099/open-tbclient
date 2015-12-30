package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c KD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.KD = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.KD.KB;
        this.KD.aA((int) (currentTimeMillis - j));
        handler = this.KD.zk;
        runnable = this.KD.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
