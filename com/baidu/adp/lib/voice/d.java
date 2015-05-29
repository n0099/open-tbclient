package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c zv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.zv = cVar;
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
        audioTrack = this.zv.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.zv.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int jy = this.zv.jy() + 0;
            i = this.zv.mElapsedTime;
            if (jy != i) {
                this.zv.mElapsedTime = jy;
                handler2 = this.zv.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.zv.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.zv.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.zv.zs;
            runnable = this.zv.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
