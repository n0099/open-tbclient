package com.baidu.cyberplayer.sdk;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import java.nio.Buffer;
/* loaded from: classes4.dex */
public interface i {

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, int i2, Buffer buffer);

        void a(long j);

        boolean a(int i);
    }

    Bitmap a(float f, int i, int i2);

    void a();

    void a(int i, int i2, int i3, int i4);

    void b();

    void c();

    Surface d();

    boolean e();

    View getView();

    void setClientRotation(int i);

    void setCyberSurfaceListener(a aVar);

    void setDisplayMode(int i);

    void setRawFrameRotation(int i);

    void setZOrderMediaOverlay(boolean z);
}
