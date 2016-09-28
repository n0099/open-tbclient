package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService aiD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.aiD = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.aiD.mPlayer;
        if (hVar != null) {
            voice = this.aiD.mVoice;
            if (voice != null) {
                hVar2 = this.aiD.mPlayer;
                hVar2.xg();
                this.aiD.stopVoice(null);
            }
        }
    }
}
