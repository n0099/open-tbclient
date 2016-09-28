package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aiD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aiD = mediaService;
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
        handler = this.aiD.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aiD.mPlayer;
        int gQ = hVar.gQ();
        i = this.aiD.mCurBeginSecond;
        int i4 = gQ + i;
        i2 = this.aiD.mElapsedTime;
        if (i4 != i2) {
            this.aiD.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aiD.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aiD.sendBroadcast(intent);
        }
        handler2 = this.aiD.mHandler;
        runnable = this.aiD.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
