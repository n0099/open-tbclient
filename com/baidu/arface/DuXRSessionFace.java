package com.baidu.arface;

import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Keep;
import android.util.Log;
import com.baidu.ar.dumix.face.FaceListener;
import com.baidu.ar.dumix.face.FaceSession;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.List;
@Keep
/* loaded from: classes11.dex */
public class DuXRSessionFace {
    private static final boolean DEBUG = false;
    private static final int FACE_INPUT_IMAGE_BGR = 0;
    private static final int FACE_INPUT_IMAGE_NV21 = 1;
    private static final int HANDLE_MSG_FACE_DESTROY = 113;
    private static final int HANDLE_MSG_FACE_INIT = 111;
    private static final int HANDLE_MSG_FACE_INITED = 110;
    private static final int HANDLE_MSG_FACE_RELEASE = 115;
    private static final int HANDLE_MSG_FACE_RESULT = 112;
    private static final int HANDLE_MSG_FACE_UPDATE = 114;
    private static final int SESSION_ERROR_INIT_FAIL = 1000;
    private static final int SESSION_INIT_SUCCESS = 100;
    private static final int SESSION_TRACK_FAIL = 201;
    private static final int SESSION_TRACK_SUCCESS = 200;
    private static final String TAG = "DuXRSessionFace";
    private Camera mCamera;
    private Context mContext;
    private FaceSession mFaceSession;
    private long mNativeSessionHandle;
    private Handler mSessionHandler;
    private HandlerThread mSessionThread;
    private int mTextureId;
    private int mPreviewWidth = 1280;
    private int mPreviewHeight = 720;
    private SurfaceTexture mSurfaceTexture = null;
    private boolean mAlgoInited = false;
    private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() { // from class: com.baidu.arface.DuXRSessionFace.3
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (DuXRSessionFace.this.mAlgoInited) {
                Message message = new Message();
                message.what = 114;
                message.obj = bArr;
                DuXRSessionFace.this.mSessionHandler.sendMessage(message);
            }
        }
    };
    private FaceListener mFaceListener = new FaceListener() { // from class: com.baidu.arface.DuXRSessionFace.4
    };

    /* JADX INFO: Access modifiers changed from: private */
    public native void onCameraFrameAvailable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onSessionFrameTracked(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateFail(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateSuccess(long j);

    public void startSession(int i, int i2, int i3) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        this.mContext = getContext();
        if (this.mContext == null) {
            sessionCreateFail(this.mNativeSessionHandle, 1000);
            return;
        }
        this.mTextureId = i3;
        if (com.baidu.smallgame.sdk.a.aYi != null) {
            com.baidu.smallgame.sdk.a.aYi.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new PermissionListener() { // from class: com.baidu.arface.DuXRSessionFace.1
                @Override // com.baidu.smallgame.sdk.permission.PermissionListener
                public void onPermissionResult(String str, int i4) {
                    if (i4 == 0) {
                        Log.i(DuXRSessionFace.TAG, "Permission ok!@ permissionState:" + i4);
                        DuXRSessionFace.this.initAlgoModule();
                        return;
                    }
                    int i5 = i4 + 1000;
                    DuXRSessionFace.this.sessionCreateFail(DuXRSessionFace.this.mNativeSessionHandle, i5);
                    Log.i(DuXRSessionFace.TAG, "Permission fail:" + i5);
                }
            });
        } else {
            initAlgoModule();
        }
    }

    public void updateTexture() {
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.updateTexImage();
        }
    }

    public float[] getTransformMatrix() {
        float[] fArr = new float[16];
        this.mSurfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    public void endSession() {
        this.mSessionHandler.sendEmptyMessage(115);
        this.mSessionThread.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAlgoModule() {
        this.mAlgoInited = false;
        this.mSessionThread = new HandlerThread("du-arface-session-thread");
        this.mSessionThread.start();
        this.mSessionHandler = new a(this.mSessionThread.getLooper());
        this.mSessionHandler.sendEmptyMessage(111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAlgoModule() {
        this.mFaceSession.release();
        this.mFaceSession = null;
        this.mAlgoInited = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCamera(boolean z) {
        if (this.mSurfaceTexture == null) {
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.arface.DuXRSessionFace.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    DuXRSessionFace.this.onCameraFrameAvailable(DuXRSessionFace.this.mNativeSessionHandle);
                }
            });
        }
        try {
            this.mCamera = getCameraInstance(z);
            if (this.mCamera == null) {
                startCamera(z);
                return;
            }
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            if (!z) {
                parameters.setFocusMode("auto");
                parameters.setFocusMode("continuous-picture");
            }
            this.mCamera.setParameters(parameters);
            this.mCamera.setPreviewTexture(this.mSurfaceTexture);
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.setPreviewCallback(this.mPreviewCallback);
            this.mCamera.startPreview();
            this.mCamera.cancelAutoFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        double d;
        Camera.Size size;
        if (list != null) {
            double d2 = i / i2;
            Camera.Size size2 = null;
            double d3 = Double.MAX_VALUE;
            for (Camera.Size size3 : list) {
                if (Math.abs((size3.width / size3.height) - d2) <= 0.1d) {
                    if (Math.abs(size3.height - i2) < d3) {
                        d = Math.abs(size3.height - i2);
                        size = size3;
                    } else {
                        d = d3;
                        size = size2;
                    }
                    size2 = size;
                    d3 = d;
                }
            }
            if (size2 != null) {
                this.mPreviewWidth = size2.width;
                this.mPreviewHeight = size2.height;
            }
        }
    }

    private static Camera getCameraInstance(boolean z) {
        Camera camera = null;
        try {
            if (z) {
                camera = Camera.open(1);
            } else {
                camera = Camera.open();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return camera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera() {
        if (this.mCamera != null) {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
            this.mSurfaceTexture.setOnFrameAvailableListener(null);
            this.mSurfaceTexture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 110:
                    DuXRSessionFace.this.mAlgoInited = true;
                    DuXRSessionFace.this.startCamera(true);
                    break;
                case 111:
                    DuXRSessionFace.this.mAlgoInited = false;
                    DuXRSessionFace.this.mFaceSession = new FaceSession(DuXRSessionFace.this.mContext, DuXRSessionFace.this.mFaceListener);
                    DuXRSessionFace.this.mFaceSession.init();
                    break;
                case 112:
                    long j = 0;
                    if (message.obj != null) {
                        j = ((Long) message.obj).longValue();
                    }
                    DuXRSessionFace.this.onSessionFrameTracked(DuXRSessionFace.this.mNativeSessionHandle, j);
                    break;
                case 113:
                    long longValue = ((Long) message.obj).longValue();
                    if (DuXRSessionFace.this.mFaceSession != null) {
                        DuXRSessionFace.this.mFaceSession.destroyHandle(longValue);
                        break;
                    }
                    break;
                case 114:
                    if (DuXRSessionFace.this.mAlgoInited) {
                        byte[] bArr = (byte[]) message.obj;
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr != null ? bArr.length : 0);
                        allocateDirect.put(bArr);
                        DuXRSessionFace.this.mFaceSession.updateFrameAsync(allocateDirect, DuXRSessionFace.this.mPreviewWidth, DuXRSessionFace.this.mPreviewHeight, 1);
                        break;
                    }
                    break;
                case 115:
                    DuXRSessionFace.this.mAlgoInited = false;
                    DuXRSessionFace.this.releaseCamera();
                    DuXRSessionFace.this.endAlgoModule();
                    removeMessages(112);
                    removeMessages(113);
                    break;
            }
            super.handleMessage(message);
        }
    }

    private Context getContext() {
        try {
            return ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0])).getApplicationContext();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
