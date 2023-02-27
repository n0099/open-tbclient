package com.baidu.sofire.face.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.TextureView;
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
import java.io.File;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q implements TextureView.SurfaceTextureListener, Camera.PreviewCallback, Camera.ErrorCallback, IVideoRecordProcess {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public JSONArray F;
    public int G;
    public RequestInfo H;
    public Context a;
    public Activity b;
    public TextureView c;
    public RecordCallback d;
    public com.baidu.sofire.face.a.e e;
    public com.baidu.sofire.face.d.c f;
    public String g;
    public String h;
    public com.baidu.sofire.face.b.e i;
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
    public Camera x;
    public Camera.Parameters y;
    public int z;

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, surfaceTexture) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        /* loaded from: classes3.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recordCallback = this.a.a.d) != null) {
                    recordCallback.onBeginBuildData();
                }
            }
        }

        public e(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Object> pair;
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    q qVar = this.a;
                    if (qVar.m) {
                        return;
                    }
                    if (qVar.d != null && (activity = qVar.b) != null) {
                        activity.runOnUiThread(new a(this));
                    }
                    q qVar2 = this.a;
                    JSONObject jSONObject = null;
                    if (qVar2.t) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, qVar2.l, Boolean.FALSE, "");
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
                                q qVar3 = this.a;
                                if (qVar3.n > 0 && qVar3.i.d()) {
                                    q qVar4 = this.a;
                                    qVar4.getClass();
                                    try {
                                        qVar4.a(jSONObject, "g");
                                        qVar4.a(jSONObject, "l");
                                        qVar4.a(jSONObject, "d");
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    }
                    q qVar5 = this.a;
                    if (qVar5.m) {
                        return;
                    }
                    qVar5.a(qVar5.a(jSONObject));
                } catch (Throwable th) {
                    q qVar6 = this.a;
                    com.baidu.sofire.face.b.b.a(qVar6.a, qVar6.l, 6, th);
                    this.a.a(-12);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int numberOfCameras;
            Camera open;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    q qVar = this.a;
                    boolean z = qVar.m;
                    if (z) {
                        return;
                    }
                    if (qVar.x == null && !z) {
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
                                qVar.z = i;
                            } else {
                                open = Camera.open(0);
                                qVar.z = 0;
                            }
                            qVar.x = open;
                        }
                        open = null;
                        qVar.x = open;
                    }
                    q qVar2 = this.a;
                    Camera camera = qVar2.x;
                    if (camera == null) {
                        return;
                    }
                    if (qVar2.y == null) {
                        qVar2.y = camera.getParameters();
                    }
                    this.a.x.stopPreview();
                    this.a.E = false;
                    this.a.y.setPictureFormat(256);
                    this.a.y.setPreviewFormat(17);
                    q qVar3 = this.a;
                    int a = q.a(qVar3, qVar3.a);
                    this.a.x.setDisplayOrientation(a);
                    this.a.y.set("rotation", a);
                    q qVar4 = this.a;
                    Point a2 = com.baidu.sofire.face.c.a.a(qVar4.y, qVar4.C, qVar4.D);
                    q qVar5 = this.a;
                    int i2 = a2.x;
                    qVar5.A = i2;
                    int i3 = a2.y;
                    qVar5.B = i3;
                    qVar5.u.set(0, 0, i3, i2);
                    q qVar6 = this.a;
                    float f = qVar6.w / 2;
                    float f2 = f - (0.33f * f);
                    float f3 = qVar6.B / 2;
                    float f4 = qVar6.A / 2;
                    float f5 = f4 - (0.1f * f4);
                    if (f3 <= f2) {
                        f2 = f3;
                    }
                    float f6 = (0.2f * f2) + f2;
                    qVar6.v.set((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
                    q qVar7 = this.a;
                    qVar7.y.setPreviewSize(qVar7.A, qVar7.B);
                    q qVar8 = this.a;
                    qVar8.x.setParameters(qVar8.y);
                    q qVar9 = this.a;
                    RecordCallback recordCallback = qVar9.d;
                    if (recordCallback != null) {
                        recordCallback.onConfigCamera(qVar9.x);
                    }
                    q qVar10 = this.a;
                    qVar10.A = qVar10.y.getPreviewSize().width;
                    q qVar11 = this.a;
                    qVar11.B = qVar11.y.getPreviewSize().height;
                    q qVar12 = this.a;
                    qVar12.x.setErrorCallback(qVar12);
                    q qVar13 = this.a;
                    qVar13.x.setPreviewCallback(qVar13);
                    TextureView textureView = this.a.c;
                    if (textureView != null && textureView.isAvailable()) {
                        q qVar14 = this.a;
                        qVar14.getClass();
                        try {
                            TextureView textureView2 = qVar14.c;
                            if (textureView2 != null) {
                                textureView2.setSurfaceTextureListener(qVar14);
                            }
                        } catch (Throwable unused) {
                        }
                        q qVar15 = this.a;
                        qVar15.x.setPreviewTexture(qVar15.c.getSurfaceTexture());
                    }
                    q qVar16 = this.a;
                    if (qVar16.m) {
                        return;
                    }
                    qVar16.x.startPreview();
                    this.a.E = true;
                    Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.a.l);
                    if (callSync != null && ((Integer) callSync.first).intValue() == 0) {
                        this.a.t = true;
                    }
                } catch (Throwable th) {
                    q qVar17 = this.a;
                    com.baidu.sofire.face.b.b.a(qVar17.a, qVar17.l, 2, th);
                    this.a.a(-5);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements com.baidu.sofire.face.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // com.baidu.sofire.face.d.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i < 0) {
                this.a.a(-17);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recordCallback = this.a.d) != null) {
                recordCallback.onBeginRecord();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ q b;

        public d(q qVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar;
            RecordCallback recordCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (recordCallback = (qVar = this.b).d) != null) {
                int i = this.a;
                if (i == 1) {
                    recordCallback.onEnd(i, qVar.H);
                } else {
                    recordCallback.onEnd(i, null);
                }
                this.b.d = null;
            }
        }
    }

    public q(com.baidu.sofire.face.a.e eVar, Activity activity, TextureView textureView, RecordCallback recordCallback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, activity, textureView, recordCallback, Integer.valueOf(i)};
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
        this.E = false;
        this.G = -1;
        this.e = eVar;
        this.a = activity.getApplicationContext();
        this.b = activity;
        this.c = textureView;
        if (textureView != null) {
            this.C = textureView.getLayoutParams().height;
            this.D = this.c.getLayoutParams().width;
        }
        this.d = recordCallback;
        this.k = i;
        this.i = com.baidu.sofire.face.b.e.a(this.a);
        this.f = com.baidu.sofire.face.d.c.a(this.a);
        this.g = new File(this.a.getFilesDir(), "record_tmp_dir").getAbsolutePath();
    }

    public static int a(q qVar, Context context) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qVar, context)) == null) {
            qVar.getClass();
            try {
                int rotation = qVar.b.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            i = 0;
                        } else {
                            i = 270;
                        }
                    } else {
                        i = 180;
                    }
                } else {
                    i = 90;
                }
                int i3 = ((0 - i) + 360) % 360;
                if (Build.VERSION.SDK_INT >= 9) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(qVar.z, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        i2 = (360 - ((cameraInfo.orientation + i) % 360)) % 360;
                    } else {
                        i2 = ((cameraInfo.orientation - i) + 360) % 360;
                    }
                    return i2;
                }
                return i3;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048581, this, i, camera) != null) || this.s) {
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
                if (!this.j && !this.m && (recordCallback = this.d) != null) {
                    recordCallback.onPreviewFrame(bArr, camera);
                }
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.l, 3, th);
                a(-11);
            }
        }
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
                                jSONObject6.put(NotificationStyle.NOTIFICATION_STYLE, this.G);
                                jSONObject6.put("ts", System.currentTimeMillis());
                                TimeZone timeZone = TimeZone.getDefault();
                                if (timeZone != null) {
                                    jSONObject6.put("tz", timeZone.getID());
                                }
                                JSONArray jSONArray = this.F;
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
                                this.H = com.baidu.sofire.face.b.b.a(this.a, jSONObject2.toString(), bArr, this.g);
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
                                } else if (j > this.n) {
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = string;
                                    }
                                } else {
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

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.p = true;
            try {
                if (com.baidu.sofire.face.b.f.a().a(new o(this)) != 1) {
                    a(-7);
                }
                com.baidu.sofire.face.b.f.a().a(new p(this));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
                if (cVar != null && this.o) {
                    cVar.a();
                }
                try {
                    this.b.runOnUiThread(new r(this));
                } catch (Throwable unused) {
                }
                if (this.t) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.l, Boolean.TRUE, "");
                    this.t = false;
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

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int cancelRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.p) {
                return -1;
            }
            if (!this.o) {
                return -3;
            }
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
        return invokeV.intValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048583, this, surfaceTexture, i, i2) == null) && !this.m && surfaceTexture != null) {
            TextureView textureView = this.c;
            if (textureView != null) {
                this.C = textureView.getHeight();
                this.D = this.c.getWidth();
            }
            a();
            Camera camera = this.x;
            if (camera != null) {
                try {
                    camera.setPreviewTexture(surfaceTexture);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i, i2) == null) && !this.m && surfaceTexture != null && this.E) {
            a();
        }
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int startRecord() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.p) {
                return -1;
            }
            if (this.o) {
                return -2;
            }
            if (this.x == null) {
                return -4;
            }
            if (this.q) {
                return -5;
            }
            if (this.j) {
                return -6;
            }
            this.n = System.currentTimeMillis();
            if (this.f.a(this.x, this.g, this.z, new b(this)) < 0) {
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
        return invokeV.intValue;
    }

    @Override // com.baidu.sofire.face.api.IVideoRecordProcess
    public int stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.p) {
                return -1;
            }
            if (!this.o) {
                return -3;
            }
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
                if (com.baidu.sofire.face.b.f.a().a(new e(this)) != 1) {
                    a(-7);
                }
                return 1;
            }
            a(-7);
            this.s = false;
            return -8;
        }
        return invokeV.intValue;
    }
}
