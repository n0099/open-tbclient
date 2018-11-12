package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.c = false;
    }
}
