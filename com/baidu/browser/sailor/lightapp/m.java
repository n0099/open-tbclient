package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ BdLightappKernelJsCallback adq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adk = bdLightappKernelClient;
        this.adq = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.adk.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adq.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adk.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adk.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.adk.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.adq.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.adq.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adq.sendFailCallBack(e.getMessage());
        }
    }
}
