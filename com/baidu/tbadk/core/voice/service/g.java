package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.aaO = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.aaO.mPlayer;
        if (iVar != null) {
            voice = this.aaO.mVoice;
            if (voice != null) {
                iVar2 = this.aaO.mPlayer;
                iVar2.uK();
                this.aaO.stopVoice(null);
            }
        }
    }
}
