package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService anW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.anW = mediaService;
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
        handler = this.anW.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.anW.mPlayer;
        int hN = hVar.hN();
        i = this.anW.mCurBeginSecond;
        int i4 = hN + i;
        i2 = this.anW.mElapsedTime;
        if (i4 != i2) {
            this.anW.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.anW.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.anW.sendBroadcast(intent);
        }
        handler2 = this.anW.mHandler;
        runnable = this.anW.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
