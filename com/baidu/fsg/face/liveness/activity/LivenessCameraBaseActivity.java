package com.baidu.fsg.face.liveness.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.permission.DangerousPermissionManagerProxy;
import com.baidu.fsg.base.permission.RequestPermissionDialogCallBack;
import com.baidu.fsg.face.base.d.d;
import com.baidu.fsg.face.base.d.f;
import com.baidu.fsg.face.liveness.camera.LivenessCameraSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes5.dex */
public abstract class LivenessCameraBaseActivity extends LivenessBaseActivity implements Camera.PreviewCallback, SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final int f39909b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39910c = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f39911a;
    public com.baidu.fsg.face.liveness.camera.a cameraControl;

    /* renamed from: d  reason: collision with root package name */
    public int f39912d;

    /* renamed from: e  reason: collision with root package name */
    public LivenessCameraSurfaceView f39913e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f39914f;
    public com.baidu.fsg.face.base.d.b faceRectGroup;

    /* renamed from: g  reason: collision with root package name */
    public MediaPlayer f39915g;
    public boolean permissionFlag;

    /* loaded from: classes5.dex */
    public static class b implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        this.f39912d = 1;
        this.f39911a = false;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            this.f39913e.setVisibility(4);
            boolean a2 = this.cameraControl.a(getActivity(), true);
            this.f39913e.bindSurfaceView(this, this.cameraControl.f());
            this.f39913e.setVisibility(0);
            return a2;
        }
        return invokeV.booleanValue;
    }

    public static void setBrightness(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, activity, i2) == null) {
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

    public abstract void c();

    public abstract void d();

    @Override // com.baidu.fsg.face.liveness.activity.LivenessBaseActivity, com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().addFlags(128);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            LivenessCameraSurfaceView livenessCameraSurfaceView = new LivenessCameraSurfaceView(getActivity(), null);
            this.f39913e = livenessCameraSurfaceView;
            SurfaceHolder holder = livenessCameraSurfaceView.getHolder();
            this.f39914f = holder;
            holder.setFormat(-2);
            this.f39914f.setType(3);
            this.f39914f.addCallback(this);
            addContentView(this.f39913e, layoutParams);
            addContentView(a(), layoutParams);
            this.cameraControl = new com.baidu.fsg.face.liveness.camera.a();
            this.faceRectGroup = new com.baidu.fsg.face.base.d.b();
            f.b(this, getResources().getColor(17170445));
            setBrightness(getActivity(), 255);
        }
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            try {
                if (this.f39915g != null) {
                    this.f39915g.stop();
                    this.f39915g.release();
                }
            } catch (Exception e2) {
                d.a(e2);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, camera) == null) {
            a(bArr, camera);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            this.permissionFlag = false;
            if (i2 == 1) {
                if (iArr.length == 1) {
                    if (iArr[0] == 0) {
                        startVideoOrCamera();
                    } else {
                        a(true);
                    }
                }
            } else if (i2 == 2 && iArr.length == 2) {
                boolean z = iArr[0] == 0;
                boolean z2 = iArr[1] == 0;
                if (z && z2) {
                    startVideoOrCamera();
                } else {
                    a(z, z2, true);
                }
            }
        }
    }

    public void playSound(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            MediaPlayer mediaPlayer = this.f39915g;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                MediaPlayer create = MediaPlayer.create(this, i2);
                this.f39915g = create;
                if (create == null) {
                    return;
                }
                create.setOnErrorListener(new b());
                setVolumeControlStream(3);
                this.f39915g.start();
            }
        }
    }

    public void startRecod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f39913e.post(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessCameraBaseActivity f39918a;

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
                    this.f39918a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        new a().execute(new Void[0]);
                    }
                }
            });
        }
    }

    public void startVideoOrCamera() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f39912d == 0) {
                String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE};
                if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr)) {
                    DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ LivenessCameraBaseActivity f39916a;

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
                            this.f39916a = this;
                        }

                        @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                        @TargetApi(23)
                        public void isAllAgree(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                if (z) {
                                    LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39916a;
                                    livenessCameraBaseActivity.permissionFlag = true;
                                    livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
                                    return;
                                }
                                this.f39916a.a(true);
                            }
                        }
                    });
                    return;
                } else if (e()) {
                    c();
                    return;
                } else {
                    a(false);
                    return;
                }
            }
            String[] strArr2 = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE};
            if (!DangerousPermissionManagerProxy.getInstance().isPermissionGroupGranted(getActivity(), strArr2)) {
                DangerousPermissionManagerProxy.getInstance().requestPermissionsDialog(getActivity(), strArr2, new RequestPermissionDialogCallBack(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessCameraBaseActivity f39917a;

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
                        this.f39917a = this;
                    }

                    @Override // com.baidu.fsg.base.permission.RequestPermissionDialogCallBack
                    @TargetApi(23)
                    public void isAllAgree(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            if (z) {
                                LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39917a;
                                livenessCameraBaseActivity.permissionFlag = true;
                                livenessCameraBaseActivity.requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                                return;
                            }
                            this.f39917a.a(false, false, true);
                        }
                    }
                });
            } else if (e()) {
                c();
            } else {
                a(false, true, true);
            }
        }
    }

    public void startVideoOrCamera2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
                this.permissionFlag = true;
                requestPermissions(new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1);
            } else if (this.f39912d == 0) {
                if (e()) {
                    c();
                } else {
                    a(false);
                }
            } else if (e()) {
                if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(PermissionRequest.RESOURCE_AUDIO_CAPTURE) != 0) {
                    this.permissionFlag = true;
                    requestPermissions(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2);
                    return;
                }
                this.f39913e.post(new Runnable(this) { // from class: com.baidu.fsg.face.liveness.activity.LivenessCameraBaseActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LivenessCameraBaseActivity f39919a;

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
                        this.f39919a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            new a().execute(new Void[0]);
                        }
                    }
                });
            } else {
                a(false, true, true);
            }
        }
    }

    public void stopVideoOrCamera() {
        com.baidu.fsg.face.liveness.camera.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.f39912d;
            if (i2 == 0) {
                com.baidu.fsg.face.liveness.camera.a aVar2 = this.cameraControl;
                if (aVar2 != null) {
                    aVar2.d();
                }
            } else if (i2 != 1 || (aVar = this.cameraControl) == null) {
            } else {
                aVar.e();
                this.cameraControl.d();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048592, this, surfaceHolder, i2, i3, i4) == null) {
            this.faceRectGroup.f39837b = new Rect(this.f39913e.getLeft(), this.f39913e.getTop(), this.f39913e.getRight(), this.f39913e.getBottom());
            b();
            this.cameraControl.a((Camera.PreviewCallback) this);
            this.cameraControl.a(getActivity(), this.f39914f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceHolder) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surfaceHolder) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends AsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LivenessCameraBaseActivity f39920a;

        public a(LivenessCameraBaseActivity livenessCameraBaseActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {livenessCameraBaseActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39920a = livenessCameraBaseActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39920a;
                livenessCameraBaseActivity.f39911a = livenessCameraBaseActivity.cameraControl.a((Context) livenessCameraBaseActivity.getActivity());
                LivenessCameraBaseActivity livenessCameraBaseActivity2 = this.f39920a;
                livenessCameraBaseActivity2.cameraControl.a((Camera.PreviewCallback) livenessCameraBaseActivity2);
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onPostExecute(str);
                LivenessCameraBaseActivity livenessCameraBaseActivity = this.f39920a;
                if (livenessCameraBaseActivity.f39911a) {
                    livenessCameraBaseActivity.d();
                } else {
                    livenessCameraBaseActivity.a(true, false, false);
                }
            }
        }
    }
}
