package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class k implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f9932a;

    public k(i iVar) {
        this.f9932a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f9932a.f9930c = false;
    }
}
