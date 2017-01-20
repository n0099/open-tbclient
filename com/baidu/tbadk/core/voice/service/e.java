package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aih = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aih.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aih.mElapsedTime;
        if (i != i3) {
            this.aih.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aih.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aih.sendBroadcast(intent);
        }
        handler = this.aih.mHandler;
        runnable = this.aih.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
