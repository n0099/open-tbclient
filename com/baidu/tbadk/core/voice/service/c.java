package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ MediaService IX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaService mediaService) {
        this.IX = mediaService;
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
        handler = this.IX.mHandler;
        if (handler == null) {
            return;
        }
        gVar = this.IX.mPlayer;
        int fD = gVar.fD();
        i = this.IX.mCurBeginSecond;
        int i4 = fD + i;
        i2 = this.IX.mElapsedTime;
        if (i4 != i2) {
            this.IX.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.IX.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.IX.sendBroadcast(intent);
        }
        handler2 = this.IX.mHandler;
        runnable = this.IX.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
