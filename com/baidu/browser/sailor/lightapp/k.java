package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ BdLightappKernelJsCallback adq;
    final /* synthetic */ int ads;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adk = bdLightappKernelClient;
        this.ads = i;
        this.adq = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.adk.mMediaPlayer;
        if (mediaPlayer == null) {
            this.adq.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.adk.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.adk.mMediaPlayer;
                mediaPlayer3.seekTo(this.ads);
                this.adq.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.adq.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.adq.sendFailCallBack(e.getMessage());
        }
    }
}
