package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.ade.acC = -1;
        this.ade.acD = -1;
        mediaController = this.ade.acH;
        if (mediaController != null) {
            mediaController2 = this.ade.acH;
            mediaController2.hide();
        }
        onErrorListener = this.ade.acL;
        if (onErrorListener != null) {
            onErrorListener2 = this.ade.acL;
            mediaPlayer2 = this.ade.acE;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
