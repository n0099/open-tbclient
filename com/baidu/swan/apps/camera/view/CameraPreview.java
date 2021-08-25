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
import c.a.o0.a.k;
import c.a.o0.a.v2.q;
import c.a.o0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes6.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static Camera l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaRecorder f45706e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceHolder f45707f;

    /* renamed from: g  reason: collision with root package name */
    public String f45708g;

    /* renamed from: h  reason: collision with root package name */
    public String f45709h;

    /* renamed from: i  reason: collision with root package name */
    public String f45710i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.a.z.e.a f45711j;
    public Context mContext;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            Quality quality = new Quality("LOW", 2, "low", 40);
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

    /* loaded from: classes6.dex */
    public class a implements Camera.PictureCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.c.a f45713b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45714c;

        /* renamed from: com.baidu.swan.apps.camera.view.CameraPreview$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1727a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ byte[] f45715e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f45716f;

            public RunnableC1727a(a aVar, byte[] bArr) {
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
                this.f45716f = aVar;
                this.f45715e = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int quality = Quality.getQuality(this.f45716f.f45714c.f45708g);
                    boolean z = this.f45716f.f45714c.getResources().getConfiguration().orientation == 1;
                    boolean z2 = this.f45716f.f45714c.getFrontOrBackCameraId() == 0;
                    if (z) {
                        i2 = z2 ? 90 : -90;
                    } else {
                        i2 = 0;
                    }
                    boolean h2 = c.a.o0.a.z.a.b().h(this.f45715e, this.f45716f.f45712a, quality, i2, !z2);
                    a aVar = this.f45716f;
                    c.a.o0.a.z.c.a aVar2 = aVar.f45713b;
                    if (aVar2 != null) {
                        if (h2) {
                            aVar2.onSuccess(aVar.f45712a);
                        } else {
                            aVar2.onFailure();
                        }
                    }
                }
            }
        }

        public a(CameraPreview cameraPreview, String str, c.a.o0.a.z.c.a aVar) {
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
            this.f45714c = cameraPreview;
            this.f45712a = str;
            this.f45713b = aVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bArr, camera) == null) {
                try {
                    camera.startPreview();
                    this.f45714c.setCameraDisplayOrientation();
                } catch (RuntimeException e2) {
                    if (this.f45714c.f45711j != null) {
                        c.a.o0.a.z.a.b().e(this.f45714c.f45711j.f4630g, this.f45714c.f45711j.f4629f, false);
                    }
                    this.f45714c.onRelease();
                    if (CameraPreview.k) {
                        e2.printStackTrace();
                    }
                }
                q.j(new RunnableC1727a(this, bArr), CommonTbJsBridge.SAVE_IMAGE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45717a;

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
            this.f45717a = cameraPreview;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, camera) == null) && CameraPreview.k) {
                String str = "camera auto focus result : " + z;
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
        k = k.f7049a;
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
        this.f45708g = Quality.NORMAL.getQualityName();
        this.f45709h = "";
        this.f45710i = "";
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
            c.a.o0.a.z.e.a aVar = this.f45711j;
            return (aVar == null || !aVar.m()) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    public static void releaseCamera() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (camera = l) == null) {
            return;
        }
        camera.setPreviewCallback(null);
        l.stopPreview();
        l.release();
        l = null;
    }

    private void setSaveMediaPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            this.f45709h = str + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4";
            this.f45710i = str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            d.h(new File(this.f45709h));
        }
    }

    public void clearSaveMediaPath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f45709h = "";
            this.f45710i = "";
        }
    }

    public final Camera.Size e(List<Camera.Size> list, int i2, int i3) {
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

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g();
            this.f45706e = new MediaRecorder();
            l = getCameraInstance();
            setCameraDisplayOrientation();
            if (getResources().getConfiguration().orientation == 1) {
                this.f45706e.setOrientationHint(90);
            }
            l.unlock();
            this.f45706e.setCamera(l);
            this.f45706e.setAudioSource(1);
            this.f45706e.setVideoSource(1);
            this.f45706e.setProfile(getCamcorderProfile());
            this.f45706e.setOutputFile(getVideoPath());
            this.f45706e.setVideoEncodingBitRate(8388608);
            this.f45706e.setPreviewDisplay(this.f45707f.getSurface());
            try {
                this.f45706e.prepare();
                return true;
            } catch (IOException e2) {
                if (k) {
                    String str = "IOException preparing MediaRecorder: " + e2.getMessage();
                    e2.printStackTrace();
                }
                return false;
            } catch (IllegalStateException e3) {
                if (k) {
                    String str2 = "IllegalStateException preparing MediaRecorder: " + e3.getMessage();
                    e3.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        MediaRecorder mediaRecorder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mediaRecorder = this.f45706e) == null) {
            return;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (Exception e2) {
                if (k) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.f45706e.reset();
            this.f45706e.release();
            this.f45706e = null;
        }
    }

    public Camera getCameraInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                releaseCamera();
                Camera open = Camera.open(getFrontOrBackCameraId());
                l = open;
                if (this.f45711j != null) {
                    Camera.Parameters parameters = open.getParameters();
                    h(l, parameters, this.f45711j.j());
                    int l2 = this.f45711j.l();
                    int k2 = this.f45711j.k();
                    Camera.Size e2 = e(parameters.getSupportedPreviewSizes(), l2, k2);
                    if (e2 != null) {
                        parameters.setPreviewSize(e2.width, e2.height);
                    }
                    Camera.Size e3 = e(parameters.getSupportedPictureSizes(), l2, k2);
                    if (e3 != null) {
                        parameters.setPictureSize(e3.width, e3.height);
                    }
                    boolean z = true;
                    if (getFrontOrBackCameraId() != 1) {
                        z = false;
                    }
                    if (z) {
                        parameters.set("video-flip", "flip-h");
                    }
                    l.setParameters(parameters);
                }
            } catch (Exception e4) {
                if (k) {
                    e4.printStackTrace();
                }
            }
            return l;
        }
        return (Camera) invokeV.objValue;
    }

    public String getSlaveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.o0.a.z.e.a aVar = this.f45711j;
            return aVar == null ? "" : aVar.f4630g;
        }
        return (String) invokeV.objValue;
    }

    public String getTakePhotoPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public String getThumbPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45710i : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f45709h : (String) invokeV.objValue;
    }

    public final void h(Camera camera, Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, camera, parameters, str) == null) || camera == null || parameters == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null || supportedFlashModes.isEmpty() || TextUtils.equals(str, parameters.getFlashMode()) || !supportedFlashModes.contains(str)) {
            return;
        }
        parameters.setFlashMode(str);
        camera.setParameters(parameters);
    }

    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g();
            clearSaveMediaPath();
            SurfaceHolder surfaceHolder = this.f45707f;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
            }
            releaseCamera();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() == 1) {
                try {
                    c.a.o0.a.z.d.a.d(motionEvent, l, getWidth(), getHeight());
                } catch (Exception e2) {
                    if (k) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCameraDisplayOrientation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l.setDisplayOrientation(getDegree());
        }
    }

    public void setQuality(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f45708g = str;
        }
    }

    public boolean startRecording(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            setSaveMediaPath(str);
            if (f()) {
                this.f45706e.start();
                return true;
            }
            clearSaveMediaPath();
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean stopRecording() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            g();
            Camera camera = l;
            if (camera != null) {
                camera.lock();
            }
            ThumbnailUtils.createVideoThumbnail(getThumbPath(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048592, this, surfaceHolder, i2, i3, i4) == null) {
            boolean z = k;
            updateAttr(this.f45711j);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceHolder) == null) {
            boolean z = k;
            getCameraInstance();
            try {
                if (l == null) {
                    return;
                }
                l.setPreviewDisplay(surfaceHolder);
                l.startPreview();
                setCameraDisplayOrientation();
            } catch (IOException | RuntimeException e2) {
                if (k) {
                    String str = "Error setting camera preview: " + e2.getMessage();
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surfaceHolder) == null) {
            boolean z = k;
        }
    }

    public void takePicture(String str, c.a.o0.a.z.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, aVar) == null) {
            l.takePicture(null, null, new a(this, str, aVar));
        }
    }

    public void updateAttr(c.a.o0.a.z.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            try {
                this.f45711j = aVar;
                releaseCamera();
                getCameraInstance();
                if (l != null) {
                    l.setPreviewDisplay(this.f45707f);
                    l.startPreview();
                    setCameraDisplayOrientation();
                    l.autoFocus(new b(this));
                }
            } catch (IOException | RuntimeException e2) {
                c.a.o0.a.z.a.b().e(aVar.f4630g, aVar.f4629f, false);
                if (k) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPreview(Context context, c.a.o0.a.z.e.a aVar) {
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
        this.f45708g = Quality.NORMAL.getQualityName();
        this.f45709h = "";
        this.f45710i = "";
        this.mContext = context;
        this.f45711j = aVar;
        SurfaceHolder holder = getHolder();
        this.f45707f = holder;
        holder.addCallback(this);
    }
}
