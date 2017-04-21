package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Kj = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Kj.Kh;
        this.Kj.aP((int) (currentTimeMillis - j));
        handler = this.Kj.zC;
        runnable = this.Kj.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
