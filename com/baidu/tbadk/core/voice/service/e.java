package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService ZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.ZL = mediaService;
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
        handler = this.ZL.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.ZL.mPlayer;
        int jh = iVar.jh();
        i = this.ZL.mCurBeginSecond;
        int i4 = jh + i;
        i2 = this.ZL.mElapsedTime;
        if (i4 != i2) {
            this.ZL.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.ZL.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.ZL.sendBroadcast(intent);
        }
        handler2 = this.ZL.mHandler;
        runnable = this.ZL.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
