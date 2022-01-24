package com.baidu.sofire.b;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.utils.APIUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.IVideoRecordProcess;
import com.baidu.sofire.ac.RecordCallback;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.sofire.j.d;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.sofire.utility.f;
import com.baidu.sofire.utility.j;
import com.baidu.sofire.utility.n;
import com.baidu.sofire.utility.q;
import com.baidu.sofire.utility.x;
import com.baidu.sofire.utility.y;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.io.File;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public final class c implements Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback, IVideoRecordProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Rect B;
    public Camera C;
    public Camera.Parameters D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public JSONArray J;
    public int K;
    public RequestInfo L;
    public com.baidu.sofire.j.c a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38381b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38382c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38383d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38384e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f38385f;

    /* renamed from: g  reason: collision with root package name */
    public int f38386g;

    /* renamed from: h  reason: collision with root package name */
    public int f38387h;

    /* renamed from: i  reason: collision with root package name */
    public int f38388i;

    /* renamed from: j  reason: collision with root package name */
    public int f38389j;
    public Context k;
    public Activity l;
    public SurfaceHolder m;
    public RecordCallback n;
    public b o;
    public String p;
    public String q;
    public y r;
    public int s;
    public String t;
    public boolean u;
    public long v;
    public boolean w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Pair<Integer, Object> pair;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.u) {
                        return;
                    }
                    if (this.a.n != null && this.a.l != null) {
                        this.a.l.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.c.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ a a;

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
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.a.n == null) {
                                    return;
                                }
                                this.a.a.n.onBeginBuildData();
                            }
                        });
                    }
                    JSONObject jSONObject = null;
                    if (this.a.f38384e) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.a.t, Boolean.FALSE, "");
                        this.a.f38384e = false;
                    } else {
                        pair = null;
                    }
                    if (this.a.u) {
                        return;
                    }
                    if (pair != null && ((Integer) pair.first).intValue() == 0) {
                        String str = (String) pair.second;
                        if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str).optJSONObject("s")) != null && this.a.v > 0 && this.a.r.c()) {
                            jSONObject = this.a.b(jSONObject);
                        }
                    }
                    if (this.a.u) {
                        return;
                    }
                    this.a.a(this.a.a(jSONObject));
                } catch (Throwable th) {
                    com.baidu.sofire.utility.c.a();
                    x.a(this.a.k, this.a.t, 6, th);
                    this.a.a(-12);
                }
            }
        }

        public /* synthetic */ a(c cVar, byte b2) {
            this(cVar);
        }
    }

    public c(b bVar, Activity activity, SurfaceHolder surfaceHolder, RecordCallback recordCallback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, activity, surfaceHolder, recordCallback, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38381b = true;
        this.f38382c = false;
        this.f38383d = false;
        this.s = 5;
        this.v = 0L;
        this.z = 0L;
        this.A = false;
        this.f38384e = false;
        this.B = new Rect();
        this.f38385f = new Rect();
        this.f38386g = 0;
        this.f38387h = 0;
        this.f38388i = 0;
        this.f38389j = 0;
        this.I = false;
        this.K = -1;
        this.o = bVar;
        Context applicationContext = activity.getApplicationContext();
        this.k = applicationContext;
        this.l = activity;
        this.m = surfaceHolder;
        this.n = recordCallback;
        this.s = i2;
        this.r = y.a(applicationContext);
        this.a = com.baidu.sofire.j.c.a(this.k);
        this.p = new File(this.k.getFilesDir(), "record_tmp_dir").getAbsolutePath();
    }

    public static /* synthetic */ void h(c cVar) {
        cVar.f38381b = ((AudioManager) cVar.k.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamVolume(3) > 0;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        cVar.l.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        cVar.f38388i = displayMetrics.widthPixels;
        cVar.f38389j = displayMetrics.heightPixels;
    }

    public static /* synthetic */ Camera l(c cVar) {
        int numberOfCameras;
        if (cVar.u || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
            return null;
        }
        int i2 = 0;
        while (i2 < numberOfCameras) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                break;
            }
            i2++;
        }
        if (i2 < numberOfCameras) {
            Camera open = Camera.open(i2);
            cVar.E = i2;
            return open;
        }
        Camera open2 = Camera.open(0);
        cVar.E = 0;
        return open2;
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public final int cancelRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.x) {
                if (this.w) {
                    if (this.y) {
                        return -5;
                    }
                    if (this.f38383d) {
                        return -6;
                    }
                    this.w = false;
                    this.a.b();
                    return 1;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, camera) == null) || this.A) {
            return;
        }
        a(-5);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bArr, camera) == null) {
            try {
                if (this.f38383d || this.u || this.n == null) {
                    return;
                }
                this.n.onPreviewFrame(bArr, camera);
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                x.a(this.k, this.t, 3, th);
                a(-11);
            }
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public final void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = true;
            try {
                if (z.a(this.k).b(new Runnable(this) { // from class: com.baidu.sofire.b.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:44:0x0104 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x013a A[Catch: all -> 0x0165, TryCatch #0 {all -> 0x0165, blocks: (B:5:0x0007, B:8:0x0010, B:10:0x0035, B:12:0x003d, B:13:0x004b, B:15:0x0051, B:17:0x005d, B:19:0x0065, B:22:0x006e, B:25:0x007f, B:27:0x0087, B:42:0x00fc, B:47:0x0109, B:52:0x0119, B:54:0x0121, B:56:0x0129, B:59:0x013a, B:62:0x0142, B:64:0x0148, B:67:0x0151, B:70:0x015f, B:28:0x00a9, B:30:0x00b5, B:32:0x00bd, B:34:0x00e1, B:36:0x00eb), top: B:78:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:61:0x0140  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        Pair<Integer, Object> callSync;
                        char c2;
                        int i2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        try {
                            if (this.a.u) {
                                return;
                            }
                            this.a.t = j.a("3");
                            x.a(this.a.k, this.a.t, 101, 0);
                            if (this.a.n != null && this.a.l != null) {
                                this.a.l.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.c.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.a.n == null) {
                                            return;
                                        }
                                        this.a.a.n.onBegin();
                                    }
                                });
                            }
                            if (!FH.isInitSuc(1) && this.a.r.d()) {
                                this.a.a(-15);
                            } else if (this.a.u) {
                            } else {
                                if (!this.a.r.a() || this.a.s != 0) {
                                    if (this.a.r.a() && this.a.s > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.a.t, Integer.valueOf(this.a.s))) != null && ((Integer) callSync.first).intValue() == 0) {
                                        int intValue = ((Integer) callSync.second).intValue();
                                        if (intValue == 1) {
                                            c2 = 1;
                                        } else if (intValue == 2) {
                                            c2 = 65534;
                                        }
                                        if (!this.a.u) {
                                            return;
                                        }
                                        if (c2 != 65534 && (c2 == 1 || !this.a.r.b())) {
                                            i2 = 1;
                                            if (this.a.n != null && this.a.l != null) {
                                                this.a.l.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.c.1.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ int a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ AnonymousClass1 f38390b;

                                                    {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this, Integer.valueOf(i2)};
                                                            interceptable3.invokeUnInit(65536, newInitContext);
                                                            int i3 = newInitContext.flag;
                                                            if ((i3 & 1) != 0) {
                                                                int i4 = i3 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.f38390b = this;
                                                        this.a = i2;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f38390b.a.n == null) {
                                                            return;
                                                        }
                                                        this.f38390b.a.n.onDeviceCheckResult(this.a);
                                                    }
                                                });
                                            }
                                            if (c2 != 65534) {
                                                this.a.a(-3);
                                                return;
                                            } else if (i2 == -1) {
                                                this.a.a(-3);
                                                return;
                                            } else if (this.a.u) {
                                                return;
                                            } else {
                                                c.h(this.a);
                                                if (this.a.u) {
                                                    return;
                                                }
                                                this.a.a();
                                                return;
                                            }
                                        }
                                        i2 = -1;
                                        if (this.a.n != null) {
                                            this.a.l.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.c.1.2
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ int a;

                                                /* renamed from: b  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass1 f38390b;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = objArr;
                                                        Object[] objArr = {this, Integer.valueOf(i2)};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i3 = newInitContext.flag;
                                                        if ((i3 & 1) != 0) {
                                                            int i4 = i3 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.f38390b = this;
                                                    this.a = i2;
                                                }

                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f38390b.a.n == null) {
                                                        return;
                                                    }
                                                    this.f38390b.a.n.onDeviceCheckResult(this.a);
                                                }
                                            });
                                        }
                                        if (c2 != 65534) {
                                        }
                                    }
                                } else {
                                    FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.a.t, Integer.valueOf(this.a.s));
                                }
                                c2 = 65535;
                                if (!this.a.u) {
                                }
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.utility.c.a();
                            x.a(this.a.k, this.a.t, 1, th);
                            this.a.a(-9);
                        }
                    }
                }) != 1) {
                    a(-7);
                }
                z.a(this.k).a(new Runnable(this) { // from class: com.baidu.sofire.b.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            c cVar = this.a;
                            cVar.K = n.b(cVar.k);
                            c cVar2 = this.a;
                            cVar2.J = n.a(cVar2.k);
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public final int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.y) {
                return -5;
            }
            try {
                this.u = true;
                this.y = true;
                a(-16);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public final int startRecord() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.x) {
                if (this.w) {
                    return -2;
                }
                if (this.C == null) {
                    return -4;
                }
                if (this.y) {
                    return -5;
                }
                if (this.f38383d) {
                    return -6;
                }
                this.v = System.currentTimeMillis();
                if (this.a.a(this.C, this.m, this.p, this.E, new com.baidu.sofire.j.a(this) { // from class: com.baidu.sofire.b.c.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    @Override // com.baidu.sofire.j.a
                    public final void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.a(-17);
                        }
                    }
                }) < 0) {
                    a(-17);
                } else {
                    this.z = System.currentTimeMillis();
                    if (this.n != null && (activity = this.l) != null) {
                        try {
                            activity.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.c.5
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ c a;

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
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.n == null) {
                                        return;
                                    }
                                    this.a.n.onBeginRecord();
                                }
                            });
                        } catch (Throwable unused) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                }
                this.w = true;
                x.a(this.k, this.t, 102, 0);
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.sofire.ac.IVideoRecordProcess
    public final int stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.x) {
                if (this.w) {
                    if (this.y) {
                        return -5;
                    }
                    if (this.f38383d) {
                        return -6;
                    }
                    this.w = false;
                    if (System.currentTimeMillis() - this.z < 2000) {
                        this.a.b();
                        return -7;
                    }
                    String a2 = this.a.a();
                    this.q = a2;
                    if (!TextUtils.isEmpty(a2) && new File(this.q).exists()) {
                        this.A = true;
                        if (z.a(this.k).b(new a(this, (byte) 0)) != 1) {
                            a(-7);
                        }
                        return 1;
                    }
                    a(-7);
                    this.A = false;
                    return -8;
                }
                return -3;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder, i2, i3, i4) == null) {
            this.f38386g = i3;
            this.f38387h = i4;
            if (this.u || surfaceHolder.getSurface() == null || !this.I) {
                return;
            }
            a();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, surfaceHolder) == null) {
            this.f38382c = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, surfaceHolder) == null) {
            this.f38382c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x0005, B:17:0x0029, B:19:0x0035, B:21:0x0043, B:22:0x004d), top: B:30:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65548, this)) != null) {
            return invokeV.intValue;
        }
        try {
            int rotation = this.l.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i2 = 90;
                } else if (rotation == 2) {
                    i2 = 180;
                } else if (rotation == 3) {
                    i2 = 270;
                }
                int i3 = ((0 - i2) + 360) % 360;
                if (APIUtils.hasGingerbread()) {
                    return i3;
                }
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(this.E, cameraInfo);
                if (cameraInfo.facing == 1) {
                    return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                }
                return ((cameraInfo.orientation - i2) + 360) % 360;
            }
            i2 = 0;
            int i32 = ((0 - i2) + 360) % 360;
            if (APIUtils.hasGingerbread()) {
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                this.l.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.a.u) {
                                    return;
                                }
                                this.a.I = true;
                                if (this.a.m != null) {
                                    this.a.m.addCallback(this.a);
                                }
                                if (this.a.C == null && !this.a.u) {
                                    this.a.C = c.l(this.a);
                                }
                                if (this.a.C == null) {
                                    return;
                                }
                                if (this.a.D == null) {
                                    this.a.D = this.a.C.getParameters();
                                }
                                this.a.C.stopPreview();
                                this.a.D.setPictureFormat(256);
                                this.a.D.setPreviewFormat(17);
                                int b2 = this.a.b();
                                this.a.C.setDisplayOrientation(b2);
                                this.a.D.set("rotation", b2);
                                this.a.H = b2;
                                Point a2 = com.baidu.sofire.i.a.a(this.a.D, new Point(this.a.f38388i, this.a.f38389j));
                                this.a.F = a2.x;
                                this.a.G = a2.y;
                                this.a.B.set(0, 0, this.a.G, this.a.F);
                                c cVar = this.a;
                                int i2 = this.a.f38388i;
                                int i3 = this.a.G;
                                int i4 = this.a.F;
                                float f2 = (i2 / 2) - ((i2 / 2) * 0.33f);
                                float f3 = i3 / 2;
                                float f4 = (i4 / 2) - ((i4 / 2) * 0.1f);
                                if (i3 / 2 <= f2) {
                                    f2 = i3 / 2;
                                }
                                float f5 = (0.2f * f2) + f2;
                                cVar.f38385f.set((int) (f3 - f2), (int) (f4 - f5), (int) (f3 + f2), (int) (f4 + f5));
                                this.a.D.setPreviewSize(this.a.F, this.a.G);
                                this.a.C.setParameters(this.a.D);
                                if (this.a.n != null) {
                                    this.a.n.onConfigCamera(this.a.C);
                                }
                                this.a.C.setPreviewDisplay(this.a.m);
                                this.a.C.setErrorCallback(this.a);
                                this.a.C.setPreviewCallback(this.a);
                                if (this.a.u) {
                                    return;
                                }
                                this.a.C.startPreview();
                                Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.a.t);
                                if (callSync == null || ((Integer) callSync.first).intValue() != 0) {
                                    return;
                                }
                                this.a.f38384e = true;
                            } catch (Throwable th) {
                                com.baidu.sofire.utility.c.a();
                                x.a(this.a.k, this.a.t, 2, th);
                                this.a.a(-5);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                x.a(this.k, this.t, 2, th);
                a(-5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            try {
                this.f38383d = true;
                if (this.l != null) {
                    this.l.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.c.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f38391b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f38391b = this;
                            this.a = i2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f38391b.n == null) {
                                return;
                            }
                            if (this.a == 1) {
                                this.f38391b.n.onEnd(this.a, this.f38391b.L);
                            } else {
                                this.f38391b.n.onEnd(this.a, null);
                            }
                            this.f38391b.n = null;
                        }
                    });
                }
                if (this.a != null && this.w) {
                    this.a.b();
                }
                this.l.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.c.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.a.I = false;
                                if (this.a.C != null) {
                                    this.a.C.setErrorCallback(null);
                                    this.a.C.setPreviewCallback(null);
                                    this.a.C.stopPreview();
                                    com.baidu.sofire.i.b.a(this.a.C);
                                    this.a.C = null;
                                }
                                if (this.a.m != null) {
                                    this.a.m.removeCallback(this.a);
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    }
                });
                if (this.f38384e) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.t, Boolean.TRUE, "");
                    this.f38384e = false;
                }
                this.l = null;
                this.m = null;
                if (this.o != null) {
                    b bVar = this.o;
                    if (bVar.f38376c != null && this == bVar.f38376c) {
                        bVar.f38376c = null;
                    }
                    this.o = null;
                }
                x.a(this.k, this.t, 103, i2);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, jSONObject)) == null) {
            try {
                a(jSONObject, "g");
                a(jSONObject, "l");
                a(jSONObject, "d");
                return jSONObject;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return jSONObject;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                if (optJSONArray != null) {
                    String str2 = "";
                    int i2 = 0;
                    while (true) {
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        String string = optJSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string)) {
                            String[] split = string.split("#");
                            if (split.length == 2) {
                                long longValue = Long.valueOf(split[0]).longValue();
                                if (longValue <= 0) {
                                    continue;
                                } else if (longValue <= this.v) {
                                    str2 = string;
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = string;
                                }
                            } else {
                                continue;
                            }
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.remove(str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str2);
                        jSONObject.put(str, jSONArray);
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                File file = new File(this.q);
                if (file.exists()) {
                    jSONObject3.put("f_i", this.t);
                    if (jSONObject != null) {
                        jSONObject3.put("s", jSONObject);
                    }
                    byte[][] a2 = com.baidu.sofire.j.b.a(d.a(file));
                    file.delete();
                    if (a2 != null && a2.length == 2) {
                        byte[] bArr = a2[1];
                        byte[] bArr2 = a2[0];
                        if (bArr2 != null && bArr2.length != 0) {
                            if (bArr != null && bArr.length != 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("transcheckdata", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.k, bArr2), 8).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                                jSONObject4.put("video", jSONObject5);
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("zid", FH.gzfi(this.k, "", 5002));
                                jSONObject6.put("ev", "face");
                                jSONObject6.put(NotificationStyle.NOTIFICATION_STYLE, this.K);
                                jSONObject6.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis());
                                TimeZone timeZone = TimeZone.getDefault();
                                if (timeZone != null) {
                                    jSONObject6.put("tz", timeZone.getID());
                                }
                                if (this.J != null) {
                                    jSONObject6.put("ce", this.J);
                                }
                                jSONObject4.put("risk", jSONObject6);
                                jSONObject3.put("e", jSONObject4);
                                String str = b.f38373d;
                                if (!TextUtils.isEmpty(str)) {
                                    String[] split = str.split("-");
                                    if (split.length >= 3) {
                                        StringBuilder sb = new StringBuilder();
                                        for (int i2 = 0; i2 < split.length - 3; i2++) {
                                            sb.append(split[i2]);
                                            sb.append("-");
                                        }
                                        sb.append(split[split.length - 3]);
                                        str = sb.toString();
                                    }
                                }
                                jSONObject2.put("licenseId", str);
                                jSONObject2.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.k, jSONObject3.toString().getBytes()), 8).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                                jSONObject2.put("app", "android");
                                String packageName = this.k.getPackageName();
                                if (packageName != null) {
                                    jSONObject2.put("pkg", packageName);
                                    Signature[] signatureArr = this.k.getPackageManager().getPackageInfo(packageName, 64).signatures;
                                    if (signatureArr != null && signatureArr.length > 0) {
                                        jSONObject2.put("sign", q.a(signatureArr[0].toByteArray()));
                                    }
                                }
                                this.L = f.a(this.k, jSONObject2.toString(), bArr, this.p);
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
                x.a(this.k, this.t, 6, th);
                com.baidu.sofire.utility.c.a();
                return -2;
            }
        }
        return invokeL.intValue;
    }
}
