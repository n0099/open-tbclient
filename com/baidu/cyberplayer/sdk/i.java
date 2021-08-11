package com.baidu.cyberplayer.sdk;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import java.nio.Buffer;
/* loaded from: classes5.dex */
public interface i {

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2, int i3);

        void a(int i2, int i3, Buffer buffer);

        void a(long j2);

        boolean a(int i2);
    }

    Bitmap a(float f2, int i2, int i3);

    void a();

    void a(int i2, int i3, int i4, int i5);

    void b();

    void c();

    Surface d();

    boolean e();

    View getView();

    void setClientRotation(int i2);

    void setCyberSurfaceListener(a aVar);

    void setDisplayMode(int i2);

    void setRawFrameRotation(int i2);

    void setZOrderMediaOverlay(boolean z);
}
