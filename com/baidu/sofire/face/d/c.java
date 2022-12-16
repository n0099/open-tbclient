package com.baidu.sofire.face.d;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean f;
    public static volatile c g;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaRecorder a;
    public File b;
    public volatile boolean c;
    public Context d;
    public Camera e;

    /* loaded from: classes3.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.sofire.face.d.a a;
        public final /* synthetic */ c b;

        public a(c cVar, com.baidu.sofire.face.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cVar;
            this.a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c cVar = this.b;
                    MediaRecorder mediaRecorder = cVar.a;
                    if (mediaRecorder != null) {
                        mediaRecorder.start();
                    } else {
                        cVar.c = false;
                        this.b.a();
                        com.baidu.sofire.face.d.a aVar = this.a;
                        if (aVar != null) {
                            aVar.a(-5);
                        }
                    }
                } catch (Throwable th) {
                    this.b.c = false;
                    this.b.a();
                    com.baidu.sofire.face.d.a aVar2 = this.a;
                    if (aVar2 != null) {
                        aVar2.a(-5);
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public c(Context context) {
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
        this.c = false;
        this.d = context;
    }

    public static synchronized c a(Context context) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (c.class) {
                if (g == null) {
                    synchronized (c.class) {
                        if (g == null) {
                            g = new c(context);
                        }
                    }
                }
                cVar = g;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public synchronized int a(Camera camera, String str, int i, com.baidu.sofire.face.d.a aVar) {
        InterceptResult invokeLLIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048576, this, camera, str, i, aVar)) == null) {
            synchronized (this) {
                if (camera == null) {
                    return -1;
                }
                try {
                    this.e = camera;
                    f = false;
                    if (TextUtils.isEmpty(str)) {
                        return -1;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    long freeSpace = file.getFreeSpace();
                    long j = freeSpace / 1048576;
                    if (freeSpace >= 100) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return -4;
                    }
                    if (this.c) {
                        return 2;
                    }
                    this.c = true;
                    if (!a(camera, str, i)) {
                        this.c = false;
                        a();
                        return -2;
                    }
                    new a(this, aVar).start();
                    return 1;
                } catch (Exception e) {
                    this.c = false;
                    e.printStackTrace();
                    a();
                    return -3;
                }
            }
        }
        return invokeLLIL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.c = false;
                MediaRecorder mediaRecorder = this.a;
                if (mediaRecorder != null) {
                    try {
                        mediaRecorder.release();
                    } catch (Throwable unused) {
                    }
                    this.a = null;
                }
                Camera camera = this.e;
                if (camera != null) {
                    camera.lock();
                    this.e = null;
                }
                File file = this.b;
                if (file != null) {
                    file.delete();
                    this.b = null;
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                MediaRecorder mediaRecorder = this.a;
                if (mediaRecorder != null) {
                    try {
                        mediaRecorder.release();
                    } catch (Throwable unused) {
                    }
                    this.a = null;
                }
                Camera camera = this.e;
                if (camera != null) {
                    camera.lock();
                    this.e = null;
                }
                this.c = false;
                File file = this.b;
                if (file != null) {
                    return file.getAbsolutePath();
                }
                return "";
            } catch (Throwable unused2) {
                this.c = false;
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean a(Camera camera, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, camera, str, i)) == null) {
            try {
                int i2 = camera.getParameters().getPreviewSize().width;
                int i3 = camera.getParameters().getPreviewSize().height;
                camera.unlock();
                if (this.a == null) {
                    this.a = new MediaRecorder();
                }
                this.a.reset();
                this.a.setCamera(camera);
                this.a.setAudioSource(1);
                this.a.setVideoSource(1);
                this.a.setOutputFormat(2);
                this.a.setAudioEncoder(3);
                this.a.setVideoEncoder(2);
                this.a.setVideoSize(i2, i3);
                File a2 = com.baidu.sofire.face.a.a.a(str);
                this.b = a2;
                this.a.setOutputFile(a2.getAbsolutePath());
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                this.a.setOrientationHint(cameraInfo.orientation);
                this.a.prepare();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }
}
