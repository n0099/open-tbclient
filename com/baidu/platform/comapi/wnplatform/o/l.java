package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class l implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f9933a;

    public l(i iVar) {
        this.f9933a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f9933a.f9930c = false;
    }
}
