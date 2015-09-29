package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zf = cVar;
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
        audioTrack = this.zf.yX;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zf.yX;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jp = this.zf.jp() + 0;
            i = this.zf.mElapsedTime;
            if (jp != i) {
                this.zf.mElapsedTime = jp;
                handler2 = this.zf.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zf.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zf.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zf.zc;
            runnable = this.zf.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
