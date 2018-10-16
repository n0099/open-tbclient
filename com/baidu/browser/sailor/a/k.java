package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ c Wf;
    final /* synthetic */ n Wj;
    final /* synthetic */ float Wm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, float f, n nVar) {
        this.Wf = cVar;
        this.Wm = f;
        this.Wj = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wf.Wb;
        if (mediaPlayer == null) {
            this.Wj.cA("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wf.Wb;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wf.Wb;
                mediaPlayer3.setVolume(this.Wm, this.Wm);
                this.Wj.c("setVolume", "true", true);
            } else {
                this.Wj.cA(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wj.cA(e.getMessage());
        }
    }
}
