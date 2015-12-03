package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zl = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioTrack audioTrack;
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        int i2;
        Handler handler3;
        AudioTrack audioTrack2;
        audioTrack = this.zl.zd;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zl.zd;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jr = this.zl.jr() + 0;
            i = this.zl.mElapsedTime;
            if (jr != i) {
                this.zl.mElapsedTime = jr;
                handler2 = this.zl.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zl.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zl.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zl.zi;
            runnable = this.zl.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
