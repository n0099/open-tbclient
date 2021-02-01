package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes9.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0429a {
        void awt();

        void gy(String str);

        void hH(int i);

        void hI(int i);

        void ol(String str);

        void om(String str);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void oo(@NonNull String str);
    }

    void a(@NonNull InterfaceC0429a interfaceC0429a);

    String awC();

    void awD();

    void awE();

    InterfaceC0429a awF();

    boolean awG();

    int awH();

    boolean e(String str, String str2, String str3, boolean z);

    void fN(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void hJ(int i);

    void hK(int i);

    boolean isPlaying();

    void o(int i, int i2, int i3, int i4);

    void ot(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
