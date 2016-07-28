package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c qC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.qC = cVar;
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
        audioTrack = this.qC.qu;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.qC.qu;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int fU = this.qC.fU() + 0;
            i = this.qC.mElapsedTime;
            if (fU != i) {
                this.qC.mElapsedTime = fU;
                handler2 = this.qC.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.qC.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.qC.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.qC.qz;
            runnable = this.qC.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
