package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        try {
            this.ade.acF = mediaPlayer.getVideoWidth();
            this.ade.acG = mediaPlayer.getVideoHeight();
            i3 = this.ade.acF;
            if (i3 != 0) {
                i4 = this.ade.acG;
                if (i4 != 0) {
                    this.ade.requestLayout();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
