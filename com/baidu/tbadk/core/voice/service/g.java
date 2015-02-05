package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.OD = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.OD.mPlayer;
        if (iVar != null) {
            voice = this.OD.mVoice;
            if (voice != null) {
                iVar2 = this.OD.mPlayer;
                iVar2.qS();
                this.OD.stopVoice(null);
            }
        }
    }
}
