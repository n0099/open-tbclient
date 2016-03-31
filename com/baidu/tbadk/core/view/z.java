package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView ahp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureVideoView textureVideoView) {
        this.ahp = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer.OnPreparedListener onPreparedListener;
        MediaController mediaController;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        MediaController mediaController2;
        MediaController mediaController3;
        MediaController mediaController4;
        MediaController mediaController5;
        MediaController mediaController6;
        MediaPlayer.OnPreparedListener onPreparedListener2;
        MediaPlayer mediaPlayer2;
        if (mediaPlayer != null) {
            try {
                this.ahp.agS = mediaPlayer.getVideoWidth();
                this.ahp.agT = mediaPlayer.getVideoHeight();
                this.ahp.agP = 2;
                TextureVideoView textureVideoView = this.ahp;
                TextureVideoView textureVideoView2 = this.ahp;
                this.ahp.ahc = true;
                textureVideoView2.ahb = true;
                textureVideoView.aha = true;
                onPreparedListener = this.ahp.agW;
                if (onPreparedListener != null) {
                    onPreparedListener2 = this.ahp.agW;
                    mediaPlayer2 = this.ahp.agR;
                    onPreparedListener2.onPrepared(mediaPlayer2);
                }
                mediaController = this.ahp.agU;
                if (mediaController != null) {
                    mediaController6 = this.ahp.agU;
                    mediaController6.setEnabled(true);
                }
                i = this.ahp.agZ;
                if (i != 0) {
                    this.ahp.seekTo(i);
                }
                i2 = this.ahp.agS;
                if (i2 != 0) {
                    i4 = this.ahp.agT;
                    if (i4 != 0) {
                        this.ahp.requestLayout();
                        i5 = this.ahp.agQ;
                        if (i5 == 3) {
                            this.ahp.start();
                            mediaController4 = this.ahp.agU;
                            if (mediaController4 != null) {
                                mediaController5 = this.ahp.agU;
                                mediaController5.show();
                                return;
                            }
                            return;
                        } else if (!this.ahp.isPlaying()) {
                            if (i != 0 || this.ahp.getCurrentPosition() > 0) {
                                mediaController2 = this.ahp.agU;
                                if (mediaController2 != null) {
                                    mediaController3 = this.ahp.agU;
                                    mediaController3.show(0);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                }
                i3 = this.ahp.agQ;
                if (i3 == 3) {
                    this.ahp.start();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
