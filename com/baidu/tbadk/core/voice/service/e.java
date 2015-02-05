package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.OD = mediaService;
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
        handler = this.OD.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.OD.mPlayer;
        int fE = iVar.fE();
        i = this.OD.mCurBeginSecond;
        int i4 = fE + i;
        i2 = this.OD.mElapsedTime;
        if (i4 != i2) {
            this.OD.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.OD.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.OD.sendBroadcast(intent);
        }
        handler2 = this.OD.mHandler;
        runnable = this.OD.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
