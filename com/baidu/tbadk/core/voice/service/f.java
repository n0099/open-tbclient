package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService anR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.anR = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.anR.mPlayer;
        if (hVar != null) {
            voice = this.anR.mVoice;
            if (voice != null) {
                hVar2 = this.anR.mPlayer;
                hVar2.xL();
                this.anR.stopVoice(null);
            }
        }
    }
}
