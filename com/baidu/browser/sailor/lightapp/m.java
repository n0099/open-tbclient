package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ BdLightappKernelJsCallback IP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IH = bdLightappKernelClient;
        this.IP = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.IH.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IP.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IH.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IH.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.IH.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.IP.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.IP.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IP.sendFailCallBack(e.getMessage());
        }
    }
}
