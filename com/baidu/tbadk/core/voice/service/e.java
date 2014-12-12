package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService Of;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.Of = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        i iVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.Of.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.Of.mPlayer;
        int fF = iVar.fF();
        i = this.Of.mCurBeginSecond;
        int i4 = fF + i;
        i2 = this.Of.mElapsedTime;
        if (i4 != i2) {
            this.Of.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.Of.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.Of.sendBroadcast(intent);
        }
        handler2 = this.Of.mHandler;
        runnable = this.Of.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
