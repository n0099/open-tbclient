package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
import com.baidu.mapapi.UIMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ n Wu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, n nVar) {
        this.Wq = cVar;
        this.Wu = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.Wq.Wm;
        if (mediaPlayer == null) {
            this.Wu.cB("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wq.Wm;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wq.Wm;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.Wq.Wm;
                mediaPlayer4.seekTo(currentPosition + UIMsg.m_AppUI.MSG_APP_GPS);
                this.Wu.c("AudioSpeedFF", "true", true);
            } else {
                this.Wu.cB(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wu.cB(e.getMessage());
        }
    }
}
