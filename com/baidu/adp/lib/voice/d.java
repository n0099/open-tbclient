package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c oj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.oj = cVar;
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
        audioTrack = this.oj.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.oj.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int fE = this.oj.fE() + 0;
            i = this.oj.mElapsedTime;
            if (fE != i) {
                this.oj.mElapsedTime = fE;
                handler2 = this.oj.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.oj.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.oj.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.oj.og;
            runnable = this.oj.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
