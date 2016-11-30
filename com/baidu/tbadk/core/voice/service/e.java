package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService ajv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.ajv = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ajv.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.ajv.mElapsedTime;
        if (i != i3) {
            this.ajv.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.ajv.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.ajv.sendBroadcast(intent);
        }
        handler = this.ajv.mHandler;
        runnable = this.ajv.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
