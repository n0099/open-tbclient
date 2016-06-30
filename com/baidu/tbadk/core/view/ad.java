package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.adC.acX = -1;
        this.adC.acY = -1;
        mediaController = this.adC.adc;
        if (mediaController != null) {
            mediaController2 = this.adC.adc;
            mediaController2.hide();
        }
        onErrorListener = this.adC.adh;
        if (onErrorListener != null) {
            onErrorListener2 = this.adC.adh;
            mediaPlayer2 = this.adC.acZ;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
