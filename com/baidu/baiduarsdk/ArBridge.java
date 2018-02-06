package com.baidu.baiduarsdk;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import com.baidu.baiduarsdk.RendererUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class ArBridge {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static ArBridge self = null;
    private AREngine mAREngine;
    private Handler mHandler;
    private List<ArCallback> mMsgHandlers;
    private OrientationEventListener mOrientationEventListener;
    private VideoUpdateCallback mVideoCallback;
    private long mCurrentGLThreadID = -1;
    private int mDeviceOrientation = -1;
    private TouchOrientation mTouchOrientation = TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
    private int mFPS = 0;
    private boolean mHasResumeByUser = false;
    private int mImuType = 0;
    private HandlerThread mThread = new HandlerThread("msg_callback_thread");

    /* loaded from: classes3.dex */
    public interface ARRecorder {
        void onContextChanged(EGLContext eGLContext, int i, int i2);

        void onFrameAvailable(int i);
    }

    /* loaded from: classes3.dex */
    private static class ARRenderer implements GLSurfaceView.Renderer {
        private ARRecorder mArRecorder;
        private int mFboId;
        private int mHeight;
        private RendererUtils.RenderContext mRenderContext;
        private int mTextureId;
        private int mWidth;

        private ARRenderer() {
            this.mFboId = -1;
            this.mTextureId = -1;
            this.mWidth = 0;
            this.mHeight = 0;
        }

        public void onContextDestroy() {
            if (this.mArRecorder != null) {
                this.mArRecorder.onContextChanged(null, 0, 0);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            System.currentTimeMillis();
            ArBridge.getInstance().update();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            this.mTextureId = -1;
            this.mFboId = -1;
            this.mRenderContext = null;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Log.d("ContentValues", "onSurfaceCreated");
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
            GLES20.glClear(16640);
        }

        public void setRecorder(ARRecorder aRRecorder) {
            this.mArRecorder = aRRecorder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ArCallback {
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ArMessage {
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* loaded from: classes3.dex */
    public interface CaptureCallback {
        void onSucceed(Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public static class LuaSdkBridgeMessageType {
        public static final int MSG_TYPE_SDK_LUA_GAME_CONFIG = 1001;
    }

    /* loaded from: classes3.dex */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    /* loaded from: classes3.dex */
    public static class MessageParamKeys {
        public static final String MAP_NPC_KEY_NAME = "script";
        public static final String MODEL_COLOR_KEY = "model_color";
        public static final String MODEL_TYPE_KEY = "model_type";
    }

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
        public static final int MSG_TYPE_IMU_CLOSE = 303;
        public static final int MSG_TYPE_IMU_CLOSE_RES = 304;
        public static final int MSG_TYPE_IMU_OPEN = 301;
        public static final int MSG_TYPE_IMU_OPEN_RES = 302;
        public static final int MSG_TYPE_LANDSCAPE_LEFT = 4001;
        public static final int MSG_TYPE_LANDSCAPE_RIGHT = 4002;
        public static final int MSG_TYPE_LUA_SDK_BRIDGE = 1901;
        public static final int MSG_TYPE_MUSIC_FAILED = 1010;
        public static final int MSG_TYPE_MUSIC_FINISHED = 1009;
        public static final int MSG_TYPE_OPEN_URL = 1301;
        public static final int MSG_TYPE_PAUSE_MUSIC = 1003;
        public static final int MSG_TYPE_PAUSE_MUSIC_RES = 1004;
        public static final int MSG_TYPE_PHONE_CALL = 1401;
        public static final int MSG_TYPE_PORTRAIT = 4003;
        public static final int MSG_TYPE_RESUME_MUSIC = 1005;
        public static final int MSG_TYPE_RESUME_MUSIC_RES = 1006;
        public static final int MSG_TYPE_SDK_LUA_BRIDGE = 1902;
        public static final int MSG_TYPE_SDK_RUN_SCRIPT = 2001;
        public static final int MSG_TYPE_SDK_SET_MODEL_COLOR = 2002;
        public static final int MSG_TYPE_SHARE = 1601;
        public static final int MSG_TYPE_STATISTICS = 1801;
        public static final int MSG_TYPE_STOP_MUSIC = 1007;
        public static final int MSG_TYPE_STOP_MUSIC_RES = 1008;
        public static final int MSG_TYPE_VIBERATOR = 1501;
        public static final int MSG_TYPE_VIDEO_PAUSE = 1023;
        public static final int MSG_TYPE_VIDEO_PAUSE_RES = 1024;
        public static final int MSG_TYPE_VIDEO_PLAY = 1021;
        public static final int MSG_TYPE_VIDEO_PLAY_FAILED = 1029;
        public static final int MSG_TYPE_VIDEO_PLAY_FINISH = 1030;
        public static final int MSG_TYPE_VIDEO_PLAY_RES = 1022;
        public static final int MSG_TYPE_VIDEO_RESUME = 1025;
        public static final int MSG_TYPE_VIDEO_RESUME_RES = 1026;
        public static final int MSG_TYPE_VIDEO_STOP = 1027;
        public static final int MSG_TYPE_VIDEO_STOP_RES = 1028;
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

    /* loaded from: classes3.dex */
    public interface VideoUpdateCallback {
        void onUpdateVideoFrame(String str, int i, String str2);
    }

    private ArBridge() {
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.baiduarsdk.ArBridge.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        ArBridge.this.processIncomingMessage((ArMessage) message.obj);
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.mMsgHandlers = new LinkedList();
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

    public static native boolean libraryHasLoaded();

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        for (ArCallback arCallback : this.mMsgHandlers) {
            if (arCallback.mMessageType == 0 || arMessage.mMessageType == arCallback.mMessageType) {
                if (-1 == arCallback.mMessageId || arMessage.mResMessageID == arCallback.mMessageId) {
                    arCallback.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
                }
            }
        }
    }

    private void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
    }

    private void sendMessageImpl(final int i, final int i2, final HashMap<String, Object> hashMap, final int i3) {
        if (this.mAREngine != null) {
            this.mAREngine.queueEvent(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.2
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

    public void clearScreen() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.14
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeClearScreen();
            }
        });
    }

    public int createCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        final int caseId = getCaseId();
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.5
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeCreateCase(str, caseId, hashMap, i, i2);
            }
        });
        return caseId;
    }

    public void destroyCase() {
        if (this.mAREngine == null) {
            return;
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.11
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeDestroyCase();
                Log.e("bdar", "nativeDestroyCase");
            }
        });
        this.mAREngine.requestRenderAndWait();
    }

    public void executeOnGLThread(Runnable runnable) {
        if (this.mAREngine != null) {
            if (this.mAREngine.getCurrentGLThreadID() == Thread.currentThread().getId()) {
                runnable.run();
            } else {
                this.mAREngine.queueEvent(runnable);
            }
        }
    }

    native int getCaseId();

    public int getFps() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.16
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

    public int getRenderMode() {
        if (this.mAREngine != null) {
            return this.mAREngine.getRenderMode();
        }
        return -1;
    }

    public void initAREngine() {
        if (this.mAREngine == null) {
            this.mAREngine = new AREngine();
            this.mAREngine.setRenderer(new ARRenderer());
            this.mAREngine.onResume();
            onResume();
        }
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

    native void nativeSetTargetInfo(HashMap<String, Object> hashMap);

    native void nativeUpdate();

    native void nativeUpdateRMatrix(float[] fArr);

    native void nativeUpdateRTMatrix(float[] fArr);

    native void nativeUpdateSLAMMatrix(float[] fArr);

    public void onPause() {
        if (this.mOrientationEventListener != null) {
            this.mOrientationEventListener.disable();
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.17
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPause();
            }
        });
    }

    public void onPauseByUser() {
        this.mHasResumeByUser = false;
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.13
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeOnPauseByUser();
            }
        });
    }

    public void onResume() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.18
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
        if (this.mAREngine == null) {
            this.mHasResumeByUser = true;
        }
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.12
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mHasResumeByUser = false;
                ArBridge.this.nativeOnResumeByUser();
            }
        });
    }

    public void onTouchEvent(final int i, final int i2, final float f, final float f2, final float f3, final float f4, final int i3, final float f5, final float f6, final float f7, final float f8, final long j) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.19
            @Override // java.lang.Runnable
            public void run() {
                Log.d("orientation", "onTouchEvent the orientation is " + ArBridge.this.mTouchOrientation.name());
                ArBridge.this.onTouchEventNative(i, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, j, ArBridge.this.mTouchOrientation.ordinal());
            }
        });
    }

    native void onTouchEventNative(int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j, int i4);

    public synchronized void registerMessageHandler(final int i, final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.3
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.mMsgHandlers.add(new ArCallback(i, -1, messageHandler));
            }
        });
    }

    public void releaseAREngine() {
        if (this.mAREngine != null) {
            this.mAREngine.setSurface(null, 0, 0);
            this.mAREngine.exitGLThread();
            this.mAREngine = null;
        }
    }

    public synchronized void removeMessageHandeler(final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ArBridge.this.mMsgHandlers.iterator();
                while (it.hasNext()) {
                    if (((ArCallback) it.next()).mHandler == messageHandler) {
                        it.remove();
                    }
                }
            }
        });
    }

    public void requestRenderAndWait() {
        if (this.mAREngine != null) {
            this.mAREngine.requestRenderAndWait();
        }
    }

    public void requestRenderer() {
        if (this.mAREngine != null) {
            this.mAREngine.requestRender();
        }
    }

    public void reset() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.15
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
        hashMap.put(MessageParamKeys.MAP_NPC_KEY_NAME, str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, hashMap, -1);
    }

    native void sendMessageToEngine(int i, int i2, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, hashMap, i2);
    }

    public void setCameraDefaultPos() {
        nativeSetCameraDefaultPos();
    }

    public void setDensity(float f) {
        nativeDensity(f);
    }

    public void setEnginGLJniEnv() {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.20
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.setGLJniEnv();
            }
        });
    }

    public void setEuler(final float f, final float f2, final float f3, final String str) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.8
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetEuler(f, f2, f3, str);
            }
        });
    }

    public void setFrustum(final float f, final float f2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.9
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetFrustum(f, f2);
            }
        });
    }

    public native void setGLJniEnv();

    public void setGLThreadID(long j) {
        this.mCurrentGLThreadID = j;
    }

    public void setImuType(int i) {
        this.mImuType = i;
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(MessageParamKeys.MODEL_COLOR_KEY, Integer.valueOf(i));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setRenderMode(int i) {
        if (this.mAREngine != null) {
            this.mAREngine.setRenderMode(i);
        }
    }

    public void setSize(final int i, final int i2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.7
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetSize(i, i2);
            }
        });
    }

    public void setSurface(Object obj, int i, int i2) {
        if (this.mAREngine != null) {
            this.mAREngine.setSurface(obj, i, i2);
        }
    }

    public void setTargetInfo(final HashMap<String, Object> hashMap) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.6
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeSetTargetInfo(hashMap);
            }
        });
    }

    public void setTouchOrientation(TouchOrientation touchOrientation) {
        this.mTouchOrientation = touchOrientation;
    }

    public synchronized void setVideoUpdateCallback(VideoUpdateCallback videoUpdateCallback) {
        this.mVideoCallback = videoUpdateCallback;
    }

    @Deprecated
    public void surfaceViewCapture(CaptureCallback captureCallback) {
        if (captureCallback != null) {
            captureCallback.onSucceed(null);
        }
    }

    public void switchCase(final String str, final HashMap<String, Object> hashMap, final int i, final int i2) {
        executeOnGLThread(new Runnable() { // from class: com.baidu.baiduarsdk.ArBridge.10
            @Override // java.lang.Runnable
            public void run() {
                ArBridge.this.nativeDestroyCase();
                ArBridge.this.setGLJniEnv();
                ArBridge.this.nativeCreateCase(str, ArBridge.this.getCaseId(), hashMap, i, i2);
            }
        });
    }

    void update() {
        nativeUpdate();
    }

    public void updateRMatrix(float[] fArr) {
        nativeUpdateRMatrix(fArr);
    }

    public void updateRTMatrix(float[] fArr) {
        nativeUpdateRTMatrix(fArr);
    }

    public void updateSLAMMatrix(float[] fArr) {
        nativeUpdateSLAMMatrix(fArr);
    }

    public void updateVideoFrame(String str, int i, String str2) {
        if (this.mVideoCallback != null) {
            this.mVideoCallback.onUpdateVideoFrame(str, i, str2);
        }
    }
}
