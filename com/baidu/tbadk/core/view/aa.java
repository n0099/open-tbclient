package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        try {
            this.aeo.adL = mediaPlayer.getVideoWidth();
            this.aeo.adM = mediaPlayer.getVideoHeight();
            i3 = this.aeo.adL;
            if (i3 != 0) {
                i4 = this.aeo.adM;
                if (i4 != 0) {
                    this.aeo.requestLayout();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
