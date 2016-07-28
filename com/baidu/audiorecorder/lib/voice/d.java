package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c BR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.BR = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.BR.BP;
        this.BR.aD((int) (currentTimeMillis - j));
        handler = this.BR.qz;
        runnable = this.BR.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
