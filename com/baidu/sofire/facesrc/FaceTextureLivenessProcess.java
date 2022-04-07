package com.baidu.sofire.facesrc;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.IDetectStrategyCallback;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.pass.face.platform.ILivenessStrategyCallback;
import com.baidu.pass.face.platform.ILivenessViewCallback;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.sofire.ac.Degree;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IFaceProcessInfo;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FaceTextureLivenessProcess implements Camera.ErrorCallback, TextureView.SurfaceTextureListener, ISecurityCallback, IFaceProcess {
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
    public static final int OPERATION_ALREADY_RECORDING = -2;
    public static final int OPERATION_CAMERA_NOT_READY = -4;
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
    public static final int PROCESS_TYPE_COMPARE = 2;
    public static final int PROCESS_TYPE_VERIFY = 1;
    public static final int SFV_STATUS_NO = 0;
    public static final int SFV_STATUS_YES = 1;
    public static final float WIDTH_SPACE_RATIO = 0.33f;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public Camera mBackCamera;
    public boolean mBackCameraError;
    public Camera.Parameters mBackCameraParam;
    public byte[] mBackFrame1Data;
    public byte[] mBackFrame2Data;
    public int mBackFrameCount;
    public long mBeginRecordTimestamp;
    public Bitmap mBitmap;
    public Map<Long, String> mBitmapMap;
    public long mBitmapTimestamp;
    public FaceProcessCallback mCallback;
    public Camera mCamera;
    public int mCameraId;
    public Camera.Parameters mCameraParam;
    public boolean mCancel;
    public JSONArray mCetificateInfo;
    public boolean mCollectBackFrame;
    public boolean mCollectFirstFrame;
    public SdkFacePrivateConfig mConfig;
    public Context mContext;
    public DecodeThread mDecodeThread;
    public Rect mDetectRect;
    public int mDeviceCheckTimeout;
    public int mDisplayHeight;
    public int mDisplayWidth;
    public String mFaceAuthId;
    public FaceConfig mFaceConfig;
    public FaceDetectStrategyCallback mFaceDetectCallback;
    public Map<Long, FaceInfo> mFaceInfoMap;
    public FaceLivenessStrategyCallback mFaceLivenessCallback;
    public IFaceProcessInfo mFaceProcessInfo;
    public Bitmap mFirstFrameBitmap;
    public volatile int mFrameStackCounter;
    public IDetectStrategy mIDetectStrategy;
    public ILivenessStrategy mILivenessStrategy;
    public int mImageCount;
    public long mInterval;
    public boolean mIsCollectingBackFrame;
    public boolean mIsCompletion;
    public boolean mIsCreateSurface;
    public volatile boolean mIsEnableSound;
    public boolean mIsPluginCollectingSensor;
    public boolean mIsPluginProcess;
    public boolean mIsPreviewing;
    public long mLastFaceInfoTimestamp;
    public boolean mLiveness;
    public FaceLivenessProcessManager mManager;
    public String mMediaDirPath;
    public String mMediaFilePath;
    public int mNetworkType;
    public Degree mPreviewDegree;
    public int mPreviewHight;
    public Rect mPreviewRect;
    public TextureView mPreviewTextureView;
    public int mPreviewWidth;
    public boolean mRecord;
    public MediaRecordManager mRecordManager;
    public long mRecordStartTime;
    public boolean mRecording;
    public boolean mRelease;
    public RequestInfo mResult;
    public boolean mSrcFileExsist;
    public int mSurfaceHeight;
    public int mSurfaceWidth;
    public int mTextureHeight;
    public int mTextureWidth;
    public Timer mTimer;
    public FaceLivenessViewCallback mViewCallback;

    /* loaded from: classes2.dex */
    public class BackCameraCallback implements Camera.ErrorCallback, Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public BackCameraCallback(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, camera) == null) {
                this.this$0.mBackCameraError = true;
                this.this$0.releaseBackCamera();
                this.this$0.notifyCollectBackFrame();
            }
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, camera) == null) {
                try {
                    int i = this.this$0.mBackFrameCount;
                    if (i == 1) {
                        this.this$0.mBackFrame1Data = bArr;
                    } else if (i == 2) {
                        this.this$0.mBackFrame2Data = bArr;
                    }
                    this.this$0.releaseBackCamera();
                    this.this$0.notifyCollectBackFrame();
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    this.this$0.releaseBackCamera();
                    this.this$0.notifyCollectBackFrame();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class DecodeThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean running;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public DecodeThread(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
            this.running = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.running) {
                    if (this.this$0.mFrameStackCounter > 0) {
                        if (this.this$0.mIsCompletion || !this.running) {
                            return;
                        }
                        if (this.this$0.mBitmap != null && this.this$0.mILivenessStrategy != null) {
                            this.this$0.mBitmap = FaceSDKManager.getInstance().scaleImage(this.this$0.mBitmap, this.this$0.mPreviewHight, this.this$0.mPreviewWidth);
                            this.this$0.mILivenessStrategy.livenessStrategy(this.this$0.mBitmap);
                            if (this.this$0.mBitmap != this.this$0.mFirstFrameBitmap) {
                                this.this$0.mBitmap.recycle();
                            }
                            FaceTextureLivenessProcess faceTextureLivenessProcess = this.this$0;
                            faceTextureLivenessProcess.mFrameStackCounter--;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class FaceDetectStrategyCallback implements IDetectStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public FaceDetectStrategyCallback(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
        }

        @Override // com.baidu.pass.face.platform.IDetectStrategyCallback
        public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, faceStatusNewEnum, str, hashMap, hashMap2) == null) {
                try {
                    if (!this.this$0.mIsCompletion && !this.this$0.mCancel) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            this.this$0.mIsCompletion = true;
                            Map bestImages = this.this$0.getBestImages(hashMap, hashMap2);
                            if (bestImages != null) {
                                this.this$0.mBitmapMap = bestImages;
                            } else {
                                this.this$0.processEnd(-8);
                            }
                            if (this.this$0.mCallback != null) {
                                this.this$0.removePlaintext(hashMap, hashMap2);
                                this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, -1);
                            }
                            if (ThreadPoolManager.getInstance(this.this$0.mContext).executeCore(new RemoteFaceVerifyRunnable()) != 1) {
                                this.this$0.processEnd(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            if (this.this$0.mCallback != null) {
                                this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                            this.this$0.processEnd(-18);
                        } else if (this.this$0.mCallback != null) {
                            this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 4, th);
                    this.this$0.processEnd(-10);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class FaceLivenessStrategyCallback implements ILivenessStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public FaceLivenessStrategyCallback(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
        }

        @Override // com.baidu.pass.face.platform.ILivenessStrategyCallback
        public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i)}) == null) {
                try {
                    if (!this.this$0.mIsCompletion && !this.this$0.mCancel) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            this.this$0.mIsCompletion = true;
                            Map bestImages = this.this$0.getBestImages(hashMap, hashMap2);
                            if (bestImages != null) {
                                this.this$0.mBitmapMap = bestImages;
                            } else {
                                this.this$0.processEnd(-8);
                            }
                            if (this.this$0.mCallback != null) {
                                this.this$0.removePlaintext(hashMap, hashMap2);
                                this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i);
                            }
                            this.this$0.stopRecord();
                            if (ThreadPoolManager.getInstance(this.this$0.mContext).executeCore(new RemoteFaceVerifyRunnable()) != 1) {
                                this.this$0.processEnd(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            if (this.this$0.mCallback != null) {
                                this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                            }
                            this.this$0.processEnd(-18);
                        } else if (this.this$0.mCallback != null) {
                            this.this$0.mCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 4, th);
                    this.this$0.processEnd(-10);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class FaceLivenessViewCallback implements ILivenessViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public FaceLivenessViewCallback(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void animStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.this$0.mCallback != null) {
                        this.this$0.mCallback.animStop();
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessTypeEnum) == null) {
                try {
                    if (this.this$0.mCallback != null) {
                        this.this$0.mCallback.setCurrentLiveType(livenessTypeEnum);
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void setFaceInfo(FaceExtInfo faceExtInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceExtInfo) == null) {
                try {
                    if (this.this$0.mCallback != null) {
                        this.this$0.mCallback.setFaceInfo(faceExtInfo);
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void viewReset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    if (this.this$0.mCallback != null) {
                        this.this$0.mCallback.viewReset();
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class RemoteFaceVerifyRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceTextureLivenessProcess this$0;

        public RemoteFaceVerifyRunnable(FaceTextureLivenessProcess faceTextureLivenessProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceTextureLivenessProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = faceTextureLivenessProcess;
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
                    if (this.this$0.mCollectBackFrame && !this.this$0.mBackCameraError) {
                        this.this$0.collectBackFrame();
                    }
                    if (this.this$0.mCancel) {
                        return;
                    }
                    if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                        this.this$0.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.RemoteFaceVerifyRunnable.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ RemoteFaceVerifyRunnable this$1;

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
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.this$0.mFaceAuthId, Boolean.FALSE, this.this$0.buildFaceInfos());
                        this.this$0.mIsPluginCollectingSensor = false;
                    } else {
                        pair = null;
                    }
                    if (this.this$0.mCancel) {
                        return;
                    }
                    if (pair != null && ((Integer) pair.first).intValue() == 0) {
                        String str = (String) pair.second;
                        if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str).optJSONObject("s")) != null && this.this$0.mBitmapTimestamp > 0 && this.this$0.mConfig.getSingleSensorFlag()) {
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

    public FaceTextureLivenessProcess(FaceLivenessProcessManager faceLivenessProcessManager, Activity activity, TextureView textureView, FaceProcessCallback faceProcessCallback, int i, IFaceProcessInfo iFaceProcessInfo, int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {faceLivenessProcessManager, activity, textureView, faceProcessCallback, Integer.valueOf(i), iFaceProcessInfo, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsEnableSound = true;
        this.mIsCreateSurface = false;
        this.mIsCompletion = false;
        this.mDeviceCheckTimeout = 5;
        this.mCollectBackFrame = false;
        this.mCollectFirstFrame = false;
        this.mIsPluginProcess = false;
        this.mIsPluginCollectingSensor = false;
        this.mPreviewDegree = new Degree(0);
        this.mPreviewRect = new Rect();
        this.mDetectRect = new Rect();
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mDisplayWidth = 0;
        this.mDisplayHeight = 0;
        this.mIsPreviewing = false;
        this.mIsCollectingBackFrame = false;
        this.mFrameStackCounter = 0;
        this.mBackFrameCount = 0;
        this.mBackCameraError = false;
        this.mImageCount = 1;
        this.mBitmapTimestamp = 0L;
        this.mNetworkType = -1;
        this.mFaceInfoMap = new HashMap();
        this.mLastFaceInfoTimestamp = 0L;
        this.mBeginRecordTimestamp = 0L;
        this.mRecordStartTime = 0L;
        this.mSrcFileExsist = false;
        this.mTimer = null;
        this.mManager = faceLivenessProcessManager;
        this.mContext = activity.getApplicationContext();
        this.mActivity = activity;
        this.mPreviewTextureView = textureView;
        if (textureView != null) {
            this.mTextureHeight = textureView.getLayoutParams().height;
            this.mTextureWidth = this.mPreviewTextureView.getLayoutParams().width;
        }
        this.mCallback = faceProcessCallback;
        this.mDeviceCheckTimeout = i;
        SdkFacePrivateConfig sdkFacePrivateConfig = SdkFacePrivateConfig.getInstance(this.mContext);
        this.mConfig = sdkFacePrivateConfig;
        this.mInterval = sdkFacePrivateConfig.getFaceInfoInterval();
        this.mFaceProcessInfo = iFaceProcessInfo;
        this.mLiveness = z;
        this.mRecordManager = MediaRecordManager.getInstance(this.mContext);
        this.mMediaDirPath = new File(this.mContext.getFilesDir(), "record_tmp_dir").getAbsolutePath();
        this.mRecord = z2;
        this.mImageCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildFaceInfos() {
        JSONObject parseFaceInfo;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, this)) == null) {
            try {
                if (this.mFaceInfoMap == null || this.mFaceInfoMap.size() <= 0) {
                    return "";
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Long, FaceInfo> entry : this.mFaceInfoMap.entrySet()) {
                    long longValue = entry.getKey().longValue();
                    FaceInfo value = entry.getValue();
                    if (longValue > 0 && (parseFaceInfo = parseFaceInfo(value)) != null) {
                        jSONObject.put(String.valueOf(longValue), parseFaceInfo);
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void collectBackFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65604, this) == null) {
            synchronized (this) {
                if (!this.mBackCameraError && !this.mCancel) {
                    this.mBackFrameCount++;
                    this.mIsCollectingBackFrame = true;
                    startBackCameraPreview();
                    if (!this.mBackCameraError) {
                        try {
                            wait(2000L);
                        } catch (InterruptedException e) {
                            CommonMethods.handleNuLException(e);
                        }
                    }
                    this.mIsCollectingBackFrame = false;
                }
            }
        }
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
        if (interceptable != null && (invokeL = interceptable.invokeL(65605, this, context)) != null) {
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
    public Map<Long, String> getBestImages(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        InterceptResult invokeLL;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65606, this, hashMap, hashMap2)) == null) {
            try {
                if (this.mFaceConfig.getOutputImageType() == 0) {
                    hashMap = hashMap2;
                }
                if (hashMap == null || hashMap.size() <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                        InterceptResult invokeLL2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry, entry2)) == null) ? Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2])) : invokeLL2.intValue;
                    }
                });
                if (arrayList.size() > 0) {
                    int i = this.mImageCount;
                    if (i < 0) {
                        i = 1;
                    }
                    if (i > arrayList.size()) {
                        i = arrayList.size();
                    }
                    HashMap hashMap3 = new HashMap();
                    for (int i2 = 0; i2 < i; i2++) {
                        String[] split = ((String) ((Map.Entry) arrayList.get(i2)).getKey()).split("_");
                        if (split.length > 3) {
                            currentTimeMillis = Long.valueOf(split[3]).longValue();
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        if (this.mBitmapTimestamp == 0) {
                            this.mBitmapTimestamp = currentTimeMillis;
                        }
                        String secBase64 = ((ImageInfo) ((Map.Entry) arrayList.get(i2)).getValue()).getSecBase64();
                        if (!TextUtils.isEmpty(secBase64)) {
                            secBase64 = secBase64.replace("\n", "").replace("\t", "").replace("\r", "");
                        }
                        hashMap3.put(Long.valueOf(currentTimeMillis), secBase64);
                    }
                    return hashMap3;
                }
                return null;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Map) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            this.mFaceConfig = FaceSDKManager.getInstance().getFaceConfig();
            this.mIsEnableSound = ((AudioManager) this.mContext.getSystemService("audio")).getStreamVolume(3) > 0 ? this.mFaceConfig.isSound() : false;
            if (this.mLiveness) {
                if (this.mFaceLivenessCallback == null) {
                    this.mFaceLivenessCallback = new FaceLivenessStrategyCallback();
                }
            } else if (this.mFaceDetectCallback == null) {
                this.mFaceDetectCallback = new FaceDetectStrategyCallback();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mDisplayWidth = displayMetrics.widthPixels;
            this.mDisplayHeight = displayMetrics.heightPixels;
            this.mCollectFirstFrame = this.mConfig.getFirstFrameFlag();
            this.mCollectBackFrame = this.mConfig.getBackFrameFlag();
            setSurfaceTextureCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyCollectBackFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65608, this) == null) {
            synchronized (this) {
                try {
                    notifyAll();
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera openCamera(boolean z) {
        InterceptResult invokeZ;
        int numberOfCameras;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65609, this, z)) == null) {
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

    private JSONObject parseFaceInfo(FaceInfo faceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, this, faceInfo)) == null) {
            if (faceInfo == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("faceID", faceInfo.faceID);
                jSONObject.put("centerX", faceInfo.centerX);
                jSONObject.put("centerY", faceInfo.centerY);
                jSONObject.put("width", faceInfo.width);
                jSONObject.put("height", faceInfo.height);
                jSONObject.put("angle", faceInfo.angle);
                jSONObject.put("score", faceInfo.score);
                String str = "";
                jSONObject.put("landmarks", faceInfo.landmarks == null ? "" : Arrays.toString(faceInfo.landmarks));
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.p, faceInfo.yaw);
                jSONObject.put("roll", faceInfo.roll);
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.q, faceInfo.pitch);
                jSONObject.put("bluriness", faceInfo.bluriness);
                jSONObject.put("illum", faceInfo.illum);
                double d = 0.0d;
                jSONObject.put("occlusion_leftEye", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.leftEye);
                jSONObject.put("occlusion_rightEye", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.rightEye);
                jSONObject.put("occlusion_leftCheek", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.leftCheek);
                jSONObject.put("occlusion_rightCheek", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.rightCheek);
                jSONObject.put("occlusion_mouth", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.mouth);
                jSONObject.put("occlusion_nose", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.nose);
                if (faceInfo.occlusion != null) {
                    d = faceInfo.occlusion.chin;
                }
                jSONObject.put("occlusion_chin", d);
                jSONObject.put("age", faceInfo.age);
                jSONObject.put("race", faceInfo.race == null ? "" : faceInfo.race.name());
                jSONObject.put("glasses", faceInfo.glasses == null ? "" : faceInfo.glasses.name());
                jSONObject.put("gender", faceInfo.gender == null ? "" : faceInfo.gender.name());
                jSONObject.put("emotionThree", faceInfo.emotionThree == null ? "" : faceInfo.emotionThree.name());
                if (faceInfo.emotionSeven != null) {
                    str = faceInfo.emotionSeven.name();
                }
                jSONObject.put("emotionSeven", str);
                jSONObject.put("mouthclose", faceInfo.mouthclose);
                jSONObject.put("leftEyeclose", faceInfo.leftEyeclose);
                jSONObject.put("rightEyeclose", faceInfo.rightEyeclose);
                return jSONObject;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65611, this, i) == null) {
            try {
                this.mIsCompletion = true;
                this.mCancel = true;
                this.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;
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
                if (this.mRecordManager != null && this.mRecording) {
                    this.mRecordManager.cancelRecorder();
                }
                if (this.mTimer != null) {
                    this.mTimer.cancel();
                    this.mTimer = null;
                }
                stopPreview();
                releaseBackCamera();
                if (this.mIsPluginCollectingSensor) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.mFaceAuthId, Boolean.TRUE, buildFaceInfos());
                    this.mIsPluginCollectingSensor = false;
                }
                if (this.mPreviewTextureView != null) {
                    this.mPreviewTextureView.setSurfaceTextureListener(null);
                    this.mPreviewTextureView = null;
                }
                this.mActivity = null;
                if (this.mManager != null) {
                    this.mManager.processEnd(this);
                    this.mManager = null;
                }
                if (this.mBitmapMap != null) {
                    this.mBitmapMap.clear();
                    this.mBitmapMap = null;
                }
                ReportUtil.reportProcessKeyPoint(this.mContext, this.mFaceAuthId, 2, i, null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    private JSONObject rebuildJsonArray(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65612, this, jSONObject, str)) == null) {
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
                                } else if (longValue <= this.mBitmapTimestamp) {
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
    public void removePlaintext(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65613, this, hashMap, hashMap2) == null) {
            if (hashMap != null) {
                try {
                    if (hashMap.size() > 0) {
                        for (ImageInfo imageInfo : hashMap.values()) {
                            imageInfo.setBase64("");
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    return;
                }
            }
            if (hashMap2 == null || hashMap2.size() <= 0) {
                return;
            }
            for (ImageInfo imageInfo2 : hashMap2.values()) {
                imageInfo2.setBase64("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject selectClosestSensorData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, this, jSONObject)) == null) {
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
    public void setSurfaceTextureCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
            try {
                if (this.mPreviewTextureView != null) {
                    this.mPreviewTextureView.setSurfaceTextureListener(this);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    private void startBackCameraPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65616, this) == null) {
            try {
                this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
                                this.this$0.mBackCameraError = false;
                                if (this.this$0.mPreviewTextureView != null) {
                                    this.this$0.mPreviewTextureView.setSurfaceTextureListener(this.this$0);
                                }
                                if (this.this$0.mBackCamera == null) {
                                    this.this$0.mBackCamera = this.this$0.openCamera(false);
                                }
                                if (this.this$0.mBackCamera == null) {
                                    this.this$0.mBackCameraError = true;
                                    this.this$0.notifyCollectBackFrame();
                                    return;
                                }
                                if (this.this$0.mBackCameraParam == null) {
                                    this.this$0.mBackCameraParam = this.this$0.mBackCamera.getParameters();
                                }
                                this.this$0.mBackCamera.stopPreview();
                                this.this$0.mBackCameraParam.setPictureFormat(256);
                                int displayOrientation = this.this$0.displayOrientation(this.this$0.mContext);
                                this.this$0.mBackCamera.setDisplayOrientation(displayOrientation);
                                this.this$0.mBackCameraParam.set("rotation", displayOrientation);
                                this.this$0.mPreviewDegree.set(displayOrientation);
                                Point bestVideoForSameSize = CameraPreviewUtils.getBestVideoForSameSize(this.this$0.mBackCameraParam, this.this$0.mTextureHeight, this.this$0.mTextureWidth);
                                this.this$0.mPreviewWidth = bestVideoForSameSize.x;
                                this.this$0.mPreviewHight = bestVideoForSameSize.y;
                                this.this$0.mBackCameraParam.setPreviewSize(this.this$0.mPreviewWidth, this.this$0.mPreviewHight);
                                this.this$0.mBackCamera.setParameters(this.this$0.mBackCameraParam);
                                if (this.this$0.mPreviewTextureView != null) {
                                    this.this$0.mBackCamera.setPreviewTexture(this.this$0.mPreviewTextureView.getSurfaceTexture());
                                } else {
                                    this.this$0.mBackCamera.setPreviewTexture(null);
                                }
                                BackCameraCallback backCameraCallback = new BackCameraCallback();
                                this.this$0.mBackCamera.setErrorCallback(backCameraCallback);
                                this.this$0.mBackCamera.setPreviewCallback(backCameraCallback);
                                if (this.this$0.mCancel) {
                                    return;
                                }
                                this.this$0.mBackCamera.startPreview();
                            } catch (Throwable th) {
                                CommonMethods.handleNuLException(th);
                                this.this$0.mBackCameraError = true;
                                this.this$0.notifyCollectBackFrame();
                                this.this$0.releaseBackCamera();
                                ReportUtil.reportProcessException(this.this$0.mContext, this.this$0.mFaceAuthId, 5, th);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                this.mBackCameraError = true;
                notifyCollectBackFrame();
                releaseBackCamera();
                ReportUtil.reportProcessException(this.mContext, this.mFaceAuthId, 5, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65617, this) == null) {
            try {
                this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
                                int displayOrientation = this.this$0.displayOrientation(this.this$0.mContext);
                                this.this$0.mCamera.setDisplayOrientation(displayOrientation);
                                this.this$0.mCameraParam.set("rotation", displayOrientation);
                                this.this$0.mPreviewDegree.set(displayOrientation);
                                Point bestVideoForSameSize = CameraPreviewUtils.getBestVideoForSameSize(this.this$0.mCameraParam, this.this$0.mTextureHeight, this.this$0.mTextureWidth);
                                this.this$0.mPreviewWidth = bestVideoForSameSize.x;
                                this.this$0.mPreviewHight = bestVideoForSameSize.y;
                                if (this.this$0.mLiveness) {
                                    if (this.this$0.mILivenessStrategy != null) {
                                        this.this$0.mILivenessStrategy.setPreviewDegree(this.this$0.mPreviewDegree.get());
                                    }
                                } else if (this.this$0.mIDetectStrategy != null) {
                                    this.this$0.mIDetectStrategy.setPreviewDegree(this.this$0.mPreviewDegree.get());
                                }
                                this.this$0.mPreviewRect.set(0, 0, this.this$0.mPreviewHight, this.this$0.mPreviewWidth);
                                this.this$0.getPreviewDetectRect(this.this$0.mDisplayWidth, this.this$0.mPreviewHight, this.this$0.mPreviewWidth);
                                this.this$0.mCameraParam.setPreviewSize(this.this$0.mPreviewWidth, this.this$0.mPreviewHight);
                                this.this$0.mCamera.setParameters(this.this$0.mCameraParam);
                                if (this.this$0.mCallback != null) {
                                    this.this$0.mCallback.onConfigCamera(this.this$0.mCamera, this.this$0.mPreviewRect, this.this$0.mDetectRect, this.this$0.mPreviewDegree);
                                }
                                this.this$0.mPreviewWidth = this.this$0.mCameraParam.getPreviewSize().width;
                                this.this$0.mPreviewHight = this.this$0.mCameraParam.getPreviewSize().height;
                                this.this$0.mCamera.setErrorCallback(this.this$0);
                                if (this.this$0.mPreviewTextureView != null && this.this$0.mPreviewTextureView.isAvailable()) {
                                    this.this$0.setSurfaceTextureCallback();
                                    this.this$0.mCamera.setPreviewTexture(this.this$0.mPreviewTextureView.getSurfaceTexture());
                                }
                                if (this.this$0.mCancel) {
                                    return;
                                }
                                this.this$0.mCamera.startPreview();
                                this.this$0.mIsPreviewing = true;
                                if (this.this$0.mFrameStackCounter > 0) {
                                    this.this$0.mFrameStackCounter = 0;
                                }
                                this.this$0.mDecodeThread = new DecodeThread();
                                this.this$0.mDecodeThread.start();
                                if (this.this$0.mRecord) {
                                    this.this$0.startRecord();
                                    if (this.this$0.mTimer == null) {
                                        this.this$0.mTimer = new Timer();
                                    }
                                    this.this$0.mTimer.schedule(new TimerTask(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.3.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass3 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.util.TimerTask, java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                this.this$1.this$0.stopRecord();
                                            }
                                        }
                                    }, 20000L);
                                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public int startRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, this)) == null) {
            if (this.mRecording) {
                return -2;
            }
            if (this.mCamera == null) {
                return -4;
            }
            this.mBeginRecordTimestamp = System.currentTimeMillis();
            if (this.mRecordManager.startRecord(this.mCamera, this.mMediaDirPath, this.mCameraId, new IRecCallback(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
            }
            this.mRecording = true;
            ReportUtil.reportProcessKeyPoint(this.mContext, this.mFaceAuthId, 102, 0, null);
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65619, this)) == null) {
            if (this.mRecording) {
                this.mRecording = false;
                if (System.currentTimeMillis() - this.mRecordStartTime < 2000) {
                    this.mRecordManager.cancelRecorder();
                    return -7;
                }
                String stopRecord = this.mRecordManager.stopRecord();
                this.mMediaFilePath = stopRecord;
                if (!TextUtils.isEmpty(stopRecord) && new File(this.mMediaFilePath).exists()) {
                    this.mSrcFileExsist = true;
                    return 1;
                }
                processEnd(-7);
                this.mSrcFileExsist = false;
                return -8;
            }
            return -3;
        }
        return invokeV.intValue;
    }

    public int buildData(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        byte[] bArr;
        byte[] bArr2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("f_i", this.mFaceAuthId);
                JSONObject jSONObject5 = new JSONObject();
                if (this.mRecord) {
                    File file = new File(this.mMediaFilePath);
                    if (file.exists()) {
                        byte[][] transform = MP4Transform.transform(RecordHelper.toByteArray(file));
                        file.delete();
                        if (transform != null && transform.length == 2) {
                            byte[] bArr3 = transform[1];
                            byte[] bArr4 = transform[0];
                            if (bArr4 != null && bArr4.length != 0) {
                                if (bArr3 != null && bArr3.length != 0) {
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject2 = jSONObject3;
                                    jSONObject6.put("transcheckdata", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.mContext, bArr4), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                    jSONObject5.put("video", jSONObject6);
                                    bArr = bArr3;
                                } else {
                                    throw new RuntimeException("empty mediaData");
                                }
                            } else {
                                throw new RuntimeException("empty mediaSafeInfo");
                            }
                        } else {
                            throw new RuntimeException("transformResult unexpected");
                        }
                    } else {
                        throw new RuntimeException("mediaFile not exists");
                    }
                } else {
                    jSONObject2 = jSONObject3;
                    bArr = null;
                }
                jSONObject4.put("t_c", this.mBitmapTimestamp);
                if (!this.mCollectFirstFrame || this.mFirstFrameBitmap == null) {
                    bArr2 = bArr;
                } else {
                    bArr2 = bArr;
                    jSONObject4.put("d_f", Base64.encodeToString(BitmapUtils.scale(this.mFirstFrameBitmap, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                    this.mFirstFrameBitmap.recycle();
                    this.mFirstFrameBitmap = null;
                }
                if (!this.mCollectBackFrame || this.mBackFrame1Data == null || this.mBackFrame1Data.length <= 0) {
                    str = "-";
                } else {
                    str = "-";
                    jSONObject4.put("d_p", Base64.encodeToString(BitmapUtils.nv21ToBitmap(this.mContext, this.mBackFrame1Data, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (this.mCollectBackFrame && this.mBackFrame2Data != null && this.mBackFrame2Data.length > 0) {
                    jSONObject4.put("d_a", Base64.encodeToString(BitmapUtils.nv21ToBitmap(this.mContext, this.mBackFrame2Data, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (jSONObject != null) {
                    jSONObject4.put("s", jSONObject);
                }
                JSONObject buildJson = this.mFaceProcessInfo != null ? this.mFaceProcessInfo.buildJson() : null;
                if (buildJson == null) {
                    buildJson = new JSONObject();
                }
                JSONObject jSONObject7 = buildJson;
                if (this.mBitmapMap.size() == 1) {
                    jSONObject7.put("image", this.mBitmapMap.values().iterator().next());
                } else if (this.mBitmapMap.size() >= 2) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : this.mBitmapMap.values()) {
                        jSONArray.put(str2);
                    }
                    jSONObject7.put("images", jSONArray);
                }
                jSONObject7.put("image_type", FaceEnum.ImageType.BASE64.name());
                jSONObject7.put("image_sec", true);
                jSONObject7.put("risk_identify", true);
                jSONObject7.put("app", "android");
                jSONObject5.put("face", jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("zid", FH.gzfi(this.mContext, "", 5002));
                jSONObject8.put(Config.EVENT_PART, "face");
                jSONObject8.put(NotificationStyle.NOTIFICATION_STYLE, this.mNetworkType);
                jSONObject8.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis());
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    jSONObject8.put("tz", timeZone.getID());
                }
                if (this.mCetificateInfo != null) {
                    jSONObject8.put("ce", this.mCetificateInfo);
                }
                jSONObject5.put("risk", jSONObject8);
                jSONObject4.put("e", jSONObject5);
                String licenseId = FaceLivenessProcessManager.getLicenseId();
                if (!TextUtils.isEmpty(licenseId)) {
                    String str3 = str;
                    String[] split = licenseId.split(str3);
                    if (split.length >= 3) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < split.length - 3; i++) {
                            sb.append(split[i]);
                            sb.append(str3);
                        }
                        sb.append(split[split.length - 3]);
                        licenseId = sb.toString();
                    }
                }
                JSONObject jSONObject9 = jSONObject2;
                jSONObject9.put("licenseId", licenseId);
                jSONObject9.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.mContext, jSONObject4.toString().getBytes()), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                jSONObject9.put("app", "android");
                String packageName = this.mContext.getPackageName();
                if (packageName != null) {
                    jSONObject9.put("pkg", packageName);
                    Signature[] signatureArr = this.mContext.getPackageManager().getPackageInfo(packageName, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        jSONObject9.put("sign", MD5Util.getMD5(signatureArr[0].toByteArray()));
                    }
                }
                this.mResult = EncryptConnFaceServerUtil.buildRequestInfo(this.mContext, jSONObject9.toString(), bArr2, this.mMediaDirPath);
                return 1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.sofire.facesrc.IFaceProcess
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.mCancel) {
                    return;
                }
                this.mCancel = true;
                FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.mFaceAuthId, Boolean.TRUE, "");
                processEnd(-6);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.pass.face.platform.listener.ISecurityCallback
    public void getFaceInfoForSecurity(FaceInfo[] faceInfoArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceInfoArr) == null) || faceInfoArr == null) {
            return;
        }
        try {
            if (faceInfoArr.length == 0 || this.mInterval == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastFaceInfoTimestamp >= this.mInterval && this.mFaceInfoMap != null) {
                this.mFaceInfoMap.put(Long.valueOf(currentTimeMillis), faceInfoArr[0]);
                this.mLastFaceInfoTimestamp = currentTimeMillis;
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void getPreviewDetectRect(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
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
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, camera) == null) || this.mSrcFileExsist) {
            return;
        }
        processEnd(-5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i, i2) == null) {
            this.mIsCreateSurface = true;
            if (this.mCancel || surfaceTexture == null) {
                return;
            }
            TextureView textureView = this.mPreviewTextureView;
            if (textureView != null) {
                this.mTextureHeight = textureView.getHeight();
                this.mTextureWidth = this.mPreviewTextureView.getWidth();
            }
            Camera camera = this.mCamera;
            if (camera != null) {
                try {
                    camera.setPreviewTexture(surfaceTexture);
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, surfaceTexture)) == null) {
            this.mIsCreateSurface = false;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, surfaceTexture, i, i2) == null) {
            this.mSurfaceWidth = i;
            this.mSurfaceHeight = i2;
            if (this.mCancel || surfaceTexture == null) {
                return;
            }
            if (this.mIsPreviewing) {
                startPreview();
            } else if (this.mIsCollectingBackFrame) {
                startBackCameraPreview();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture) == null) {
            try {
                if (this.mIsCompletion || this.mCancel || this.mFrameStackCounter > 0 || this.mPreviewTextureView == null) {
                    return;
                }
                Bitmap bitmap = this.mPreviewTextureView.getBitmap();
                this.mBitmap = bitmap;
                if (this.mCollectFirstFrame && this.mFirstFrameBitmap == null) {
                    this.mFirstFrameBitmap = bitmap;
                }
                if (this.mILivenessStrategy == null && !this.mIsCompletion && !this.mCancel) {
                    if (!FaceLivenessProcessManager.checkFaceSdkInit()) {
                        processEnd(-20);
                    }
                    if (this.mViewCallback == null) {
                        this.mViewCallback = new FaceLivenessViewCallback();
                    }
                    ILivenessStrategy livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this.mViewCallback);
                    this.mILivenessStrategy = livenessStrategyModule;
                    livenessStrategyModule.setISecurityCallback(this);
                    this.mILivenessStrategy.setPreviewDegree(this.mPreviewDegree.get());
                    this.mILivenessStrategy.setLivenessStrategySoundEnable(this.mIsEnableSound);
                    this.mILivenessStrategy.setLivenessStrategyConfig(this.mFaceConfig.getLivenessTypeList(), this.mPreviewRect, this.mDetectRect, this.mFaceLivenessCallback);
                }
                this.mFrameStackCounter++;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                ReportUtil.reportProcessException(this.mContext, this.mFaceAuthId, 3, th);
                processEnd(-11);
            }
        }
    }

    public void releaseBackCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                if (this.mActivity != null) {
                    this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
                                    this.this$0.mIsCollectingBackFrame = false;
                                    if (this.this$0.mBackCamera != null) {
                                        this.this$0.mBackCamera.setErrorCallback(null);
                                        this.this$0.mBackCamera.setPreviewCallback(null);
                                        this.this$0.mBackCamera.stopPreview();
                                        CameraUtils.releaseCamera(this.this$0.mBackCamera);
                                        this.this$0.mBackCamera = null;
                                    }
                                    if (this.this$0.mPreviewTextureView != null) {
                                        this.this$0.mPreviewTextureView.setSurfaceTextureListener(null);
                                    }
                                } catch (Throwable th) {
                                    CommonMethods.handleNuLException(th);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.facesrc.IFaceProcess
    public void setSoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            try {
                if (this.mLiveness && !this.mCancel) {
                    if (this.mILivenessStrategy != null) {
                        this.mILivenessStrategy.setLivenessStrategySoundEnable(z);
                    }
                } else if (this.mIDetectStrategy != null) {
                    this.mIDetectStrategy.setDetectStrategySoundEnable(z);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    @Override // com.baidu.sofire.facesrc.IFaceProcess
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                if (ThreadPoolManager.getInstance(this.mContext).executeCore(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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

                    /* JADX WARN: Removed duplicated region for block: B:47:0x010c A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
                    /* JADX WARN: Removed duplicated region for block: B:62:0x0142 A[Catch: all -> 0x01b2, TryCatch #0 {all -> 0x01b2, blocks: (B:5:0x0007, B:8:0x0010, B:11:0x0024, B:13:0x003d, B:15:0x0045, B:16:0x0053, B:18:0x0059, B:20:0x0065, B:22:0x006d, B:25:0x0076, B:28:0x0087, B:30:0x008f, B:45:0x0104, B:50:0x0111, B:55:0x0121, B:57:0x0129, B:59:0x0131, B:62:0x0142, B:65:0x014a, B:67:0x0150, B:70:0x0159, B:73:0x0167, B:75:0x016f, B:77:0x0177, B:78:0x017c, B:81:0x0185, B:83:0x018d, B:85:0x0195, B:86:0x01a3, B:89:0x01ac, B:31:0x00b1, B:33:0x00bd, B:35:0x00c5, B:37:0x00e9, B:39:0x00f3), top: B:97:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:64:0x0148  */
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
                            this.this$0.mFaceAuthId = FaceId.getFaceAuthId("5");
                            if (this.this$0.mCancel) {
                                return;
                            }
                            ReportUtil.reportProcessKeyPoint(this.this$0.mContext, this.this$0.mFaceAuthId, 1, 0, null);
                            if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                                this.this$0.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.1.1
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
                                                this.this$0.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.1.2
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
                                                if (this.this$0.mCollectBackFrame && !this.this$0.mBackCameraError) {
                                                    this.this$0.collectBackFrame();
                                                }
                                                if (this.this$0.mCancel) {
                                                    return;
                                                }
                                                if (this.this$0.mCallback != null && this.this$0.mActivity != null) {
                                                    this.this$0.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.1.3
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
                                                            this.this$1.this$0.mCallback.onBeginCollectFaceInfo();
                                                        }
                                                    });
                                                }
                                                if (this.this$0.mCancel) {
                                                    return;
                                                }
                                                this.this$0.startPreview();
                                                return;
                                            }
                                        }
                                        i = -1;
                                        if (this.this$0.mCallback != null) {
                                            this.this$0.mActivity.runOnUiThread(new Runnable(this, i) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.1.2
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
                ThreadPoolManager.getInstance(this.mContext).execute(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
                            FaceTextureLivenessProcess faceTextureLivenessProcess = this.this$0;
                            faceTextureLivenessProcess.mNetworkType = HttpCetificateUtil.getNetWorkType(faceTextureLivenessProcess.mContext);
                            FaceTextureLivenessProcess faceTextureLivenessProcess2 = this.this$0;
                            faceTextureLivenessProcess2.mCetificateInfo = HttpCetificateUtil.getHttpCetificate(faceTextureLivenessProcess2.mContext);
                        }
                    }
                });
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void stopPreview() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                this.mActivity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.facesrc.FaceTextureLivenessProcess.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FaceTextureLivenessProcess this$0;

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
                                if (this.this$0.mPreviewTextureView != null) {
                                    this.this$0.mPreviewTextureView.setSurfaceTextureListener(null);
                                }
                                if (this.this$0.mLiveness) {
                                    if (this.this$0.mILivenessStrategy != null) {
                                        this.this$0.mILivenessStrategy.reset();
                                        this.this$0.mILivenessStrategy = null;
                                    }
                                } else if (this.this$0.mIDetectStrategy != null) {
                                    this.this$0.mIDetectStrategy.reset();
                                    this.this$0.mIDetectStrategy = null;
                                }
                                if (this.this$0.mDecodeThread != null) {
                                    this.this$0.mDecodeThread.running = false;
                                    this.this$0.mDecodeThread.interrupt();
                                    this.this$0.mDecodeThread = null;
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
}
