package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService anG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.anG = mediaService;
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
        handler = this.anG.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.anG.mPlayer;
        int hN = hVar.hN();
        i = this.anG.mCurBeginSecond;
        int i4 = hN + i;
        i2 = this.anG.mElapsedTime;
        if (i4 != i2) {
            this.anG.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.anG.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.anG.sendBroadcast(intent);
        }
        handler2 = this.anG.mHandler;
        runnable = this.anG.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
