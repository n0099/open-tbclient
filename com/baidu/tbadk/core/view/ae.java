package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2;
        i2 = this.aeo.adQ;
        if (i2 != i) {
            this.aeo.adQ = i;
            onBufferingUpdateListener = this.aeo.adW;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener2 = this.aeo.adW;
                onBufferingUpdateListener2.onBufferingUpdate(mediaPlayer, i);
            }
        }
    }
}
