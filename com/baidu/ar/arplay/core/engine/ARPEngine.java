package com.baidu.ar.arplay.core.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.baidu.ar.arplay.core.engine.ARPContent;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.renderer.ARPFilter;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class ARPEngine implements c {
    private static final String ENGINE_3D_CLASS_NAME = "com.baidu.ar.arplay.core.engine3d.ARPEngine3D";
    private static final String LOWEST_VERSION_KEY = "compatible_version";
    private static final String TAG = "ARPEngine";
    private static ARPEngine self = null;
    private AbstractARPEngine3D mARPEngine3D;
    private ARPEngineParams mARPEngineParams;
    boolean mScenePausedByUser;
    private boolean mIsInitNative = false;
    private volatile boolean mIsEngineCreated = false;
    private boolean mIsPaused = false;
    private ARPContent mARPContent = new ARPContent();
    private ARPFilter mARPFilter = new ARPFilter();
    private ARPRenderer mARPRenderer = new ARPRenderer();
    private ARPDataInteraction mARPDataInteraction = new ARPDataInteraction();

    private ARPEngine() {
        this.mARPContent.registerCaseLoadListener(this.mARPDataInteraction);
        initEngine3DInstance();
    }

    private boolean createApp(int i, int i2, int i3, int i4, float f, String str) {
        com.baidu.ar.arplay.c.b.b(TAG, "createApp [width*height]: [" + i + "*" + i2 + "]");
        boolean nativeCreateApp = nativeCreateApp(i, i2, i3, i4, f, str);
        this.mIsEngineCreated = true;
        if (this.mARPContent != null) {
            this.mARPContent.setEngineCreated(this.mIsEngineCreated);
        }
        return nativeCreateApp;
    }

    public static synchronized ARPEngine getInstance() {
        ARPEngine aRPEngine;
        synchronized (ARPEngine.class) {
            if (self == null) {
                self = new ARPEngine();
            }
            aRPEngine = self;
        }
        return aRPEngine;
    }

    private void initEngine3DInstance() {
        try {
            Object newInstance = Class.forName(ENGINE_3D_CLASS_NAME).newInstance();
            if (newInstance instanceof IARPEngine3D) {
                this.mARPEngine3D = (AbstractARPEngine3D) newInstance;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    public static native boolean libraryHasLoaded();

    private native boolean nativeSetup(Object obj, String str);

    public static synchronized void releaseInstance() {
        synchronized (ARPEngine.class) {
            if (self != null) {
                self.destroy();
            }
            self = null;
        }
    }

    public void addAlgoType(int[] iArr, int i) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.addAlgoType(iArr, i);
        }
    }

    public String adjustFilterWithCasePathParam(String str) {
        if (this.mARPFilter != null) {
            this.mARPFilter.adjustFilterWithCasePathParam(str);
            return null;
        }
        return null;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        if (this.mARPFilter != null) {
            this.mARPFilter.adjustFilterWithFloatArrayParam(str, str2, fArr, j);
        }
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f, long j) {
        if (this.mARPFilter != null) {
            this.mARPFilter.adjustFilterWithFloatParam(str, str2, f, j);
        }
    }

    public void adjustFilterWithIntParam(String str, String str2, int i, long j) {
        if (this.mARPFilter != null) {
            this.mARPFilter.adjustFilterWithIntParam(str, str2, i, j);
        }
    }

    public String adjustFilterWithJsonPathParam(String str) {
        if (this.mARPFilter != null) {
            return this.mARPFilter.adjustFilterWithJsonPathParam(str);
        }
        return null;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        if (this.mARPFilter != null) {
            this.mARPFilter.adjustFilterWithStringParam(str, str2, str3, j);
        }
    }

    public void clearARMemory() {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.clearARMemory();
        }
    }

    public void clearAlgoCache() {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.clearAlgoCache();
        }
    }

    public boolean createEngine(ARPEngineParams aRPEngineParams) {
        boolean z = false;
        synchronized (this) {
            if (aRPEngineParams != null) {
                this.mARPEngineParams = aRPEngineParams;
                if (!this.mIsInitNative) {
                    z = nativeSetup(new WeakReference(this), "5.1.0");
                    this.mIsInitNative = true;
                }
                if (!this.mIsEngineCreated) {
                    z = createApp(this.mARPEngineParams.getInputWidth(), this.mARPEngineParams.getInputHeight(), this.mARPEngineParams.getOutputWidth(), this.mARPEngineParams.getOutputHeight(), this.mARPEngineParams.getDensity(), this.mARPEngineParams.getShaderDBPath());
                    if (this.mARPDataInteraction != null) {
                        this.mARPDataInteraction.setup();
                    }
                }
                if (this.mARPEngine3D != null) {
                    this.mARPEngine3D.setIsActiveByARPlayVersionCase(isDriverdByARPVersion());
                }
                this.mARPContent.setIsFrontCamera(this.mARPEngineParams.isIsFrontCamera());
            }
        }
        return z;
    }

    @Override // com.baidu.ar.arplay.core.engine.d
    public synchronized void destroy() {
        com.baidu.ar.arplay.c.b.b(TAG, "destroy");
        if (this.mARPRenderer != null) {
            this.mARPRenderer.destroy();
        }
    }

    public synchronized void destroyEngine() {
        com.baidu.ar.arplay.c.b.b(TAG, "destroyEngine");
        this.mIsEngineCreated = false;
        if (this.mARPFilter != null) {
            this.mARPFilter.destroy();
        }
        if (this.mARPContent != null) {
            this.mARPContent.setEngineCreated(this.mIsEngineCreated);
            this.mARPContent.destroy();
        }
        if (this.mARPEngine3D != null) {
            this.mARPEngine3D.destroy();
        }
        nativeSetEngineBlendState(0);
        nativeDestroyEngine();
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.destroy();
        }
    }

    public void destroyMockAlgoHandle(long j) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.destroyMockAlgoHandle(j);
        }
    }

    public void disableCaseLutTexture() {
        if (this.mARPFilter != null) {
            this.mARPFilter.disableCaseLutTexture();
        }
    }

    public void disableFilterByAuthCode(int i) {
        if (this.mARPFilter != null) {
            this.mARPFilter.disableFilterByAuthCode(i);
        }
    }

    public IARPRenderer getARPRenderer() {
        return this.mARPRenderer;
    }

    public IARPScene getCurrentScene() {
        if (isEngineCanAccess() && this.mARPEngine3D != null) {
            return this.mARPEngine3D.getCurrentScene();
        }
        return null;
    }

    public float[] getWindowSize() {
        return this.mARPContent != null ? this.mARPContent.getWindowSize() : new float[0];
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.initDataStore(sharedPreferences);
        }
    }

    public void initWorldAxis() {
        if (this.mARPEngine3D != null) {
            this.mARPEngine3D.initWorldAxis();
        }
    }

    public boolean isAppControllerInterrupt() {
        return nativeIsAppControllerInterrupt();
    }

    public boolean isDriverdByARPVersion() {
        Object sharedEnvironmentValue = ARPScriptEnvironment.getInstance().getSharedEnvironmentValue("caseinfo");
        if (sharedEnvironmentValue != null && (sharedEnvironmentValue instanceof HashMap)) {
            HashMap hashMap = (HashMap) sharedEnvironmentValue;
            if (hashMap.get(LOWEST_VERSION_KEY) instanceof String) {
                String str = (String) hashMap.get(LOWEST_VERSION_KEY);
                return str != "" && str.compareTo("2.0.0") >= 0;
            }
        }
        return false;
    }

    public boolean isEngineCanAccess() {
        return this.mIsEngineCreated && this.mARPContent.isCaseCreated();
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public synchronized int loadCaseWithResPath(String str) {
        return (this.mARPContent == null || this.mARPRenderer == null) ? -1 : this.mARPContent.loadCaseWithResPath(str, this.mARPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
    }

    public synchronized void loadTempleteWithResPath(String str) {
        if (this.mARPContent != null && this.mARPRenderer != null) {
            this.mARPContent.loadTempleteWithResPath(str, this.mARPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
        }
    }

    public long mockFaceAlgoHandle(long j, float[] fArr) {
        if (this.mARPDataInteraction != null) {
            return this.mARPDataInteraction.mockFaceAlgoHandle(j, fArr);
        }
        return -1L;
    }

    native boolean nativeCreateApp(int i, int i2, int i3, int i4, float f, String str);

    native void nativeDestroyEngine();

    native boolean nativeIsAppControllerInterrupt();

    native void nativeOnPause();

    native void nativeOnResume();

    native void nativeSetConfig(String str, String str2);

    native void nativeSetEngineBlendState(int i);

    native void nativeSetLocalDeviceGrade(int i);

    public synchronized void onCaseLoadCompleted(Map map) {
        if (map != null) {
            if (this.mARPContent != null && this.mARPContent.checkValid(ARPContent.b.OnCaseLoaded)) {
                if (this.mARPRenderer != null) {
                    this.mARPRenderer.clearAllAsyncRenderTask();
                }
                this.mARPContent.onCaseLoadCompleted(map);
            }
            if (this.mIsPaused) {
                nativeOnPause();
            }
        }
    }

    public void onCaseUnloadCompleted() {
        if (this.mARPContent != null) {
            this.mARPContent.onCaseUnloadCompleted();
        }
    }

    public void onGestureUpdate(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9) {
        if (isEngineCanAccess() && this.mARPDataInteraction != null) {
            this.mARPDataInteraction.onGestureUpdate(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9);
        }
    }

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z) {
        if (isEngineCanAccess() && this.mARPDataInteraction != null) {
            this.mARPDataInteraction.onGestureUpdateWithScaleFinish(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9, z);
        }
    }

    public synchronized void onTempleLoadCompleted(Map map) {
        if (map != null) {
            if (this.mARPContent != null) {
                if (this.mARPRenderer != null) {
                    this.mARPRenderer.clearAllAsyncRenderTask();
                }
                this.mARPContent.onTempleLoadCompleted(map);
            }
        }
    }

    public void onTouchUpdate(int i, float f, float f2, float f3, float f4, long j, int i2, float f5) {
        if (isEngineCanAccess() && this.mARPDataInteraction != null) {
            this.mARPDataInteraction.onTouchUpdate(i, f, f2, f3, f4, j, i2, f5);
        }
    }

    public synchronized void pause() {
        this.mIsPaused = true;
        if (isEngineCanAccess()) {
            nativeOnPause();
        }
        if (this.mARPRenderer != null) {
            this.mARPRenderer.pause();
        }
    }

    public synchronized void pauseScene() {
        this.mIsPaused = true;
        if (isEngineCanAccess()) {
            nativeOnPause();
        }
        this.mScenePausedByUser = true;
    }

    public void removeAlgoType(int[] iArr) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.removeAlgoType(iArr);
        }
    }

    public synchronized void resume() {
        if (!this.mScenePausedByUser) {
            resumeScene();
        }
        if (this.mARPRenderer != null) {
            this.mARPRenderer.resume();
        }
    }

    public synchronized void resumeScene() {
        this.mIsPaused = false;
        if (isEngineCanAccess()) {
            nativeOnResume();
        }
        this.mScenePausedByUser = false;
    }

    public void sceneRotateToCamera() {
        if (this.mARPEngine3D != null) {
            this.mARPEngine3D.sceneRotateToCamera();
        }
    }

    public void sceneWorldPositionToOrigin() {
        if (this.mARPEngine3D != null) {
            this.mARPEngine3D.sceneWorldPositionToOrigin();
        }
    }

    public synchronized void setAlgoDataHandle(long j) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.setAlgoDataHandle(j);
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        if (this.mARPFilter != null) {
            this.mARPFilter.setAuthPic(bitmap, fArr);
        }
    }

    public void setConfig(String str, String str2) {
        com.baidu.ar.arplay.c.b.b(TAG, "syncServerConfig :" + str2);
        nativeSetConfig(str, str2);
    }

    public void setContext(SoftReference<Context> softReference) {
        if (this.mARPFilter != null) {
            this.mARPFilter.setContext(softReference);
        }
    }

    public void setEngineBlendState(int i) {
        nativeSetEngineBlendState(i);
    }

    public void setFaceLandMarkFrameAcheMode(int i) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.setFaceLandMarkFrameAcheMode(i);
        }
    }

    public synchronized void setHtmlUpdateCallback(ARPDataInteraction.a aVar) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.setHtmlUpdateCallback(aVar);
        }
    }

    public void setInteraction(ARPDataInteraction.b bVar) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.setInteraction(bVar);
        }
    }

    public void setIsFrontCamera(boolean z) {
        this.mARPContent.setIsFrontCamera(z);
    }

    public void setLocalDeviceGrade(int i) {
        com.baidu.ar.arplay.c.b.b(TAG, "setLocalDeviceGrade :" + i);
        nativeSetLocalDeviceGrade(i);
    }

    public void setPreviewSize(int i, int i2) {
        if (this.mARPContent != null) {
            this.mARPContent.setPreviewSize(i, i2);
        }
    }

    public synchronized void setVideoUpdateCallback(ARPDataInteraction.c cVar) {
        if (this.mARPDataInteraction != null) {
            this.mARPDataInteraction.setVideoUpdateCallback(cVar);
        }
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        if (this.mARPFilter != null) {
            this.mARPFilter.setWatermark(str, bitmap, fArr);
        }
    }

    public void setWindowSize(int i, int i2) {
        if (this.mARPContent != null) {
            this.mARPContent.setWindowSize(i, i2);
        }
    }

    public synchronized void unloadCase() {
        if (this.mARPContent != null && this.mARPContent.checkValid(ARPContent.b.UnloadCase)) {
            if (this.mARPRenderer != null) {
                this.mARPRenderer.clearAllAsyncRenderTask();
            }
            this.mARPContent.unloadCase();
        }
    }

    public synchronized void unloadTemplete() {
        com.baidu.ar.arplay.c.b.b(TAG, "unloadTemplete");
        this.mARPContent.unloadTemplete();
    }

    public void updateAlgoDataToNode(int i, int i2, byte[] bArr) {
        com.baidu.ar.arplay.c.b.c(TAG, "updateAlgoDataToNode");
        if (isEngineCanAccess() && this.mARPDataInteraction != null) {
            this.mARPDataInteraction.updateAlgoDataToNode(i, i2, bArr);
        }
    }

    public void updateNodeUniform(String str, HashMap<String, Object> hashMap) {
        if (!isEngineCanAccess() || isAppControllerInterrupt() || this.mARPEngine3D == null) {
            return;
        }
        this.mARPEngine3D.updateNodeUniform(str, hashMap);
    }
}
