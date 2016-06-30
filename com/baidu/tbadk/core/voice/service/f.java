package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService afs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.afs = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.afs.mPlayer;
        if (hVar != null) {
            voice = this.afs.mVoice;
            if (voice != null) {
                hVar2 = this.afs.mPlayer;
                hVar2.wa();
                this.afs.stopVoice(null);
            }
        }
    }
}
