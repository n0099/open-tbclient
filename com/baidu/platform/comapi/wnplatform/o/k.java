package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class k implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.c = false;
    }
}
