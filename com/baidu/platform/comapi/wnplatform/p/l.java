package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f4698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f4698a = jVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f4698a.c = false;
    }
}
