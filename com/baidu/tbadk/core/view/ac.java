package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2;
        i2 = this.ahp.agX;
        if (i2 != i) {
            this.ahp.agX = i;
            onBufferingUpdateListener = this.ahp.ahd;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener2 = this.ahp.ahd;
                onBufferingUpdateListener2.onBufferingUpdate(mediaPlayer, i);
            }
        }
    }
}
