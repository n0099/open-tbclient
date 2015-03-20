package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService ZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.ZL = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ZL.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.ZL.mElapsedTime;
        if (i != i3) {
            this.ZL.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.ZL.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.ZL.sendBroadcast(intent);
        }
        handler = this.ZL.mHandler;
        runnable = this.ZL.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
