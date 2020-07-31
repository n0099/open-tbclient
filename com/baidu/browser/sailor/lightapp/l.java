package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ BdLightappKernelJsCallback adq;
    final /* synthetic */ float adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adk = bdLightappKernelClient;
        this.adt = f;
        this.adq = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.adk.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adq.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adk.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adk.mMediaPlayer;
                mediaPlayer3.setVolume(this.adt, this.adt);
                this.adq.sendCallBack("setVolume", "true", true);
            } else {
                this.adq.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adq.sendFailCallBack(e.getMessage());
        }
    }
}
