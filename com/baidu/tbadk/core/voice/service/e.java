package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.aaO = mediaService;
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
        handler = this.aaO.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.aaO.mPlayer;
        int jy = iVar.jy();
        i = this.aaO.mCurBeginSecond;
        int i4 = jy + i;
        i2 = this.aaO.mElapsedTime;
        if (i4 != i2) {
            this.aaO.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aaO.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aaO.sendBroadcast(intent);
        }
        handler2 = this.aaO.mHandler;
        runnable = this.aaO.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
