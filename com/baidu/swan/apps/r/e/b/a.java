package com.baidu.swan.apps.r.e.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.r.d;
/* loaded from: classes10.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.r.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0267a {
        void Rp();

        void eN(int i);

        void onEnded();

        void onError(int i);

        void onPaused();

        void onPlayed();

        void onPrepared();
    }

    void Rq();

    void Rr();

    boolean Rs();

    void a(@NonNull InterfaceC0267a interfaceC0267a);

    boolean c(String str, String str2, String str3, boolean z);

    void cz(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void m(int i, int i2, int i3, int i4);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
