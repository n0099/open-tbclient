package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aih = mediaService;
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
        handler = this.aih.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aih.mPlayer;
        int gO = hVar.gO();
        i = this.aih.mCurBeginSecond;
        int i4 = gO + i;
        i2 = this.aih.mElapsedTime;
        if (i4 != i2) {
            this.aih.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aih.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aih.sendBroadcast(intent);
        }
        handler2 = this.aih.mHandler;
        runnable = this.aih.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
