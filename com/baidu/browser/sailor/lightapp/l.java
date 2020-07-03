package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ BdLightappKernelJsCallback adw;
    final /* synthetic */ float adz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adq = bdLightappKernelClient;
        this.adz = f;
        this.adw = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.adq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adw.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adq.mMediaPlayer;
                mediaPlayer3.setVolume(this.adz, this.adz);
                this.adw.sendCallBack("setVolume", "true", true);
            } else {
                this.adw.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adw.sendFailCallBack(e.getMessage());
        }
    }
}
