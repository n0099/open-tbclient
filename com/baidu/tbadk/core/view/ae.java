package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2;
        i2 = this.ade.acK;
        if (i2 != i) {
            this.ade.acK = i;
            onBufferingUpdateListener = this.ade.acQ;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener2 = this.ade.acQ;
                onBufferingUpdateListener2.onBufferingUpdate(mediaPlayer, i);
            }
        }
    }
}
