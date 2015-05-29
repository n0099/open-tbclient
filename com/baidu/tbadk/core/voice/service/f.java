package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aaO = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aaO.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aaO.mElapsedTime;
        if (i != i3) {
            this.aaO.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aaO.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aaO.sendBroadcast(intent);
        }
        handler = this.aaO.mHandler;
        runnable = this.aaO.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
