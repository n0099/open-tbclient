package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
    }
}
