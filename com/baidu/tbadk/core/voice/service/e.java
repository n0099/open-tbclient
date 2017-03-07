package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService anD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.anD = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.anD.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.anD.mElapsedTime;
        if (i != i3) {
            this.anD.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.anD.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.anD.sendBroadcast(intent);
        }
        handler = this.anD.mHandler;
        runnable = this.anD.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
