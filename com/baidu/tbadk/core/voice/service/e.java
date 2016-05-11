package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aeR = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aeR.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aeR.mElapsedTime;
        if (i != i3) {
            this.aeR.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aeR.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aeR.sendBroadcast(intent);
        }
        handler = this.aeR.mHandler;
        runnable = this.aeR.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
