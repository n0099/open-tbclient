package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService ajv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.ajv = mediaService;
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
        handler = this.ajv.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.ajv.mPlayer;
        int gQ = hVar.gQ();
        i = this.ajv.mCurBeginSecond;
        int i4 = gQ + i;
        i2 = this.ajv.mElapsedTime;
        if (i4 != i2) {
            this.ajv.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.ajv.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.ajv.sendBroadcast(intent);
        }
        handler2 = this.ajv.mHandler;
        runnable = this.ajv.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
