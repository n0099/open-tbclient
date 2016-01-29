package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aiP = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.aiP.mPlayer;
        if (hVar != null) {
            voice = this.aiP.mVoice;
            if (voice != null) {
                hVar2 = this.aiP.mPlayer;
                hVar2.xB();
                this.aiP.stopVoice(null);
            }
        }
    }
}
