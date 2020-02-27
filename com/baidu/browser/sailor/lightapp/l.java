package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ BdLightappKernelJsCallback Js;
    final /* synthetic */ float Jv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.Jm = bdLightappKernelClient;
        this.Jv = f;
        this.Js = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Jm.mMediaPlayer;
        if (mediaPlayer == null) {
            this.Js.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Jm.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Jm.mMediaPlayer;
                mediaPlayer3.setVolume(this.Jv, this.Jv);
                this.Js.sendCallBack("setVolume", "true", true);
            } else {
                this.Js.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Js.sendFailCallBack(e.getMessage());
        }
    }
}
