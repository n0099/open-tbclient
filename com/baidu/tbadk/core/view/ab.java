package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView ade;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureVideoView textureVideoView) {
        this.ade = textureVideoView;
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
                this.ade.acF = mediaPlayer.getVideoWidth();
                this.ade.acG = mediaPlayer.getVideoHeight();
                this.ade.acC = 2;
                TextureVideoView textureVideoView = this.ade;
                TextureVideoView textureVideoView2 = this.ade;
                this.ade.acP = true;
                textureVideoView2.acO = true;
                textureVideoView.acN = true;
                onPreparedListener = this.ade.acJ;
                if (onPreparedListener != null) {
                    onPreparedListener2 = this.ade.acJ;
                    mediaPlayer2 = this.ade.acE;
                    onPreparedListener2.onPrepared(mediaPlayer2);
                }
                mediaController = this.ade.acH;
                if (mediaController != null) {
                    mediaController6 = this.ade.acH;
                    mediaController6.setEnabled(true);
                }
                i = this.ade.acM;
                if (i != 0) {
                    this.ade.seekTo(i);
                }
                i2 = this.ade.acF;
                if (i2 != 0) {
                    i4 = this.ade.acG;
                    if (i4 != 0) {
                        this.ade.requestLayout();
                        i5 = this.ade.acD;
                        if (i5 == 3) {
                            this.ade.start();
                            mediaController4 = this.ade.acH;
                            if (mediaController4 != null) {
                                mediaController5 = this.ade.acH;
                                mediaController5.show();
                                return;
                            }
                            return;
                        } else if (!this.ade.isPlaying()) {
                            if (i != 0 || this.ade.getCurrentPosition() > 0) {
                                mediaController2 = this.ade.acH;
                                if (mediaController2 != null) {
                                    mediaController3 = this.ade.acH;
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
                i3 = this.ade.acD;
                if (i3 == 3) {
                    this.ade.start();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
