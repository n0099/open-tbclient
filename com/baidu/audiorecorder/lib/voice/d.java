package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c JR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.JR = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.JR.JP;
        this.JR.aE((int) (currentTimeMillis - j));
        handler = this.JR.zs;
        runnable = this.JR.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
