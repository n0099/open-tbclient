package com.baidu.browser.sailor.lightapp;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class k implements Runnable {
    final /* synthetic */ BdLightappKernelJsCallback acA;
    final /* synthetic */ int acC;
    final /* synthetic */ BdLightappKernelClient act;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdLightappKernelClient bdLightappKernelClient, int i, BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.act = bdLightappKernelClient;
        this.acC = i;
        this.acA = bdLightappKernelJsCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.act.mMediaPlayer;
        if (mediaPlayer == null) {
            this.acA.sendFailCallBack("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.act.mMediaPlayer;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.act.mMediaPlayer;
                mediaPlayer3.seekTo(this.acC);
                this.acA.sendCallBack("AudioSeekTo", "true", true);
            } else {
                this.acA.sendFailCallBack("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.acA.sendFailCallBack(e.getMessage());
        }
    }
}
