package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService OG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.OG = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.OG.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.OG.mElapsedTime;
        if (i != i3) {
            this.OG.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.OG.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.OG.sendBroadcast(intent);
        }
        handler = this.OG.mHandler;
        runnable = this.OG.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
