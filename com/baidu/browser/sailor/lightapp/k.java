package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ BdLightappKernelJsCallback IP;
    final /* synthetic */ int IR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.IH = bdLightappKernelClient;
        this.IR = i;
        this.IP = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.IH.mMediaPlayer;
        if (mediaPlayer == null) {
            this.IP.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.IH.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.IH.mMediaPlayer;
                mediaPlayer3.seekTo(this.IR);
                this.IP.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.IP.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.IP.sendFailCallBack(e.getMessage());
        }
    }
}
