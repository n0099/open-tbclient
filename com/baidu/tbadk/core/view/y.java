package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        try {
            this.ahp.agS = mediaPlayer.getVideoWidth();
            this.ahp.agT = mediaPlayer.getVideoHeight();
            i3 = this.ahp.agS;
            if (i3 != 0) {
                i4 = this.ahp.agT;
                if (i4 != 0) {
                    this.ahp.requestLayout();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
