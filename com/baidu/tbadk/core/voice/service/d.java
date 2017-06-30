package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aoG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aoG = mediaService;
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
        handler = this.aoG.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aoG.mPlayer;
        int hM = hVar.hM();
        i = this.aoG.mCurBeginSecond;
        int i4 = hM + i;
        i2 = this.aoG.mElapsedTime;
        if (i4 != i2) {
            this.aoG.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aoG.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aoG.sendBroadcast(intent);
        }
        handler2 = this.aoG.mHandler;
        runnable = this.aoG.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
