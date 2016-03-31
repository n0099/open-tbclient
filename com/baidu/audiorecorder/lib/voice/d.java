package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c KZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.KZ = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.KZ.KX;
        this.KZ.aM((int) (currentTimeMillis - j));
        handler = this.KZ.zK;
        runnable = this.KZ.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
