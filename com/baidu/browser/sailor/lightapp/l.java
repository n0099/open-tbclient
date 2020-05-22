package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ BdLightappKernelJsCallback acR;
    final /* synthetic */ float acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acL = bdLightappKernelClient;
        this.acU = f;
        this.acR = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.acL.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acR.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acL.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acL.mMediaPlayer;
                mediaPlayer3.setVolume(this.acU, this.acU);
                this.acR.sendCallBack("setVolume", "true", true);
            } else {
                this.acR.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acR.sendFailCallBack(e.getMessage());
        }
    }
}
