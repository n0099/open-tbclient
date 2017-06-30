package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aoG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aoG = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aoG.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aoG.mElapsedTime;
        if (i != i3) {
            this.aoG.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aoG.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aoG.sendBroadcast(intent);
        }
        handler = this.aoG.mHandler;
        runnable = this.aoG.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
