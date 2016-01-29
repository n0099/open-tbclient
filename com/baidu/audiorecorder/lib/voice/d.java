package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c KS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.KS = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.KS.KQ;
        this.KS.aN((int) (currentTimeMillis - j));
        handler = this.KS.zs;
        runnable = this.KS.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
