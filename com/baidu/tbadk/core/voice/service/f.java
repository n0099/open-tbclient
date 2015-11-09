package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MediaService mediaService) {
        this.afu = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        h hVar;
        Voice voice;
        h hVar2;
        hVar = this.afu.mPlayer;
        if (hVar != null) {
            voice = this.afu.mVoice;
            if (voice != null) {
                hVar2 = this.afu.mPlayer;
                hVar2.vN();
                this.afu.stopVoice(null);
            }
        }
    }
}
