package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.afR = mediaService;
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
        handler = this.afR.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.afR.mPlayer;
        int jr = hVar.jr();
        i = this.afR.mCurBeginSecond;
        int i4 = jr + i;
        i2 = this.afR.mElapsedTime;
        if (i4 != i2) {
            this.afR.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.afR.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.afR.sendBroadcast(intent);
        }
        handler2 = this.afR.mHandler;
        runnable = this.afR.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
