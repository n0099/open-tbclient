package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c ze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ze = cVar;
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
        audioTrack = this.ze.yW;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.ze.yW;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jo = this.ze.jo() + 0;
            i = this.ze.mElapsedTime;
            if (jo != i) {
                this.ze.mElapsedTime = jo;
                handler2 = this.ze.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.ze.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.ze.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.ze.zb;
            runnable = this.ze.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
