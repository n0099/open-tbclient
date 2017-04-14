package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService anR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.anR = mediaService;
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
        handler = this.anR.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.anR.mPlayer;
        int hN = hVar.hN();
        i = this.anR.mCurBeginSecond;
        int i4 = hN + i;
        i2 = this.anR.mElapsedTime;
        if (i4 != i2) {
            this.anR.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.anR.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.anR.sendBroadcast(intent);
        }
        handler2 = this.anR.mHandler;
        runnable = this.anR.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
