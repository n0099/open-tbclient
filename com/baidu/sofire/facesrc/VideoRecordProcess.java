package com.baidu.sofire.facesrc;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.EncryptConnFaceServerUtil;
import com.baidu.sofire.utility.FaceId;
import com.baidu.sofire.utility.HttpCetificateUtil;
import com.baidu.sofire.utility.MD5Util;
import com.baidu.sofire.utility.ReportUtil;
import com.baidu.sofire.utility.SdkFacePrivateConfig;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.sofire.utility.camera.CameraPreviewUtils;
import com.baidu.sofire.utility.camera.CameraUtils;
import com.baidu.sofire.utility.record.IRecCallback;
import com.baidu.sofire.utility.record.MP4Transform;
import com.baidu.sofire.utility.record.MediaRecordManager;
import com.baidu.sofire.utility.record.RecordHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoRecordProcess implements Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback, IVideoRecordProcess {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEVICE_CHECK_RESULT_CALLBACK_PASS = 1;
    public static final int DEVICE_CHECK_RESULT_CALLBACK_RISK = -1;
    public static final int DEVICE_CHECK_RESULT_CALLBACK_UNKNOWN_BLOCK = -2;
    public static final int DEVICE_CHECK_RESULT_CALLBACK_UNKNOWN_CONTINUE = -3;
    public static final int DEVICE_CHECK_RESULT_PASS = 1;
    public static final int DEVICE_CHECK_RESULT_RISK = -2;
    public static final int DEVICE_CHECK_RESULT_UNKNOWN = -1;
    public static final String DIR_NAME = "record_tmp_dir";
    public static final float HEIGHT_EXT_RATIO = 0.2f;
    public static final float HEIGHT_RATIO = 0.1f;
    public static final int OPERATION_ALREADY_END = -6;
    public static final int OPERATION_ALREADY_RECORDING = -2;
    public static final int OPERATION_ALREADY_RELEASE = -5;
    public static final int OPERATION_CAMERA_NOT_READY = -4;
    public static final int OPERATION_NEVER_PREPARE = -1;
    public static final int OPERATION_NOT_RECORDING = -3;
    public static final int OPERATION_OK = 1;
    public static final int OPERATION_RECORD_FAIL = -8;
    public static final int OPERATION_RECORD_TOO_SHORT = -7;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_DATA = -5;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_LAST_EXCEPTION = -2;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_NATIVE = -6;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_NETWORK = -4;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_TIMEOUT = -3;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_ERROR_UNKNOWN = -1;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_OK = 1;
    public static final int PLUGIN_DEVICE_CHECK_STATUS_RISK = 2;
    public static final float WIDTH_SPACE_RATIO = 0.33f;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public long mBeginRecordTimestamp;
    public RecordCallback mCallback;
    public Camera mCamera;
    public int mCameraId;
    public Camera.Parameters mCameraParam;
    public boolean mCancel;
    public JSONArray mCetificateInfo;
    public SdkFacePrivateConfig mConfig;
    public Context mContext;
    public Rect mDetectRect;
    public int mDeviceCheckTimeout;
    public int mDisplayHeight;
    public int mDisplayWidth;
    public String mFaceAuthId;
    public boolean mIsCompletion;
    public boolean mIsCreateSurface;
    public volatile boolean mIsEnableSound;
    public boolean mIsPluginCollectingSensor;
    public boolean mIsPreviewing;
    public FaceLivenessProcessManager mManager;
    public String mMediaDirPath;
    public String mMediaFilePath;
    public int mNetworkType;
    public boolean mPrepare;
    public int mPreviewHight;
    public Rect mPreviewRect;
    public SurfaceHolder mPreviewSurfaceHolder;
    public int mPreviewWidth;
    public MediaRecordManager mRecordManager;
    public long mRecordStartTime;
    public boolean mRecording;
    public boolean mRelease;
    public RequestInfo mResult;
    public boolean mSrcFileExsist;
    public int mSurfaceHeight;
    public int mSurfaceWidth;

    /* loaded from: classes2.dex */
    public class BuildDataRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoRecordProcess this$0;

        public BuildDataRunnable(VideoRecordProcess videoRecordProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoRecordProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = videoRecordProcess;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Object> pair;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.this$0.mCancel) {
                        return;
                    }
                    if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                        this.this$0.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.BuildDataRunnable.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BuildDataRunnable this$1;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.mCallback == null) {
                                    return;
                                }
                                this.this$1.this$0.mCallback.onBeginBuildData();
                            }
                        });
                    }
                    JSONObject jSONObject = null;
                    if (this.this$0.mIsPluginCollectingSensor) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.this$0.mFaceAuthId, Boolean.FALSE, "");
                        this.this$0.mIsPluginCollectingSensor = false;
                    } else {
                        pair = null;
                    }
                    if (this.this$0.mCancel) {
                        return;
                    }
                    if (pair != null && ((Integer) pair.first).intValue() == 0) {
                        String str = (String) pair.second;
                        if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str).optJSONObject("s")) != null && this.this$0.mBeginRecordTimestamp > 0 && this.this$0.mConfig.getSingleSensorFlag()) {
                            jSONObject = this.this$0.selectClosestSensorData(jSONObject);
                        }
                    }
                    if (this.this$0.mCancel) {
                        return;
                    }
                    this.this$0.processEnd(this.this$0.buildData(jSONObject));
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 6, th);
                    this.this$0.processEnd(-12);
                }
            }
        }
    }

    public VideoRecordProcess(FaceLivenessProcessManager faceLivenessProcessManager, Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceLivenessProcessManager, activity, surfaceHolder, recordCallback, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsEnableSound = true;
        this.mIsCreateSurface = false;
        this.mIsCompletion = false;
        this.mDeviceCheckTimeout = 5;
        this.mBeginRecordTimestamp = 0L;
        this.mRecordStartTime = 0L;
        this.mSrcFileExsist = false;
        this.mIsPluginCollectingSensor = false;
        this.mPreviewRect = new Rect();
        this.mDetectRect = new Rect();
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mDisplayWidth = 0;
        this.mDisplayHeight = 0;
        this.mIsPreviewing = false;
        this.mNetworkType = -1;
        this.mManager = faceLivenessProcessManager;
        Context applicationContext = activity.getApplicationContext();
        this.mContext = applicationContext;
        this.mActivity = activity;
        this.mPreviewSurfaceHolder = surfaceHolder;
        this.mCallback = recordCallback;
        this.mDeviceCheckTimeout = i;
        this.mConfig = SdkFacePrivateConfig.getInstance(applicationContext);
        this.mRecordManager = MediaRecordManager.getInstance(this.mContext);
        this.mMediaDirPath = new File(this.mContext.getFilesDir(), "record_tmp_dir").getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x0005, B:17:0x0029, B:19:0x0035, B:21:0x0043, B:22:0x004d), top: B:31:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int displayOrientation(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65567, this, context)) != null) {
            return invokeL.intValue;
        }
        try {
            int rotation = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i = 90;
                } else if (rotation == 2) {
                    i = 180;
                } else if (rotation == 3) {
                    i = 270;
                }
                int i2 = ((0 - i) + 360) % 360;
                if (Build.VERSION.SDK_INT < 9) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(this.mCameraId, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
                    }
                    return ((cameraInfo.orientation - i) + 360) % 360;
                }
                return i2;
            }
            i = 0;
            int i22 = ((0 - i) + 360) % 360;
            if (Build.VERSION.SDK_INT < 9) {
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.mIsEnableSound = ((AudioManager) this.mContext.getSystemService("audio")).getStreamVolume(3) > 0;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mDisplayWidth = displayMetrics.widthPixels;
            this.mDisplayHeight = displayMetrics.heightPixels;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera openCamera(boolean z) {
        InterceptResult invokeZ;
        int numberOfCameras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65569, this, z)) == null) {
            if (this.mCancel || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
                return null;
            }
            int i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if ((z && cameraInfo.facing == 1) || (!z && cameraInfo.facing == 0)) {
                    break;
                }
                i++;
            }
            if (i < numberOfCameras) {
                Camera open = Camera.open(i);
                this.mCameraId = i;
                return open;
            }
            Camera open2 = Camera.open(0);
            this.mCameraId = 0;
            return open2;
        }
        return (Camera) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i) == null) {
            try {
                this.mIsCompletion = true;
                if (this.mActivity != null) {
                    this.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VideoRecordProcess this$0;
                        public final /* synthetic */ int val$status;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$status = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mCallback == null) {
                                return;
                            }
                            if (this.val$status == 1) {
                                this.this$0.mCallback.onEnd(this.val$status, this.this$0.mResult);
                            } else {
                                this.this$0.mCallback.onEnd(this.val$status, null);
                            }
                            this.this$0.mCallback = null;
                        }
                    });
                }
                if (this.mRecordManager != null && this.mRecording) {
                    this.mRecordManager.cancelRecorder();
                }
                stopPreview();
                if (this.mIsPluginCollectingSensor) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.mFaceAuthId, Boolean.TRUE, "");
                    this.mIsPluginCollectingSensor = false;
                }
                if (this.mPreviewSurfaceHolder != null) {
                    this.mPreviewSurfaceHolder.removeCallback(this);
                    this.mPreviewSurfaceHolder = null;
                }
                this.mActivity = null;
                if (this.mManager != null) {
                    this.mManager.processEnd(this);
                    this.mManager = null;
                }
                ReportUtil.reportProcessKeyPoint(this.mContext, this.mFaceAuthId, 103, i, null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    private JSONObject rebuildJsonArray(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, this, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    String str2 = "";
                    int i = 0;
                    while (true) {
                        if (i >= optJSONArray.length()) {
                            break;
                        }
                        String string = optJSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            String[] split = string.split("#");
                            if (split.length == 2) {
                                long longValue = Long.valueOf(split[0]).longValue();
                                if (longValue <= 0) {
                                    continue;
                                } else if (longValue <= this.mBeginRecordTimestamp) {
                                    str2 = string;
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = string;
                                }
                            } else {
                                continue;
                            }
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.remove(str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str2);
                        jSONObject.put(str, jSONArray);
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject selectClosestSensorData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, this, jSONObject)) == null) {
            try {
                rebuildJsonArray(jSONObject, "g");
                rebuildJsonArray(jSONObject, "l");
                rebuildJsonArray(jSONObject, "d");
                return jSONObject;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return jSONObject;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoRecordProcess this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.this$0.mCancel) {
                                    return;
                                }
                                if (this.this$0.mPreviewSurfaceHolder != null) {
                                    this.this$0.mPreviewSurfaceHolder.addCallback(this.this$0);
                                }
                                if (this.this$0.mCamera == null && !this.this$0.mCancel) {
                                    this.this$0.mCamera = this.this$0.openCamera(true);
                                }
                                if (this.this$0.mCamera == null) {
                                    return;
                                }
                                if (this.this$0.mCameraParam == null) {
                                    this.this$0.mCameraParam = this.this$0.mCamera.getParameters();
                                }
                                this.this$0.mCamera.stopPreview();
                                this.this$0.mIsPreviewing = false;
                                this.this$0.mCameraParam.setPictureFormat(256);
                                this.this$0.mCameraParam.setPreviewFormat(17);
                                int displayOrientation = this.this$0.displayOrientation(this.this$0.mContext);
                                this.this$0.mCamera.setDisplayOrientation(displayOrientation);
                                this.this$0.mCameraParam.set("rotation", displayOrientation);
                                Point bestPreview = CameraPreviewUtils.getBestPreview(this.this$0.mCameraParam, new Point(this.this$0.mDisplayWidth, this.this$0.mDisplayHeight));
                                this.this$0.mPreviewWidth = bestPreview.x;
                                this.this$0.mPreviewHight = bestPreview.y;
                                this.this$0.mPreviewRect.set(0, 0, this.this$0.mPreviewHight, this.this$0.mPreviewWidth);
                                this.this$0.getPreviewDetectRect(this.this$0.mDisplayWidth, this.this$0.mPreviewHight, this.this$0.mPreviewWidth);
                                this.this$0.mCameraParam.setPreviewSize(this.this$0.mPreviewWidth, this.this$0.mPreviewHight);
                                this.this$0.mCamera.setParameters(this.this$0.mCameraParam);
                                if (this.this$0.mCallback != null) {
                                    this.this$0.mCallback.onConfigCamera(this.this$0.mCamera);
                                }
                                this.this$0.mPreviewWidth = this.this$0.mCameraParam.getPreviewSize().width;
                                this.this$0.mPreviewHight = this.this$0.mCameraParam.getPreviewSize().height;
                                this.this$0.mCamera.setPreviewDisplay(this.this$0.mPreviewSurfaceHolder);
                                this.this$0.mCamera.setErrorCallback(this.this$0);
                                this.this$0.mCamera.setPreviewCallback(this.this$0);
                                if (this.this$0.mCancel) {
                                    return;
                                }
                                this.this$0.mCamera.startPreview();
                                this.this$0.mIsPreviewing = true;
                                Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.this$0.mFaceAuthId);
                                if (callSync == null || ((Integer) callSync.first).intValue() != 0) {
                                    return;
                                }
                                this.this$0.mIsPluginCollectingSensor = true;
                            } catch (Throwable th) {
                                CommonMethods.handleNuLException(th);
                                ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 2, th);
                                this.this$0.processEnd(-5);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                ReportUtil.reportProcessException(this.mContext, this.mFaceAuthId, 2, th);
                processEnd(-5);
            }
        }
    }

    public int buildData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                File file = new File(this.mMediaFilePath);
                if (file.exists()) {
                    jSONObject3.put("f_i", this.mFaceAuthId);
                    if (jSONObject != null) {
                        jSONObject3.put("s", jSONObject);
                    }
                    byte[][] transform = MP4Transform.transform(RecordHelper.toByteArray(file));
                    file.delete();
                    if (transform != null && transform.length == 2) {
                        byte[] bArr = transform[1];
                        byte[] bArr2 = transform[0];
                        if (bArr2 != null && bArr2.length != 0) {
                            if (bArr != null && bArr.length != 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("transcheckdata", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.mContext, bArr2), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                jSONObject4.put("video", jSONObject5);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("zid", FH.gzfi(this.mContext, "", 5002));
                                jSONObject6.put(Config.EVENT_PART, "face");
                                jSONObject6.put(NotificationStyle.NOTIFICATION_STYLE, this.mNetworkType);
                                jSONObject6.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis());
                                TimeZone timeZone = TimeZone.getDefault();
                                if (timeZone != null) {
                                    jSONObject6.put("tz", timeZone.getID());
                                }
                                if (this.mCetificateInfo != null) {
                                    jSONObject6.put("ce", this.mCetificateInfo);
                                }
                                jSONObject4.put("risk", jSONObject6);
                                jSONObject3.put("e", jSONObject4);
                                String licenseId = FaceLivenessProcessManager.getLicenseId();
                                if (!TextUtils.isEmpty(licenseId)) {
                                    String[] split = licenseId.split("-");
                                    if (split.length >= 3) {
                                        StringBuilder sb = new StringBuilder();
                                        for (int i = 0; i < split.length - 3; i++) {
                                            sb.append(split[i]);
                                            sb.append("-");
                                        }
                                        sb.append(split[split.length - 3]);
                                        licenseId = sb.toString();
                                    }
                                }
                                jSONObject2.put("licenseId", licenseId);
                                jSONObject2.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.mContext, jSONObject3.toString().getBytes()), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                jSONObject2.put("app", "android");
                                String packageName = this.mContext.getPackageName();
                                if (packageName != null) {
                                    jSONObject2.put("pkg", packageName);
                                    Signature[] signatureArr = this.mContext.getPackageManager().getPackageInfo(packageName, 64).signatures;
                                    if (signatureArr != null && signatureArr.length > 0) {
                                        jSONObject2.put("sign", MD5Util.getMD5(signatureArr[0].toByteArray()));
                                    }
                                }
                                this.mResult = EncryptConnFaceServerUtil.buildRequestInfo(this.mContext, jSONObject2.toString(), bArr, this.mMediaDirPath);
                                return 1;
                            }
                            throw new RuntimeException("empty mediaData");
                        }
                        throw new RuntimeException("empty mediaSafeInfo");
                    }
                    throw new RuntimeException("transformResult unexpected");
                }
                throw new RuntimeException("mediaFile not exists");
            } catch (Throwable th) {
                ReportUtil.reportProcessException(this.mContext, this.mFaceAuthId, 6, th);
                CommonMethods.handleNuLException(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public int cancelRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mPrepare) {
                if (this.mRecording) {
                    if (this.mRelease) {
                        return -5;
                    }
                    if (this.mIsCompletion) {
                        return -6;
                    }
                    this.mRecording = false;
                    this.mRecordManager.cancelRecorder();
                    return 1;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void getPreviewDetectRect(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            float f = i / 2;
            float f2 = f - (0.33f * f);
            float f3 = i2 / 2;
            float f4 = i3 / 2;
            float f5 = f4 - (0.1f * f4);
            if (f3 <= f2) {
                f2 = f3;
            }
            float f6 = (0.2f * f2) + f2;
            this.mDetectRect.set((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, camera) == null) || this.mSrcFileExsist) {
            return;
        }
        processEnd(-5);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bArr, camera) == null) {
            try {
                if (this.mIsCompletion || this.mCancel || this.mCallback == null) {
                    return;
                }
                this.mCallback.onPreviewFrame(bArr, camera);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                ReportUtil.reportProcessException(this.mContext, this.mFaceAuthId, 3, th);
                processEnd(-11);
            }
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mPrepare = true;
            start();
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mRelease) {
                return -5;
            }
            try {
                this.mCancel = true;
                this.mRelease = true;
                processEnd(-16);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (ThreadPoolManager.getInstance(this.mContext).executeCore(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoRecordProcess this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:44:0x0105 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x013b A[Catch: all -> 0x0166, TryCatch #0 {all -> 0x0166, blocks: (B:5:0x0007, B:8:0x0010, B:10:0x0036, B:12:0x003e, B:13:0x004c, B:15:0x0052, B:17:0x005e, B:19:0x0066, B:22:0x006f, B:25:0x0080, B:27:0x0088, B:42:0x00fd, B:47:0x010a, B:52:0x011a, B:54:0x0122, B:56:0x012a, B:59:0x013b, B:62:0x0143, B:64:0x0149, B:67:0x0152, B:70:0x0160, B:28:0x00aa, B:30:0x00b6, B:32:0x00be, B:34:0x00e2, B:36:0x00ec), top: B:78:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:61:0x0141  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        Pair<Integer, Object> callSync;
                        char c;
                        int i;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        try {
                            if (this.this$0.mCancel) {
                                return;
                            }
                            this.this$0.mFaceAuthId = FaceId.getFaceAuthId("3");
                            ReportUtil.reportProcessKeyPoint(this.this$0.mContext, this.this$0.mFaceAuthId, 101, 0, null);
                            if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                                this.this$0.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCallback == null) {
                                            return;
                                        }
                                        this.this$1.this$0.mCallback.onBegin();
                                    }
                                });
                            }
                            if (FH.isInitSuc(1) || !this.this$0.mConfig.getBlockWhenNoPlugin()) {
                                if (this.this$0.mCancel) {
                                    return;
                                }
                                if (!this.this$0.mConfig.getDeviceCheckFlag() || this.this$0.mDeviceCheckTimeout != 0) {
                                    if (this.this$0.mConfig.getDeviceCheckFlag() && this.this$0.mDeviceCheckTimeout > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.this$0.mFaceAuthId, Integer.valueOf(this.this$0.mDeviceCheckTimeout))) != null && ((Integer) callSync.first).intValue() == 0) {
                                        int intValue = ((Integer) callSync.second).intValue();
                                        if (intValue == 1) {
                                            c = 1;
                                        } else if (intValue == 2) {
                                            c = 65534;
                                        }
                                        if (!this.this$0.mCancel) {
                                            return;
                                        }
                                        if (c != 65534 && (c == 1 || !this.this$0.mConfig.getUnknownContinueFlag())) {
                                            i = 1;
                                            if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                                                this.this$0.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.1.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ AnonymousClass1 this$1;
                                                    public final /* synthetic */ int val$deviceCheckCallbackResultCode;

                                                    {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this, Integer.valueOf(i)};
                                                            interceptable3.invokeUnInit(65536, newInitContext);
                                                            int i2 = newInitContext.flag;
                                                            if ((i2 & 1) != 0) {
                                                                int i3 = i2 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.this$1 = this;
                                                        this.val$deviceCheckCallbackResultCode = i;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCallback == null) {
                                                            return;
                                                        }
                                                        this.this$1.this$0.mCallback.onDeviceCheckResult(this.val$deviceCheckCallbackResultCode);
                                                    }
                                                });
                                            }
                                            if (c != 65534) {
                                                this.this$0.processEnd(-3);
                                                return;
                                            } else if (i == -1) {
                                                this.this$0.processEnd(-3);
                                                return;
                                            } else if (this.this$0.mCancel) {
                                                return;
                                            } else {
                                                this.this$0.init();
                                                if (this.this$0.mCancel) {
                                                    return;
                                                }
                                                this.this$0.startPreview();
                                                return;
                                            }
                                        }
                                        i = -1;
                                        if (this.this$0.mCallback != null) {
                                            this.this$0.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.1.2
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass1 this$1;
                                                public final /* synthetic */ int val$deviceCheckCallbackResultCode;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, Integer.valueOf(i)};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.this$1 = this;
                                                    this.val$deviceCheckCallbackResultCode = i;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCallback == null) {
                                                        return;
                                                    }
                                                    this.this$1.this$0.mCallback.onDeviceCheckResult(this.val$deviceCheckCallbackResultCode);
                                                }
                                            });
                                        }
                                        if (c != 65534) {
                                        }
                                    }
                                } else {
                                    FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.this$0.mFaceAuthId, Integer.valueOf(this.this$0.mDeviceCheckTimeout));
                                }
                                c = 65535;
                                if (!this.this$0.mCancel) {
                                }
                            } else {
                                this.this$0.processEnd(-15);
                            }
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                            ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 1, th);
                            this.this$0.processEnd(-9);
                        }
                    }
                }) != 1) {
                    processEnd(-7);
                }
                ThreadPoolManager.getInstance(this.mContext).execute(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoRecordProcess this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            VideoRecordProcess videoRecordProcess = this.this$0;
                            videoRecordProcess.mNetworkType = HttpCetificateUtil.getNetWorkType(videoRecordProcess.mContext);
                            VideoRecordProcess videoRecordProcess2 = this.this$0;
                            videoRecordProcess2.mCetificateInfo = HttpCetificateUtil.getHttpCetificate(videoRecordProcess2.mContext);
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public int startRecord() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mPrepare) {
                if (this.mRecording) {
                    return -2;
                }
                if (this.mCamera == null) {
                    return -4;
                }
                if (this.mRelease) {
                    return -5;
                }
                if (this.mIsCompletion) {
                    return -6;
                }
                this.mBeginRecordTimestamp = System.currentTimeMillis();
                if (this.mRecordManager.startRecord(this.mCamera, this.mMediaDirPath, this.mCameraId, new IRecCallback(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoRecordProcess this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.sofire.utility.record.IRecCallback
                    public void onError(int i) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) || i >= 0) {
                            return;
                        }
                        this.this$0.processEnd(-17);
                    }
                }) < 0) {
                    processEnd(-17);
                } else {
                    this.mRecordStartTime = System.currentTimeMillis();
                    if (this.mCallback != null && (activity = this.mActivity) != null) {
                        try {
                            activity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ VideoRecordProcess this$0;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mCallback == null) {
                                        return;
                                    }
                                    this.this$0.mCallback.onBeginRecord();
                                }
                            });
                        } catch (Throwable th) {
                            CommonMethods.handleNuLException(th);
                        }
                    }
                }
                this.mRecording = true;
                ReportUtil.reportProcessKeyPoint(this.mContext, this.mFaceAuthId, 102, 0, null);
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void stopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.VideoRecordProcess.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ VideoRecordProcess this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$0.mIsPreviewing = false;
                                if (this.this$0.mCamera != null) {
                                    this.this$0.mCamera.setErrorCallback(null);
                                    this.this$0.mCamera.setPreviewCallback(null);
                                    this.this$0.mCamera.stopPreview();
                                    CameraUtils.releaseCamera(this.this$0.mCamera);
                                    this.this$0.mCamera = null;
                                }
                                if (this.this$0.mPreviewSurfaceHolder != null) {
                                    this.this$0.mPreviewSurfaceHolder.removeCallback(this.this$0);
                                }
                            } catch (Throwable th) {
                                CommonMethods.handleNuLException(th);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public int stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mPrepare) {
                if (this.mRecording) {
                    if (this.mRelease) {
                        return -5;
                    }
                    if (this.mIsCompletion) {
                        return -6;
                    }
                    this.mRecording = false;
                    if (System.currentTimeMillis() - this.mRecordStartTime < 2000) {
                        this.mRecordManager.cancelRecorder();
                        return -7;
                    }
                    String stopRecord = this.mRecordManager.stopRecord();
                    this.mMediaFilePath = stopRecord;
                    if (!TextUtils.isEmpty(stopRecord) && new File(this.mMediaFilePath).exists()) {
                        this.mSrcFileExsist = true;
                        if (ThreadPoolManager.getInstance(this.mContext).executeCore(new BuildDataRunnable()) != 1) {
                            processEnd(-7);
                        }
                        return 1;
                    }
                    processEnd(-7);
                    this.mSrcFileExsist = false;
                    return -8;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, surfaceHolder, i, i2, i3) == null) {
            this.mSurfaceWidth = i2;
            this.mSurfaceHeight = i3;
            if (this.mCancel || surfaceHolder.getSurface() == null || !this.mIsPreviewing) {
                return;
            }
            startPreview();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceHolder) == null) {
            this.mIsCreateSurface = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.mIsCreateSurface = false;
        }
    }
}
