package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.afu = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.afu.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.afu.mElapsedTime;
        if (i != i3) {
            this.afu.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.afu.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.afu.sendBroadcast(intent);
        }
        handler = this.afu.mHandler;
        runnable = this.afu.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
