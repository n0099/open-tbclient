package com.baidu.swan.apps.p.f.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.p.d;
/* loaded from: classes7.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.p.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0373a {
        void agO();

        void fQ(int i);

        void fa(String str);

        void le(String str);

        void lf(String str);

        void lg(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onStateChange(int i);
    }

    void a(@NonNull InterfaceC0373a interfaceC0373a);

    String agP();

    void agQ();

    void agR();

    InterfaceC0373a agS();

    boolean agT();

    int agU();

    boolean c(String str, String str2, String str3, boolean z);

    void ee(boolean z);

    void fR(int i);

    void fS(int i);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
