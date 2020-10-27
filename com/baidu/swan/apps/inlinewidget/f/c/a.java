package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes10.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0435a {
        void atx();

        void hf(String str);

        void iL(int i);

        void iM(int i);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void ox(String str);

        void oy(String str);

        void oz(@NonNull String str);
    }

    void a(@NonNull InterfaceC0435a interfaceC0435a);

    String atG();

    void atH();

    void atI();

    InterfaceC0435a atJ();

    boolean atK();

    int atL();

    boolean c(String str, String str2, String str3, boolean z);

    void ff(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void iN(int i);

    void iO(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void oE(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
