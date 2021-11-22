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
/* loaded from: classes7.dex */
public abstract class LivenessCameraBaseActivity extends LivenessBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38722c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FaceProcessCallback f38723a;

    /* renamed from: b  reason: collision with root package name */
    public RecordCallback f38724b;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceView f38725d;

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f38726e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f38727f;
    public String faceData;
    public b faceRectGroup;

    /* renamed from: g  reason: collision with root package name */
    public int f38728g;

    /* renamed from: h  reason: collision with root package name */
    public int f38729h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f38730i;
    public boolean isRecording;
    public Rect j;
    public boolean k;
    public LivenessVideoState livenessVideoState;
    public IVideoRecordProcess mProcess;
    public boolean permissionFlag;
    public String sKey;
    public String xDeviceId;

    /* loaded from: classes7.dex */
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
        this.f38723a = new FaceProcessCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessCameraBaseActivity f38733a;

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
                this.f38733a = this;
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
                    this.f38733a.onRefreshView(faceStatusNewEnum, str, i4);
                    if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                        this.f38733a.livenessVideoState.currentCount = 2;
                    }
                }
            }

            @Override // com.baidu.sofire.ac.FaceProcessCallback
            public void onConfigCamera(Camera camera, Rect rect, Rect rect2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048581, this, camera, rect, rect2) == null) {
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.f38733a.f38728g, this.f38733a.f38729h);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewSize(similarRatioSize.width, similarRatioSize.height);
                    LogUtil.d("hello", "size.width:" + similarRatioSize.width + "size.height:" + similarRatioSize.height);
                    camera.setParameters(parameters);
                    this.f38733a.j = new Rect(0, 0, similarRatioSize.height, similarRatioSize.width);
                    int width = this.f38733a.faceRectGroup.f38651a.width();
                    double doubleValue = new BigDecimal(Double.toString((double) this.f38733a.faceRectGroup.f38651a.height())).divide(new BigDecimal(Double.toString((double) this.f38733a.f38729h)), 10, 4).doubleValue();
                    double doubleValue2 = new BigDecimal(Double.toString((double) width)).divide(new BigDecimal(Double.toString((double) this.f38733a.f38728g)), 10, 4).doubleValue();
                    double height = (this.f38733a.j.height() - (this.f38733a.j.height() * doubleValue)) / 2.0d;
                    double width2 = (this.f38733a.j.width() - (this.f38733a.j.width() * doubleValue2)) / 2.0d;
                    double height2 = this.f38733a.j.height() - height;
                    double width3 = this.f38733a.j.width() - width2;
                    this.f38733a.f38730i = new Rect((int) width2, (int) height, (int) width3, (int) height2);
                    rect.set(this.f38733a.j);
                    rect2.set(this.f38733a.f38730i);
                    LogUtil.d("hello", "face onConfigCamera:" + this.f38733a.j.toString());
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
                        this.f38733a.buildDataError();
                    } else if (i4 == -3 || i4 == -4) {
                        this.f38733a.notTrustedDevice();
                    } else if (i4 == -5) {
                        this.f38733a.cameraException();
                    } else if (i4 == 1) {
                        LivenessCameraBaseActivity livenessCameraBaseActivity = this.f38733a;
                        if (livenessCameraBaseActivity.livenessVideoState.currentCount == 2) {
                            try {
                                livenessCameraBaseActivity.xDeviceId = requestInfo.xDeviceId;
                                livenessCameraBaseActivity.sKey = requestInfo.sKey;
                                livenessCameraBaseActivity.faceData = requestInfo.data.getString("data");
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            this.f38733a.dofaceMatch();
                            this.f38733a.d();
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
        this.f38724b = new RecordCallback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LivenessCameraBaseActivity f38734a;

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
                this.f38734a = this;
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
                    Camera.Size similarRatioSize = CameraUtils.getSimilarRatioSize(camera.getParameters(), this.f38734a.f38728g, this.f38734a.f38729h);
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
                        this.f38734a.buildDataError();
                    } else if (i4 == -3 || i4 == -4) {
                        this.f38734a.notTrustedDevice();
                    } else if (i4 == -5) {
                        this.f38734a.cameraException();
                    } else {
                        if (i4 == 1) {
                            try {
                                this.f38734a.xDeviceId = requestInfo.xDeviceId;
                                this.f38734a.sKey = requestInfo.sKey;
                                g.a(requestInfo.path);
                                this.f38734a.faceData = requestInfo.data.getString("data");
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
                    this.f38734a.a(bArr, camera);
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
                    public final /* synthetic */ LivenessCameraBaseActivity f38731a;

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
                        this.f38731a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @TargetApi(23)
                    public void isAllAgree(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            if (z) {
                                LivenessCameraBaseActivity livenessCameraBaseActivity = this.f38731a;
                                livenessCameraBaseActivity.permissionFlag = true;
                                livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                                return;
                            }
                            this.f38731a.a(false, false, true);
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
            this.f38725d = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            this.f38726e = holder;
            holder.setFormat(-2);
            this.f38726e.setType(3);
            addContentView(this.f38725d, layoutParams);
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
                if (this.f38727f != null) {
                    this.f38727f.stop();
                    this.f38727f.release();
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
            MediaPlayer mediaPlayer = this.f38727f;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                MediaPlayer create = MediaPlayer.create(this, i2);
                this.f38727f = create;
                if (create == null) {
                    return;
                }
                create.setOnErrorListener(new a());
                setVolumeControlStream(3);
                this.f38727f.start();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f38725d.setVisibility(4);
            this.f38725d.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mProcess = FH.getVideoRecordProcess(getActivity(), this.f38726e, this.f38724b, -1);
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
            this.f38726e.addCallback(new SurfaceHolder.Callback(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessCameraBaseActivity f38732a;

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
                    this.f38732a = this;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
                        this.f38732a.f38728g = i3;
                        this.f38732a.f38729h = i4;
                        LogUtil.d("hello", "face surfaceChanged,surWidth:" + i3 + ",surHeight:" + i4);
                        LivenessCameraBaseActivity livenessCameraBaseActivity = this.f38732a;
                        LivenessVideoState livenessVideoState = livenessCameraBaseActivity.livenessVideoState;
                        if (livenessVideoState.currentState != 0) {
                            return;
                        }
                        livenessVideoState.currentState = 1;
                        livenessCameraBaseActivity.faceRectGroup.f38652b = new Rect(this.f38732a.f38725d.getLeft(), this.f38732a.f38725d.getTop(), this.f38732a.f38725d.getRight(), this.f38732a.f38725d.getBottom());
                        this.f38732a.b();
                        FH.startFaceVerify(this.f38732a.getActivity(), this.f38732a.f38726e, this.f38732a.f38723a, 0, null, false);
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
