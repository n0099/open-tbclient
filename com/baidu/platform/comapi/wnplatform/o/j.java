package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f4460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f4460a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
    }
}
