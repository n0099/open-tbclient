package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService ajv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.ajv = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.ajv.mPlayer;
        if (hVar != null) {
            voice = this.ajv.mVoice;
            if (voice != null) {
                hVar2 = this.ajv.mPlayer;
                hVar2.xl();
                this.ajv.stopVoice(null);
            }
        }
    }
}
