package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aeR = mediaService;
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
        handler = this.aeR.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aeR.mPlayer;
        int fU = hVar.fU();
        i = this.aeR.mCurBeginSecond;
        int i4 = fU + i;
        i2 = this.aeR.mElapsedTime;
        if (i4 != i2) {
            this.aeR.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aeR.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aeR.sendBroadcast(intent);
        }
        handler2 = this.aeR.mHandler;
        runnable = this.aeR.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
