package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Eh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Eh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Eh.Ef;
        this.Eh.aR((int) (currentTimeMillis - j));
        handler = this.Eh.sQ;
        runnable = this.Eh.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
