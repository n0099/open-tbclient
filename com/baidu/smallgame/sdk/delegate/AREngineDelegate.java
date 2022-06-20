package com.baidu.smallgame.sdk.delegate;

import android.opengl.GLSurfaceView;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.repackage.md1;
import com.repackage.od1;
import com.repackage.vb0;
import com.repackage.xb0;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes2.dex */
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

    od1 getStuckScreenHandler();

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

    void setAudioEngineProxy(vb0 vb0Var);

    void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener);

    void setGameRecordCallback(xb0 xb0Var);

    void setOnStuckScreenListener(md1 md1Var);

    void setPermissionProxy(PermissionProxy permissionProxy);

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setScreenShotStatus(boolean z);

    void setStuckScreenLimitTime(long j);

    void smallGameDestroy();

    void smallGameOnPause();

    void smallGameUpdate();

    void startEngine();

    void startRecord(boolean z, int i, String str, boolean z2);

    void stopRecord();

    void surfaceChanged(int i, int i2);

    void surfaceCreated();

    void surfaceDestroyed();

    void updateSurfaceViewSize(float f, float f2);
}
