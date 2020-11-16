package com.baidu.ala.recorder.video.listener;

import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.view.Surface;
/* loaded from: classes15.dex */
public interface TextureViewListener {

    /* loaded from: classes15.dex */
    public interface SurfaceHolder {
        Surface getSurface();

        int getSurfaceHeight();

        int getSurfaceWidth();
    }

    void onConfigurationChanged(Configuration configuration);

    void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

    void onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);

    void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2);

    void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

    void onSurfaceWindow(SurfaceHolder surfaceHolder);
}
