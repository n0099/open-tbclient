package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService ajf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.ajf = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.ajf.mPlayer;
        if (hVar != null) {
            voice = this.ajf.mVoice;
            if (voice != null) {
                hVar2 = this.ajf.mPlayer;
                hVar2.yc();
                this.ajf.stopVoice(null);
            }
        }
    }
}
