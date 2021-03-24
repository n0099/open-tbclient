package com.baidu.arface;

import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.ar.dumix.face.FaceListener;
import com.baidu.ar.dumix.face.FaceSession;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.List;
@Keep
/* loaded from: classes2.dex */
public class DuXRSessionFace {
    public static final boolean DEBUG = false;
    public static final int FACE_INPUT_IMAGE_BGR = 0;
    public static final int FACE_INPUT_IMAGE_NV21 = 1;
    public static final int HANDLE_MSG_FACE_DESTROY = 113;
    public static final int HANDLE_MSG_FACE_INIT = 111;
    public static final int HANDLE_MSG_FACE_INITED = 110;
    public static final int HANDLE_MSG_FACE_RELEASE = 115;
    public static final int HANDLE_MSG_FACE_RESULT = 112;
    public static final int HANDLE_MSG_FACE_UPDATE = 114;
    public static final int SESSION_ERROR_INIT_FAIL = 1000;
    public static final int SESSION_INIT_SUCCESS = 100;
    public static final int SESSION_TRACK_FAIL = 201;
    public static final int SESSION_TRACK_SUCCESS = 200;
    public static final String TAG = "DuXRSessionFace";
    public Camera mCamera;
    public Context mContext;
    public FaceSession mFaceSession;
    public long mNativeSessionHandle;
    public Handler mSessionHandler;
    public HandlerThread mSessionThread;
    public int mTextureId;
    public int mPreviewWidth = 1280;
    public int mPreviewHeight = PeerConnectionClient.HD_VIDEO_HEIGHT;
    public SurfaceTexture mSurfaceTexture = null;
    public boolean mAlgoInited = false;
    public Camera.PreviewCallback mPreviewCallback = new c();
    public FaceListener mFaceListener = new d(this);

    /* loaded from: classes2.dex */
    public class a implements PermissionListener {
        public a() {
        }

        @Override // com.baidu.smallgame.sdk.permission.PermissionListener
        public void onPermissionResult(String str, int i) {
            if (i == 0) {
                Log.i(DuXRSessionFace.TAG, "Permission ok!@ permissionState:" + i);
                DuXRSessionFace.this.initAlgoModule();
                return;
            }
            int i2 = i + 1000;
            DuXRSessionFace duXRSessionFace = DuXRSessionFace.this;
            duXRSessionFace.sessionCreateFail(duXRSessionFace.mNativeSessionHandle, i2);
            Log.i(DuXRSessionFace.TAG, "Permission fail:" + i2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SurfaceTexture.OnFrameAvailableListener {
        public b() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            DuXRSessionFace duXRSessionFace = DuXRSessionFace.this;
            duXRSessionFace.onCameraFrameAvailable(duXRSessionFace.mNativeSessionHandle);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Camera.PreviewCallback {
        public c() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (DuXRSessionFace.this.mAlgoInited) {
                Message message = new Message();
                message.what = 114;
                message.obj = bArr;
                DuXRSessionFace.this.mSessionHandler.sendMessage(message);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements FaceListener {
        public d(DuXRSessionFace duXRSessionFace) {
        }
    }

    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e(Looper looper) {
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
                    Object obj = message.obj;
                    long longValue = obj != null ? ((Long) obj).longValue() : 0L;
                    DuXRSessionFace duXRSessionFace = DuXRSessionFace.this;
                    duXRSessionFace.onSessionFrameTracked(duXRSessionFace.mNativeSessionHandle, longValue);
                    break;
                case 113:
                    long longValue2 = ((Long) message.obj).longValue();
                    if (DuXRSessionFace.this.mFaceSession != null) {
                        DuXRSessionFace.this.mFaceSession.destroyHandle(longValue2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void endAlgoModule() {
        this.mFaceSession.release();
        this.mFaceSession = null;
        this.mAlgoInited = false;
    }

    public static Camera getCameraInstance(boolean z) {
        Camera open;
        try {
            if (z) {
                open = Camera.open(1);
            } else {
                open = Camera.open();
            }
            return open;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Context getContext() {
        try {
            return ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0])).getApplicationContext();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAlgoModule() {
        this.mAlgoInited = false;
        HandlerThread handlerThread = new HandlerThread("du-arface-session-thread");
        this.mSessionThread = handlerThread;
        handlerThread.start();
        e eVar = new e(this.mSessionThread.getLooper());
        this.mSessionHandler = eVar;
        eVar.sendEmptyMessage(111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onCameraFrameAvailable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onSessionFrameTracked(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
            this.mSurfaceTexture.setOnFrameAvailableListener(null);
            this.mSurfaceTexture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateFail(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateSuccess(long j);

    private void setOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        if (list == null) {
            return;
        }
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        Camera.Size size = null;
        double d5 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            double d6 = size2.width;
            double d7 = size2.height;
            Double.isNaN(d6);
            Double.isNaN(d7);
            if (Math.abs((d6 / d7) - d4) <= 0.1d && Math.abs(size2.height - i2) < d5) {
                d5 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size != null) {
            this.mPreviewWidth = size.width;
            this.mPreviewHeight = size.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCamera(boolean z) {
        if (this.mSurfaceTexture == null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(new b());
        }
        try {
            Camera cameraInstance = getCameraInstance(z);
            this.mCamera = cameraInstance;
            if (cameraInstance == null) {
                startCamera(z);
                return;
            }
            Camera.Parameters parameters = cameraInstance.getParameters();
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void endSession() {
        this.mSessionHandler.sendEmptyMessage(115);
        this.mSessionThread.quitSafely();
    }

    public float[] getTransformMatrix() {
        float[] fArr = new float[16];
        this.mSurfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    public void startSession(int i, int i2, int i3) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        Context context = getContext();
        this.mContext = context;
        if (context == null) {
            sessionCreateFail(this.mNativeSessionHandle, 1000);
            return;
        }
        this.mTextureId = i3;
        PermissionProxy permissionProxy = d.b.e0.a.a.o;
        if (permissionProxy != null) {
            permissionProxy.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new a());
        } else {
            initAlgoModule();
        }
    }

    public void updateTexture() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }
}
