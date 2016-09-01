package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c sS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.sS = cVar;
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
        audioTrack = this.sS.sK;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.sS.sK;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int gQ = this.sS.gQ() + 0;
            i = this.sS.mElapsedTime;
            if (gQ != i) {
                this.sS.mElapsedTime = gQ;
                handler2 = this.sS.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.sS.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.sS.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.sS.sP;
            runnable = this.sS.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
