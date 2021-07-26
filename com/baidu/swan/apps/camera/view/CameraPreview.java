package com.baidu.swan.apps.camera.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.q;
import d.a.o0.t.d;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static Camera m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f10912e;

    /* renamed from: f  reason: collision with root package name */
    public MediaRecorder f10913f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceHolder f10914g;

    /* renamed from: h  reason: collision with root package name */
    public String f10915h;

    /* renamed from: i  reason: collision with root package name */
    public String f10916i;
    public String j;
    public d.a.o0.a.z.e.a k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Quality {
        public static final /* synthetic */ Quality[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Quality HIGH;
        public static final Quality LOW;
        public static final Quality NORMAL;
        public transient /* synthetic */ FieldHolder $fh;
        public int qualityInt;
        public String qualityName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1555531510, "Lcom/baidu/swan/apps/camera/view/CameraPreview$Quality;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1555531510, "Lcom/baidu/swan/apps/camera/view/CameraPreview$Quality;");
                    return;
                }
            }
            HIGH = new Quality("HIGH", 0, "high", 100);
            NORMAL = new Quality("NORMAL", 1, "normal", 70);
            Quality quality = new Quality("LOW", 2, Config.EXCEPTION_MEMORY_LOW, 40);
            LOW = quality;
            $VALUES = new Quality[]{HIGH, NORMAL, quality};
        }

        public Quality(String str, int i2, String str2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.qualityName = str2;
            this.qualityInt = i3;
        }

        public static int getQuality(String str) {
            InterceptResult invokeL;
            Quality[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                int qualityInt = NORMAL.getQualityInt();
                for (Quality quality : values()) {
                    if (TextUtils.equals(quality.getQualityName(), str)) {
                        return quality.qualityInt;
                    }
                }
                return qualityInt;
            }
            return invokeL.intValue;
        }

        public static Quality valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Quality) Enum.valueOf(Quality.class, str) : (Quality) invokeL.objValue;
        }

        public static Quality[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Quality[]) $VALUES.clone() : (Quality[]) invokeV.objValue;
        }

        public int getQualityInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.qualityInt : invokeV.intValue;
        }

        public String getQualityName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.qualityName : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Camera.PictureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.z.c.a f10918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f10919c;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0174a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f10920e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10921f;

            public RunnableC0174a(a aVar, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10921f = aVar;
                this.f10920e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int quality = Quality.getQuality(this.f10921f.f10919c.f10915h);
                    boolean z = this.f10921f.f10919c.getResources().getConfiguration().orientation == 1;
                    boolean z2 = this.f10921f.f10919c.getFrontOrBackCameraId() == 0;
                    if (z) {
                        i2 = z2 ? 90 : -90;
                    } else {
                        i2 = 0;
                    }
                    boolean h2 = d.a.o0.a.z.a.b().h(this.f10920e, this.f10921f.f10917a, quality, i2, !z2);
                    a aVar = this.f10921f;
                    d.a.o0.a.z.c.a aVar2 = aVar.f10918b;
                    if (aVar2 != null) {
                        if (h2) {
                            aVar2.onSuccess(aVar.f10917a);
                        } else {
                            aVar2.onFailure();
                        }
                    }
                }
            }
        }

        public a(CameraPreview cameraPreview, String str, d.a.o0.a.z.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10919c = cameraPreview;
            this.f10917a = str;
            this.f10918b = aVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                try {
                    camera.startPreview();
                    this.f10919c.setCameraDisplayOrientation();
                } catch (RuntimeException e2) {
                    if (this.f10919c.k != null) {
                        d.a.o0.a.z.a.b().e(this.f10919c.k.f43982g, this.f10919c.k.f43981f, false);
                    }
                    this.f10919c.h();
                    if (CameraPreview.l) {
                        e2.printStackTrace();
                    }
                }
                q.j(new RunnableC0174a(this, bArr), CommonTbJsBridge.SAVE_IMAGE);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f10922a;

        public b(CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10922a = cameraPreview;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) && CameraPreview.l) {
                Log.i("SwanAppCameraManager", "camera auto focus result : " + z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-836213787, "Lcom/baidu/swan/apps/camera/view/CameraPreview;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-836213787, "Lcom/baidu/swan/apps/camera/view/CameraPreview;");
                return;
            }
        }
        l = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPreview(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10915h = Quality.NORMAL.getQualityName();
        this.f10916i = "";
        this.j = "";
    }

    private CamcorderProfile getCamcorderProfile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = 5;
            if (!CamcorderProfile.hasProfile(5)) {
                i2 = CamcorderProfile.hasProfile(4) ? 4 : 1;
            }
            return CamcorderProfile.get(i2);
        }
        return (CamcorderProfile) invokeV.objValue;
    }

    private int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            Context context = getContext();
            int i2 = 0;
            if (context instanceof Activity) {
                int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 0) {
                    if (rotation == 1) {
                        i2 = 90;
                    } else if (rotation == 2) {
                        i2 = 180;
                    } else if (rotation == 3) {
                        i2 = 270;
                    }
                }
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(getFrontOrBackCameraId(), cameraInfo);
                if (cameraInfo.facing == 1) {
                    return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                }
                return ((cameraInfo.orientation - i2) + 360) % 360;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFrontOrBackCameraId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            d.a.o0.a.z.e.a aVar = this.k;
            return (aVar == null || !aVar.m()) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public static void j() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (camera = m) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        m.stopPreview();
        m.release();
        m = null;
    }

    private void setSaveMediaPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            this.f10916i = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
            this.j = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
            d.h(new File(this.f10916i));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10916i = "";
            this.j = "";
        }
    }

    public final Camera.Size f(List<Camera.Size> list, int i2, int i3) {
        InterceptResult invokeLII;
        float f2;
        float f3;
        int i4;
        float f4;
        int i5;
        float f5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2, i3)) == null) {
            Camera.Size size = null;
            if (list != null && !list.isEmpty() && i3 != 0) {
                float f6 = i2 / i3;
                float f7 = -1.0f;
                boolean z = getDegree() % 180 == 0;
                Camera.Size size2 = null;
                for (Camera.Size size3 : list) {
                    if (size3 != null) {
                        if (z) {
                            f4 = size3.width;
                            i5 = size3.height;
                        } else {
                            f4 = size3.height;
                            i5 = size3.width;
                        }
                        float f8 = (f4 / i5) - f6;
                        float abs = Math.abs(f8);
                        if (f7 < 0.0f) {
                            size = size3;
                            f7 = abs;
                        }
                        if (abs < f7) {
                            size = size3;
                            f7 = abs;
                        }
                        if ((z ? size3.width : size3.height) == i2) {
                            if (size2 != null) {
                                if (z) {
                                    f5 = size2.width;
                                    i6 = size2.height;
                                } else {
                                    f5 = size2.height;
                                    i6 = size2.width;
                                }
                                if (Math.abs(f8) < Math.abs((f5 / i6) - f6)) {
                                }
                            }
                            size2 = size3;
                        }
                    }
                }
                if (size != null && size2 != null) {
                    if (z) {
                        f2 = size2.width / size2.height;
                        f3 = size.width;
                        i4 = size.height;
                    } else {
                        f2 = size2.height / size2.width;
                        f3 = size.height;
                        i4 = size.width;
                    }
                    if (Math.abs(f2 - f6) < Math.abs((f3 / i4) - f6) + 0.2f) {
                        return size2;
                    }
                }
            }
            return size;
        }
        return (Camera.Size) invokeLII.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
        }
        return (String) invokeL.objValue;
    }

    public Camera getCameraInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                j();
                Camera open = Camera.open(getFrontOrBackCameraId());
                m = open;
                if (this.k != null) {
                    Camera.Parameters parameters = open.getParameters();
                    l(m, parameters, this.k.j());
                    int l2 = this.k.l();
                    int k = this.k.k();
                    Camera.Size f2 = f(parameters.getSupportedPreviewSizes(), l2, k);
                    if (f2 != null) {
                        parameters.setPreviewSize(f2.width, f2.height);
                    }
                    Camera.Size f3 = f(parameters.getSupportedPictureSizes(), l2, k);
                    if (f3 != null) {
                        parameters.setPictureSize(f3.width, f3.height);
                    }
                    boolean z = true;
                    if (getFrontOrBackCameraId() != 1) {
                        z = false;
                    }
                    if (z) {
                        parameters.set("video-flip", "flip-h");
                    }
                    m.setParameters(parameters);
                }
            } catch (Exception e2) {
                if (l) {
                    Log.d("SwanAppCameraManager", "camera is not available");
                    e2.printStackTrace();
                }
            }
            return m;
        }
        return (Camera) invokeV.objValue;
    }

    public String getSlaveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.a.z.e.a aVar = this.k;
            return aVar == null ? "" : aVar.f43982g;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10916i : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k();
            e();
            SurfaceHolder surfaceHolder = this.f10914g;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
            }
            j();
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            k();
            this.f10913f = new MediaRecorder();
            m = getCameraInstance();
            setCameraDisplayOrientation();
            if (getResources().getConfiguration().orientation == 1) {
                this.f10913f.setOrientationHint(90);
            }
            m.unlock();
            this.f10913f.setCamera(m);
            this.f10913f.setAudioSource(1);
            this.f10913f.setVideoSource(1);
            this.f10913f.setProfile(getCamcorderProfile());
            this.f10913f.setOutputFile(getVideoPath());
            this.f10913f.setVideoEncodingBitRate(8388608);
            this.f10913f.setPreviewDisplay(this.f10914g.getSurface());
            try {
                this.f10913f.prepare();
                return true;
            } catch (IOException e2) {
                if (l) {
                    Log.d("SwanAppCameraManager", "IOException preparing MediaRecorder: " + e2.getMessage());
                    e2.printStackTrace();
                }
                return false;
            } catch (IllegalStateException e3) {
                if (l) {
                    Log.d("SwanAppCameraManager", "IllegalStateException preparing MediaRecorder: " + e3.getMessage());
                    e3.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mediaRecorder = this.f10913f) == null) {
            return;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (Exception e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.f10913f.reset();
            this.f10913f.release();
            this.f10913f = null;
        }
    }

    public final void l(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, camera, parameters, str) == null) || camera == null || parameters == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null || supportedFlashModes.isEmpty() || TextUtils.equals(str, parameters.getFlashMode()) || !supportedFlashModes.contains(str)) {
            return;
        }
        parameters.setFlashMode(str);
        camera.setParameters(parameters);
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            setSaveMediaPath(str);
            if (i()) {
                this.f10913f.start();
                return true;
            }
            e();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            k();
            Camera camera = m;
            if (camera != null) {
                camera.lock();
            }
            ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o(String str, d.a.o0.a.z.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, aVar) == null) {
            m.takePicture(null, null, new a(this, str, aVar));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() == 1) {
                try {
                    d.a.o0.a.z.d.a.d(motionEvent, m, getWidth(), getHeight());
                } catch (Exception e2) {
                    if (l) {
                        Log.d("SwanAppCameraManager", Log.getStackTraceString(e2));
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void p(d.a.o0.a.z.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            try {
                this.k = aVar;
                j();
                getCameraInstance();
                if (m != null) {
                    m.setPreviewDisplay(this.f10914g);
                    m.startPreview();
                    setCameraDisplayOrientation();
                    m.autoFocus(new b(this));
                }
            } catch (IOException | RuntimeException e2) {
                d.a.o0.a.z.a.b().e(aVar.f43982g, aVar.f43981f, false);
                if (l) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void setCameraDisplayOrientation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            m.setDisplayOrientation(getDegree());
        }
    }

    public void setQuality(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f10915h = str;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, surfaceHolder, i2, i3, i4) == null) {
            if (l) {
                Log.d("SwanAppCameraManager", "camera surfaceChanged");
            }
            p(this.k);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) {
            if (l) {
                Log.d("SwanAppCameraManager", "camera surfaceCreated");
            }
            getCameraInstance();
            try {
                if (m == null) {
                    return;
                }
                m.setPreviewDisplay(surfaceHolder);
                m.startPreview();
                setCameraDisplayOrientation();
            } catch (IOException | RuntimeException e2) {
                if (l) {
                    Log.d("SwanAppCameraManager", "Error setting camera preview: " + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) && l) {
            Log.d("SwanAppCameraManager", "camera surfaceDestroyed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPreview(Context context, d.a.o0.a.z.e.a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f10915h = Quality.NORMAL.getQualityName();
        this.f10916i = "";
        this.j = "";
        this.f10912e = context;
        this.k = aVar;
        SurfaceHolder holder = getHolder();
        this.f10914g = holder;
        holder.addCallback(this);
    }
}
