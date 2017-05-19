package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService anW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.anW = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.anW.mPlayer;
        if (hVar != null) {
            voice = this.anW.mVoice;
            if (voice != null) {
                hVar2 = this.anW.mPlayer;
                hVar2.wZ();
                this.anW.stopVoice(null);
            }
        }
    }
}
