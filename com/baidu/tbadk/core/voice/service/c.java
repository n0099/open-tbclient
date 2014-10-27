package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ MediaService IW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaService mediaService) {
        this.IW = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        g gVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.IW.mHandler;
        if (handler == null) {
            return;
        }
        gVar = this.IW.mPlayer;
        int fD = gVar.fD();
        i = this.IW.mCurBeginSecond;
        int i4 = fD + i;
        i2 = this.IW.mElapsedTime;
        if (i4 != i2) {
            this.IW.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.IW.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.IW.sendBroadcast(intent);
        }
        handler2 = this.IW.mHandler;
        runnable = this.IW.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
