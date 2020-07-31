package com.baidu.ar.arplay.core.engine;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.arplay.core.filter.ARPFilter;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class ARPEngine {
    private static final String LOWEST_VERSION_KEY = "compatible_version";
    public static final String MYTAG = "tracking_data_debug";
    private static final String TAG = "EngineLogger";
    private static ARPEngine self = null;
    private int mCurrentCaseId;
    private com.baidu.ar.arplay.a.b mDataStore;
    private d mHtmlCallback;
    public ByteBuffer mMaskBuffer;
    private OrientationEventListener mOrientationEventListener;
    private g mVideoCallback;
    private boolean mIsInitNative = false;
    private e mInteraction = null;
    private boolean mIsAppBackground = false;
    private c mCaseState = c.EUninit;
    private volatile boolean mIsEngineCreated = false;
    private volatile boolean mIsTempleteCreating = false;
    private volatile boolean mIsTempleteCreated = false;
    private volatile boolean mIsTempleteDestoring = true;
    private volatile boolean mIsTempleteDestoryed = false;
    private boolean mIsFrontCamera = true;
    private int mWindowWidth = 720;
    private int mWindowHeight = PlatformPlugin.DEFAULT_SYSTEM_UI;
    private boolean mIsPaused = false;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private Map<String, a> mAlgoRunnbaleMap = new HashMap();
    private int mDeviceOrientation = -1;
    private f mTouchOrientation = f.SCREEN_ORIENTATION_NOT_DEFINED;
    private int mFPS = 0;
    private final int mARTypeUnknow = -1;
    private final int mARTypeTracking = 0;
    private final int mARTypeSlam = 5;
    private final int mARTypeLocalSameSearch = 6;
    private final int mARTypeCloudSameSearch = 7;
    private final int mARTypeIMU = 8;
    private int mImuType = 0;
    private long start = 0;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private ARPHandle et;
        final /* synthetic */ ARPEngine eu;

        public synchronized void release() {
            if (this.et != null) {
                this.et.release();
            }
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            if (this.eu.isEngineCanAccess() && this.et != null) {
                com.baidu.ar.arplay.c.b.c("ARPHandle", "use copy handle : " + this.et.getHandle());
                this.eu.nativeSetAlgoDataHandle(this.et.getHandle());
                this.et.release();
                this.et = null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum c {
        EUninit,
        ECreating,
        ECreated,
        EDestroying
    }

    /* loaded from: classes11.dex */
    public interface d {
        boolean c(int i, int i2);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void a(float f, float f2, float f3);
    }

    /* loaded from: classes11.dex */
    public enum f {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes11.dex */
    public interface g {
        void a(String str, int i, String str2, String str3);
    }

    private ARPEngine() {
    }

    private void createApp(int i, int i2, int i3, int i4, float f2) {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "createApp");
        nativeCreateApp(i, i2, i3, i4, f2);
        this.mIsEngineCreated = true;
    }

    private int getARType() {
        Object sharedEnvironmentValue = ARPScriptEnvironment.getInstance().getSharedEnvironmentValue(TableDefine.DB_TABLE_USERINFO);
        if (sharedEnvironmentValue != null && (sharedEnvironmentValue instanceof HashMap)) {
            HashMap hashMap = (HashMap) sharedEnvironmentValue;
            if (hashMap.get("ar_type") instanceof Integer) {
                return ((Integer) hashMap.get("ar_type")).intValue();
            }
        }
        return 0;
    }

    private ARPScene getCurrentSceneInner() {
        long nativeGetCurrentScene = nativeGetCurrentScene();
        if (nativeGetCurrentScene == -1) {
            return null;
        }
        ARPScene aRPScene = new ARPScene();
        aRPScene.f(nativeGetCurrentScene);
        return aRPScene;
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

    private static String getValue(Object obj, int i, String str) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        return aRPEngine == null ? "" : aRPEngine.getValue(i, str);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native void nativeSetup(Object obj);

    public static void onInteractionFinish(Object obj, float f2, float f3, float f4) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine == null) {
            return;
        }
        aRPEngine.onInteractionFinish(f2, f3, f4);
    }

    private void releaseComponents() {
        setImuType(0);
        com.baidu.ar.arplay.a.a.aB().aC();
        com.baidu.ar.arplay.a.e.aM().release();
        com.baidu.ar.arplay.d.b.bh().release();
        ARPScriptEnvironment.getInstance().release();
    }

    private void saveInteractionInfoInEnvironment() {
        int aRType = getARType();
        if (aRType == 8) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("gesture_scroll", "interaction_space_move");
            hashMap2.put("gesture_two_finger_scroll", "interaction_rotate");
            hashMap2.put("gesture_two_finger_pinch", "interaction_scale_down");
            hashMap2.put("gesture_two_finger_unpinch", "interaction_scale_up");
            hashMap.put("continuous_mapping", hashMap2);
            hashMap3.put("limit_radius_invariant", 1);
            hashMap.put("space_move_config", hashMap3);
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
        } else if (aRType == 0 || aRType == 6 || aRType == 7) {
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            HashMap hashMap6 = new HashMap();
            hashMap5.put("gesture_scroll", "interaction_space_move");
            hashMap5.put("gesture_two_finger_scroll", "interaction_rotate");
            hashMap5.put("gesture_two_finger_pinch", "interaction_scale_down");
            hashMap5.put("gesture_two_finger_unpinch", "interaction_scale_up");
            hashMap4.put("continuous_mapping", hashMap5);
            hashMap6.put("limit_radius_invariant", 0);
            hashMap4.put("space_move_config", hashMap6);
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap4);
        } else if (aRType == 5) {
            HashMap hashMap7 = new HashMap();
            HashMap hashMap8 = new HashMap();
            hashMap8.put("gesture_scroll", "interaction_plane_move");
            hashMap8.put("gesture_two_finger_scroll", "interaction_rotate");
            hashMap8.put("gesture_two_finger_pinch", "interaction_scale_down");
            hashMap8.put("gesture_two_finger_unpinch", "interaction_scale_up");
            hashMap7.put("continuous_mapping", hashMap8);
            HashMap hashMap9 = new HashMap();
            hashMap9.put("limit_radius", 1);
            hashMap9.put("radius_min", Float.valueOf(0.0f));
            hashMap9.put("radius_max", Float.valueOf(3000.0f));
            hashMap9.put("limit_step_length", 1);
            hashMap9.put("step_length", Float.valueOf(80.0f));
            hashMap9.put("limit_far_frustum", 1);
            hashMap9.put("move_leave_callback", 1);
            hashMap7.put("plane_move_config", hashMap9);
            HashMap hashMap10 = new HashMap();
            hashMap10.put("limit_world_axis", 1);
            hashMap10.put("world_axis", "y");
            hashMap7.put("rotate_config", hashMap10);
            HashMap hashMap11 = new HashMap();
            hashMap11.put("limit_distance_factor", 1);
            hashMap7.put("scale_config", hashMap11);
            ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap7);
        }
    }

    private void setFaceFrame(long j) {
        if (j > 0) {
            nativeSetFaceLandMark(j, this.mIsFrontCamera ? 0 : 1);
        } else {
            nativeSetFaceLandMark(0L, 0);
        }
    }

    private void setInteractionConfigAfterSceneCreate() {
        boolean isDriverdByARPVersion = isDriverdByARPVersion();
        ARPScene currentSceneInner = getCurrentSceneInner();
        if (getARType() != 5 || currentSceneInner == null) {
            return;
        }
        ARPNode aZ = currentSceneInner.aZ();
        if (isDriverdByARPVersion) {
            Vector3f vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
            if (aZ != null) {
                aZ.b(vector3f);
                return;
            }
            return;
        }
        ARPInteractionConfig.a(new Vector3f(0.0f, 0.0f, 1.0f), 0.0f);
        Vector3f vector3f2 = new Vector3f(0.0f, 0.0f, 1.0f);
        if (aZ != null) {
            aZ.b(vector3f2);
        }
    }

    private void setInteractionConfigBeforeSceneCreate() {
        saveInteractionInfoInEnvironment();
    }

    private static void setValue(Object obj, int i, String str, String str2) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine == null) {
            return;
        }
        aRPEngine.setValue(i, str, str2);
    }

    private static void updateVideoFrame(Object obj, String str, int i, String str2, String str3) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine == null) {
            return;
        }
        aRPEngine.updateVideoFrame(str, i, str2, str3);
    }

    public static boolean updateWebViewFrame(Object obj, int i, int i2) {
        ARPEngine aRPEngine = (ARPEngine) ((WeakReference) obj).get();
        if (aRPEngine == null) {
            return false;
        }
        return aRPEngine.updateWebViewFrame(i, i2);
    }

    public void addAlgoType(int[] iArr, int i) {
        nativeAddAlgoType(iArr, i);
    }

    public void clearARMemory() {
        if (this.mDataStore != null) {
            this.mDataStore.clearARMemory();
        }
    }

    public void clearAlgoCache() {
        nativeClearAlgoCache();
    }

    public void createEngine(int i, int i2, int i3, int i4, float f2) {
        synchronized (this) {
            if (!this.mIsInitNative) {
                nativeSetup(new WeakReference(this));
                this.mIsInitNative = true;
            }
            if (!this.mIsEngineCreated) {
                createApp(i, i2, i3, i4, f2);
            }
        }
    }

    public synchronized void destroyEngine() {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "destroyEngine");
        this.mIsEngineCreated = false;
        this.mCaseState = c.EUninit;
        ARPCamera.aU();
        nativeSetEngineBlendState(0);
        nativeDestroyEngine();
        releaseComponents();
        nativeReleaseALgoCacheInstance();
    }

    protected void finalize() {
        super.finalize();
        synchronized (this) {
            if (this.mIsInitNative) {
                try {
                    nativeFinalize();
                } catch (Throwable th) {
                }
            }
        }
    }

    public ARPScene getCurrentScene() {
        if (isEngineCanAccess()) {
            return getCurrentSceneInner();
        }
        return null;
    }

    public int getFps() {
        this.mFPS = nativeGetFps();
        return this.mFPS;
    }

    public int getImuType() {
        return this.mImuType;
    }

    public String getValue(int i, String str) {
        if (this.mDataStore != null) {
            return this.mDataStore.getValue(i, str);
        }
        Log.e("ARPEngine", "get value error!");
        return "";
    }

    public float[] getWindowSize() {
        return new float[]{this.mWindowWidth, this.mWindowHeight};
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            this.mDataStore = new com.baidu.ar.arplay.a.b();
            this.mDataStore.a(sharedPreferences);
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
        return this.mIsEngineCreated && this.mCaseState == c.ECreated;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public synchronized int loadCaseWithResPath(String str) {
        int i;
        if (!this.mIsEngineCreated || this.mCaseState == c.ECreating) {
            i = -1;
        } else {
            this.mCaseState = c.ECreating;
            setInteractionConfigBeforeSceneCreate();
            ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
            com.baidu.ar.arplay.c.b.b("ARPEngine", "loadCase :" + str + " mCurrentCaseId :" + this.mCurrentCaseId);
            this.start = System.currentTimeMillis();
            this.mPreviewWidth = this.mPreviewWidth > 0 ? this.mPreviewWidth : ARPFilter.getInstance().getCameraPreviewWidth();
            this.mPreviewHeight = this.mPreviewHeight > 0 ? this.mPreviewHeight : ARPFilter.getInstance().getCameraPreviewHeight();
            if (this.mWindowWidth > 0 && this.mWindowHeight > 0) {
                nativeSetWindowSize(this.mWindowWidth, this.mWindowHeight);
            }
            nativeLoadCase(str, this.mPreviewWidth, this.mPreviewHeight);
            i = this.mCurrentCaseId;
        }
        return i;
    }

    public synchronized void loadTempleteWithResPath(String str) {
        synchronized (this) {
            if (!this.mIsTempleteCreating) {
                if (!this.mIsTempleteDestoring) {
                    unloadTemplete();
                }
                this.mIsTempleteCreating = true;
                this.mIsTempleteDestoring = false;
                this.mIsTempleteDestoryed = false;
                setInteractionConfigBeforeSceneCreate();
                this.mIsTempleteCreated = false;
                ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
                com.baidu.ar.arplay.c.b.b("ARPEngine", "loadTempleteWithResPath :" + str + " mCurrentCaseId :" + this.mCurrentCaseId);
                this.start = System.currentTimeMillis();
                nativeLoadTemplete(str, ARPFilter.getInstance().getCameraPreviewWidth(), ARPFilter.getInstance().getCameraPreviewHeight());
            }
        }
    }

    native void nativeAddAlgoType(int[] iArr, int i);

    native void nativeClearAlgoCache();

    native void nativeCreateApp(int i, int i2, int i3, int i4, float f2);

    native void nativeDestroyEngine();

    native long nativeGetCurrentScene();

    native int nativeGetFps();

    native boolean nativeIsAppControllerInterrupt();

    native void nativeLoadCase(String str, int i, int i2);

    native void nativeLoadTemplete(String str, int i, int i2);

    native void nativeOnAppear();

    native void nativeOnDisappear();

    native void nativeOnPause();

    native void nativeOnResume();

    native void nativeReleaseALgoCacheInstance();

    native void nativeRemoveAlgoType(int[] iArr);

    native void nativeSetAlgoDataHandle(long j);

    native void nativeSetAlgoHandle(long j);

    native void nativeSetConfig(String str, String str2);

    native void nativeSetEngineBlendState(int i);

    native void nativeSetFaceAlgoParam(int i);

    native void nativeSetFaceLandMark(long j, int i);

    native void nativeSetFaceLandMarkFrameAcheMode(int i);

    native void nativeSetLocalDeviceGrade(int i);

    native void nativeSetPreviewSize(int i, int i2);

    native void nativeSetWindowSize(int i, int i2);

    native void nativeSmallGameDestroy();

    native int nativeSmallGameGetFPS();

    native void nativeSmallGameOnPause();

    native void nativeSmallGameOnResume();

    native void nativeSmallGameUpdate();

    native void nativeUnloadCase();

    native void nativeUnloadTemplete();

    native void nativeUpdate();

    native void nativeUpdateAlgoDataToNode(int i, int i2, ByteBuffer byteBuffer);

    public void onCaseLoadCompleted(Map map) {
        if (this.mIsEngineCreated && this.mCaseState == c.ECreating && map != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2 + " cost: " + (System.currentTimeMillis() - this.start));
            ARPFilter.getInstance().clearAllAsyncRenderTask();
            setInteractionConfigAfterSceneCreate();
            this.mCaseState = c.ECreated;
        }
    }

    public void onCaseUnloadCompleted() {
        if (this.mIsEngineCreated && this.mCaseState == c.EDestroying) {
            this.mCaseState = c.EUninit;
        }
    }

    public void onGestureUpdate(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10) {
        if (isEngineCanAccess()) {
            onGestureUpdateNative(i, j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, i4, f10, false);
        }
    }

    native void onGestureUpdateNative(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10, boolean z);

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, int i4, float f10, boolean z) {
        if (isEngineCanAccess()) {
            onGestureUpdateNative(i, j, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, i4, f10, z);
        }
    }

    public void onInteractionFinish(float f2, float f3, float f4) {
        if (this.mInteraction != null) {
            this.mInteraction.a(f2, f3, f4);
        }
    }

    public synchronized void onTempleLoadCompleted(Map map) {
        if (map != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(map.get("case_id"), 0);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "caseId : " + a2);
            com.baidu.ar.arplay.c.b.b("ARPEngine", "onTempleLoadCompleted : " + a2 + " cost: " + (System.currentTimeMillis() - this.start));
            ARPFilter.getInstance().clearAllAsyncRenderTask();
            setInteractionConfigAfterSceneCreate();
            this.mIsTempleteCreated = true;
            this.mIsTempleteCreating = false;
        }
    }

    public void onTouchUpdate(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6) {
        if (isEngineCanAccess()) {
            onTouchUpdateNative(i, f2, f3, f4, f5, j, i2, f6);
        }
    }

    native void onTouchUpdateNative(int i, float f2, float f3, float f4, float f5, long j, int i2, float f6);

    public synchronized void pause() {
        if (this.mOrientationEventListener != null) {
            this.mOrientationEventListener.disable();
        }
        this.mIsPaused = true;
        if (isEngineCanAccess()) {
            nativeOnPause();
        }
    }

    public void removeAlgoType(int[] iArr) {
        nativeRemoveAlgoType(iArr);
    }

    public synchronized void resume() {
        this.mIsPaused = false;
        if (isEngineCanAccess()) {
            nativeOnResume();
        }
    }

    public void sceneRotateToCamera() {
        ARPScene currentScene = getCurrentScene();
        if (currentScene == null) {
            return;
        }
        ARPCamera aY = currentScene.aY();
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(aY.aT());
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        ARPNode aZ = currentScene.aZ();
        if (aZ == null) {
            Log.e("sceneRotateToCamera", "current scene root node is null!");
            return;
        }
        Vector3f vector3f = new Vector3f(0.0f, -1.0f, 0.0f);
        boolean isDriverdByARPVersion = isDriverdByARPVersion();
        if (isDriverdByARPVersion) {
            vector3f.setXYZ(0.0f, 0.0f, 1.0f);
        }
        Vector4f aX = aZ.aX();
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngleRad(new Vector3f(aX.x(), aX.y(), aX.z()), aX.getW());
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        matrixf4x43.setMatrixValues(quaternion.getMatrix4x4().getMatrix());
        Vector3f vector3f2 = new Vector3f();
        Matrix.multiplyMV3(vector3f2.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
        Vector3f vector3f3 = new Vector3f();
        Vector3f vector3f4 = new Vector3f(0.0f, 0.0f, -1.0f);
        matrixf4x42.setW0(0.0f);
        matrixf4x42.setW1(0.0f);
        matrixf4x42.setW2(0.0f);
        matrixf4x42.setW3(1.0f);
        Matrix.multiplyMV3(vector3f3.toArray(), matrixf4x42.getMatrix(), vector3f4.toArray(), 1.0f);
        Vector3f vector3f5 = new Vector3f();
        if (isDriverdByARPVersion) {
            vector3f3.setY(0.0f);
            vector3f5.setXYZ(0.0f, 1.0f, 0.0f);
        } else {
            vector3f3.setZ(0.0f);
            vector3f5.setXYZ(0.0f, 0.0f, 1.0f);
        }
        vector3f3.normalize();
        vector3f3.multiplyByScalar(-1.0f);
        Quaternion a2 = ARPNumber.a(vector3f2, vector3f3);
        a2.multiplyByQuat(quaternion);
        Vector4f vector4f = new Vector4f();
        a2.toAxisAngle(vector4f);
        vector4f.setW((float) Math.toRadians(vector4f.w()));
        aZ.a(vector4f);
    }

    public void sceneWorldPositionToOrigin() {
        ARPScene currentScene = getCurrentScene();
        if (currentScene == null) {
            return;
        }
        ARPNode aZ = currentScene.aZ();
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        if (aZ != null) {
            aZ.a(vector3f);
        }
    }

    public synchronized void setAlgoDataHandle(long j) {
        nativeSetAlgoHandle(j);
    }

    public void setConfig(String str, String str2) {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "syncServerConfig :" + str2);
        nativeSetConfig(str, str2);
    }

    @Deprecated
    public void setEnginGLJniEnv() {
    }

    public void setEngineBlendState(int i) {
        nativeSetEngineBlendState(i);
    }

    public void setFaceLandMarkFrameAcheMode(int i) {
        nativeSetFaceLandMarkFrameAcheMode(i);
    }

    public synchronized void setHtmlUpdateCallback(d dVar) {
        this.mHtmlCallback = dVar;
    }

    public void setImuType(int i) {
        this.mImuType = i;
    }

    public void setInteraction(e eVar) {
        this.mInteraction = eVar;
    }

    public void setIsFrontCamera(boolean z) {
        this.mIsFrontCamera = z;
    }

    public void setLocalDeviceGrade(int i) {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "setLocalDeviceGrade :" + i);
        nativeSetLocalDeviceGrade(i);
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetPreviewSize(i, i2);
        }
    }

    public void setTouchOrientation(f fVar) {
        this.mTouchOrientation = fVar;
    }

    public void setValue(int i, String str, String str2) {
        if (this.mDataStore != null) {
            this.mDataStore.setValue(i, str, str2);
        } else {
            Log.e("ARPEngine", "set value error!");
        }
    }

    public synchronized void setVideoUpdateCallback(g gVar) {
        this.mVideoCallback = gVar;
    }

    public void setWindowSize(int i, int i2) {
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetWindowSize(i, i2);
        }
    }

    public void smallGameDestroy() {
        nativeSmallGameDestroy();
    }

    public int smallGameGetFPS() {
        return nativeSmallGameGetFPS();
    }

    public void smallGameUpdate() {
        nativeSmallGameUpdate();
    }

    @Deprecated
    public void surfaceViewCapture(b bVar) {
        if (bVar != null) {
            bVar.a(null);
        }
    }

    public synchronized void unloadCase() {
        if (this.mIsEngineCreated && this.mCaseState != c.EDestroying && this.mCaseState != c.EUninit) {
            com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadCase");
            this.mCaseState = c.EDestroying;
            this.mPreviewWidth = 0;
            this.mPreviewHeight = 0;
            for (Map.Entry<String, a> entry : this.mAlgoRunnbaleMap.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().release();
                }
            }
            this.mAlgoRunnbaleMap.clear();
            ARPFilter.getInstance().clearAllAsyncRenderTask();
            nativeUnloadCase();
            releaseComponents();
            com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadCase finished");
        }
    }

    public synchronized void unloadTemplete() {
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadTemplete");
        this.mIsTempleteDestoring = true;
        this.mIsTempleteCreated = false;
        nativeUnloadTemplete();
        com.baidu.ar.arplay.c.b.b("ARPEngine", "unloadTemplete finished");
        this.mIsTempleteDestoryed = true;
    }

    public void updateAlgoDataToNode(int i, int i2, byte[] bArr) {
        com.baidu.ar.arplay.c.b.c(TAG, "updateAlgoDataToNode");
        if (isEngineCanAccess()) {
            this.mMaskBuffer = ByteBuffer.allocateDirect(bArr.length);
            this.mMaskBuffer.put(bArr);
            nativeUpdateAlgoDataToNode(i, i2, this.mMaskBuffer);
        }
    }

    native boolean updateFrameBuffers(int[] iArr);

    public void updateVideoFrame(String str, int i, String str2, String str3) {
        if (this.mVideoCallback == null || this.mCaseState != c.ECreated) {
            return;
        }
        this.mVideoCallback.a(str, i, str2, str3);
    }

    public boolean updateWebViewFrame(int i, int i2) {
        if (this.mHtmlCallback == null || this.mCaseState != c.ECreated) {
            return false;
        }
        return this.mHtmlCallback.c(i, i2);
    }
}
