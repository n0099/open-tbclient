package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aiD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aiD = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aiD.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aiD.mElapsedTime;
        if (i != i3) {
            this.aiD.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aiD.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aiD.sendBroadcast(intent);
        }
        handler = this.aiD.mHandler;
        runnable = this.aiD.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
