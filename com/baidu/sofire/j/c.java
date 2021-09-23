package com.baidu.sofire.j;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.liveness.utils.CameraUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f45455a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public MediaRecorder f45456b;

    /* renamed from: c  reason: collision with root package name */
    public File f45457c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f45458d;

    /* renamed from: e  reason: collision with root package name */
    public Context f45459e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f45462a;

        /* renamed from: b  reason: collision with root package name */
        public int f45463b;

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45462a = i2;
            this.f45463b = i3;
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45458d = false;
        this.f45459e = context;
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (c.class) {
                if (f45455a == null) {
                    synchronized (c.class) {
                        if (f45455a == null) {
                            f45455a = new c(context);
                        }
                    }
                }
                cVar = f45455a;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f45458d = false;
                if (this.f45456b != null) {
                    this.f45456b.release();
                    this.f45456b = null;
                }
                if (this.f45457c != null) {
                    this.f45457c.delete();
                    this.f45457c = null;
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public final synchronized int a(Camera camera, SurfaceHolder surfaceHolder, String str, int i2, com.baidu.sofire.j.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{camera, surfaceHolder, str, Integer.valueOf(i2), aVar})) == null) {
            synchronized (this) {
                if (camera == null || surfaceHolder == null) {
                    return -1;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return -1;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (file.getFreeSpace() >= 100) {
                        if (this.f45458d) {
                            return 2;
                        }
                        this.f45458d = true;
                        if (!a(camera, str, i2)) {
                            this.f45458d = false;
                            return -2;
                        }
                        new Thread(this, aVar) { // from class: com.baidu.sofire.j.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.baidu.sofire.j.a f45460a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ c f45461b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, aVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f45461b = this;
                                this.f45460a = aVar;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f45461b.f45456b != null) {
                                            this.f45461b.f45456b.start();
                                        } else {
                                            this.f45461b.f45458d = false;
                                        }
                                    } catch (Throwable unused) {
                                        this.f45461b.f45458d = false;
                                        com.baidu.sofire.j.a aVar2 = this.f45460a;
                                        if (aVar2 != null) {
                                            aVar2.a();
                                        }
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                            }
                        }.start();
                        return 1;
                    }
                    return -4;
                } catch (Exception unused) {
                    this.f45458d = false;
                    com.baidu.sofire.utility.c.a();
                    return -3;
                }
            }
        }
        return invokeCommon.intValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.f45456b != null) {
                    this.f45456b.release();
                    this.f45456b = null;
                }
                this.f45458d = false;
                return this.f45457c != null ? this.f45457c.getAbsolutePath() : "";
            } catch (Throwable unused) {
                this.f45458d = false;
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd A[Catch: all -> 0x017b, TryCatch #0 {all -> 0x017b, blocks: (B:5:0x0005, B:8:0x0015, B:11:0x001c, B:13:0x0043, B:14:0x004e, B:15:0x0054, B:17:0x005a, B:19:0x0068, B:21:0x0070, B:22:0x007c, B:24:0x0080, B:26:0x008b, B:29:0x0092, B:30:0x00b7, B:32:0x00bd, B:35:0x00d5, B:36:0x00d8, B:38:0x00e7, B:39:0x00ee, B:41:0x0125, B:45:0x015b, B:44:0x012c), top: B:53:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e7 A[Catch: all -> 0x017b, TryCatch #0 {all -> 0x017b, blocks: (B:5:0x0005, B:8:0x0015, B:11:0x001c, B:13:0x0043, B:14:0x004e, B:15:0x0054, B:17:0x005a, B:19:0x0068, B:21:0x0070, B:22:0x007c, B:24:0x0080, B:26:0x008b, B:29:0x0092, B:30:0x00b7, B:32:0x00bd, B:35:0x00d5, B:36:0x00d8, B:38:0x00e7, B:39:0x00ee, B:41:0x0125, B:45:0x015b, B:44:0x012c), top: B:53:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Camera camera, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList arrayList;
        a aVar;
        File file;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, camera, str, i2)) == null) {
            try {
                Context context = this.f45459e;
                List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
                File file2 = null;
                if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    a aVar2 = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    int i4 = 153600;
                    int i5 = 921600;
                    if ((aVar2.f45462a * aVar2.f45463b) / 4 > 921600) {
                        i5 = CameraUtils.f40305b;
                        i4 = (aVar2.f45462a * aVar2.f45463b) / 8;
                    }
                    arrayList = new ArrayList();
                    for (int i6 = 0; i6 < supportedPreviewSizes.size(); i6++) {
                        Camera.Size size = supportedPreviewSizes.get(i6);
                        if (size.width * size.height >= i4 && size.width * size.height <= i5) {
                            arrayList.add(new a(size.width, size.height));
                        }
                    }
                    aVar = new a(640, 480);
                    if (arrayList != null && arrayList.size() != 0) {
                        Display defaultDisplay2 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                        a aVar3 = new a(defaultDisplay2.getWidth(), defaultDisplay2.getHeight());
                        float f2 = aVar3.f45463b / aVar3.f45462a;
                        float f3 = aVar.f45462a / aVar.f45463b;
                        for (i3 = 0; i3 < arrayList.size(); i3++) {
                            a aVar4 = (a) arrayList.get(i3);
                            float abs = Math.abs((aVar4.f45462a / aVar4.f45463b) - f2);
                            if (abs < f3) {
                                aVar = aVar4;
                                f3 = abs;
                            }
                        }
                    }
                    a a2 = d.a(camera.getParameters(), aVar);
                    camera.unlock();
                    if (this.f45456b == null) {
                        this.f45456b = new MediaRecorder();
                    }
                    this.f45456b.setCamera(camera);
                    this.f45456b.setAudioSource(1);
                    this.f45456b.setVideoSource(1);
                    this.f45456b.setOutputFormat(2);
                    this.f45456b.setAudioEncoder(3);
                    this.f45456b.setVideoEncoder(2);
                    this.f45456b.setVideoSize(a2.f45462a, a2.f45463b);
                    file = new File(str, ".records");
                    if (!file.exists() || file.mkdirs()) {
                        file2 = new File(file.getPath() + File.separator + "bdv_" + String.valueOf(System.currentTimeMillis()) + ".mp4");
                    }
                    this.f45457c = file2;
                    this.f45456b.setOutputFile(file2.getAbsolutePath());
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i2, cameraInfo);
                    this.f45456b.setOrientationHint(cameraInfo.orientation);
                    this.f45456b.prepare();
                    return true;
                }
                arrayList = null;
                aVar = new a(640, 480);
                if (arrayList != null) {
                    Display defaultDisplay22 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    a aVar32 = new a(defaultDisplay22.getWidth(), defaultDisplay22.getHeight());
                    float f22 = aVar32.f45463b / aVar32.f45462a;
                    float f32 = aVar.f45462a / aVar.f45463b;
                    while (i3 < arrayList.size()) {
                    }
                }
                a a22 = d.a(camera.getParameters(), aVar);
                camera.unlock();
                if (this.f45456b == null) {
                }
                this.f45456b.setCamera(camera);
                this.f45456b.setAudioSource(1);
                this.f45456b.setVideoSource(1);
                this.f45456b.setOutputFormat(2);
                this.f45456b.setAudioEncoder(3);
                this.f45456b.setVideoEncoder(2);
                this.f45456b.setVideoSize(a22.f45462a, a22.f45463b);
                file = new File(str, ".records");
                if (!file.exists()) {
                }
                file2 = new File(file.getPath() + File.separator + "bdv_" + String.valueOf(System.currentTimeMillis()) + ".mp4");
                this.f45457c = file2;
                this.f45456b.setOutputFile(file2.getAbsolutePath());
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo2);
                this.f45456b.setOrientationHint(cameraInfo2.orientation);
                this.f45456b.prepare();
                return true;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }
}
