package com.baidu.swan.apps.inlinewidget.rtcroom.c;

import android.view.Surface;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface a extends c {

    /* renamed from: com.baidu.swan.apps.inlinewidget.rtcroom.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0433a {
    }

    void a(@NonNull InterfaceC0433a interfaceC0433a);

    int getVideoHeight();

    int getVideoWidth();

    void ht(int i);

    void nM(String str);

    void onFocus(int i, int i2, int i3, int i4);

    void onSurfaceChanged(int i, int i2);

    void setSurface(Surface surface);

    void setUserId(long j);
}
