package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes8.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0432a {
        void avV();

        void ga(String str);

        void hE(int i);

        void hF(int i);

        void nS(String str);

        void nT(String str);

        void nU(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();
    }

    void a(@NonNull InterfaceC0432a interfaceC0432a);

    String awe();

    void awf();

    void awg();

    InterfaceC0432a awh();

    boolean awi();

    int awj();

    boolean e(String str, String str2, String str3, boolean z);

    void fL(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void hG(int i);

    void hH(int i);

    boolean isPlaying();

    void nZ(String str);

    void o(int i, int i2, int i3, int i4);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
