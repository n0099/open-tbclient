package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Eg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Eg = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Eg.Ee;
        this.Eg.aQ((int) (currentTimeMillis - j));
        handler = this.Eg.sQ;
        runnable = this.Eg.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
