package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class l implements Runnable {
    final /* synthetic */ float acA;
    final /* synthetic */ BdLightappKernelClient acq;
    final /* synthetic */ BdLightappKernelJsCallback acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acq = bdLightappKernelClient;
        this.acA = f;
        this.acx = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.acq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acx.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acq.mMediaPlayer;
                mediaPlayer3.setVolume(this.acA, this.acA);
                this.acx.sendCallBack("setVolume", "true", true);
            } else {
                this.acx.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acx.sendFailCallBack(e.getMessage());
        }
    }
}
