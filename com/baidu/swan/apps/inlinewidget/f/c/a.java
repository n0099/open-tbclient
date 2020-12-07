package com.baidu.swan.apps.inlinewidget.f.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.baidu.swan.apps.inlinewidget.d;
/* loaded from: classes25.dex */
public interface a extends d {

    /* renamed from: com.baidu.swan.apps.inlinewidget.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0457a {
        void ayx();

        void hB(String str);

        void jp(int i);

        void jq(int i);

        void onEnded();

        void onError(int i);

        void onPrepared();

        void pm(String str);

        void pn(String str);

        void po(@NonNull String str);
    }

    void a(@NonNull InterfaceC0457a interfaceC0457a);

    String ayG();

    void ayH();

    void ayI();

    InterfaceC0457a ayJ();

    boolean ayK();

    int ayL();

    boolean c(String str, String str2, String str3, boolean z);

    void fG(boolean z);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void jr(int i);

    void js(int i);

    void o(int i, int i2, int i3, int i4);

    void pause();

    boolean prepareAsync();

    void pt(String str);

    void release();

    void seekTo(int i);

    void setMuted(boolean z);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
