package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService ZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.ZL = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.ZL.mPlayer;
        if (iVar != null) {
            voice = this.ZL.mVoice;
            if (voice != null) {
                iVar2 = this.ZL.mPlayer;
                iVar2.ub();
                this.ZL.stopVoice(null);
            }
        }
    }
}
