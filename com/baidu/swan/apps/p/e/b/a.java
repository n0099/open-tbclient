package com.baidu.swan.apps.p.e.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.p.d;
/* loaded from: classes11.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.p.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0370a {
        void afD();

        void fG(int i);

        void fb(String str);

        void kH(String str);

        void kI(String str);

        void kJ(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onStateChange(int i);
    }

    void a(@NonNull InterfaceC0370a interfaceC0370a);

    String afE();

    void afF();

    void afG();

    InterfaceC0370a afH();

    boolean afI();

    int afJ();

    boolean c(String str, String str2, String str3, boolean z);

    void dY(boolean z);

    void fH(int i);

    void fI(int i);

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
