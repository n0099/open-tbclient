package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l implements Runnable {
    final /* synthetic */ c Wf;
    final /* synthetic */ n Wj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, n nVar) {
        this.Wf = cVar;
        this.Wj = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        MediaPlayer mediaPlayer4;
        mediaPlayer = this.Wf.Wb;
        if (mediaPlayer == null) {
            this.Wj.cA("AudioSpeedFF Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wf.Wb;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wf.Wb;
                int currentPosition = mediaPlayer3.getCurrentPosition();
                mediaPlayer4 = this.Wf.Wb;
                mediaPlayer4.seekTo(currentPosition + 5000);
                this.Wj.c("AudioSpeedFF", "true", true);
            } else {
                this.Wj.cA(" AudioSpeedFF Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wj.cA(e.getMessage());
        }
    }
}
