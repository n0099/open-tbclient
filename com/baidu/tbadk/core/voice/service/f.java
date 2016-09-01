package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService ajb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.ajb = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.ajb.mPlayer;
        if (hVar != null) {
            voice = this.ajb.mVoice;
            if (voice != null) {
                hVar2 = this.ajb.mPlayer;
                hVar2.xe();
                this.ajb.stopVoice(null);
            }
        }
    }
}
