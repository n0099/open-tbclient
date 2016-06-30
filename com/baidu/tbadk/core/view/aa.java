package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        try {
            this.adC.ada = mediaPlayer.getVideoWidth();
            this.adC.adb = mediaPlayer.getVideoHeight();
            i3 = this.adC.ada;
            if (i3 != 0) {
                i4 = this.adC.adb;
                if (i4 != 0) {
                    this.adC.requestLayout();
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
