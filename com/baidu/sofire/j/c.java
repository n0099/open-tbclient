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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f44042a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public MediaRecorder f44043b;

    /* renamed from: c  reason: collision with root package name */
    public File f44044c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f44045d;

    /* renamed from: e  reason: collision with root package name */
    public Context f44046e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f44049a;

        /* renamed from: b  reason: collision with root package name */
        public int f44050b;

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
            this.f44049a = i2;
            this.f44050b = i3;
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
        this.f44045d = false;
        this.f44046e = context;
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (c.class) {
                if (f44042a == null) {
                    synchronized (c.class) {
                        if (f44042a == null) {
                            f44042a = new c(context);
                        }
                    }
                }
                cVar = f44042a;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.f44045d = false;
                if (this.f44043b != null) {
                    this.f44043b.release();
                    this.f44043b = null;
                }
                if (this.f44044c != null) {
                    this.f44044c.delete();
                    this.f44044c = null;
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
                        if (this.f44045d) {
                            return 2;
                        }
                        this.f44045d = true;
                        if (!a(camera, str, i2)) {
                            this.f44045d = false;
                            return -2;
                        }
                        new Thread(this, aVar) { // from class: com.baidu.sofire.j.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.baidu.sofire.j.a f44047a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ c f44048b;

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
                                this.f44048b = this;
                                this.f44047a = aVar;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f44048b.f44043b != null) {
                                            this.f44048b.f44043b.start();
                                        } else {
                                            this.f44048b.f44045d = false;
                                        }
                                    } catch (Throwable unused) {
                                        this.f44048b.f44045d = false;
                                        com.baidu.sofire.j.a aVar2 = this.f44047a;
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
                    this.f44045d = false;
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
                if (this.f44043b != null) {
                    this.f44043b.release();
                    this.f44043b = null;
                }
                this.f44045d = false;
                return this.f44044c != null ? this.f44044c.getAbsolutePath() : "";
            } catch (Throwable unused) {
                this.f44045d = false;
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
                Context context = this.f44046e;
                List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
                File file2 = null;
                if (supportedPreviewSizes != null && supportedPreviewSizes.size() != 0) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    a aVar2 = new a(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                    int i4 = 153600;
                    int i5 = 921600;
                    if ((aVar2.f44049a * aVar2.f44050b) / 4 > 921600) {
                        i5 = CameraUtils.f39048b;
                        i4 = (aVar2.f44049a * aVar2.f44050b) / 8;
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
                        float f2 = aVar3.f44050b / aVar3.f44049a;
                        float f3 = aVar.f44049a / aVar.f44050b;
                        for (i3 = 0; i3 < arrayList.size(); i3++) {
                            a aVar4 = (a) arrayList.get(i3);
                            float abs = Math.abs((aVar4.f44049a / aVar4.f44050b) - f2);
                            if (abs < f3) {
                                aVar = aVar4;
                                f3 = abs;
                            }
                        }
                    }
                    a a2 = d.a(camera.getParameters(), aVar);
                    camera.unlock();
                    if (this.f44043b == null) {
                        this.f44043b = new MediaRecorder();
                    }
                    this.f44043b.setCamera(camera);
                    this.f44043b.setAudioSource(1);
                    this.f44043b.setVideoSource(1);
                    this.f44043b.setOutputFormat(2);
                    this.f44043b.setAudioEncoder(3);
                    this.f44043b.setVideoEncoder(2);
                    this.f44043b.setVideoSize(a2.f44049a, a2.f44050b);
                    file = new File(str, ".records");
                    if (!file.exists() || file.mkdirs()) {
                        file2 = new File(file.getPath() + File.separator + "bdv_" + String.valueOf(System.currentTimeMillis()) + ".mp4");
                    }
                    this.f44044c = file2;
                    this.f44043b.setOutputFile(file2.getAbsolutePath());
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i2, cameraInfo);
                    this.f44043b.setOrientationHint(cameraInfo.orientation);
                    this.f44043b.prepare();
                    return true;
                }
                arrayList = null;
                aVar = new a(640, 480);
                if (arrayList != null) {
                    Display defaultDisplay22 = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    a aVar32 = new a(defaultDisplay22.getWidth(), defaultDisplay22.getHeight());
                    float f22 = aVar32.f44050b / aVar32.f44049a;
                    float f32 = aVar.f44049a / aVar.f44050b;
                    while (i3 < arrayList.size()) {
                    }
                }
                a a22 = d.a(camera.getParameters(), aVar);
                camera.unlock();
                if (this.f44043b == null) {
                }
                this.f44043b.setCamera(camera);
                this.f44043b.setAudioSource(1);
                this.f44043b.setVideoSource(1);
                this.f44043b.setOutputFormat(2);
                this.f44043b.setAudioEncoder(3);
                this.f44043b.setVideoEncoder(2);
                this.f44043b.setVideoSize(a22.f44049a, a22.f44050b);
                file = new File(str, ".records");
                if (!file.exists()) {
                }
                file2 = new File(file.getPath() + File.separator + "bdv_" + String.valueOf(System.currentTimeMillis()) + ".mp4");
                this.f44044c = file2;
                this.f44043b.setOutputFile(file2.getAbsolutePath());
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo2);
                this.f44043b.setOrientationHint(cameraInfo2.orientation);
                this.f44043b.prepare();
                return true;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }
}
