package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ BdLightappKernelJsCallback adw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adq = bdLightappKernelClient;
        this.adw = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.adq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adw.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adq.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.adq.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.adw.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.adw.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adw.sendFailCallBack(e.getMessage());
        }
    }
}
