package com.baidu.fsg.face.liveness.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.face.base.d.b;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.base.d.g;
import com.baidu.fsg.face.liveness.utils.CameraUtils;
import com.baidu.fsg.face.liveness.utils.LivenessVideoState;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes5.dex */
public abstract class LivenessCameraBaseActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39963c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FaceProcessCallback f39964a;

    /* renamed from: b  reason: collision with root package name */
    public RecordCallback f39965b;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceView f39966d;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f39967e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f39968f;
    public String faceData;
    public b faceRectGroup;

    /* renamed from: g  reason: collision with root package name */
    public int f39969g;

    /* renamed from: h  reason: collision with root package name */
    public int f39970h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f39971i;
    public boolean isRecording;

    /* renamed from: j  reason: collision with root package name */
    public Rect f39972j;
    public boolean k;
    public LivenessVideoState livenessVideoState;
    public IVideoRecordProcess mProcess;
    public boolean permissionFlag;
    public String sKey;
    public String xDeviceId;

    /* loaded from: classes5.dex */
    public static class a implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                mediaPlayer.reset();
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public LivenessCameraBaseActivity() {
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
        this.livenessVideoState = new LivenessVideoState();
        this.f39964a = new FaceProcessCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessCameraBaseActivity f39975a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39975a = this;
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void animStop() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBegin() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    LogUtil.d("hello", "face onBegin called");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBeginBuildData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    LogUtil.d("hello", "face onBeginBuildData called");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onBeginCollectFaceInfo() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    LogUtil.d("hello", "face onBeginCollectFaceInfo");
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onCollectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i4)}) == null) {
                    this.f39975a.onRefreshView(faceStatusNewEnum, str, i4);
                    if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                        this.f39975a.livenessVideoState.currentCount = 2;
                    }
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onConfigCamera(Camera camera, Rect rect, Rect rect2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048581, this, camera, rect, rect2) == null) {
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.f39975a.f39969g, this.f39975a.f39970h);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewSize(similarRatioSize.width, similarRatioSize.height);
                    LogUtil.d("hello", "size.width:" + similarRatioSize.width + "size.height:" + similarRatioSize.height);
                    camera.setParameters(parameters);
                    this.f39975a.f39972j = new Rect(0, 0, similarRatioSize.height, similarRatioSize.width);
                    int width = this.f39975a.faceRectGroup.f39890a.width();
                    double doubleValue = new BigDecimal(Double.toString((double) this.f39975a.faceRectGroup.f39890a.height())).divide(new BigDecimal(Double.toString((double) this.f39975a.f39970h)), 10, 4).doubleValue();
                    double doubleValue2 = new BigDecimal(Double.toString((double) width)).divide(new BigDecimal(Double.toString((double) this.f39975a.f39969g)), 10, 4).doubleValue();
                    double height = (this.f39975a.f39972j.height() - (this.f39975a.f39972j.height() * doubleValue)) / 2.0d;
                    double width2 = (this.f39975a.f39972j.width() - (this.f39975a.f39972j.width() * doubleValue2)) / 2.0d;
                    double height2 = this.f39975a.f39972j.height() - height;
                    double width3 = this.f39975a.f39972j.width() - width2;
                    this.f39975a.f39971i = new Rect((int) width2, (int) height, (int) width3, (int) height2);
                    rect.set(this.f39975a.f39972j);
                    rect2.set(this.f39975a.f39971i);
                    LogUtil.d("hello", "face onConfigCamera:" + this.f39975a.f39972j.toString());
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onDeviceCheckResult(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048582, this, i4) == null) {
                    LogUtil.d("hello", "face onDeviceCheckResult:：" + i4);
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onEnd(int i4, RequestInfo requestInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048583, this, i4, requestInfo) == null) {
                    LogUtil.d("hello", "face onEnd called:" + i4);
                    if (i4 == -2) {
                        this.f39975a.buildDataError();
                    } else if (i4 == -3 || i4 == -4) {
                        this.f39975a.notTrustedDevice();
                    } else if (i4 == -5) {
                        this.f39975a.cameraException();
                    } else if (i4 == 1) {
                        LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39975a;
                        if (livenessCameraBaseActivity.livenessVideoState.currentCount == 2) {
                            try {
                                livenessCameraBaseActivity.xDeviceId = requestInfo.xDeviceId;
                                livenessCameraBaseActivity.sKey = requestInfo.sKey;
                                livenessCameraBaseActivity.faceData = requestInfo.data.getString("data");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            this.f39975a.dofaceMatch();
                            this.f39975a.d();
                        }
                    }
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onTestFrame(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048585, this, livenessTypeEnum) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void setFaceInfo(FaceExtInfo faceExtInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048586, this, faceExtInfo) == null) {
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void viewReset() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                }
            }
        };
        this.f39965b = new RecordCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessCameraBaseActivity f39976a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39976a = this;
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBegin() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LogUtil.d("hello", "video onBegin called");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBeginBuildData() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    LogUtil.d("hello", "video onBeginBuildData");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onBeginRecord() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    LogUtil.d("hello", "video onBeginRecord");
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onConfigCamera(Camera camera) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, camera) == null) {
                    LogUtil.d("hello", "video onConfigCamera");
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.f39976a.f39969g, this.f39976a.f39970h);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewSize(similarRatioSize.width, similarRatioSize.height);
                    LogUtil.d("hello", "size.width:" + similarRatioSize.width + "size.height:" + similarRatioSize.height);
                    camera.setParameters(parameters);
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onDeviceCheckResult(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    LogUtil.d("hello", "video onDeviceCheckResult:" + i4);
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onEnd(int i4, RequestInfo requestInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048581, this, i4, requestInfo) == null) {
                    if (i4 == -2) {
                        this.f39976a.buildDataError();
                    } else if (i4 == -3 || i4 == -4) {
                        this.f39976a.notTrustedDevice();
                    } else if (i4 == -5) {
                        this.f39976a.cameraException();
                    } else {
                        if (i4 == 1) {
                            try {
                                this.f39976a.xDeviceId = requestInfo.xDeviceId;
                                this.f39976a.sKey = requestInfo.sKey;
                                g.a(requestInfo.path);
                                this.f39976a.faceData = requestInfo.data.getString("data");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        LogUtil.d("hello", "video onEnd：" + i4);
                    }
                }
            }

            @Override // com.baidu.sofire.ac.RecordCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048582, this, bArr, camera) == null) {
                    this.f39976a.a(bArr, camera);
                }
            }
        };
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, activity, i2) == null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = Float.valueOf(i2).floatValue() * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }

    public abstract View a();

    public abstract void a(boolean z);

    public abstract void a(boolean z, boolean z2, boolean z3);

    public abstract void a(byte[] bArr, Camera camera);

    public abstract void b();

    public abstract void buildDataError();

    public abstract void cameraException();

    public abstract void dofaceMatch();

    public void getCameraPermission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessCameraBaseActivity f39973a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39973a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @TargetApi(23)
                    public void isAllAgree(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            if (z) {
                                LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39973a;
                                livenessCameraBaseActivity.permissionFlag = true;
                                livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                                return;
                            }
                            this.f39973a.a(false, false, true);
                        }
                    }
                });
            } else {
                e();
            }
        }
    }

    public abstract void notTrustedDevice();

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().addFlags(128);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            SurfaceView surfaceView = new SurfaceView(getActivity());
            this.f39966d = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            this.f39967e = holder;
            holder.setFormat(-2);
            this.f39967e.setType(3);
            addContentView(this.f39966d, layoutParams);
            addContentView(a(), layoutParams);
            this.faceRectGroup = new b();
            f.b(this, getResources().getColor(17170445));
            setBrightness(getActivity(), 255);
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            try {
                if (this.f39968f != null) {
                    this.f39968f.stop();
                    this.f39968f.release();
                }
            } catch (Exception e2) {
                d.a(e2);
            }
        }
    }

    public abstract void onRefreshView(FaceStatusNewEnum faceStatusNewEnum, String str, int i2);

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.permissionFlag = false;
            if (i2 == 2 && iArr.length == 2) {
                boolean z = iArr[0] == 0;
                boolean z2 = iArr[1] == 0;
                if (z && z2) {
                    e();
                } else {
                    a(z, z2, true);
                }
            }
        }
    }

    public void playSound(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            MediaPlayer mediaPlayer = this.f39968f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                MediaPlayer create = MediaPlayer.create(this, i2);
                this.f39968f = create;
                if (create == null) {
                    return;
                }
                create.setOnErrorListener(new a());
                setVolumeControlStream(3);
                this.f39968f.start();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f39966d.setVisibility(4);
            this.f39966d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mProcess = FH.getVideoRecordProcess(getActivity(), this.f39967e, this.f39965b, -1);
            String str = "get video process mProcess:" + this.mProcess;
            IVideoRecordProcess iVideoRecordProcess = this.mProcess;
            if (iVideoRecordProcess != null) {
                iVideoRecordProcess.prepare();
                LogUtil.d("hello", "video prepare");
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.livenessVideoState.currentState = 0;
            this.f39967e.addCallback(new SurfaceHolder.Callback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessCameraBaseActivity f39974a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39974a = this;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
                        this.f39974a.f39969g = i3;
                        this.f39974a.f39970h = i4;
                        LogUtil.d("hello", "face surfaceChanged,surWidth:" + i3 + ",surHeight:" + i4);
                        LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39974a;
                        LivenessVideoState livenessVideoState = livenessCameraBaseActivity.livenessVideoState;
                        if (livenessVideoState.currentState != 0) {
                            return;
                        }
                        livenessVideoState.currentState = 1;
                        livenessCameraBaseActivity.faceRectGroup.f39891b = new Rect(this.f39974a.f39966d.getLeft(), this.f39974a.f39966d.getTop(), this.f39974a.f39966d.getRight(), this.f39974a.f39966d.getBottom());
                        this.f39974a.b();
                        FH.startFaceVerify(this.f39974a.getActivity(), this.f39974a.f39967e, this.f39974a.f39964a, 0, null, false);
                        LogUtil.d("hello", "startFaceVerify");
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                    }
                }
            });
            c();
        }
    }
}
