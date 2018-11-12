package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ c Wh;
    final /* synthetic */ n Wl;
    final /* synthetic */ int Wn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, int i, n nVar) {
        this.Wh = cVar;
        this.Wn = i;
        this.Wl = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wh.Wd;
        if (mediaPlayer == null) {
            this.Wl.cA("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wh.Wd;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wh.Wd;
                mediaPlayer3.seekTo(this.Wn);
                this.Wl.c("AudioSeekTo", "true", true);
            } else {
                this.Wl.cA("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wl.cA(e.getMessage());
        }
    }
}
