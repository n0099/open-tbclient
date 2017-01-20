package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Dr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Dr = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Dr.Dp;
        this.Dr.aQ((int) (currentTimeMillis - j));
        handler = this.Dr.sH;
        runnable = this.Dr.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
