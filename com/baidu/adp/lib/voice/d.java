package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c oe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.oe = cVar;
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
        audioTrack = this.oe.nW;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.oe.nW;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int fD = this.oe.fD() + 0;
            i = this.oe.mElapsedTime;
            if (fD != i) {
                this.oe.mElapsedTime = fD;
                handler2 = this.oe.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.oe.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.oe.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.oe.ob;
            runnable = this.oe.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
