package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ MediaService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.a = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        g gVar;
        Voice voice;
        g gVar2;
        gVar = this.a.mPlayer;
        if (gVar != null) {
            voice = this.a.mVoice;
            if (voice != null) {
                gVar2 = this.a.mPlayer;
                gVar2.b();
                this.a.stopVoice(null);
            }
        }
    }
}
