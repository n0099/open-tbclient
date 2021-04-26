package com.baidu.smallgame.sdk;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.view.OrientationEventListener;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import d.a.e0.a.d.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
@NotProguard
/* loaded from: classes2.dex */
public class ArBridge {
    public static final boolean DEBUG = false;
    public static final int INVALID_MESSAGE_ID = -1;
    public static final String TAG = "EngineLogger";
    public d.a.e0.a.c.a mDataStore;
    public EGLContext mEglContext;
    public FirstFrameListener mFirstFrameListener;
    public long mNativeARBridge;
    public OrientationEventListener mOrientationEventListener;
    public int mScreenHeight;
    public int mScreenWidth;
    public c mStuckScreenHandler;
    public b mVideoCallback;
    public List<Runnable> mPendingRunnables = new LinkedList();
    public boolean mIsInitNative = false;
    public AtomicBoolean mDestroyed = new AtomicBoolean(true);
    public int mScreenTextureId = -1;
    public boolean mFirstFrameFinished = false;
    public long mCurrentGLThreadID = -1;
    public int mDeviceOrientation = -1;
    public TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    public boolean mHasResumeByUser = false;
    public int mImuType = 0;
    public final PerformanceJsonBean mPerformanceJsonBean = new PerformanceJsonBean();
    public d.a.u.c.b mGameRecorder = new d.a.u.c.b(V8Engine.getAppContext());

    @NotProguard
    /* loaded from: classes2.dex */
    public interface FirstFrameListener {
        void onFirstFrameFinished();
    }

    /* loaded from: classes2.dex */
    public enum TouchOrientation {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, int i2, String str2);
    }

    public ArBridge() {
        this.mNativeARBridge = 0L;
        this.mNativeARBridge = nativeInitializeAR();
        Log.e(TAG, "initialize ar bridge. nativePtr: " + this.mNativeARBridge);
        this.mStuckScreenHandler = new d.a.e0.a.b();
    }

    public static void exceptionCallback(String str) {
        Log.e(TAG, str, new Throwable());
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native long nativeInitializeAR();

    private native void nativeInterruptLoading();

    private native void nativeSetDisplayMetrics(long j, float f2, float f3, float f4, float f5, float f6);

    private native void nativeSetSize(long j, float f2, float f3);

    private native void nativeSetup(Object obj);

    private void onFirstFrameFinished() {
        Log.i(TAG, "onFirstFrameFinished");
        d.a.u.c.b bVar = this.mGameRecorder;
        if (bVar != null && this.mEglContext != null) {
            bVar.t(nativeIsFlipYNeeded(), this.mEglContext, this.mScreenWidth, this.mScreenHeight, V8Engine.getAppContext());
        }
        FirstFrameListener firstFrameListener = this.mFirstFrameListener;
        if (firstFrameListener != null) {
            firstFrameListener.onFirstFrameFinished();
            this.mFirstFrameListener = null;
            this.mFirstFrameFinished = true;
        }
    }

    public void clearARMemory() {
        d.a.e0.a.c.a aVar = this.mDataStore;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        synchronized (this) {
            if (this.mIsInitNative) {
                try {
                    nativeFinalize();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public native int getCaseId();

    public d.a.u.c.b getGameRecorder() {
        return this.mGameRecorder;
    }

    public int getImuType() {
        return this.mImuType;
    }

    public native int getMessageID();

    public JSONArray getPerformanceJson() {
        return this.mPerformanceJsonBean.toJSONArray();
    }

    public PerformanceJsonBean getPerformanceJsonBean() {
        return this.mPerformanceJsonBean;
    }

    public int getScreenTextureId() {
        return this.mScreenTextureId;
    }

    public c getStuckScreenHandler() {
        return this.mStuckScreenHandler;
    }

    public String getValue(int i2, String str) {
        d.a.e0.a.c.a aVar = this.mDataStore;
        if (aVar != null) {
            return aVar.b(i2, str);
        }
        Log.e("ArBridge", "get value error!");
        return "";
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            d.a.e0.a.c.a aVar = new d.a.e0.a.c.a();
            this.mDataStore = aVar;
            aVar.c(sharedPreferences);
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed.get();
    }

    public boolean isRenderCallbackQueueEmpty() {
        return nativeIsRenderCallbackQueueEmpty();
    }

    public native void nativeClearScreen();

    public native void nativeCreateCase(String str, int i2, HashMap<String, Object> hashMap, int i3, int i4);

    public native void nativeDensity(float f2);

    public native void nativeDestroyCase();

    public native int nativeGetFps();

    public native boolean nativeIsFlipYNeeded();

    public native boolean nativeIsRenderCallbackQueueEmpty();

    public native void nativeOnPause();

    public native void nativeOnPauseByUser();

    public native void nativeOnResume();

    public native void nativeOnResumeByUser();

    public long nativePtr() {
        return this.mNativeARBridge;
    }

    public native void nativeReset();

    public native void nativeSetCameraDefaultPos();

    public native void nativeSetEuler(float f2, float f3, float f4, String str);

    public native void nativeSetFrustum(float f2, float f3);

    public native void nativeSetSlamRelocationType(int i2);

    public native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    public native void nativeSmallGameDestroy(long j);

    public native void nativeSmallGameOnInit(long j);

    public native void nativeSmallGameOnPause();

    public native void nativeSmallGameOnPauseOnGLThread();

    public native void nativeSmallGameOnResume();

    public native boolean nativeSmallGameShouldSwapBuffer();

    public native int nativeSmallGameUpdate();

    public native void nativeUpdate();

    public native void nativeUpdateRMatrix(float[] fArr);

    public native void nativeUpdateRTMatrix(float[] fArr);

    public native void nativeUpdateRecordingStatus(boolean z);

    public native void nativeUpdateSLAMMatrix(float[] fArr);

    public void notifyFrameUpdated() {
        d.a.u.c.b bVar = this.mGameRecorder;
        if (bVar != null) {
            bVar.u(getScreenTextureId());
        }
    }

    public native void onTouchEventNative(int i2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, long j, int i5);

    public native void sendMessageToEngine(int i2, int i3, HashMap<String, Object> hashMap, int i4);

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public void setDensity(float f2) {
        nativeDensity(f2);
    }

    public void setDisplayMetrics(float f2, float f3, float f4, float f5, float f6) {
        nativeSetDisplayMetrics(this.mNativeARBridge, f2, f3, f4, f5, f6);
    }

    public void setEglContextToRecorder(EGLContext eGLContext, int i2, int i3) {
        this.mEglContext = eGLContext;
        if (i2 > 0 && i3 > 0) {
            this.mScreenWidth = i2;
            this.mScreenHeight = i3;
        }
        Log.i(TAG, "set eglContext:" + this.mEglContext);
    }

    @Deprecated
    public void setEnginGLJniEnv() {
    }

    public void setFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListener = firstFrameListener;
    }

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setGameRecordCallback(d.a.u.c.c cVar) {
        d.a.u.c.b bVar = this.mGameRecorder;
        if (bVar != null) {
            bVar.C(cVar);
        }
    }

    public void setImuType(int i2) {
        this.mImuType = i2;
    }

    public void setOnStuckScreenListener(d.a.e0.a.d.a aVar) {
        this.mStuckScreenHandler.b(aVar);
    }

    public void setScreenShotStatus(boolean z) {
    }

    public void setSize(float f2, float f3) {
        nativeSetSize(this.mNativeARBridge, f2, f3);
    }

    public void setSlamRelocationType(int i2) {
        nativeSetSlamRelocationType(i2);
    }

    public void setStuckScreenLimitTime(long j) {
        this.mStuckScreenHandler.c(j);
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    public void setValue(int i2, String str, String str2) {
        d.a.e0.a.c.a aVar = this.mDataStore;
        if (aVar != null) {
            aVar.d(i2, str, str2);
        } else {
            Log.e("ArBridge", "set value error!");
        }
    }

    public synchronized void setVideoUpdateCallback(b bVar) {
        this.mVideoCallback = bVar;
    }

    public boolean shouldSwapBuffer() {
        return nativeSmallGameShouldSwapBuffer();
    }

    public void smallGameDestroy() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameDestroy, destroyed=" + this.mDestroyed);
        if (this.mDestroyed.getAndSet(true)) {
            return;
        }
        nativeSmallGameDestroy(this.mNativeARBridge);
        this.mNativeARBridge = 0L;
        this.mGameRecorder.I();
        this.mGameRecorder.x();
    }

    public void smallGameOnInit() {
        nativeSmallGameOnInit(this.mNativeARBridge);
        this.mDestroyed.set(false);
    }

    public void smallGameOnPause() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPause.");
        nativeSmallGameOnPause();
    }

    public void smallGameOnPauseOnGLThrad() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnPauseOnGLThrad.");
        nativeSmallGameOnPauseOnGLThread();
    }

    public void smallGameOnResume() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameOnResume.");
        nativeSmallGameOnResume();
    }

    public void smallGameUpdate() {
        this.mScreenTextureId = nativeSmallGameUpdate();
    }

    @Deprecated
    public void surfaceViewCapture(a aVar) {
        if (aVar != null) {
            aVar.a(null);
        }
    }

    public void update() {
        nativeUpdate();
    }

    public boolean updateFbos(int[] iArr) {
        return updateFrameBuffers(iArr);
    }

    public native boolean updateFrameBuffers(int[] iArr);

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateVideoFrame(String str, int i2, String str2) {
        Log.i(TAG, "updateVideoFrame:" + i2 + "     ;avideoPath:" + str2);
        b bVar = this.mVideoCallback;
        if (bVar != null) {
            bVar.a(str, i2, str2);
        }
    }

    public static String getValue(Object obj, int i2, String str) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        return arBridge == null ? "" : arBridge.getValue(i2, str);
    }

    public static void setValue(Object obj, int i2, String str, String str2) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.setValue(i2, str, str2);
    }

    public static void updateVideoFrame(Object obj, String str, int i2, String str2) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.updateVideoFrame(str, i2, str2);
    }
}
