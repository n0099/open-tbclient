package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c KG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.KG = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.KG.KE;
        this.KG.aQ((int) (currentTimeMillis - j));
        handler = this.KG.zY;
        runnable = this.KG.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
