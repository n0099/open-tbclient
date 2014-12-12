package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService Of;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.Of = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.Of.mPlayer;
        if (iVar != null) {
            voice = this.Of.mVoice;
            if (voice != null) {
                iVar2 = this.Of.mPlayer;
                iVar2.qN();
                this.Of.stopVoice(null);
            }
        }
    }
}
