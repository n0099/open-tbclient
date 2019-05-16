package com.baidu.smallgame.sdk;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.OrientationEventListener;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8SoLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@NotProguard
/* loaded from: classes2.dex */
public class ArBridge {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    static final String TAG = "EngineLogger";
    private com.baidu.smallgame.sdk.a.a mDataStore;
    private EGLContext mEglContext;
    private FirstFrameListener mFirstFrameListener;
    private com.baidu.mario.b.a mGameRecorder;
    private Handler mHandler;
    private List<a> mMsgHandlers;
    private OrientationEventListener mOrientationEventListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private e mVideoCallback;
    private List<Runnable> mPendingRunnables = new LinkedList();
    private boolean mIsInitNative = false;
    private boolean mDestroyed = false;
    private int mScreenTextureId = -1;
    private long mCurrentGLThreadID = -1;
    private int mDeviceOrientation = -1;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private int mFPS = 0;
    private boolean mHasResumeByUser = false;
    private int mImuType = 0;
    private HandlerThread mThread = new HandlerThread("msg_callback_thread");

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
    public interface c {
        void e(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void b(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void b(String str, int i, String str2);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native void nativeInterruptLoading();

    private native void nativeSetup(Object obj);

    native int getCaseId();

    native int getMessageID();

    native void nativeClearScreen();

    native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    native void nativeDensity(float f);

    native void nativeDestroyCase();

    native int nativeGetFps();

    native boolean nativeIsFlipYNeeded();

    native void nativeOnPause();

    native void nativeOnPauseByUser();

    native void nativeOnResume();

    native void nativeOnResumeByUser();

    native void nativeReset();

    native void nativeSetCameraDefaultPos();

    native void nativeSetEuler(float f, float f2, float f3, String str);

    native void nativeSetFrustum(float f, float f2);

    native void nativeSetSize(int i, int i2);

    native void nativeSetSlamRelocationType(int i);

    native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    native void nativeSmallGameDestroy();

    native int nativeSmallGameGetFPS();

    native void nativeSmallGameOnPause();

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

    static {
        V8SoLoader.load();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArBridge() {
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.smallgame.sdk.ArBridge.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        ArBridge.this.processIncomingMessage((b) message.obj);
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.mMsgHandlers = new LinkedList();
        this.mGameRecorder = new com.baidu.mario.b.a(V8Engine.getAppContext());
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
            this.mGameRecorder.bB(getScreenTextureId());
        }
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
        }
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    @Deprecated
    public void surfaceViewCapture(c cVar) {
        if (cVar != null) {
            cVar.e(null);
        }
    }

    public synchronized void registerMessageHandler(final int i, final d dVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.smallgame.sdk.ArBridge.2
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mMsgHandlers.add(new a(i, -1, dVar));
            }
        });
    }

    public synchronized void removeMessageHandeler(final d dVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.smallgame.sdk.ArBridge.3
            @Override // java.lang.Runnable
            public void run() {
                if (ArBridge.this.mMsgHandlers != null) {
                    Iterator it = ArBridge.this.mMsgHandlers.iterator();
                    while (it.hasNext()) {
                        if (((a) it.next()).ajn == dVar) {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public synchronized void setVideoUpdateCallback(e eVar) {
        this.mVideoCallback = eVar;
    }

    public void updateVideoFrame(String str, int i, String str2) {
        Log.i(TAG, "updateVideoFrame:" + i + "     ;avideoPath:" + str2);
        if (this.mVideoCallback != null) {
            this.mVideoCallback.b(str, i, str2);
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.mHandler.obtainMessage(1, new b(i, i2, hashMap, i3)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(b bVar) {
        for (a aVar : this.mMsgHandlers) {
            if (aVar.mMessageType == 0 || bVar.mMessageType == aVar.mMessageType) {
                if (-1 == aVar.ajm || bVar.ajq == aVar.ajm) {
                    aVar.ajn.b(bVar.mMessageType, bVar.ajo, bVar.ajp);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        public int ajo;
        public HashMap<String, Object> ajp;
        public int ajq;
        public int mMessageType;

        public b(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.ajo = i2;
            this.ajp = hashMap;
            this.ajq = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public int ajm;
        public d ajn;
        public int mMessageType;

        public a(int i, int i2, d dVar) {
            this.mMessageType = i;
            this.ajm = i2;
            this.ajn = dVar;
        }
    }

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setDensity(float f) {
        nativeDensity(f);
    }

    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.smallgame.sdk.ArBridge.4
            @Override // java.lang.Runnable
            public void run() {
                if (ArBridge.this.mMsgHandlers != null) {
                    ArBridge.this.mMsgHandlers.clear();
                }
            }
        });
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

    private static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge != null) {
            arBridge.receiveMsgFromEngine(i, i2, hashMap, i3);
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

    public com.baidu.mario.b.a getGameRecorder() {
        return this.mGameRecorder;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        if (this.mGameRecorder != null) {
            this.mGameRecorder.setGameRecordCallback(bVar);
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

    public int smallGameGetFPS() {
        return nativeSmallGameGetFPS();
    }

    public void smallGameDestroy() {
        Log.w(TAG, "[V8Dispose][ArBridge] MiniGameDestroy, destroyed=" + this.mDestroyed);
        if (!this.mDestroyed) {
            nativeSmallGameDestroy();
        }
        this.mGameRecorder.stopRecord();
        this.mGameRecorder.release();
        this.mDestroyed = true;
    }
}
