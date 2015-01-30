package com.baidu.adp.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h ov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ov = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ov.ot;
        this.ov.af((int) (currentTimeMillis - j));
        handler = this.ov.og;
        runnable = this.ov.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
