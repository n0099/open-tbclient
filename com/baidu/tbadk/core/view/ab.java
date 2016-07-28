package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer.OnPreparedListener onPreparedListener;
        MediaController mediaController;
        int i;
        int i2;
        int i3;
        String str;
        TextureVideoView.c cVar;
        TextureVideoView.c cVar2;
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
                this.aeo.adL = mediaPlayer.getVideoWidth();
                this.aeo.adM = mediaPlayer.getVideoHeight();
                this.aeo.adI = 2;
                TextureVideoView textureVideoView = this.aeo;
                TextureVideoView textureVideoView2 = this.aeo;
                this.aeo.adV = true;
                textureVideoView2.adU = true;
                textureVideoView.adT = true;
                onPreparedListener = this.aeo.adP;
                if (onPreparedListener != null) {
                    onPreparedListener2 = this.aeo.adP;
                    mediaPlayer2 = this.aeo.adK;
                    onPreparedListener2.onPrepared(mediaPlayer2);
                }
                mediaController = this.aeo.adN;
                if (mediaController != null) {
                    mediaController6 = this.aeo.adN;
                    mediaController6.setEnabled(true);
                }
                i = this.aeo.adS;
                if (i != 0) {
                    this.aeo.seekTo(i);
                }
                i2 = this.aeo.adL;
                if (i2 != 0) {
                    i4 = this.aeo.adM;
                    if (i4 != 0) {
                        this.aeo.requestLayout();
                        i5 = this.aeo.adJ;
                        if (i5 == 3) {
                            this.aeo.start();
                            mediaController4 = this.aeo.adN;
                            if (mediaController4 != null) {
                                mediaController5 = this.aeo.adN;
                                mediaController5.show();
                            }
                        } else if (!this.aeo.isPlaying() && (i != 0 || this.aeo.getCurrentPosition() > 0)) {
                            mediaController2 = this.aeo.adN;
                            if (mediaController2 != null) {
                                mediaController3 = this.aeo.adN;
                                mediaController3.show(0);
                            }
                        }
                        ay ayVar = new ay("c11244");
                        ayVar.ab("obj_duration", "0");
                        str = this.aeo.aeh;
                        ayVar.ab("obj_type", str);
                        cVar = this.aeo.aeg;
                        if (cVar != null) {
                            cVar2 = this.aeo.aeg;
                            cVar2.a(ayVar);
                        }
                        TiebaStatic.log(ayVar);
                        this.aeo.startTime = System.currentTimeMillis();
                    }
                }
                i3 = this.aeo.adJ;
                if (i3 == 3) {
                    this.aeo.start();
                }
                ay ayVar2 = new ay("c11244");
                ayVar2.ab("obj_duration", "0");
                str = this.aeo.aeh;
                ayVar2.ab("obj_type", str);
                cVar = this.aeo.aeg;
                if (cVar != null) {
                }
                TiebaStatic.log(ayVar2);
                this.aeo.startTime = System.currentTimeMillis();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
