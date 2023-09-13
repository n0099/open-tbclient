package com.baidu.cyberplayer.sdk;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.View;
import java.nio.Buffer;
@Keep
/* loaded from: classes3.dex */
public interface ICyberRenderView {

    /* loaded from: classes3.dex */
    public interface ICyberSurfaceListener {
        void onSnapShotComplete(int i, int i2, Buffer buffer);

        void onSurfaceChanged(int i, int i2);

        void onSurfaceDestroyed(int i);

        void onSurfaceFirstFrameDrawed(long j);

        boolean onSurfaceReady(int i);
    }

    Surface createNewSurface();

    void destory();

    SurfaceTexture getSurfaceTexture();

    View getView();

    boolean isNeedTakeSnapShotAsync();

    void onVideoSizeChanged(int i, int i2, int i3, int i4);

    void release();

    void reset();

    void setClientRotation(int i);

    void setCyberSurfaceListener(ICyberSurfaceListener iCyberSurfaceListener);

    void setDisplayMode(int i);

    boolean setFilterRegion(int i, float f, float f2, float f3, float f4);

    void setRawFrameRotation(int i);

    void setZOrderMediaOverlay(boolean z);

    Bitmap takeSnapshot(float f, int i, int i2);
}
