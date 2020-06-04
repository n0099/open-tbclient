package com.baidu.swan.apps.p.e.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.p.d;
/* loaded from: classes11.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.p.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0364a {
        void aex();

        void eV(String str);

        void fv(int i);

        void kA(String str);

        void kB(@NonNull String str);

        void kz(String str);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onStateChange(int i);
    }

    void a(@NonNull InterfaceC0364a interfaceC0364a);

    void aeA();

    InterfaceC0364a aeB();

    boolean aeC();

    int aeD();

    String aey();

    void aez();

    boolean c(String str, String str2, String str3, boolean z);

    void dT(boolean z);

    void fw(int i);

    void fx(int i);

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
