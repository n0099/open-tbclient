package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements Runnable {
    final /* synthetic */ c JB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.JB = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.JB.Jz;
        this.JB.aM((int) (currentTimeMillis - j));
        handler = this.JB.zD;
        runnable = this.JB.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
