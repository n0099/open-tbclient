package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Ka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Ka = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Ka.JY;
        this.Ka.aG((int) (currentTimeMillis - j));
        handler = this.Ka.zD;
        runnable = this.Ka.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
