package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes10.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0421a {
        void arC();

        void gU(String str);

        void iA(int i);

        void iB(int i);

        void oc(String str);

        void od(String str);

        void oe(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();
    }

    void a(@NonNull InterfaceC0421a interfaceC0421a);

    String arL();

    void arM();

    void arN();

    InterfaceC0421a arO();

    boolean arP();

    int arQ();

    boolean c(String str, String str2, String str3, boolean z);

    void eS(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void iC(int i);

    void iD(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void ok(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
