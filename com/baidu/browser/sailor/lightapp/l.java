package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class l implements Runnable {
    final /* synthetic */ BdLightappKernelJsCallback acA;
    final /* synthetic */ float acD;
    final /* synthetic */ BdLightappKernelClient act;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdLightappKernelClient bdLightappKernelClient, float f, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.act = bdLightappKernelClient;
        this.acD = f;
        this.acA = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.act.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acA.sendFailCallBack("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.act.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.act.mMediaPlayer;
                mediaPlayer3.setVolume(this.acD, this.acD);
                this.acA.sendCallBack("setVolume", "true", true);
            } else {
                this.acA.sendFailCallBack(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acA.sendFailCallBack(e.getMessage());
        }
    }
}
