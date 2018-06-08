package com.baidu.baiduarsdk;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.baiduarsdk.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class ArBridge {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static final String TAG = "EngineLogger";
    private static ArBridge self = null;
    private com.baidu.baiduarsdk.c.a mArGLEngineCtl;
    private com.baidu.baiduarsdk.a.b mDataStore;
    private Handler mHandler;
    private List<a> mMsgHandlers;
    private OrientationEventListener mOrientationEventListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private e mVideoCallback;
    private List<Runnable> mPendingRunnables = new LinkedList();
    private boolean mIsInitNative = false;
    private boolean isScreenOrientationLandscape = false;
    private long mCurrentGLThreadID = -1;
    private int mDeviceOrientation = -1;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private int mFPS = 0;
    private boolean mHasResumeByUser = false;
    private int mImuType = 0;
    private a.b mAudioPlayerCallback = new a.b() { // from class: com.baidu.baiduarsdk.ArBridge.5
        @Override // com.baidu.baiduarsdk.a.a.b
        public void a(Exception exc) {
            com.baidu.baiduarsdk.a.a.c();
        }

        @Override // com.baidu.baiduarsdk.a.a.b
        public void a(boolean z) {
            com.baidu.baiduarsdk.a.a.c();
        }
    };
    private HandlerThread mThread = new HandlerThread("msg_callback_thread");

    /* loaded from: classes3.dex */
    public static class MessageType {
        public static final int MSG_ALL = 0;
        public static final int MSG_CASE_INIT_COMPLETED = 9;
        public static final int MSG_MODEL_APPEAR = 201;
        public static final int MSG_MODEL_DISAPPEAR = 202;
        public static final int MSG_NONE = -1;
        public static final int MSG_PLAY_MUSIC = 1001;
        public static final int MSG_PLAY_MUSIC_RES = 1002;
        public static final int MSG_START_CONFIG = 10;
        public static final int MSG_TRACK_FOUND = 101;
        public static final int MSG_TRACK_LOST = 102;
        public static final int MSG_TYPE_AUDIO = 5211;
        public static final int MSG_TYPE_IMU_CLOSE = 303;
        public static final int MSG_TYPE_IMU_CLOSE_RES = 304;
        public static final int MSG_TYPE_IMU_OPEN = 301;
        public static final int MSG_TYPE_IMU_OPEN_RES = 302;
        public static final int MSG_TYPE_LANDSCAPE_LEFT = 4001;
        public static final int MSG_TYPE_LANDSCAPE_RIGHT = 4002;
        public static final int MSG_TYPE_LUA_CALL_SDK_FUC = 3002;
        public static final int MSG_TYPE_LUA_SDK_BRIDGE = 1901;
        public static final int MSG_TYPE_MODEL_LOAD_PROGRESS = 6001;
        public static final int MSG_TYPE_MUSIC_FAILED = 1010;
        public static final int MSG_TYPE_MUSIC_FINISHED = 1009;
        public static final int MSG_TYPE_MUSIC_PLAY_INFO_UPDATE = 1011;
        public static final int MSG_TYPE_OPEN_URL = 1301;
        public static final int MSG_TYPE_PAUSE_MUSIC = 1003;
        public static final int MSG_TYPE_PAUSE_MUSIC_RES = 1004;
        public static final int MSG_TYPE_PHONE_CALL = 1401;
        public static final int MSG_TYPE_PORTRAIT = 4003;
        public static final int MSG_TYPE_RELEASE = -2;
        public static final int MSG_TYPE_RESUME_MUSIC = 1005;
        public static final int MSG_TYPE_RESUME_MUSIC_RES = 1006;
        public static final int MSG_TYPE_RES_REQUEST = 5001;
        public static final int MSG_TYPE_RES_RESPONE = 5003;
        public static final int MSG_TYPE_RES_RESPONE_PROGRESS = 5002;
        public static final int MSG_TYPE_SDK_CALL_LUA_FUC = 3001;
        public static final int MSG_TYPE_SDK_LUA_BRIDGE = 1902;
        public static final int MSG_TYPE_SDK_RUN_SCRIPT = 2001;
        public static final int MSG_TYPE_SDK_SET_MODEL_COLOR = 2002;
        public static final int MSG_TYPE_SHARE = 1601;
        public static final int MSG_TYPE_SLAM_GUESTURE_INTERACTION = 4100;
        public static final int MSG_TYPE_STATISTICS = 1801;
        public static final int MSG_TYPE_STOP_MUSIC = 1007;
        public static final int MSG_TYPE_STOP_MUSIC_RES = 1008;
        public static final int MSG_TYPE_VIBERATOR = 1501;
        public static final int MSG_TYPE_VIDEO = 5210;
        public static final int MSG_TYPE_VIDEO_PAUSE = 1023;
        public static final int MSG_TYPE_VIDEO_PAUSE_RES = 1024;
        public static final int MSG_TYPE_VIDEO_PLAY = 1021;
        public static final int MSG_TYPE_VIDEO_PLAY_FAILED = 1029;
        public static final int MSG_TYPE_VIDEO_PLAY_FINISH = 1030;
        public static final int MSG_TYPE_VIDEO_PLAY_INFO_UPDATE = 1031;
        public static final int MSG_TYPE_VIDEO_PLAY_RES = 1022;
        public static final int MSG_TYPE_VIDEO_RESUME = 1025;
        public static final int MSG_TYPE_VIDEO_RESUME_RES = 1026;
        public static final int MSG_TYPE_VIDEO_STOP = 1027;
        public static final int MSG_TYPE_VIDEO_STOP_RES = 1028;
        public static final int MSG_TYPE_WAIT_SLAM_DATA = 4101;
        public static final int MSG_USR_INTERACTION_CONFIG = 11;
    }

    /* loaded from: classes3.dex */
    public enum TouchOrientation {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public int a;
        public int b;
        public d c;

        public a(int i, int i2, d dVar) {
            this.a = i;
            this.b = i2;
            this.c = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        public int a;
        public int b;
        public HashMap<String, Object> c;
        public int d;

        public b(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.a = i;
            this.b = i2;
            this.c = hashMap;
            this.d = i3;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str, int i, String str2, String str3);
    }

    private ArBridge() {
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.baiduarsdk.ArBridge.1
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
    }

    private static void executeOnGLResLoadThread(Object obj, Runnable runnable) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.executeOnGLResLoadThread(runnable);
    }

    private void executeOnGLResLoadThread(Runnable runnable) {
        queueResLoadEvent(runnable);
    }

    private static void executeOnGLThread(Object obj, Runnable runnable) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.executeOnGLThread(runnable);
    }

    public static synchronized ArBridge getInstance() {
        ArBridge arBridge;
        synchronized (ArBridge.class) {
            if (self == null) {
                self = new ArBridge();
            }
            arBridge = self;
        }
        return arBridge;
    }

    private static String getValue(Object obj, int i, String str) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        return arBridge == null ? "" : arBridge.getValue(i, str);
    }

    public static native boolean libraryHasLoaded();

    private native void nativeFinalize();

    private native void nativeInterruptLoading();

    private native void nativeSetup(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(b bVar) {
        for (a aVar : this.mMsgHandlers) {
            if (aVar.a == 0 || bVar.a == aVar.a) {
                if (-1 == aVar.b || bVar.d == aVar.b) {
                    aVar.c.a(bVar.a, bVar.b, bVar.c);
                }
            }
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.mHandler.obtainMessage(1, new b(i, i2, hashMap, i3)).sendToTarget();
    }

    private static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.receiveMsgFromEngine(i, i2, hashMap, i3);
    }

    private void sendMessageImpl(final int i, final int i2, final HashMap<String, Object> hashMap, final int i3) {
        if (this.mArGLEngineCtl != null) {
            this.mArGLEngineCtl.a(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.12
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("bdar", "sendMessageImpl aMessageType = " + i);
                    if (-1 == i2) {
                        ArBridge.this.sendMessageToEngine(i, ArBridge.this.getMessageID(), hashMap, i3);
                    } else {
                        ArBridge.this.sendMessageToEngine(i, i2, hashMap, i3);
                    }
                }
            });
        }
    }

    private void sendMessageImpl(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, -1, hashMap, i2);
    }

    private static void setValue(Object obj, int i, String str, String str2) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.setValue(i, str, str2);
    }

    private static void updateVideoFrame(Object obj, String str, int i, String str2, String str3) {
        ArBridge arBridge = (ArBridge) ((WeakReference) obj).get();
        if (arBridge == null) {
            return;
        }
        arBridge.updateVideoFrame(str, i, str2, str3);
    }

    public void clearARMemory() {
        if (this.mDataStore != null) {
            this.mDataStore.a();
        }
    }

    public void clearResLoadEventAndWait() {
        if (this.mArGLEngineCtl != null) {
            this.mArGLEngineCtl.g();
        }
    }

    public void clearScreen() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.8
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeClearScreen();
            }
        });
    }

    public int createCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        final int caseId = getCaseId();
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.17
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeCreateCase(str, caseId, hashMap, i, i2);
            }
        });
        return caseId;
    }

    public void destroyCase() {
        if (this.mArGLEngineCtl == null) {
            return;
        }
        receiveMsgFromEngine(0, -2, null, 0);
        nativeInterruptLoading();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Runnable runnable = new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ArBridge.this.clearResLoadEventAndWait();
                    ArBridge.this.nativeDestroyCase();
                    ArBridge.this.mArGLEngineCtl.j();
                    Log.d("bdar", "bdar:destroyCase nativeDestroyCase");
                    atomicBoolean.set(true);
                    notify();
                }
            }
        };
        executeOnGLThread(runnable);
        try {
            synchronized (runnable) {
                while (!atomicBoolean.get()) {
                    runnable.wait();
                }
                Log.d(TAG, "bdar:destroyCase destroyCaseTask done!");
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        setImuType(0);
        this.mVideoCallback = null;
        releaseMediaPlayer();
        this.mAudioPlayerCallback = null;
        releaseVideoPlayer();
    }

    public void executeOnGLThread(Runnable runnable) {
        if (this.mArGLEngineCtl != null) {
            if (this.mArGLEngineCtl.d() == Thread.currentThread().getId()) {
                runnable.run();
            } else {
                this.mArGLEngineCtl.a(runnable);
            }
        }
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

    public com.baidu.baiduarsdk.c.a getArGLEngineCtl() {
        return this.mArGLEngineCtl;
    }

    native int getCaseId();

    public int getFps() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.10
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mFPS = ArBridge.this.nativeGetFps();
            }
        });
        return this.mFPS;
    }

    public int getImuType() {
        return this.mImuType;
    }

    native int getMessageID();

    public String getValue(int i, String str) {
        if (this.mDataStore != null) {
            return this.mDataStore.a(i, str);
        }
        Log.e("ArBridge", "get value error!");
        return "";
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            this.mDataStore = new com.baidu.baiduarsdk.a.b();
            this.mDataStore.a(sharedPreferences);
        }
    }

    public void interruptEngine() {
        if (this.mArGLEngineCtl == null) {
            return;
        }
        nativeInterruptLoading();
    }

    native void nativeClearScreen();

    native void nativeCreateCase(String str, int i, HashMap<String, Object> hashMap, int i2, int i3);

    native void nativeDensity(float f);

    native void nativeDestroyCase();

    native int nativeGetFps();

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

    native void nativeUpdate();

    native void nativeUpdateRMatrix(float[] fArr);

    native void nativeUpdateRTMatrix(float[] fArr);

    native void nativeUpdateSLAMMatrix(float[] fArr);

    public void onPause() {
        if (this.mOrientationEventListener != null) {
            this.mOrientationEventListener.disable();
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.11
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPause();
            }
        });
    }

    public void onPauseByUser() {
        this.mHasResumeByUser = false;
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.7
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPauseByUser();
            }
        });
    }

    public void onResume() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.13
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnResume();
            }
        });
        if (this.mHasResumeByUser) {
            onResumeByUser();
            this.mHasResumeByUser = false;
        }
    }

    public void onResumeByUser() {
        if (this.mArGLEngineCtl == null) {
            this.mHasResumeByUser = true;
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.6
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mHasResumeByUser = false;
                ArBridge.this.nativeOnResumeByUser();
            }
        });
    }

    public void onTouchEvent(final int i, final int i2, float f, float f2, final float f3, final float f4, final int i3, float f5, float f6, final float f7, final float f8, final long j) {
        final float f9;
        final float f10;
        final float f11;
        final float f12;
        if (this.isScreenOrientationLandscape) {
            f12 = this.mScreenHeight - f2;
            f10 = this.mScreenHeight - f6;
            f9 = f5;
            f11 = f;
        } else {
            f9 = f6;
            f10 = f5;
            f11 = f2;
            f12 = f;
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.14
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.onTouchEventNative(i, i2, f12, f11, f3, f4, i3, f10, f9, f7, f8, j, ArBridge.this.mTouchOrientation.ordinal());
            }
        });
    }

    native void onTouchEventNative(int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j, int i4);

    public void queueResLoadEvent(Runnable runnable) {
        if (this.mArGLEngineCtl != null) {
            this.mArGLEngineCtl.b(runnable);
        }
    }

    public synchronized void registerMessageHandler(final int i, final d dVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.15
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mMsgHandlers.add(new a(i, -1, dVar));
            }
        });
    }

    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.4
            @Override // java.lang.Runnable
            public void run() {
                if (ArBridge.this.mMsgHandlers != null) {
                    ArBridge.this.mMsgHandlers.clear();
                }
            }
        });
    }

    protected void releaseMediaPlayer() {
        com.baidu.baiduarsdk.a.a.a().a(this.mAudioPlayerCallback);
    }

    protected void releaseVideoPlayer() {
        com.baidu.baiduarsdk.a.e.a().c();
    }

    public synchronized void removeMessageHandeler(final d dVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.16
            @Override // java.lang.Runnable
            public void run() {
                if (ArBridge.this.mMsgHandlers == null) {
                    return;
                }
                Iterator it = ArBridge.this.mMsgHandlers.iterator();
                while (it.hasNext()) {
                    if (((a) it.next()).c == dVar) {
                        it.remove();
                    }
                }
            }
        });
    }

    public void reset() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.9
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeReset();
            }
        });
    }

    public void sendLuaScriptToEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("script", str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setArEngineCtl(com.baidu.baiduarsdk.c.a aVar) {
        this.mArGLEngineCtl = aVar;
        synchronized (this) {
            if (this.mArGLEngineCtl != null && !this.mIsInitNative) {
                nativeSetup(new WeakReference(this));
                this.mIsInitNative = true;
            }
        }
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public void setDensity(float f) {
        nativeDensity(f);
    }

    @Deprecated
    public void setEnginGLJniEnv() {
    }

    public void setEuler(final float f, final float f2, final float f3, final String str) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.20
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetEuler(f, f2, f3, str);
            }
        });
    }

    public void setFrustum(final float f, final float f2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.21
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetFrustum(f, f2);
            }
        });
    }

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setImuType(int i) {
        this.mImuType = i;
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("model_color", Integer.valueOf(i));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setScreenOrientationLandscape(boolean z) {
        this.isScreenOrientationLandscape = z;
    }

    public void setScreenWidthHight(int i, int i2) {
        this.mScreenHeight = i2;
        this.mScreenWidth = i;
    }

    public void setSize(final int i, final int i2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.19
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetSize(i, i2);
            }
        });
    }

    public void setSlamRelocationType(int i) {
        nativeSetSlamRelocationType(i);
    }

    public void setTargetInfo(final HashMap<String, Object> hashMap) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.18
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetTargetInfo(hashMap);
            }
        });
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    public void setValue(int i, String str, String str2) {
        if (this.mDataStore != null) {
            this.mDataStore.a(i, str, str2);
        } else {
            Log.e("ArBridge", "set value error!");
        }
    }

    public synchronized void setVideoUpdateCallback(e eVar) {
        this.mVideoCallback = eVar;
    }

    @Deprecated
    public void surfaceViewCapture(c cVar) {
        if (cVar != null) {
            cVar.a(null);
        }
    }

    public void switchCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        nativeInterruptLoading();
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.2
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.clearResLoadEventAndWait();
                ArBridge.this.nativeDestroyCase();
                ArBridge.this.nativeCreateCase(str, ArBridge.this.getCaseId(), hashMap, i, i2);
            }
        });
    }

    public void update() {
        nativeUpdate();
    }

    public boolean updateFbos(int[] iArr) {
        return updateFrameBuffers(iArr);
    }

    native boolean updateFrameBuffers(int[] iArr);

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateVideoFrame(String str, int i, String str2, String str3) {
        if (this.mVideoCallback != null) {
            this.mVideoCallback.a(str, i, str2, str3);
        }
    }
}
