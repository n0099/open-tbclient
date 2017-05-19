package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zG = cVar;
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
        audioTrack = this.zG.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zG.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int hN = this.zG.hN() + 0;
            i = this.zG.mElapsedTime;
            if (hN != i) {
                this.zG.mElapsedTime = hN;
                handler2 = this.zG.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zG.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zG.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zG.zD;
            runnable = this.zG.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
