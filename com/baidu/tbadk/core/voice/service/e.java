package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService ajb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.ajb = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajb.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.ajb.mElapsedTime;
        if (i != i3) {
            this.ajb.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.ajb.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.ajb.sendBroadcast(intent);
        }
        handler = this.ajb.mHandler;
        runnable = this.ajb.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
