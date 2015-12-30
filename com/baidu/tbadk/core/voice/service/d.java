package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService aid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.aid = mediaService;
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
        handler = this.aid.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.aid.mPlayer;
        int js = hVar.js();
        i = this.aid.mCurBeginSecond;
        int i4 = js + i;
        i2 = this.aid.mElapsedTime;
        if (i4 != i2) {
            this.aid.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.aid.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.aid.sendBroadcast(intent);
        }
        handler2 = this.aid.mHandler;
        runnable = this.aid.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
