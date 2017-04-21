package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zF = cVar;
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
        audioTrack = this.zF.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zF.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int hO = this.zF.hO() + 0;
            i = this.zF.mElapsedTime;
            if (hO != i) {
                this.zF.mElapsedTime = hO;
                handler2 = this.zF.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zF.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zF.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zF.zC;
            runnable = this.zF.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
