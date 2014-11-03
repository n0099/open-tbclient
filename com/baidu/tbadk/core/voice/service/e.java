package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService IX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.IX = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        g gVar;
        Voice voice;
        g gVar2;
        gVar = this.IX.mPlayer;
        if (gVar != null) {
            voice = this.IX.mVoice;
            if (voice != null) {
                gVar2 = this.IX.mPlayer;
                gVar2.nM();
                this.IX.stopVoice(null);
            }
        }
    }
}
