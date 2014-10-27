package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService IW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.IW = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        g gVar;
        Voice voice;
        g gVar2;
        gVar = this.IW.mPlayer;
        if (gVar != null) {
            voice = this.IW.mVoice;
            if (voice != null) {
                gVar2 = this.IW.mPlayer;
                gVar2.nM();
                this.IW.stopVoice(null);
            }
        }
    }
}
