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
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.repackage.bh4;
import com.repackage.it1;
import com.repackage.jh1;
import com.repackage.qt1;
import com.repackage.st1;
import com.repackage.td3;
import com.repackage.tt1;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static Camera i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public MediaRecorder b;
    public SurfaceHolder c;
    public String d;
    public String e;
    public String f;
    public tt1 g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public Quality(String str, int i, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.qualityName = str2;
            this.qualityInt = i2;
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

    /* loaded from: classes2.dex */
    public class a implements Camera.PictureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qt1 b;
        public final /* synthetic */ CameraPreview c;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0176a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ byte[] a;
            public final /* synthetic */ a b;

            public RunnableC0176a(a aVar, byte[] bArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int quality = Quality.getQuality(this.b.c.d);
                    boolean z = this.b.c.getResources().getConfiguration().orientation == 1;
                    boolean z2 = this.b.c.getFrontOrBackCameraId() == 0;
                    if (z) {
                        i = z2 ? 90 : -90;
                    } else {
                        i = 0;
                    }
                    boolean h = it1.b().h(this.a, this.b.a, quality, i, !z2);
                    a aVar = this.b;
                    qt1 qt1Var = aVar.b;
                    if (qt1Var != null) {
                        if (h) {
                            qt1Var.onSuccess(aVar.a);
                        } else {
                            qt1Var.onFailure();
                        }
                    }
                }
            }
        }

        public a(CameraPreview cameraPreview, String str, qt1 qt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview, str, qt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cameraPreview;
            this.a = str;
            this.b = qt1Var;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                try {
                    camera.startPreview();
                    this.c.setCameraDisplayOrientation();
                } catch (RuntimeException e) {
                    if (this.c.g != null) {
                        it1.b().e(this.c.g.c, this.c.g.b, false);
                    }
                    this.c.h();
                    if (CameraPreview.h) {
                        e.printStackTrace();
                    }
                }
                td3.k(new RunnableC0176a(this, bArr), CommonTbJsBridge.SAVE_IMAGE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;

        public b(CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraPreview;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) && CameraPreview.h) {
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
        h = jh1.a;
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
        this.d = Quality.NORMAL.getQualityName();
        this.e = "";
        this.f = "";
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
            tt1 tt1Var = this.g;
            return (tt1Var == null || !tt1Var.k()) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public static void j() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (camera = i) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        i.stopPreview();
        i.release();
        i = null;
    }

    private void setSaveMediaPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            this.e = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.f = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
            bh4.h(new File(this.e));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = "";
            this.f = "";
        }
    }

    public final Camera.Size f(List<Camera.Size> list, int i2, int i3) {
        InterceptResult invokeLII;
        float f;
        float f2;
        int i4;
        float f3;
        int i5;
        float f4;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2, i3)) == null) {
            Camera.Size size = null;
            if (list != null && !list.isEmpty() && i3 != 0) {
                float f5 = i2 / i3;
                float f6 = -1.0f;
                boolean z = getDegree() % 180 == 0;
                Camera.Size size2 = null;
                for (Camera.Size size3 : list) {
                    if (size3 != null) {
                        if (z) {
                            f3 = size3.width;
                            i5 = size3.height;
                        } else {
                            f3 = size3.height;
                            i5 = size3.width;
                        }
                        float f7 = (f3 / i5) - f5;
                        float abs = Math.abs(f7);
                        if (f6 < 0.0f) {
                            size = size3;
                            f6 = abs;
                        }
                        if (abs < f6) {
                            size = size3;
                            f6 = abs;
                        }
                        if ((z ? size3.width : size3.height) == i2) {
                            if (size2 != null) {
                                if (z) {
                                    f4 = size2.width;
                                    i6 = size2.height;
                                } else {
                                    f4 = size2.height;
                                    i6 = size2.width;
                                }
                                if (Math.abs(f7) < Math.abs((f4 / i6) - f5)) {
                                }
                            }
                            size2 = size3;
                        }
                    }
                }
                if (size != null && size2 != null) {
                    if (z) {
                        f = size2.width / size2.height;
                        f2 = size.width;
                        i4 = size.height;
                    } else {
                        f = size2.height / size2.width;
                        f2 = size.height;
                        i4 = size.width;
                    }
                    if (Math.abs(f - f5) < Math.abs((f2 / i4) - f5) + 0.2f) {
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
                i = open;
                if (this.g != null) {
                    Camera.Parameters parameters = open.getParameters();
                    l(i, parameters, this.g.h());
                    int j = this.g.j();
                    int i2 = this.g.i();
                    Camera.Size f = f(parameters.getSupportedPreviewSizes(), j, i2);
                    if (f != null) {
                        parameters.setPreviewSize(f.width, f.height);
                    }
                    Camera.Size f2 = f(parameters.getSupportedPictureSizes(), j, i2);
                    if (f2 != null) {
                        parameters.setPictureSize(f2.width, f2.height);
                    }
                    boolean z = true;
                    if (getFrontOrBackCameraId() != 1) {
                        z = false;
                    }
                    if (z) {
                        parameters.set("video-flip", "flip-h");
                    }
                    i.setParameters(parameters);
                }
            } catch (Exception e) {
                if (h) {
                    Log.d("SwanAppCameraManager", "camera is not available");
                    e.printStackTrace();
                }
            }
            return i;
        }
        return (Camera) invokeV.objValue;
    }

    public String getSlaveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tt1 tt1Var = this.g;
            return tt1Var == null ? "" : tt1Var.c;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k();
            e();
            SurfaceHolder surfaceHolder = this.c;
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
            this.b = new MediaRecorder();
            i = getCameraInstance();
            setCameraDisplayOrientation();
            if (getResources().getConfiguration().orientation == 1) {
                this.b.setOrientationHint(90);
            }
            i.unlock();
            this.b.setCamera(i);
            this.b.setAudioSource(1);
            this.b.setVideoSource(1);
            this.b.setProfile(getCamcorderProfile());
            this.b.setOutputFile(getVideoPath());
            this.b.setVideoEncodingBitRate(8388608);
            this.b.setPreviewDisplay(this.c.getSurface());
            try {
                this.b.prepare();
                return true;
            } catch (IOException e) {
                if (h) {
                    Log.d("SwanAppCameraManager", "IOException preparing MediaRecorder: " + e.getMessage());
                    e.printStackTrace();
                }
                return false;
            } catch (IllegalStateException e2) {
                if (h) {
                    Log.d("SwanAppCameraManager", "IllegalStateException preparing MediaRecorder: " + e2.getMessage());
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mediaRecorder = this.b) == null) {
            return;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (Exception e) {
                if (h) {
                    e.printStackTrace();
                }
            }
        } finally {
            this.b.reset();
            this.b.release();
            this.b = null;
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
                this.b.start();
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
            Camera camera = i;
            if (camera != null) {
                camera.lock();
            }
            ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o(String str, qt1 qt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, qt1Var) == null) {
            i.takePicture(null, null, new a(this, str, qt1Var));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() == 1) {
                try {
                    st1.d(motionEvent, i, getWidth(), getHeight());
                } catch (Exception e) {
                    if (h) {
                        Log.d("SwanAppCameraManager", Log.getStackTraceString(e));
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void p(tt1 tt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tt1Var) == null) {
            try {
                this.g = tt1Var;
                j();
                getCameraInstance();
                if (i != null) {
                    i.setPreviewDisplay(this.c);
                    i.startPreview();
                    setCameraDisplayOrientation();
                    i.autoFocus(new b(this));
                }
            } catch (IOException | RuntimeException e) {
                it1.b().e(tt1Var.c, tt1Var.b, false);
                if (h) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCameraDisplayOrientation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            i.setDisplayOrientation(getDegree());
        }
    }

    public void setQuality(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.d = str;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048594, this, surfaceHolder, i2, i3, i4) == null) {
            if (h) {
                Log.d("SwanAppCameraManager", "camera surfaceChanged");
            }
            p(this.g);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) {
            if (h) {
                Log.d("SwanAppCameraManager", "camera surfaceCreated");
            }
            getCameraInstance();
            try {
                if (i == null) {
                    return;
                }
                i.setPreviewDisplay(surfaceHolder);
                i.startPreview();
                setCameraDisplayOrientation();
            } catch (IOException | RuntimeException e) {
                if (h) {
                    Log.d("SwanAppCameraManager", "Error setting camera preview: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) && h) {
            Log.d("SwanAppCameraManager", "camera surfaceDestroyed");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPreview(Context context, tt1 tt1Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tt1Var};
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
        this.d = Quality.NORMAL.getQualityName();
        this.e = "";
        this.f = "";
        this.a = context;
        this.g = tt1Var;
        SurfaceHolder holder = getHolder();
        this.c = holder;
        holder.addCallback(this);
    }
}
