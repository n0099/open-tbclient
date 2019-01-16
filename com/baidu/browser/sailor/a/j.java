package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ n Wu;
    final /* synthetic */ int Ww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, int i, n nVar) {
        this.Wq = cVar;
        this.Ww = i;
        this.Wu = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wq.Wm;
        if (mediaPlayer == null) {
            this.Wu.cB("AudioSeekTo Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wq.Wm;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wq.Wm;
                mediaPlayer3.seekTo(this.Ww);
                this.Wu.c("AudioSeekTo", "true", true);
            } else {
                this.Wu.cB("AudioSeekTo Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wu.cB(e.getMessage());
        }
    }
}
