package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
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
                this.adC.ada = mediaPlayer.getVideoWidth();
                this.adC.adb = mediaPlayer.getVideoHeight();
                this.adC.acX = 2;
                TextureVideoView textureVideoView = this.adC;
                TextureVideoView textureVideoView2 = this.adC;
                this.adC.adl = true;
                textureVideoView2.adk = true;
                textureVideoView.adj = true;
                onPreparedListener = this.adC.adf;
                if (onPreparedListener != null) {
                    onPreparedListener2 = this.adC.adf;
                    mediaPlayer2 = this.adC.acZ;
                    onPreparedListener2.onPrepared(mediaPlayer2);
                }
                mediaController = this.adC.adc;
                if (mediaController != null) {
                    mediaController6 = this.adC.adc;
                    mediaController6.setEnabled(true);
                }
                i = this.adC.adi;
                if (i != 0) {
                    this.adC.seekTo(i);
                }
                i2 = this.adC.ada;
                if (i2 != 0) {
                    i4 = this.adC.adb;
                    if (i4 != 0) {
                        this.adC.requestLayout();
                        i5 = this.adC.acY;
                        if (i5 == 3) {
                            this.adC.start();
                            mediaController4 = this.adC.adc;
                            if (mediaController4 != null) {
                                mediaController5 = this.adC.adc;
                                mediaController5.show();
                            }
                        } else if (!this.adC.isPlaying() && (i != 0 || this.adC.getCurrentPosition() > 0)) {
                            mediaController2 = this.adC.adc;
                            if (mediaController2 != null) {
                                mediaController3 = this.adC.adc;
                                mediaController3.show(0);
                            }
                        }
                        ay ayVar = new ay("c11244");
                        ayVar.ab("obj_duration", "0");
                        TiebaStatic.log(ayVar);
                        this.adC.startTime = System.currentTimeMillis();
                    }
                }
                i3 = this.adC.acY;
                if (i3 == 3) {
                    this.adC.start();
                }
                ay ayVar2 = new ay("c11244");
                ayVar2.ab("obj_duration", "0");
                TiebaStatic.log(ayVar2);
                this.adC.startTime = System.currentTimeMillis();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
