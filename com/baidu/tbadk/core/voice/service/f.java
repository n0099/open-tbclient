package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.OD = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.OD.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.OD.mElapsedTime;
        if (i != i3) {
            this.OD.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.OD.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.OD.sendBroadcast(intent);
        }
        handler = this.OD.mHandler;
        runnable = this.OD.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
