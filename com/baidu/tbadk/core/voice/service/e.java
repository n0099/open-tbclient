package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aha = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aha.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aha.mElapsedTime;
        if (i != i3) {
            this.aha.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aha.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aha.sendBroadcast(intent);
        }
        handler = this.aha.mHandler;
        runnable = this.aha.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
