package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService agh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.agh = mediaService;
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
        handler = this.agh.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.agh.mPlayer;
        int fU = hVar.fU();
        i = this.agh.mCurBeginSecond;
        int i4 = fU + i;
        i2 = this.agh.mElapsedTime;
        if (i4 != i2) {
            this.agh.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.agh.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.agh.sendBroadcast(intent);
        }
        handler2 = this.agh.mHandler;
        runnable = this.agh.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
