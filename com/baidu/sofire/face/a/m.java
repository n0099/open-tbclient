package com.baidu.sofire.face.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.IVideoRecordProcess;
import com.baidu.sofire.face.api.RecordCallback;
import com.baidu.sofire.face.api.RequestInfo;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, IVideoRecordProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public JSONArray E;
    public int F;
    public RequestInfo G;
    public Context a;
    public Activity b;
    public SurfaceHolder c;
    public RecordCallback d;
    public com.baidu.sofire.face.a.e e;
    public com.baidu.sofire.face.d.c f;
    public String g;
    public String h;
    public com.baidu.sofire.face.b.d i;
    public boolean j;
    public int k;
    public String l;
    public boolean m;
    public long n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public boolean s;
    public boolean t;
    public Rect u;
    public Rect v;
    public int w;
    public int x;
    public Camera y;
    public Camera.Parameters z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int numberOfCameras;
            Camera open;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    m mVar = this.a;
                    if (mVar.m) {
                        return;
                    }
                    SurfaceHolder surfaceHolder = mVar.c;
                    if (surfaceHolder != null) {
                        surfaceHolder.addCallback(mVar);
                    }
                    m mVar2 = this.a;
                    if (mVar2.y == null && !(z = mVar2.m)) {
                        if (!z && (numberOfCameras = Camera.getNumberOfCameras()) != 0) {
                            int i = 0;
                            while (i < numberOfCameras) {
                                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                                Camera.getCameraInfo(i, cameraInfo);
                                if (cameraInfo.facing == 1) {
                                    break;
                                }
                                i++;
                            }
                            if (i < numberOfCameras) {
                                open = Camera.open(i);
                                mVar2.A = i;
                            } else {
                                open = Camera.open(0);
                                mVar2.A = 0;
                            }
                            mVar2.y = open;
                        }
                        open = null;
                        mVar2.y = open;
                    }
                    m mVar3 = this.a;
                    Camera camera = mVar3.y;
                    if (camera == null) {
                        return;
                    }
                    if (mVar3.z == null) {
                        mVar3.z = camera.getParameters();
                    }
                    this.a.y.stopPreview();
                    this.a.D = false;
                    this.a.z.setPictureFormat(256);
                    this.a.z.setPreviewFormat(17);
                    m mVar4 = this.a;
                    int a = m.a(mVar4, mVar4.a);
                    try {
                        this.a.y.setDisplayOrientation(a);
                    } catch (Throwable unused) {
                    }
                    this.a.z.set(Key.ROTATION, a);
                    m mVar5 = this.a;
                    Point a2 = com.baidu.sofire.face.c.a.a(mVar5.z, mVar5.x, mVar5.w);
                    m mVar6 = this.a;
                    int i2 = a2.x;
                    mVar6.B = i2;
                    int i3 = a2.y;
                    mVar6.C = i3;
                    mVar6.u.set(0, 0, i3, i2);
                    m mVar7 = this.a;
                    float f = mVar7.w / 2;
                    float f2 = f - (0.33f * f);
                    float f3 = mVar7.C / 2;
                    float f4 = mVar7.B / 2;
                    float f5 = f4 - (0.1f * f4);
                    if (f3 <= f2) {
                        f2 = f3;
                    }
                    float f6 = (0.2f * f2) + f2;
                    mVar7.v.set((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
                    m mVar8 = this.a;
                    mVar8.z.setPreviewSize(mVar8.B, mVar8.C);
                    m mVar9 = this.a;
                    mVar9.y.setParameters(mVar9.z);
                    m mVar10 = this.a;
                    RecordCallback recordCallback = mVar10.d;
                    if (recordCallback != null) {
                        recordCallback.onConfigCamera(mVar10.y);
                    }
                    m mVar11 = this.a;
                    mVar11.B = mVar11.z.getPreviewSize().width;
                    m mVar12 = this.a;
                    mVar12.C = mVar12.z.getPreviewSize().height;
                    m mVar13 = this.a;
                    mVar13.y.setPreviewDisplay(mVar13.c);
                    m mVar14 = this.a;
                    mVar14.y.setErrorCallback(mVar14);
                    m mVar15 = this.a;
                    mVar15.y.setPreviewCallback(mVar15);
                    m mVar16 = this.a;
                    if (mVar16.m) {
                        return;
                    }
                    mVar16.y.startPreview();
                    this.a.D = true;
                    Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.a.l);
                    if (callSync == null || ((Integer) callSync.first).intValue() != 0) {
                        return;
                    }
                    this.a.t = true;
                } catch (Throwable th) {
                    m mVar17 = this.a;
                    com.baidu.sofire.face.b.b.a(mVar17.a, mVar17.l, 2, th);
                    this.a.a(-5);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements com.baidu.sofire.face.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // com.baidu.sofire.face.d.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i >= 0) {
                return;
            }
            this.a.a(-17);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (recordCallback = this.a.d) == null) {
                return;
            }
            recordCallback.onBeginRecord();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ m b;

        public d(m mVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (recordCallback = (mVar = this.b).d) == null) {
                return;
            }
            int i = this.a;
            if (i == 1) {
                recordCallback.onEnd(i, mVar.G);
            } else {
                recordCallback.onEnd(i, null);
            }
            this.b.d = null;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                RecordCallback recordCallback;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (recordCallback = this.a.a.d) == null) {
                    return;
                }
                recordCallback.onBeginBuildData();
            }
        }

        public e(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Object> pair;
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    m mVar = this.a;
                    if (mVar.m) {
                        return;
                    }
                    if (mVar.d != null && (activity = mVar.b) != null) {
                        activity.runOnUiThread(new a(this));
                    }
                    m mVar2 = this.a;
                    JSONObject jSONObject = null;
                    if (mVar2.t) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, mVar2.l, Boolean.FALSE, "");
                        this.a.t = false;
                    } else {
                        pair = null;
                    }
                    if (this.a.m) {
                        return;
                    }
                    if (pair != null && ((Integer) pair.first).intValue() == 0) {
                        String str = (String) pair.second;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                jSONObject = new JSONObject(str).optJSONObject("s");
                            } catch (Throwable unused) {
                            }
                            if (jSONObject != null) {
                                m mVar3 = this.a;
                                if (mVar3.n > 0 && mVar3.i.d()) {
                                    m mVar4 = this.a;
                                    mVar4.getClass();
                                    try {
                                        mVar4.a(jSONObject, "g");
                                        mVar4.a(jSONObject, "l");
                                        mVar4.a(jSONObject, "d");
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    }
                    m mVar5 = this.a;
                    if (mVar5.m) {
                        return;
                    }
                    mVar5.a(mVar5.a(jSONObject));
                } catch (Throwable th) {
                    m mVar6 = this.a;
                    com.baidu.sofire.face.b.b.a(mVar6.a, mVar6.l, 6, th);
                    this.a.a(-12);
                }
            }
        }
    }

    public m(com.baidu.sofire.face.a.e eVar, Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, activity, surfaceHolder, recordCallback, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = 5;
        this.n = 0L;
        this.r = 0L;
        this.s = false;
        this.t = false;
        this.u = new Rect();
        this.v = new Rect();
        this.w = 0;
        this.x = 0;
        this.D = false;
        this.F = -1;
        this.e = eVar;
        Context applicationContext = activity.getApplicationContext();
        this.a = applicationContext;
        this.b = activity;
        this.c = surfaceHolder;
        this.d = recordCallback;
        this.k = i;
        this.i = com.baidu.sofire.face.b.d.a(applicationContext);
        this.f = com.baidu.sofire.face.d.c.a(this.a);
        this.g = new File(this.a.getFilesDir(), "record_tmp_dir").getAbsolutePath();
    }

    public static int a(m mVar, Context context) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mVar, context)) == null) {
            mVar.getClass();
            try {
                int rotation = mVar.b.getWindowManager().getDefaultDisplay().getRotation();
                int i2 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
                int i3 = ((0 - i2) + 360) % 360;
                if (Build.VERSION.SDK_INT >= 9) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(mVar.A, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                    } else {
                        i = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    return i;
                }
                return i3;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int cancelRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.p) {
                if (this.o) {
                    if (this.q) {
                        return -5;
                    }
                    if (this.j) {
                        return -6;
                    }
                    this.o = false;
                    this.f.a();
                    return 1;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i, camera) == null) || this.s) {
            return;
        }
        a(-5);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        RecordCallback recordCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bArr, camera) == null) {
            try {
                if (this.j || this.m || (recordCallback = this.d) == null) {
                    return;
                }
                recordCallback.onPreviewFrame(bArr, camera);
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.l, 3, th);
                a(-11);
            }
        }
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p = true;
            try {
                if (com.baidu.sofire.face.b.e.a().a(new k(this)) != 1) {
                    a(-7);
                }
                com.baidu.sofire.face.b.e.a().a(new l(this));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.q) {
                return -5;
            }
            try {
                this.m = true;
                this.q = true;
                a(-16);
            } catch (Throwable unused) {
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int startRecord() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.p) {
                if (this.o) {
                    return -2;
                }
                if (this.y == null) {
                    return -4;
                }
                if (this.q) {
                    return -5;
                }
                if (this.j) {
                    return -6;
                }
                this.n = System.currentTimeMillis();
                if (this.f.a(this.y, this.g, this.A, new b(this)) < 0) {
                    a(-17);
                } else {
                    this.r = System.currentTimeMillis();
                    if (this.d != null && (activity = this.b) != null) {
                        try {
                            activity.runOnUiThread(new c(this));
                        } catch (Throwable unused) {
                        }
                    }
                }
                this.o = true;
                com.baidu.sofire.face.b.b.a(this.a, this.l, 102, 0, null);
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.p) {
                if (this.o) {
                    if (this.q) {
                        return -5;
                    }
                    if (this.j) {
                        return -6;
                    }
                    this.o = false;
                    if (System.currentTimeMillis() - this.r < 2000) {
                        this.f.a();
                        return -7;
                    }
                    String b2 = this.f.b();
                    this.h = b2;
                    if (!TextUtils.isEmpty(b2) && new File(this.h).exists()) {
                        this.s = true;
                        if (com.baidu.sofire.face.b.e.a().a(new e(this)) != 1) {
                            a(-7);
                        }
                        return 1;
                    }
                    a(-7);
                    this.s = false;
                    return -8;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048587, this, surfaceHolder, i, i2, i3) == null) || this.m || surfaceHolder.getSurface() == null || !this.D) {
            return;
        }
        a();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceHolder) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.b.runOnUiThread(new a(this));
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.l, 2, th);
                a(-5);
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            try {
                this.j = true;
                Activity activity = this.b;
                if (activity != null) {
                    activity.runOnUiThread(new d(this, i));
                }
                com.baidu.sofire.face.d.c cVar = this.f;
                if (cVar != null) {
                    cVar.a();
                }
                try {
                    this.b.runOnUiThread(new n(this));
                } catch (Throwable unused) {
                }
                if (this.t) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.l, Boolean.TRUE, "");
                    this.t = false;
                }
                SurfaceHolder surfaceHolder = this.c;
                if (surfaceHolder != null) {
                    surfaceHolder.removeCallback(this);
                    this.c = null;
                }
                this.b = null;
                com.baidu.sofire.face.a.e eVar = this.e;
                if (eVar != null) {
                    IVideoRecordProcess iVideoRecordProcess = eVar.b;
                    if (iVideoRecordProcess != null && this == iVideoRecordProcess) {
                        eVar.b = null;
                    }
                    this.e = null;
                }
                com.baidu.sofire.face.b.b.a(this.a, this.l, 103, i, null);
            } catch (Throwable unused2) {
            }
        }
    }

    public final JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    String str2 = "";
                    int i = 0;
                    while (true) {
                        if (i >= optJSONArray.length()) {
                            break;
                        }
                        String string = optJSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            String[] split = string.split("#");
                            if (split.length != 2) {
                                continue;
                            } else {
                                try {
                                    j = Long.valueOf(split[0]).longValue();
                                } catch (Throwable unused) {
                                    j = 0;
                                }
                                if (j <= 0) {
                                    continue;
                                } else if (j <= this.n) {
                                    str2 = string;
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = string;
                                }
                            }
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.remove(str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str2);
                        jSONObject.put(str, jSONArray);
                    }
                }
            } catch (Throwable unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                File file = new File(this.h);
                if (file.exists()) {
                    jSONObject3.put("f_i", this.l);
                    if (jSONObject != null) {
                        jSONObject3.put("s", jSONObject);
                    }
                    byte[][] a2 = com.baidu.sofire.face.d.b.a(com.baidu.sofire.face.a.a.a(file));
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                    if (a2 != null && a2.length == 2) {
                        byte[] bArr = a2[1];
                        byte[] bArr2 = a2[0];
                        if (bArr2 != null && bArr2.length != 0) {
                            if (bArr != null && bArr.length != 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("transcheckdata", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.a, bArr2), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                jSONObject4.put("video", jSONObject5);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("zid", FH.gzfi(this.a, "", 5002));
                                jSONObject6.put(Config.EVENT_PART, "face");
                                jSONObject6.put(NotificationStyle.NOTIFICATION_STYLE, this.F);
                                jSONObject6.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis());
                                TimeZone timeZone = TimeZone.getDefault();
                                if (timeZone != null) {
                                    jSONObject6.put("tz", timeZone.getID());
                                }
                                JSONArray jSONArray = this.E;
                                if (jSONArray != null) {
                                    jSONObject6.put("ce", jSONArray);
                                }
                                jSONObject4.put("risk", jSONObject6);
                                jSONObject3.put("e", jSONObject4);
                                String str = com.baidu.sofire.face.a.e.d;
                                try {
                                    if (!TextUtils.isEmpty(str)) {
                                        String[] split = str.split("-");
                                        if (split.length >= 3) {
                                            StringBuilder sb = new StringBuilder();
                                            for (int i = 0; i < split.length - 3; i++) {
                                                sb.append(split[i]);
                                                sb.append("-");
                                            }
                                            sb.append(split[split.length - 3]);
                                            str = sb.toString();
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                                jSONObject2.put("licenseId", str);
                                jSONObject2.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.a, jSONObject3.toString().getBytes()), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                jSONObject2.put("app", "android");
                                String packageName = this.a.getPackageName();
                                if (packageName != null) {
                                    jSONObject2.put("pkg", packageName);
                                    try {
                                        Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
                                        if (signatureArr != null && signatureArr.length > 0) {
                                            jSONObject2.put("sign", com.baidu.sofire.face.b.c.b(signatureArr[0].toByteArray()));
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                this.G = com.baidu.sofire.face.b.b.a(this.a, jSONObject2.toString(), bArr, this.g);
                                return 1;
                            }
                            throw new RuntimeException("empty mediaData");
                        }
                        throw new RuntimeException("empty mediaSafeInfo");
                    }
                    throw new RuntimeException("transformResult unexpected");
                }
                throw new RuntimeException("mediaFile not exists");
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.l, 6, th);
                return -2;
            }
        }
        return invokeL.intValue;
    }
}
