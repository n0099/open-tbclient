package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes7.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0445a {
        void avp();

        void hg(String str);

        void iR(int i);

        void iS(int i);

        void oF(String str);

        void oG(String str);

        void oH(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();
    }

    void a(@NonNull InterfaceC0445a interfaceC0445a);

    void avA();

    InterfaceC0445a avB();

    boolean avC();

    int avD();

    String avy();

    void avz();

    boolean c(String str, String str2, String str3, boolean z);

    void fr(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void iT(int i);

    void iU(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void oM(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
