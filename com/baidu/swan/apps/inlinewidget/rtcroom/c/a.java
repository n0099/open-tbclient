package com.baidu.swan.apps.inlinewidget.rtcroom.c;

import android.support.annotation.NonNull;
import android.view.Surface;
/* loaded from: classes10.dex */
public interface a extends c {

    /* renamed from: com.baidu.swan.apps.inlinewidget.rtcroom.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0422a {
    }

    void a(@NonNull InterfaceC0422a interfaceC0422a);

    int getVideoHeight();

    int getVideoWidth();

    void ip(int i);

    void nW(String str);

    void onFocus(int i, int i2, int i3, int i4);

    void onSurfaceChanged(int i, int i2);

    void setSurface(Surface surface);

    void setUserId(long j);
}
