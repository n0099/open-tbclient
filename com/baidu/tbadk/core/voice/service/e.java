package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aiP = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aiP.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aiP.mElapsedTime;
        if (i != i3) {
            this.aiP.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aiP.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aiP.sendBroadcast(intent);
        }
        handler = this.aiP.mHandler;
        runnable = this.aiP.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
