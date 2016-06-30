package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TextureVideoView textureVideoView) {
        this.adC = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaController mediaController;
        MediaPlayer.OnCompletionListener onCompletionListener;
        long j;
        MediaPlayer.OnCompletionListener onCompletionListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.adC.acX = 5;
        this.adC.acY = 5;
        mediaController = this.adC.adc;
        if (mediaController != null) {
            mediaController2 = this.adC.adc;
            mediaController2.hide();
        }
        onCompletionListener = this.adC.ade;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.adC.ade;
            mediaPlayer2 = this.adC.acZ;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        j = this.adC.startTime;
        long j2 = (currentTimeMillis - j) / 1000;
        if (j2 > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", j2);
            TiebaStatic.log(ayVar);
        }
        this.adC.startTime = System.currentTimeMillis();
    }
}
