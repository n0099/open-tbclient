package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        int i2;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
        MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2;
        i2 = this.adC.adg;
        if (i2 != i) {
            this.adC.adg = i;
            onBufferingUpdateListener = this.adC.adm;
            if (onBufferingUpdateListener != null) {
                onBufferingUpdateListener2 = this.adC.adm;
                onBufferingUpdateListener2.onBufferingUpdate(mediaPlayer, i);
            }
        }
    }
}
