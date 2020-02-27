package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ BdLightappKernelJsCallback Js;
    final /* synthetic */ int Ju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.Jm = bdLightappKernelClient;
        this.Ju = i;
        this.Js = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Jm.mMediaPlayer;
        if (mediaPlayer == null) {
            this.Js.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Jm.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Jm.mMediaPlayer;
                mediaPlayer3.seekTo(this.Ju);
                this.Js.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.Js.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Js.sendFailCallBack(e.getMessage());
        }
    }
}
