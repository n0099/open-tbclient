package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient IP;
    final /* synthetic */ BdLightappKernelJsCallback IW;
    final /* synthetic */ float IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IP = bdLightappKernelClient;
        this.IZ = f;
        this.IW = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.IP.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IW.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IP.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IP.mMediaPlayer;
                mediaPlayer3.setVolume(this.IZ, this.IZ);
                this.IW.sendCallBack("setVolume", "true", true);
            } else {
                this.IW.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IW.sendFailCallBack(e.getMessage());
        }
    }
}
