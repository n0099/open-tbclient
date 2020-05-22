package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ BdLightappKernelJsCallback acR;
    final /* synthetic */ int acT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acL = bdLightappKernelClient;
        this.acT = i;
        this.acR = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.acL.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acR.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acL.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acL.mMediaPlayer;
                mediaPlayer3.seekTo(this.acT);
                this.acR.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.acR.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acR.sendFailCallBack(e.getMessage());
        }
    }
}
