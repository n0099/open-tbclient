package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService IX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.IX = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.IX.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.IX.mElapsedTime;
        if (i != i3) {
            this.IX.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.IX.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.IX.sendBroadcast(intent);
        }
        handler = this.IX.mHandler;
        runnable = this.IX.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
