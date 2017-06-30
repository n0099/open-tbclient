package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d implements Runnable {
    final /* synthetic */ c Jo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Jo = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Jo.Jm;
        this.Jo.aN((int) (currentTimeMillis - j));
        handler = this.Jo.zD;
        runnable = this.Jo.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
