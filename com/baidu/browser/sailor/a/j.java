package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ c Wf;
    final /* synthetic */ n Wj;
    final /* synthetic */ int Wl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, int i, n nVar) {
        this.Wf = cVar;
        this.Wl = i;
        this.Wj = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wf.Wb;
        if (mediaPlayer == null) {
            this.Wj.cA("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wf.Wb;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wf.Wb;
                mediaPlayer3.seekTo(this.Wl);
                this.Wj.c("AudioSeekTo", "true", true);
            } else {
                this.Wj.cA("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wj.cA(e.getMessage());
        }
    }
}
