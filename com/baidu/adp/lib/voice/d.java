package com.baidu.adp.lib.voice;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c sK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.sK = cVar;
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
        audioTrack = this.sK.mAudioTrack;
        if (audioTrack != null) {
            try {
                audioTrack2 = this.sK.mAudioTrack;
                if (audioTrack2.getPlayState() != 3) {
                    return;
                }
            } catch (NullPointerException e) {
            }
            int gO = this.sK.gO() + 0;
            i = this.sK.mElapsedTime;
            if (gO != i) {
                this.sK.mElapsedTime = gO;
                handler2 = this.sK.mHandler;
                Message obtainMessage = handler2.obtainMessage(6);
                i2 = this.sK.mElapsedTime;
                obtainMessage.arg1 = i2;
                handler3 = this.sK.mHandler;
                handler3.sendMessage(obtainMessage);
            }
            handler = this.sK.sH;
            runnable = this.sK.mPlayTimeThread;
            handler.postDelayed(runnable, 100L);
        }
    }
}
