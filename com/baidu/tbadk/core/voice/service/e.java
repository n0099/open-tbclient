package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService ajf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.ajf = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajf.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.ajf.mElapsedTime;
        if (i != i3) {
            this.ajf.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.ajf.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.ajf.sendBroadcast(intent);
        }
        handler = this.ajf.mHandler;
        runnable = this.ajf.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
