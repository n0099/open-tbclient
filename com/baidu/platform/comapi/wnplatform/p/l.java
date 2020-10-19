package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f3149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f3149a = jVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3149a.c = false;
    }
}
