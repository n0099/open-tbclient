package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView ahh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TextureVideoView textureVideoView) {
        this.ahh = textureVideoView;
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
        this.ahh.agz = 5;
        this.ahh.agA = 5;
        mediaController = this.ahh.agE;
        if (mediaController != null) {
            mediaController2 = this.ahh.agE;
            mediaController2.hide();
        }
        onCompletionListener = this.ahh.agF;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.ahh.agF;
            mediaPlayer2 = this.ahh.agB;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        j = this.ahh.startTime;
        long j2 = (currentTimeMillis - j) / 1000;
        if (j2 > 0) {
            ay ayVar = new ay("c11244");
            ayVar.g("obj_duration", j2);
            str = this.ahh.agY;
            ayVar.ab("obj_type", str);
            cVar = this.ahh.agX;
            if (cVar != null) {
                cVar2 = this.ahh.agX;
                cVar2.a(ayVar);
            }
            TiebaStatic.log(ayVar);
            this.ahh.agY = "1";
        }
        this.ahh.startTime = System.currentTimeMillis();
    }
}
