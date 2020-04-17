package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient acq;
    final /* synthetic */ BdLightappKernelJsCallback acx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acq = bdLightappKernelClient;
        this.acx = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.acq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acx.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acq.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.acq.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.acx.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.acx.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acx.sendFailCallBack(e.getMessage());
        }
    }
}
