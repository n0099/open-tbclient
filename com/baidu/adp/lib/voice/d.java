package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c sT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.sT = cVar;
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
        audioTrack = this.sT.sL;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.sT.sL;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int gQ = this.sT.gQ() + 0;
            i = this.sT.mElapsedTime;
            if (gQ != i) {
                this.sT.mElapsedTime = gQ;
                handler2 = this.sT.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.sT.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.sT.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.sT.sQ;
            runnable = this.sT.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
