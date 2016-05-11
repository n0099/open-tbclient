package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaController mediaController;
        MediaPlayer.OnCompletionListener onCompletionListener;
        MediaPlayer.OnCompletionListener onCompletionListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.ade.acC = 5;
        this.ade.acD = 5;
        mediaController = this.ade.acH;
        if (mediaController != null) {
            mediaController2 = this.ade.acH;
            mediaController2.hide();
        }
        onCompletionListener = this.ade.acI;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.ade.acI;
            mediaPlayer2 = this.ade.acE;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
    }
}
