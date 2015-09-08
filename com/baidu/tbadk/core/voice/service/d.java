package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService agb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.agb = mediaService;
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
        handler = this.agb.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.agb.mPlayer;
        int jo = hVar.jo();
        i = this.agb.mCurBeginSecond;
        int i4 = jo + i;
        i2 = this.agb.mElapsedTime;
        if (i4 != i2) {
            this.agb.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.agb.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.agb.sendBroadcast(intent);
        }
        handler2 = this.agb.mHandler;
        runnable = this.agb.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
