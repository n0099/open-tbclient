package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Kn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Kn = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Kn.Kl;
        this.Kn.aH((int) (currentTimeMillis - j));
        handler = this.Kn.zi;
        runnable = this.Kn.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
