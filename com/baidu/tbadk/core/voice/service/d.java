package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aha = mediaService;
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
        handler = this.aha.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aha.mPlayer;
        int jr = hVar.jr();
        i = this.aha.mCurBeginSecond;
        int i4 = jr + i;
        i2 = this.aha.mElapsedTime;
        if (i4 != i2) {
            this.aha.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aha.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aha.sendBroadcast(intent);
        }
        handler2 = this.aha.mHandler;
        runnable = this.aha.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
