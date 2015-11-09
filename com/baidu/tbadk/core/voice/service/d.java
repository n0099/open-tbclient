package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MediaService afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MediaService mediaService) {
        this.afu = mediaService;
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
        handler = this.afu.mHandler;
        if (handler == null) {
            return;
        }
        hVar = this.afu.mPlayer;
        int jq = hVar.jq();
        i = this.afu.mCurBeginSecond;
        int i4 = jq + i;
        i2 = this.afu.mElapsedTime;
        if (i4 != i2) {
            this.afu.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.afu.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.afu.sendBroadcast(intent);
        }
        handler2 = this.afu.mHandler;
        runnable = this.afu.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
