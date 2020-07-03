package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ BdLightappKernelJsCallback adw;
    final /* synthetic */ int ady;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adq = bdLightappKernelClient;
        this.ady = i;
        this.adw = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.adq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adw.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adq.mMediaPlayer;
                mediaPlayer3.seekTo(this.ady);
                this.adw.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.adw.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adw.sendFailCallBack(e.getMessage());
        }
    }
}
