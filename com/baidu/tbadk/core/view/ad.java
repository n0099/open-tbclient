package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.ahh.agz = -1;
        this.ahh.agA = -1;
        mediaController = this.ahh.agE;
        if (mediaController != null) {
            mediaController2 = this.ahh.agE;
            mediaController2.hide();
        }
        onErrorListener = this.ahh.agI;
        if (onErrorListener != null) {
            onErrorListener2 = this.ahh.agI;
            mediaPlayer2 = this.ahh.agB;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
