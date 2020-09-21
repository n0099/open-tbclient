package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes3.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0404a {
        void aoQ();

        void gG(String str);

        void id(int i);

        void ie(int i);

        void nq(String str);

        void nr(String str);

        void ns(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();
    }

    void a(@NonNull InterfaceC0404a interfaceC0404a);

    String aoZ();

    void apa();

    void apb();

    InterfaceC0404a apc();

    boolean apd();

    int ape();

    boolean c(String str, String str2, String str3, boolean z);

    void ew(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    /* renamed from: if  reason: not valid java name */
    void mo34if(int i);

    void ig(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void nx(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
