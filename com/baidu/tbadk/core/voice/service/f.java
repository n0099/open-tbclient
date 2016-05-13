package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aeR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aeR = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.aeR.mPlayer;
        if (hVar != null) {
            voice = this.aeR.mVoice;
            if (voice != null) {
                hVar2 = this.aeR.mPlayer;
                hVar2.vX();
                this.aeR.stopVoice(null);
            }
        }
    }
}
