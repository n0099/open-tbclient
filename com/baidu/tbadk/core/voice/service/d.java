package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService afo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.afo = mediaService;
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
        handler = this.afo.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.afo.mPlayer;
        int jp = hVar.jp();
        i = this.afo.mCurBeginSecond;
        int i4 = jp + i;
        i2 = this.afo.mElapsedTime;
        if (i4 != i2) {
            this.afo.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.afo.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.afo.sendBroadcast(intent);
        }
        handler2 = this.afo.mHandler;
        runnable = this.afo.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
