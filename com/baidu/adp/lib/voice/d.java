package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zn = cVar;
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
        audioTrack = this.zn.zf;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zn.zf;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int js = this.zn.js() + 0;
            i = this.zn.mElapsedTime;
            if (js != i) {
                this.zn.mElapsedTime = js;
                handler2 = this.zn.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zn.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zn.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zn.zk;
            runnable = this.zn.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
