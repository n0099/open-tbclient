package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient IP;
    final /* synthetic */ BdLightappKernelJsCallback IW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IP = bdLightappKernelClient;
        this.IW = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.IP.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IW.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IP.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IP.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.IP.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.IW.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.IW.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IW.sendFailCallBack(e.getMessage());
        }
    }
}
