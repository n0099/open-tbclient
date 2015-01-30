package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService OG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.OG = mediaService;
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
        handler = this.OG.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.OG.mPlayer;
        int fE = iVar.fE();
        i = this.OG.mCurBeginSecond;
        int i4 = fE + i;
        i2 = this.OG.mElapsedTime;
        if (i4 != i2) {
            this.OG.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.OG.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.OG.sendBroadcast(intent);
        }
        handler2 = this.OG.mHandler;
        runnable = this.OG.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
