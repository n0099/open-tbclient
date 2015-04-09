package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService ZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaService mediaService) {
        this.ZN = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        i iVar;
        Voice voice;
        i iVar2;
        iVar = this.ZN.mPlayer;
        if (iVar != null) {
            voice = this.ZN.mVoice;
            if (voice != null) {
                iVar2 = this.ZN.mPlayer;
                iVar2.ub();
                this.ZN.stopVoice(null);
            }
        }
    }
}
