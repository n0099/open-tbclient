package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Ee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Ee = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Ee.Ec;
        this.Ee.aQ((int) (currentTimeMillis - j));
        handler = this.Ee.sP;
        runnable = this.Ee.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
