package com.baidu.tbadk.core.voice.service;

import android.content.Intent;
import android.os.Handler;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ MediaService ZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.ZN = mediaService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        i iVar;
        int i;
        int i2;
        Handler handler2;
        Runnable runnable;
        int i3;
        handler = this.ZN.mHandler;
        if (handler == null) {
            return;
        }
        iVar = this.ZN.mPlayer;
        int jh = iVar.jh();
        i = this.ZN.mCurBeginSecond;
        int i4 = jh + i;
        i2 = this.ZN.mElapsedTime;
        if (i4 != i2) {
            this.ZN.mElapsedTime = i4;
            Intent intent = new Intent("com.baidu.playElapsedTime");
            i3 = this.ZN.mElapsedTime;
            intent.putExtra("com.baidu.msg.playElapsedTime", i3);
            this.ZN.sendBroadcast(intent);
        }
        handler2 = this.ZN.mHandler;
        runnable = this.ZN.mPlayTimeThread;
        handler2.postDelayed(runnable, 100L);
    }
}
