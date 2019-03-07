package com.baidu.smallgame.sdk.delegate;

import android.opengl.GLSurfaceView;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.smallgame.sdk.ArBridge;
@NotProguard
/* loaded from: classes2.dex */
public interface AREngineDelegate {
    void exitGLThread();

    ArBridge getArBridge();

    Thread getGLThread();

    int getRenderMode();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void queueEvent(Runnable runnable);

    void requestRender();

    void requestRenderAndWait();

    void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener);

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void smallGameDestroy();

    void smallGameOnPause();

    void smallGameUpdate();

    void surfaceChanged(int i, int i2);

    void surfaceCreated();

    void surfaceDestroyed();
}
