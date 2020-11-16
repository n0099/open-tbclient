package com.baidu.swan.apps.inlinewidget.rtcroom.c;

import android.support.annotation.NonNull;
import android.view.Surface;
/* loaded from: classes7.dex */
public interface a extends c {

    /* renamed from: com.baidu.swan.apps.inlinewidget.rtcroom.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0446a {
    }

    void a(@NonNull InterfaceC0446a interfaceC0446a);

    int getVideoHeight();

    int getVideoWidth();

    void iG(int i);

    void onFocus(int i, int i2, int i3, int i4);

    void onSurfaceChanged(int i, int i2);

    void oz(String str);

    void setSurface(Surface surface);

    void setUserId(long j);
}
