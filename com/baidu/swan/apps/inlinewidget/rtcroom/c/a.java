package com.baidu.swan.apps.inlinewidget.rtcroom.c;

import android.support.annotation.NonNull;
import android.view.Surface;
/* loaded from: classes8.dex */
public interface a extends c {

    /* renamed from: com.baidu.swan.apps.inlinewidget.rtcroom.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0410a {
    }

    void a(@NonNull InterfaceC0410a interfaceC0410a);

    int getVideoHeight();

    int getVideoWidth();

    void hJ(int i);

    void mQ(String str);

    void onFocus(int i, int i2, int i3, int i4);

    void onSurfaceChanged(int i, int i2);

    void setSurface(Surface surface);

    void setUserId(long j);
}
