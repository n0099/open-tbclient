package com.baidu.arface;

import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.dumix.face.FaceListener;
import com.baidu.ar.dumix.face.FaceSession;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.List;
@Keep
/* loaded from: classes9.dex */
public class DuXRSessionFace {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAlgoInited;
    public Camera mCamera;
    public Context mContext;
    public FaceListener mFaceListener;
    public FaceSession mFaceSession;
    public long mNativeSessionHandle;
    public Camera.PreviewCallback mPreviewCallback;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public Handler mSessionHandler;
    public HandlerThread mSessionThread;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureId;

    /* loaded from: classes9.dex */
    public class a implements PermissionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuXRSessionFace a;

        public a(DuXRSessionFace duXRSessionFace) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duXRSessionFace};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = duXRSessionFace;
        }

        @Override // com.baidu.smallgame.sdk.permission.PermissionListener
        public void onPermissionResult(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (i2 == 0) {
                    String str2 = "Permission ok!@ permissionState:" + i2;
                    this.a.initAlgoModule();
                    return;
                }
                int i3 = i2 + 1000;
                DuXRSessionFace duXRSessionFace = this.a;
                duXRSessionFace.sessionCreateFail(duXRSessionFace.mNativeSessionHandle, i3);
                String str3 = "Permission fail:" + i3;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuXRSessionFace f33763e;

        public b(DuXRSessionFace duXRSessionFace) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duXRSessionFace};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33763e = duXRSessionFace;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                DuXRSessionFace duXRSessionFace = this.f33763e;
                duXRSessionFace.onCameraFrameAvailable(duXRSessionFace.mNativeSessionHandle);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuXRSessionFace f33764e;

        public c(DuXRSessionFace duXRSessionFace) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duXRSessionFace};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33764e = duXRSessionFace;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) && this.f33764e.mAlgoInited) {
                Message message = new Message();
                message.what = 114;
                message.obj = bArr;
                this.f33764e.mSessionHandler.sendMessage(message);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements FaceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(DuXRSessionFace duXRSessionFace) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duXRSessionFace};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuXRSessionFace a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DuXRSessionFace duXRSessionFace, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duXRSessionFace, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = duXRSessionFace;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 110:
                        this.a.mAlgoInited = true;
                        this.a.startCamera(true);
                        break;
                    case 111:
                        this.a.mAlgoInited = false;
                        this.a.mFaceSession = new FaceSession(this.a.mContext, this.a.mFaceListener);
                        this.a.mFaceSession.init();
                        break;
                    case 112:
                        Object obj = message.obj;
                        long longValue = obj != null ? ((Long) obj).longValue() : 0L;
                        DuXRSessionFace duXRSessionFace = this.a;
                        duXRSessionFace.onSessionFrameTracked(duXRSessionFace.mNativeSessionHandle, longValue);
                        break;
                    case 113:
                        long longValue2 = ((Long) message.obj).longValue();
                        if (this.a.mFaceSession != null) {
                            this.a.mFaceSession.destroyHandle(longValue2);
                            break;
                        }
                        break;
                    case 114:
                        if (this.a.mAlgoInited) {
                            byte[] bArr = (byte[]) message.obj;
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr != null ? bArr.length : 0);
                            allocateDirect.put(bArr);
                            this.a.mFaceSession.updateFrameAsync(allocateDirect, this.a.mPreviewWidth, this.a.mPreviewHeight, 1);
                            break;
                        }
                        break;
                    case 115:
                        this.a.mAlgoInited = false;
                        this.a.releaseCamera();
                        this.a.endAlgoModule();
                        removeMessages(112);
                        removeMessages(113);
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    public DuXRSessionFace() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPreviewWidth = 1280;
        this.mPreviewHeight = 720;
        this.mSurfaceTexture = null;
        this.mAlgoInited = false;
        this.mPreviewCallback = new c(this);
        this.mFaceListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAlgoModule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mFaceSession.release();
            this.mFaceSession = null;
            this.mAlgoInited = false;
        }
    }

    public static Camera getCameraInstance(boolean z) {
        Camera open;
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65556, null, z)) == null) {
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
        return (Camera) invokeZ.objValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
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
        return (Context) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAlgoModule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.mAlgoInited = false;
            HandlerThread handlerThread = new HandlerThread("du-arface-session-thread");
            this.mSessionThread = handlerThread;
            handlerThread.start();
            e eVar = new e(this, this.mSessionThread.getLooper());
            this.mSessionHandler = eVar;
            eVar.sendEmptyMessage(111);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onCameraFrameAvailable(long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onSessionFrameTracked(long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (camera = this.mCamera) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        this.mCamera.stopPreview();
        this.mCamera.release();
        this.mCamera = null;
        this.mSurfaceTexture.setOnFrameAvailableListener(null);
        this.mSurfaceTexture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateFail(long j2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void sessionCreateSuccess(long j2);

    private void setOptimalPreviewSize(List<Camera.Size> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65564, this, list, i2, i3) == null) || list == null) {
            return;
        }
        double d2 = i2 / i3;
        Camera.Size size = null;
        double d3 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d2) <= 0.1d && Math.abs(size2.height - i3) < d3) {
                d3 = Math.abs(size2.height - i3);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, this, z) == null) {
            if (this.mSurfaceTexture == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureId);
                this.mSurfaceTexture = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(new b(this));
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
    }

    public void endSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mSessionHandler.sendEmptyMessage(115);
            this.mSessionThread.quitSafely();
        }
    }

    public float[] getTransformMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float[] fArr = new float[16];
            this.mSurfaceTexture.getTransformMatrix(fArr);
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public void startSession(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
            Context context = getContext();
            this.mContext = context;
            if (context == null) {
                sessionCreateFail(this.mNativeSessionHandle, 1000);
                return;
            }
            this.mTextureId = i4;
            PermissionProxy permissionProxy = c.a.m0.a.a.o;
            if (permissionProxy != null) {
                permissionProxy.requestPermission(PermissionProxy.SCOPE_ID_CAMERA, new a(this));
            } else {
                initAlgoModule();
            }
        }
    }

    public void updateTexture() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (surfaceTexture = this.mSurfaceTexture) == null) {
            return;
        }
        surfaceTexture.updateTexImage();
    }
}
