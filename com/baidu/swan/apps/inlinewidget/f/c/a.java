package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes9.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0449a {
        void azP();

        void hm(String str);

        void jk(int i);

        void jl(int i);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void pf(String str);

        void pg(String str);

        void ph(@NonNull String str);
    }

    void a(@NonNull InterfaceC0449a interfaceC0449a);

    void aAa();

    InterfaceC0449a aAb();

    boolean aAc();

    int aAd();

    String azY();

    void azZ();

    boolean e(String str, String str2, String str3, boolean z);

    void fP(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void jm(int i);

    void jn(int i);

    void o(int i, int i2, int i3, int i4);

    void pause();

    void pm(String str);

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
