package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient IP;
    final /* synthetic */ BdLightappKernelJsCallback IW;
    final /* synthetic */ int IY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IP = bdLightappKernelClient;
        this.IY = i;
        this.IW = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.IP.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IW.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IP.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IP.mMediaPlayer;
                mediaPlayer3.seekTo(this.IY);
                this.IW.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.IW.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IW.sendFailCallBack(e.getMessage());
        }
    }
}
