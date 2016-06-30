package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService afs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.afs = mediaService;
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
        handler = this.afs.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.afs.mPlayer;
        int fV = hVar.fV();
        i = this.afs.mCurBeginSecond;
        int i4 = fV + i;
        i2 = this.afs.mElapsedTime;
        if (i4 != i2) {
            this.afs.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.afs.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.afs.sendBroadcast(intent);
        }
        handler2 = this.afs.mHandler;
        runnable = this.afs.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
