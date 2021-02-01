package com.baidu.swan.apps.inlinewidget.rtcroom.c;

import android.view.Surface;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public interface a extends c {

    /* renamed from: com.baidu.swan.apps.inlinewidget.rtcroom.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0430a {
    }

    void a(@NonNull InterfaceC0430a interfaceC0430a);

    int getVideoHeight();

    int getVideoWidth();

    void hw(int i);

    void oe(String str);

    void onFocus(int i, int i2, int i3, int i4);

    void onSurfaceChanged(int i, int i2);

    void setSurface(Surface surface);

    void setUserId(long j);
}
