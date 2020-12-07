package com.baidu.smallgame.sdk;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.view.OrientationEventListener;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.smallgame.sdk.b.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes14.dex */
public class ArBridge {
    private static final boolean DEBUG = false;
    private static final int INVALID_MESSAGE_ID = -1;
    static final String TAG = "EngineLogger";
    private com.baidu.smallgame.sdk.a.a mDataStore;
    private EGLContext mEglContext;
    private FirstFrameListener mFirstFrameListener;
    private long mNativeARBridge;
    private OrientationEventListener mOrientationEventListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private c mStuckScreenHandler;
    private b mVideoCallback;
    private List<Runnable> mPendingRunnables = new LinkedList();
    private boolean mIsInitNative = false;
    private AtomicBoolean mDestroyed = new AtomicBoolean(true);
    private int mScreenTextureId = -1;
    public boolean mFirstFrameFinished = false;
    private long mCurrentGLThreadID = -1;
    private int mDeviceOrientation = -1;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private boolean mHasResumeByUser = false;
    private int mImuType = 0;
    private final PerformanceJsonBean mPerformanceJsonBean = new PerformanceJsonBean();
    private com.baidu.mario.a.b mGameRecorder = new com.baidu.mario.a.b(V8Engine.getAppContext());

    @NotProguard
    /* loaded from: classes14.dex */
    public interface FirstFrameListener {
        void onFirstFrameFinished();
    }

    /* loaded from: classes14.dex */
    public enum TouchOrientation {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes14.dex */
    public interface a {
        void h(Bitmap bitmap);
    }

    /* loaded from: classes14.dex */
    public interface b {
        void h(String str, int i, String str2);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native long nativeInitializeAR();

    private native void nativeInterruptLoading();

    private native void nativeSetDisplayMetrics(long j, float f, float f2, float f3, float f4, float f5);

    private native void nativeSetSize(long j, float f, float f2);

    private native void nativeSetup(Object obj);

    native int getCaseId();

    native int getMessageID();

    native void nativeClearScreen();

    native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    native void nativeDensity(float f);

    native void nativeDestroyCase();

    native int nativeGetFps();

    native boolean nativeIsFlipYNeeded();

    native boolean nativeIsRenderCallbackQueueEmpty();

    native void nativeOnPause();

    native void nativeOnPauseByUser();

    native void nativeOnResume();

    native void nativeOnResumeByUser();

    native void nativeReset();

    native void nativeSetCameraDefaultPos();

    native void nativeSetEuler(float f, float f2, float f3, String str);

    native void nativeSetFrustum(float f, float f2);

    native void nativeSetSlamRelocationType(int i);

    native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    native void nativeSmallGameDestroy(long j);

    native void nativeSmallGameOnInit(long j);

    native void nativeSmallGameOnPause();

    native void nativeSmallGameOnPauseOnGLThread();

    native void nativeSmallGameOnResume();

    native boolean nativeSmallGameShouldSwapBuffer();

    native int nativeSmallGameUpdate();

    native void nativeUpdate();

    native void nativeUpdateRMatrix(float[] fArr);

    native void nativeUpdateRTMatrix(float[] fArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeUpdateRecordingStatus(boolean z);

    native void nativeUpdateSLAMMatrix(float[] fArr);

    native void onTouchEventNative(int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j, int i4);

    native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    native boolean updateFrameBuffers(int[] iArr);

    public long nativePtr() {
        return this.mNativeARBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStuckScreenListener(com.baidu.smallgame.sdk.b.a aVar) {
        this.mStuckScreenHandler.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStuckScreenLimitTime(long j) {
        this.mStuckScreenHandler.setStuckScreenLimitTime(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c getStuckScreenHandler() {
        return this.mStuckScreenHandler;
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.mPerformanceJsonBean;
    }

    public JSONArray getPerformanceJson() {
        return this.mPerformanceJsonBean.toJSONArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArBridge() {
        this.mNativeARBridge = 0L;
        this.mNativeARBridge = nativeInitializeAR();
        Log.e(TAG, "initialize ar bridge. nativePtr: " + this.mNativeARBridge);
        this.mStuckScreenHandler = new com.baidu.smallgame.sdk.b();
    }

    public int getScreenTextureId() {
        return this.mScreenTextureId;
    }

    protected void finalize() throws Throwable {
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

    public void setFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListener = firstFrameListener;
    }

    public void notifyFrameUpdated() {
        if (this.mGameRecorder != null) {
            this.mGameRecorder.gX(getScreenTextureId());
        }
    }

    private static void exceptionCallback(String str) {
        Log.e(TAG, str, new Throwable());
    }

    public void setEglContextToRecorder(EGLContext eGLContext, int i, int i2) {
        this.mEglContext = eGLContext;
        if (i > 0 && i2 > 0) {
            this.mScreenWidth = i;
            this.mScreenHeight = i2;
        }
        Log.i(TAG, "set eglContext:" + this.mEglContext);
    }

    private void onFirstFrameFinished() {
        Log.i(TAG, "onFirstFrameFinished");
        if (this.mGameRecorder != null && this.mEglContext != null) {
            this.mGameRecorder.a(nativeIsFlipYNeeded(), this.mEglContext, this.mScreenWidth, this.mScreenHeight, V8Engine.getAppContext());
        }
        if (this.mFirstFrameListener != null) {
            this.mFirstFrameListener.onFirstFrameFinished();
            this.mFirstFrameListener = null;
            this.mFirstFrameFinished = true;
        }
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    @Deprecated
    public void surfaceViewCapture(a aVar) {
        if (aVar != null) {
            aVar.h(null);
        }
    }

    public synchronized void setVideoUpdateCallback(b bVar) {
        this.mVideoCallback = bVar;
    }

    public void updateVideoFrame(String str, int i, String str2) {
        Log.i(TAG, "updateVideoFrame:" + i + "     ;avideoPath:" + str2);
        if (this.mVideoCallback != null) {
            this.mVideoCallback.h(str, i, str2);
        }
    }

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setDensity(float f) {
        nativeDensity(f);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void setSlamRelocationType(int i) {
        nativeSetSlamRelocationType(i);
    }

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public int getImuType() {
        return this.mImuType;
    }

    public void setImuType(int i) {
        this.mImuType = i;
    }

    public void update() {
        nativeUpdate();
    }

    public boolean updateFbos(int[] iArr) {
        return updateFrameBuffers(iArr);
    }

    @Deprecated
    public void setEnginGLJniEnv() {
    }

    private static void updateVideoFrame(Object obj, String str, int i, String str2) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge != null) {
            arBridge.updateVideoFrame(str, i, str2);
        }
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            this.mDataStore = new com.baidu.smallgame.sdk.a.a();
            this.mDataStore.b(sharedPreferences);
        }
    }

    public void clearARMemory() {
        if (this.mDataStore != null) {
            this.mDataStore.clearARMemory();
        }
    }

    public void setValue(int i, String str, String str2) {
        if (this.mDataStore != null) {
            this.mDataStore.setValue(i, str, str2);
        } else {
            Log.e("ArBridge", "set value error!");
        }
    }

    public String getValue(int i, String str) {
        if (this.mDataStore != null) {
            return this.mDataStore.getValue(i, str);
        }
        Log.e("ArBridge", "get value error!");
        return "";
    }

    private static void setValue(Object obj, int i, String str, String str2) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge != null) {
            arBridge.setValue(i, str, str2);
        }
    }

    private static String getValue(Object obj, int i, String str) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        return arBridge == null ? "" : arBridge.getValue(i, str);
    }

    public void smallGameOnPause() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPause.");
        nativeSmallGameOnPause();
    }

    public void smallGameOnPauseOnGLThrad() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPauseOnGLThrad.");
        nativeSmallGameOnPauseOnGLThread();
    }

    public com.baidu.mario.a.b getGameRecorder() {
        return this.mGameRecorder;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        if (this.mGameRecorder != null) {
            this.mGameRecorder.setGameRecordCallback(cVar);
        }
    }

    public void smallGameOnResume() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnResume.");
        nativeSmallGameOnResume();
    }

    public void smallGameUpdate() {
        this.mScreenTextureId = nativeSmallGameUpdate();
    }

    public boolean shouldSwapBuffer() {
        return nativeSmallGameShouldSwapBuffer();
    }

    public boolean isRenderCallbackQueueEmpty() {
        return nativeIsRenderCallbackQueueEmpty();
    }

    public void setScreenShotStatus(boolean z) {
    }

    public void smallGameDestroy() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameDestroy, destroyed=" + this.mDestroyed);
        if (!this.mDestroyed.getAndSet(true)) {
            nativeSmallGameDestroy(this.mNativeARBridge);
            this.mNativeARBridge = 0L;
            this.mGameRecorder.stopRecord();
            this.mGameRecorder.release();
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void smallGameOnInit() {
        nativeSmallGameOnInit(this.mNativeARBridge);
        this.mDestroyed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSize(float f, float f2) {
        nativeSetSize(this.mNativeARBridge, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisplayMetrics(float f, float f2, float f3, float f4, float f5) {
        nativeSetDisplayMetrics(this.mNativeARBridge, f, f2, f3, f4, f5);
    }
}
