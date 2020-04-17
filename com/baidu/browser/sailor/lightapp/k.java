package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient acq;
    final /* synthetic */ BdLightappKernelJsCallback acx;
    final /* synthetic */ int acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acq = bdLightappKernelClient;
        this.acz = i;
        this.acx = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.acq.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acx.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.acq.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.acq.mMediaPlayer;
                mediaPlayer3.seekTo(this.acz);
                this.acx.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.acx.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acx.sendFailCallBack(e.getMessage());
        }
    }
}
