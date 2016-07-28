package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TextureVideoView textureVideoView) {
        this.aeo = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaController mediaController;
        MediaPlayer.OnCompletionListener onCompletionListener;
        long j;
        String str;
        TextureVideoView.c cVar;
        TextureVideoView.c cVar2;
        MediaPlayer.OnCompletionListener onCompletionListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.aeo.adI = 5;
        this.aeo.adJ = 5;
        mediaController = this.aeo.adN;
        if (mediaController != null) {
            mediaController2 = this.aeo.adN;
            mediaController2.hide();
        }
        onCompletionListener = this.aeo.adO;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.aeo.adO;
            mediaPlayer2 = this.aeo.adK;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        j = this.aeo.startTime;
        long j2 = (currentTimeMillis - j) / 1000;
        if (j2 > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", j2);
            str = this.aeo.aeh;
            ayVar.ab("obj_type", str);
            cVar = this.aeo.aeg;
            if (cVar != null) {
                cVar2 = this.aeo.aeg;
                cVar2.a(ayVar);
            }
            TiebaStatic.log(ayVar);
            this.aeo.aeh = "1";
        }
        this.aeo.startTime = System.currentTimeMillis();
    }
}
