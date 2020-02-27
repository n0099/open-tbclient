package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class m implements Runnable {
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ BdLightappKernelJsCallback Js;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdLightappKernelClient bdLightappKernelClient, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.Jm = bdLightappKernelClient;
        this.Js = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.Jm.mMediaPlayer;
        if (mediaPlayer == null) {
            this.Js.sendFailCallBack("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Jm.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Jm.mMediaPlayer;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.Jm.mMediaPlayer;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.Js.sendCallBack("AudioSpeedFF", "true", true);
            } else {
                this.Js.sendFailCallBack(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Js.sendFailCallBack(e.getMessage());
        }
    }
}
