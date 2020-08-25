package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class k implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.baidu.platform.comapi.wnplatform.n.d.a().a(false);
    }
}
