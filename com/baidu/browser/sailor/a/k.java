package com.baidu.browser.sailor.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ c Wh;
    final /* synthetic */ n Wl;
    final /* synthetic */ float Wo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, float f, n nVar) {
        this.Wh = cVar;
        this.Wo = f;
        this.Wl = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        mediaPlayer = this.Wh.Wd;
        if (mediaPlayer == null) {
            this.Wl.cA("setVolume Not palying Audio");
            return;
        }
        try {
            mediaPlayer2 = this.Wh.Wd;
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer3 = this.Wh.Wd;
                mediaPlayer3.setVolume(this.Wo, this.Wo);
                this.Wl.c("setVolume", "true", true);
            } else {
                this.Wl.cA(" setVolume Not palying Audio");
            }
        } catch (IllegalStateException e) {
            this.Wl.cA(e.getMessage());
        }
    }
}
