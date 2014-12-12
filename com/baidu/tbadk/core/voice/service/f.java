package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService Of;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.Of = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.Of.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.Of.mElapsedTime;
        if (i != i3) {
            this.Of.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.Of.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.Of.sendBroadcast(intent);
        }
        handler = this.Of.mHandler;
        runnable = this.Of.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
