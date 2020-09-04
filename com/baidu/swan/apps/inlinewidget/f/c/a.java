package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes8.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0409a {
        void aog();

        void gw(String str);

        void hU(int i);

        void mX(String str);

        void mY(String str);

        void mZ(@NonNull String str);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onStateChange(int i);
    }

    void a(@NonNull InterfaceC0409a interfaceC0409a);

    String aop();

    void aoq();

    void aor();

    InterfaceC0409a aos();

    boolean aot();

    int aou();

    boolean c(String str, String str2, String str3, boolean z);

    void ey(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void hV(int i);

    void hW(int i);

    boolean isPlaying();

    void l(int i, int i2, int i3, int i4);

    void ne(String str);

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
