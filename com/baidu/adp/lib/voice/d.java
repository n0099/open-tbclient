package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zN = cVar;
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
        audioTrack = this.zN.zF;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zN.zF;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jH = this.zN.jH() + 0;
            i = this.zN.mElapsedTime;
            if (jH != i) {
                this.zN.mElapsedTime = jH;
                handler2 = this.zN.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zN.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zN.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zN.zK;
            runnable = this.zN.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
