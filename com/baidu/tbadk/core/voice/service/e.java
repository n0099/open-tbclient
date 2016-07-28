package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService agh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.agh = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.agh.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.agh.mElapsedTime;
        if (i != i3) {
            this.agh.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.agh.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.agh.sendBroadcast(intent);
        }
        handler = this.agh.mHandler;
        runnable = this.agh.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
