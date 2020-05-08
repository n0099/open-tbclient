package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelJsCallback acA;
    final /* synthetic */ BdLightappKernelClient act;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.act = bdLightappKernelClient;
        this.acA = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.act.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acA.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.act.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.act.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.act.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.acA.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.acA.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acA.sendFailCallBack(e.getMessage());
        }
    }
}
