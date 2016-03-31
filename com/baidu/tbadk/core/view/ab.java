package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.ahp.agP = -1;
        this.ahp.agQ = -1;
        mediaController = this.ahp.agU;
        if (mediaController != null) {
            mediaController2 = this.ahp.agU;
            mediaController2.hide();
        }
        onErrorListener = this.ahp.agY;
        if (onErrorListener != null) {
            onErrorListener2 = this.ahp.agY;
            mediaPlayer2 = this.ahp.agR;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
