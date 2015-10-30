package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService afp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.afp = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.afp.mPlayer;
        if (hVar != null) {
            voice = this.afp.mVoice;
            if (voice != null) {
                hVar2 = this.afp.mPlayer;
                hVar2.vJ();
                this.afp.stopVoice(null);
            }
        }
    }
}
