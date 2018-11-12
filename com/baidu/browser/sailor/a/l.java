package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import com.baidu.mapapi.UIMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ c Wh;
    final /* synthetic */ n Wl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, n nVar) {
        this.Wh = cVar;
        this.Wl = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.Wh.Wd;
        if (mediaPlayer == null) {
            this.Wl.cA("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wh.Wd;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wh.Wd;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.Wh.Wd;
                mediaPlayer4.seekTo(currentPosition + UIMsg.m_AppUI.MSG_APP_GPS);
                this.Wl.c("AudioSpeedFF", "true", true);
            } else {
                this.Wl.cA(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wl.cA(e.getMessage());
        }
    }
}
