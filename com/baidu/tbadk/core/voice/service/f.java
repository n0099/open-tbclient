package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MediaService ZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.ZN = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ZN.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.ZN.mElapsedTime;
        if (i != i3) {
            this.ZN.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.ZN.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.ZN.sendBroadcast(intent);
        }
        handler = this.ZN.mHandler;
        runnable = this.ZN.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
