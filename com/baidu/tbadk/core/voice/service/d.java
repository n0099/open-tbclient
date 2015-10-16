package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService afp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.afp = mediaService;
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
        handler = this.afp.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.afp.mPlayer;
        int jp = hVar.jp();
        i = this.afp.mCurBeginSecond;
        int i4 = jp + i;
        i2 = this.afp.mElapsedTime;
        if (i4 != i2) {
            this.afp.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.afp.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.afp.sendBroadcast(intent);
        }
        handler2 = this.afp.mHandler;
        runnable = this.afp.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
