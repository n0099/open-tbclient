package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService ajb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.ajb = mediaService;
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
        handler = this.ajb.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.ajb.mPlayer;
        int gQ = hVar.gQ();
        i = this.ajb.mCurBeginSecond;
        int i4 = gQ + i;
        i2 = this.ajb.mElapsedTime;
        if (i4 != i2) {
            this.ajb.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.ajb.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.ajb.sendBroadcast(intent);
        }
        handler2 = this.ajb.mHandler;
        runnable = this.ajb.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
