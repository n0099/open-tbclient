package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService afo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.afo = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.afo.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.afo.mElapsedTime;
        if (i != i3) {
            this.afo.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.afo.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.afo.sendBroadcast(intent);
        }
        handler = this.afo.mHandler;
        runnable = this.afo.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
