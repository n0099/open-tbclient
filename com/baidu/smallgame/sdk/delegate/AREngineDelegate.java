package com.baidu.smallgame.sdk.delegate;

import android.opengl.GLSurfaceView;
import b.a.k0.a.d.c;
import b.a.x.c.a;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes7.dex */
public interface AREngineDelegate {
    boolean ableToDraw();

    void addDebugConsole(DebugConsole debugConsole);

    void clearOldEvents();

    void exitGLThread();

    long getCurrentRecordProcess();

    int getFPS();

    Thread getGLThread();

    JSONArray getPerformanceJson();

    PerformanceJsonBean getPerformanceJsonBean();

    int getRenderMode();

    c getStuckScreenHandler();

    void initDisplayMetrics();

    boolean isDestroyed();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void pauseRecord();

    void queueEvent(Runnable runnable);

    void queueEvent(Runnable runnable, long j);

    void removeDebugConsole(DebugConsole debugConsole);

    void requestRender();

    void requestRenderAndWait();

    void resumeRecord();

    void runOnGLThread(Runnable runnable);

    void setAudioEngineProxy(a aVar);

    void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener);

    void setGameRecordCallback(b.a.x.c.c cVar);

    void setOnStuckScreenListener(b.a.k0.a.d.a aVar);

    void setPermissionProxy(PermissionProxy permissionProxy);

    void setRenderMode(int i2);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setScreenShotStatus(boolean z);

    void setStuckScreenLimitTime(long j);

    void smallGameDestroy();

    void smallGameOnPause();

    void smallGameUpdate();

    void startEngine();

    void startRecord(boolean z, int i2, String str, boolean z2);

    void stopRecord();

    void surfaceChanged(int i2, int i3);

    void surfaceCreated();

    void surfaceDestroyed();

    void updateSurfaceViewSize(float f2, float f3);
}
