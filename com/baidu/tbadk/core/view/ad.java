package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.aeo.adI = -1;
        this.aeo.adJ = -1;
        mediaController = this.aeo.adN;
        if (mediaController != null) {
            mediaController2 = this.aeo.adN;
            mediaController2.hide();
        }
        onErrorListener = this.aeo.adR;
        if (onErrorListener != null) {
            onErrorListener2 = this.aeo.adR;
            mediaPlayer2 = this.aeo.adK;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
