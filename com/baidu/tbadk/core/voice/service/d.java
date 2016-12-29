package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aiW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aiW = mediaService;
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
        handler = this.aiW.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aiW.mPlayer;
        int gQ = hVar.gQ();
        i = this.aiW.mCurBeginSecond;
        int i4 = gQ + i;
        i2 = this.aiW.mElapsedTime;
        if (i4 != i2) {
            this.aiW.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aiW.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aiW.sendBroadcast(intent);
        }
        handler2 = this.aiW.mHandler;
        runnable = this.aiW.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
