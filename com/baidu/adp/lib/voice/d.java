package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c Ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.Ab = cVar;
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
        audioTrack = this.Ab.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.Ab.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int hI = this.Ab.hI() + 0;
            i = this.Ab.mElapsedTime;
            if (hI != i) {
                this.Ab.mElapsedTime = hI;
                handler2 = this.Ab.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.Ab.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.Ab.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.Ab.zY;
            runnable = this.Ab.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
