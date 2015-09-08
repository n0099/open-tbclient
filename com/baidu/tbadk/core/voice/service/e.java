package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.agb = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.agb.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.agb.mElapsedTime;
        if (i != i3) {
            this.agb.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.agb.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.agb.sendBroadcast(intent);
        }
        handler = this.agb.mHandler;
        runnable = this.agb.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
