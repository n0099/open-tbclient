package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaController mediaController;
        MediaPlayer.OnCompletionListener onCompletionListener;
        MediaPlayer.OnCompletionListener onCompletionListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.ahp.agP = 5;
        this.ahp.agQ = 5;
        mediaController = this.ahp.agU;
        if (mediaController != null) {
            mediaController2 = this.ahp.agU;
            mediaController2.hide();
        }
        onCompletionListener = this.ahp.agV;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.ahp.agV;
            mediaPlayer2 = this.ahp.agR;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
    }
}
