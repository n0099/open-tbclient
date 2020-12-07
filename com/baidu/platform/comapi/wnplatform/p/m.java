package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class m implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f3154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f3154a = jVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3154a.c = false;
    }
}
