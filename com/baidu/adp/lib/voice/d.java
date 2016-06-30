package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.qa = cVar;
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
        audioTrack = this.qa.pS;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.qa.pS;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int fV = this.qa.fV() + 0;
            i = this.qa.mElapsedTime;
            if (fV != i) {
                this.qa.mElapsedTime = fV;
                handler2 = this.qa.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.qa.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.qa.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.qa.pX;
            runnable = this.qa.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
