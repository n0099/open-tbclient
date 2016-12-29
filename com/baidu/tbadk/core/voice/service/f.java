package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aiW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aiW = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.aiW.mPlayer;
        if (hVar != null) {
            voice = this.aiW.mVoice;
            if (voice != null) {
                hVar2 = this.aiW.mPlayer;
                hVar2.wY();
                this.aiW.stopVoice(null);
            }
        }
    }
}
