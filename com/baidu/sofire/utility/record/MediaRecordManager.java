package com.baidu.sofire.utility.record;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class MediaRecordManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_CODE_FAIL_CODE_ERR = -3;
    public static final int STATUS_CODE_FAIL_NOSPACE = -4;
    public static final int STATUS_CODE_FAIL_PARAM_NULL = -1;
    public static final int STATUS_CODE_FAIL_PREPARE_ERR = -2;
    public static final int STATUS_CODE_FAIL_START = -5;
    public static final int STATUS_CODE_IS_RECORDING = 2;
    public static final int STATUS_CODE_NORMAL = 1;
    public static final String TAG = "MediaRecordManager";
    public static volatile MediaRecordManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean isRecording;
    public Context mContext;
    public MediaRecorder mMediaRecorder;
    public File mOutputFile;

    /* loaded from: classes4.dex */
    public static class CameraSize {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public int width;

        public CameraSize(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.width = i;
            this.height = i2;
        }
    }

    public MediaRecordManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isRecording = false;
        this.mContext = context;
    }

    public static synchronized MediaRecordManager getInstance(Context context) {
        InterceptResult invokeL;
        MediaRecordManager mediaRecordManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (MediaRecordManager.class) {
                if (sInstance == null) {
                    synchronized (MediaRecordManager.class) {
                        if (sInstance == null) {
                            sInstance = new MediaRecordManager(context);
                        }
                    }
                }
                mediaRecordManager = sInstance;
            }
            return mediaRecordManager;
        }
        return (MediaRecordManager) invokeL.objValue;
    }

    public void cancelRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.isRecording = false;
                if (this.mMediaRecorder != null) {
                    this.mMediaRecorder.release();
                    this.mMediaRecorder = null;
                }
                if (this.mOutputFile != null) {
                    this.mOutputFile.delete();
                    this.mOutputFile = null;
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public boolean prepare(Camera camera, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, camera, str, i)) == null) {
            try {
                int i2 = camera.getParameters().getPreviewSize().width;
                int i3 = camera.getParameters().getPreviewSize().height;
                camera.unlock();
                if (this.mMediaRecorder == null) {
                    this.mMediaRecorder = new MediaRecorder();
                }
                this.mMediaRecorder.reset();
                this.mMediaRecorder.setCamera(camera);
                this.mMediaRecorder.setAudioSource(1);
                this.mMediaRecorder.setVideoSource(1);
                this.mMediaRecorder.setOutputFormat(2);
                this.mMediaRecorder.setAudioEncoder(3);
                this.mMediaRecorder.setVideoEncoder(2);
                this.mMediaRecorder.setVideoSize(i2, i3);
                File outputMediaFile = RecordHelper.getOutputMediaFile(this.mContext, str);
                this.mOutputFile = outputMediaFile;
                this.mMediaRecorder.setOutputFile(outputMediaFile.getAbsolutePath());
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                this.mMediaRecorder.setOrientationHint(cameraInfo.orientation);
                this.mMediaRecorder.prepare();
                return true;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    public synchronized int startRecord(Camera camera, String str, int i, IRecCallback iRecCallback) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, camera, str, i, iRecCallback)) == null) {
            synchronized (this) {
                if (camera == null) {
                    return -1;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return -1;
                    }
                    if (RecordHelper.hasEnoughSpace(str)) {
                        if (this.isRecording) {
                            return 2;
                        }
                        this.isRecording = true;
                        if (!prepare(camera, str, i)) {
                            this.isRecording = false;
                            return -2;
                        }
                        new Thread(this, iRecCallback) { // from class: com.baidu.sofire.utility.record.MediaRecordManager.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaRecordManager this$0;
                            public final /* synthetic */ IRecCallback val$callback;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, iRecCallback};
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
                                this.val$callback = iRecCallback;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.this$0.mMediaRecorder != null) {
                                            this.this$0.mMediaRecorder.start();
                                        } else {
                                            this.this$0.isRecording = false;
                                        }
                                    } catch (Throwable th) {
                                        this.this$0.isRecording = false;
                                        IRecCallback iRecCallback2 = this.val$callback;
                                        if (iRecCallback2 != null) {
                                            iRecCallback2.onError(-5);
                                        }
                                        CommonMethods.handleNuLException(th);
                                    }
                                }
                            }
                        }.start();
                        return 1;
                    }
                    return -4;
                } catch (Exception e2) {
                    this.isRecording = false;
                    CommonMethods.handleNuLException(e2);
                    return -3;
                }
            }
        }
        return invokeLLIL.intValue;
    }

    public String stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.mMediaRecorder != null) {
                    this.mMediaRecorder.release();
                    this.mMediaRecorder = null;
                }
                this.isRecording = false;
                return this.mOutputFile != null ? this.mOutputFile.getAbsolutePath() : "";
            } catch (Throwable th) {
                this.isRecording = false;
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
