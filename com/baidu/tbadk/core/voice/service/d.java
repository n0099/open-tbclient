package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aiP = mediaService;
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
        handler = this.aiP.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aiP.mPlayer;
        int jB = hVar.jB();
        i = this.aiP.mCurBeginSecond;
        int i4 = jB + i;
        i2 = this.aiP.mElapsedTime;
        if (i4 != i2) {
            this.aiP.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aiP.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aiP.sendBroadcast(intent);
        }
        handler2 = this.aiP.mHandler;
        runnable = this.aiP.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
