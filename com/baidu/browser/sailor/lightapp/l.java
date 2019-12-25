package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ BdLightappKernelJsCallback IP;
    final /* synthetic */ float IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IH = bdLightappKernelClient;
        this.IS = f;
        this.IP = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.IH.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IP.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IH.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IH.mMediaPlayer;
                mediaPlayer3.setVolume(this.IS, this.IS);
                this.IP.sendCallBack("setVolume", "true", true);
            } else {
                this.IP.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IP.sendFailCallBack(e.getMessage());
        }
    }
}
