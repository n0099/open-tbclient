package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Kh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Kh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Kh.Kf;
        this.Kh.aP((int) (currentTimeMillis - j));
        handler = this.Kh.zz;
        runnable = this.Kh.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
