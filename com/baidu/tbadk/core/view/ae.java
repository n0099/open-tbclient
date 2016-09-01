package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2;
        i2 = this.ahh.agH;
        if (i2 != i) {
            this.ahh.agH = i;
            onBufferingUpdateListener = this.ahh.agN;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener2 = this.ahh.agN;
                onBufferingUpdateListener2.onBufferingUpdate(mediaPlayer, i);
            }
        }
    }
}
