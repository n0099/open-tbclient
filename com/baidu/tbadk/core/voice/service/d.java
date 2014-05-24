package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.a = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        Handler handler;
        Runnable runnable;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.a.mStartRecorderTime;
        int i3 = (int) (currentTimeMillis - j);
        i = this.a.mElapsedTime;
        if (i != i3) {
            this.a.mElapsedTime = i3 / LocationClientOption.MIN_SCAN_SPAN;
            Intent intent = new Intent("com.baidu.recordElapsedTime");
            i2 = this.a.mElapsedTime;
            intent.putExtra("com.baidu.msg.recordElapsedTime", i2);
            this.a.sendBroadcast(intent);
        }
        handler = this.a.mHandler;
        runnable = this.a.mRecordTimeThread;
        handler.postDelayed(runnable, 200L);
    }
}
