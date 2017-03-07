package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService anD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.anD = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        h hVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.anD.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.anD.mPlayer;
        int hI = hVar.hI();
        i = this.anD.mCurBeginSecond;
        int i4 = hI + i;
        i2 = this.anD.mElapsedTime;
        if (i4 != i2) {
            this.anD.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.anD.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.anD.sendBroadcast(intent);
        }
        handler2 = this.anD.mHandler;
        runnable = this.anD.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
