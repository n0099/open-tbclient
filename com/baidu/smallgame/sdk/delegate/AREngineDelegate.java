package com.baidu.smallgame.sdk.delegate;

import android.opengl.GLSurfaceView;
import com.baidu.mario.b.b;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.smallgame.sdk.ArBridge;
@NotProguard
/* loaded from: classes2.dex */
public interface AREngineDelegate {
    void exitGLThread();

    ArBridge getArBridge();

    long getCurrentRecordProcess();

    Thread getGLThread();

    int getRenderMode();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void pauseRecord();

    void queueEvent(Runnable runnable);

    void queueEvent(Runnable runnable, long j);

    void requestRender();

    void requestRenderAndWait();

    void resumeRecord();

    void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener);

    void setGameRecordCallback(b bVar);

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void smallGameDestroy();

    void smallGameOnPause();

    void smallGameUpdate();

    void startRecord(boolean z, int i, String str, boolean z2);

    void stopRecord();

    void surfaceChanged(int i, int i2);

    void surfaceCreated();

    void surfaceDestroyed();
}
