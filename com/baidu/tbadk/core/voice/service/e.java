package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aid = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aid.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.aid.mElapsedTime;
        if (i != i3) {
            this.aid.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.aid.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.aid.sendBroadcast(intent);
        }
        handler = this.aid.mHandler;
        runnable = this.aid.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
