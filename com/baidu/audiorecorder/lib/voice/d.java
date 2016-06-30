package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Br = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Br.Bp;
        this.Br.aA((int) (currentTimeMillis - j));
        handler = this.Br.pX;
        runnable = this.Br.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
