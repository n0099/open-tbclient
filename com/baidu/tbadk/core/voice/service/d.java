package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService ajf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.ajf = mediaService;
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
        handler = this.ajf.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.ajf.mPlayer;
        int jH = hVar.jH();
        i = this.ajf.mCurBeginSecond;
        int i4 = jH + i;
        i2 = this.ajf.mElapsedTime;
        if (i4 != i2) {
            this.ajf.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.ajf.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.ajf.sendBroadcast(intent);
        }
        handler2 = this.ajf.mHandler;
        runnable = this.ajf.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
