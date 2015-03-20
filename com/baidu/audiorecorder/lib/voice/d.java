package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c JY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.JY = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.JY.JW;
        this.JY.aG((int) (currentTimeMillis - j));
        handler = this.JY.zD;
        runnable = this.JY.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
