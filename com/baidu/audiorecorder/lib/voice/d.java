package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements Runnable {
    final /* synthetic */ c Jp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Jp = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Jp.Jn;
        this.Jp.aN((int) (currentTimeMillis - j));
        handler = this.Jp.zD;
        runnable = this.Jp.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
