package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ BdLightappKernelJsCallback acR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acL = bdLightappKernelClient;
        this.acR = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.acL.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acR.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acL.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acL.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.acL.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.acR.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.acR.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acR.sendFailCallBack(e.getMessage());
        }
    }
}
