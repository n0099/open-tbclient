package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zg = cVar;
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
        audioTrack = this.zg.yY;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zg.yY;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jr = this.zg.jr() + 0;
            i = this.zg.mElapsedTime;
            if (jr != i) {
                this.zg.mElapsedTime = jr;
                handler2 = this.zg.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zg.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zg.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zg.zd;
            runnable = this.zg.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
