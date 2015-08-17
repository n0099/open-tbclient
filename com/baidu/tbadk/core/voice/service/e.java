package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.afR = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.afR.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.afR.mElapsedTime;
        if (i != i3) {
            this.afR.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.afR.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.afR.sendBroadcast(intent);
        }
        handler = this.afR.mHandler;
        runnable = this.afR.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
