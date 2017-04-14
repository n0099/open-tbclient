package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zC = cVar;
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
        audioTrack = this.zC.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zC.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int hN = this.zC.hN() + 0;
            i = this.zC.mElapsedTime;
            if (hN != i) {
                this.zC.mElapsedTime = hN;
                handler2 = this.zC.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zC.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zC.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zC.zz;
            runnable = this.zC.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
