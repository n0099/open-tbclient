package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        try {
            this.ahh.agC = mediaPlayer.getVideoWidth();
            this.ahh.agD = mediaPlayer.getVideoHeight();
            i3 = this.ahh.agC;
            if (i3 != 0) {
                i4 = this.ahh.agD;
                if (i4 != 0) {
                    this.ahh.requestLayout();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
