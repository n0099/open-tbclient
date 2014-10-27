package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService IW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.IW = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.IW.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.IW.mElapsedTime;
        if (i != i3) {
            this.IW.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.IW.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.IW.sendBroadcast(intent);
        }
        handler = this.IW.mHandler;
        runnable = this.IW.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
