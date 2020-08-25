package com.baidu.cyberplayer.sdk;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
@Keep
/* loaded from: classes7.dex */
public abstract class CyberVRRenderProvider {

    @Keep
    /* loaded from: classes7.dex */
    public interface INotSupportCallback {
        void onNotSupport(int i);
    }

    @Keep
    /* loaded from: classes7.dex */
    public interface IOnSurfaceReadyCallback {
        void onSurfaceReady(Surface surface);
    }

    public abstract CyberVRRenderProvider asVideo(IOnSurfaceReadyCallback iOnSurfaceReadyCallback);

    public abstract CyberVRRenderProvider displayMode(int i);

    public abstract CyberVRRenderProvider ifNotSupport(INotSupportCallback iNotSupportCallback);

    public abstract void init(SurfaceView surfaceView);

    public abstract void init(TextureView textureView);

    public abstract CyberVRRenderProvider interactiveMode(int i);

    public abstract void onDestroy();

    public abstract void onOrientationChanged();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onTextureResize(float f, float f2);

    public abstract CyberVRRenderProvider pinchEnabled(boolean z);

    public abstract CyberVRRenderProvider projectionMode(int i);

    public abstract CyberVRRenderProvider setFov(float f, float f2, float f3);

    public abstract void switchDisplayMode(int i);

    public abstract void switchInteractiveMode(int i);

    public abstract void switchProjectionMode(int i);
}
