package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService OG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.OG = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.OG.mPlayer;
        if (iVar != null) {
            voice = this.OG.mVoice;
            if (voice != null) {
                iVar2 = this.OG.mPlayer;
                iVar2.qY();
                this.OG.stopVoice(null);
            }
        }
    }
}
