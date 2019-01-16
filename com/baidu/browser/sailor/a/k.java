package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ c Wq;
    final /* synthetic */ n Wu;
    final /* synthetic */ float Wx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, float f, n nVar) {
        this.Wq = cVar;
        this.Wx = f;
        this.Wu = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wq.Wm;
        if (mediaPlayer == null) {
            this.Wu.cB("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wq.Wm;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wq.Wm;
                mediaPlayer3.setVolume(this.Wx, this.Wx);
                this.Wu.c("setVolume", "true", true);
            } else {
                this.Wu.cB(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wu.cB(e.getMessage());
        }
    }
}
