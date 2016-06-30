package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService afs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.afs = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.afs.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.afs.mElapsedTime;
        if (i != i3) {
            this.afs.mElapsedTime = i3 / 1000;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.afs.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.afs.sendBroadcast(intent);
        }
        handler = this.afs.mHandler;
        runnable = this.afs.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
