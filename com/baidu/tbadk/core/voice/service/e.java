package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aiW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aiW = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aiW.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aiW.mElapsedTime;
        if (i != i3) {
            this.aiW.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aiW.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aiW.sendBroadcast(intent);
        }
        handler = this.aiW.mHandler;
        runnable = this.aiW.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
