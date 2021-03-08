package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes8.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0435a {
        void aww();

        void gE(String str);

        void hI(int i);

        void hJ(int i);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void ot(String str);

        void ou(String str);

        void ov(@NonNull String str);
    }

    void a(@NonNull InterfaceC0435a interfaceC0435a);

    String awF();

    void awG();

    void awH();

    InterfaceC0435a awI();

    boolean awJ();

    int awK();

    boolean e(String str, String str2, String str3, boolean z);

    void fN(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void hK(int i);

    void hL(int i);

    boolean isPlaying();

    void o(int i, int i2, int i3, int i4);

    void oA(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
