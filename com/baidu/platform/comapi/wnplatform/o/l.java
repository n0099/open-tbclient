package com.baidu.platform.comapi.wnplatform.o;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class l implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f10301a;

    public l(i iVar) {
        this.f10301a = iVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f10301a.f10298c = false;
    }
}
