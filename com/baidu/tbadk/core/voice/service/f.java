package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aoG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aoG = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.aoG.mPlayer;
        if (hVar != null) {
            voice = this.aoG.mVoice;
            if (voice != null) {
                hVar2 = this.aoG.mPlayer;
                hVar2.xk();
                this.aoG.stopVoice(null);
            }
        }
    }
}
