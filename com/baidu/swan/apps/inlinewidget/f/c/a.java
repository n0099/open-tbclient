package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes10.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0447a {
        void avX();

        void hm(String str);

        void iV(int i);

        void iW(int i);

        void oL(String str);

        void oM(String str);

        void oN(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();
    }

    void a(@NonNull InterfaceC0447a interfaceC0447a);

    String awg();

    void awh();

    void awi();

    InterfaceC0447a awj();

    boolean awk();

    int awl();

    boolean c(String str, String str2, String str3, boolean z);

    void fo(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void iX(int i);

    void iY(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void oS(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
