package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    @Override // android.media.MediaPlayer.OnPreparedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPrepared(MediaPlayer mediaPlayer) {
        Runnable runnable;
        Runnable runnable2;
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
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.ahh.ahg;
        eG.removeCallbacks(runnable);
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        runnable2 = this.ahh.ahg;
        eG2.postDelayed(runnable2, 200L);
        if (mediaPlayer != null) {
            try {
                this.ahh.agC = mediaPlayer.getVideoWidth();
                this.ahh.agD = mediaPlayer.getVideoHeight();
                this.ahh.agz = 2;
                TextureVideoView textureVideoView = this.ahh;
                TextureVideoView textureVideoView2 = this.ahh;
                this.ahh.agM = true;
                textureVideoView2.agL = true;
                textureVideoView.agK = true;
                onPreparedListener = this.ahh.agG;
                if (onPreparedListener != null) {
                    onPreparedListener2 = this.ahh.agG;
                    mediaPlayer2 = this.ahh.agB;
                    onPreparedListener2.onPrepared(mediaPlayer2);
                }
                mediaController = this.ahh.agE;
                if (mediaController != null) {
                    mediaController6 = this.ahh.agE;
                    mediaController6.setEnabled(true);
                }
                i = this.ahh.agJ;
                if (i != 0) {
                    this.ahh.seekTo(i);
                }
                i2 = this.ahh.agC;
                if (i2 != 0) {
                    i4 = this.ahh.agD;
                    if (i4 != 0) {
                        this.ahh.requestLayout();
                        i5 = this.ahh.agA;
                        if (i5 == 3) {
                            this.ahh.start();
                            mediaController4 = this.ahh.agE;
                            if (mediaController4 != null) {
                                mediaController5 = this.ahh.agE;
                                mediaController5.show();
                            }
                        } else if (!this.ahh.isPlaying() && (i != 0 || this.ahh.getCurrentPosition() > 0)) {
                            mediaController2 = this.ahh.agE;
                            if (mediaController2 != null) {
                                mediaController3 = this.ahh.agE;
                                mediaController3.show(0);
                            }
                        }
                        ay ayVar = new ay("c11244");
                        ayVar.ab("obj_duration", "0");
                        str = this.ahh.agY;
                        ayVar.ab("obj_type", str);
                        cVar = this.ahh.agX;
                        if (cVar != null) {
                            cVar2 = this.ahh.agX;
                            cVar2.a(ayVar);
                        }
                        TiebaStatic.log(ayVar);
                        this.ahh.startTime = System.currentTimeMillis();
                    }
                }
                i3 = this.ahh.agA;
                if (i3 == 3) {
                    this.ahh.start();
                }
                ay ayVar2 = new ay("c11244");
                ayVar2.ab("obj_duration", "0");
                str = this.ahh.agY;
                ayVar2.ab("obj_type", str);
                cVar = this.ahh.agX;
                if (cVar != null) {
                }
                TiebaStatic.log(ayVar2);
                this.ahh.startTime = System.currentTimeMillis();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
