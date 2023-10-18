package com.baidu.sofire.face.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.IDetectStrategyCallback;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.pass.face.platform.ILivenessStrategyCallback;
import com.baidu.pass.face.platform.ILivenessViewCallback;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceOcclusion;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.face.api.Degree;
import com.baidu.sofire.face.api.FaceEnum;
import com.baidu.sofire.face.api.FaceProcessCallback;
import com.baidu.sofire.face.api.IFaceProcessInfo;
import com.baidu.sofire.face.api.RequestInfo;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements SurfaceHolder.Callback, Camera.PreviewCallback, Camera.ErrorCallback, ISecurityCallback, com.baidu.sofire.face.a.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public Degree C;
    public boolean D;
    public Camera E;
    public Camera.Parameters F;
    public boolean G;
    public byte[] H;
    public byte[] I;
    public byte[] J;
    public int K;
    public boolean L;
    public FaceConfig M;
    public ILivenessStrategy N;
    public IDetectStrategy O;
    public Map<Long, String> P;
    public int Q;
    public long R;
    public JSONArray S;

    /* renamed from: T  reason: collision with root package name */
    public int f1069T;
    public Map<Long, FaceInfo> U;
    public long V;
    public long W;
    public RequestInfo X;
    public Context a;
    public Activity b;
    public SurfaceHolder c;
    public FaceProcessCallback d;
    public i e;
    public h f;
    public j g;
    public boolean h;
    public com.baidu.sofire.face.a.e i;
    public IFaceProcessInfo j;
    public com.baidu.sofire.face.b.e k;
    public volatile boolean l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public Rect t;
    public Rect u;
    public int v;
    public int w;
    public Camera x;
    public Camera.Parameters y;
    public int z;

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, surfaceHolder) == null) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceHolder) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: com.baidu.sofire.face.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0180a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0180a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                FaceProcessCallback faceProcessCallback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = this.a.a.d) != null) {
                    faceProcessCallback.onBegin();
                }
            }
        }

        /* renamed from: com.baidu.sofire.face.a.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0181b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0181b(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                FaceProcessCallback faceProcessCallback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = this.b.a.d) != null) {
                    faceProcessCallback.onDeviceCheckResult(this.a);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                FaceProcessCallback faceProcessCallback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = this.a.a.d) != null) {
                    faceProcessCallback.onBeginCollectFaceInfo();
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0118 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x013f A[Catch: all -> 0x018b, TryCatch #0 {all -> 0x018b, blocks: (B:5:0x0007, B:8:0x000e, B:10:0x001a, B:12:0x004d, B:14:0x0057, B:16:0x0061, B:18:0x0067, B:21:0x006e, B:23:0x007c, B:25:0x0080, B:26:0x0088, B:28:0x008e, B:30:0x0098, B:32:0x00a0, B:35:0x00a7, B:38:0x00b3, B:40:0x00b9, B:55:0x0112, B:66:0x012a, B:68:0x0130, B:70:0x0134, B:73:0x013f, B:76:0x0147, B:78:0x014d, B:81:0x0154, B:84:0x015e, B:86:0x0162, B:88:0x0166, B:89:0x0169, B:92:0x0170, B:94:0x0174, B:96:0x0178, B:97:0x0180, B:100:0x0187, B:61:0x011e, B:41:0x00cf, B:43:0x00d9, B:45:0x00df, B:47:0x00f7, B:49:0x0101), top: B:108:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0145  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            b bVar;
            int i;
            Pair<Integer, Object> callSync;
            char c2;
            b bVar2;
            int i2;
            b bVar3;
            Activity activity;
            Activity activity2;
            b bVar4;
            int i3;
            Activity activity3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b bVar5 = this.a;
                    if (bVar5.p) {
                        return;
                    }
                    bVar5.o = com.baidu.sofire.face.b.b.a("4");
                    Class cls = Integer.TYPE;
                    b bVar6 = this.a;
                    Pair<Integer, Object> callSync2 = FH.callSync(1, "sfv", new Class[]{Activity.class, SurfaceHolder.class, Object.class, cls}, bVar6.b, bVar6.c, bVar6.d, Integer.valueOf(bVar6.n));
                    if (callSync2 != null && ((Integer) callSync2.first).intValue() == 0 && ((Integer) callSync2.second).intValue() == 1) {
                        this.a.getClass();
                        return;
                    }
                    b bVar7 = this.a;
                    if (bVar7.p) {
                        return;
                    }
                    com.baidu.sofire.face.b.b.a(bVar7.a, bVar7.o, 0, 0, null);
                    b bVar8 = this.a;
                    if (bVar8.d != null && (activity3 = bVar8.b) != null) {
                        activity3.runOnUiThread(new RunnableC0180a(this));
                    }
                    if (!FH.isInitSuc(1) && this.a.k.a()) {
                        this.a.a(-15);
                        return;
                    }
                    b bVar9 = this.a;
                    if (bVar9.p) {
                        return;
                    }
                    if (bVar9.k.b() && (i3 = (bVar4 = this.a).n) == 0) {
                        FH.call(1, "fdrv", new Class[]{String.class, cls}, bVar4.o, Integer.valueOf(i3));
                    } else if (this.a.k.b() && (i = (bVar = this.a).n) > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, cls}, bVar.o, Integer.valueOf(i))) != null && ((Integer) callSync.first).intValue() == 0) {
                        int intValue = ((Integer) callSync.second).intValue();
                        if (intValue == 1) {
                            c2 = 1;
                        } else if (intValue == 2) {
                            c2 = 65534;
                        }
                        bVar2 = this.a;
                        if (!bVar2.p) {
                            return;
                        }
                        if (c2 != 65534) {
                            if (c2 == 65535 && bVar2.k.e()) {
                            }
                            i2 = 1;
                            bVar3 = this.a;
                            if (bVar3.d != null && (activity2 = bVar3.b) != null) {
                                activity2.runOnUiThread(new RunnableC0181b(this, i2));
                            }
                            if (c2 != 65534) {
                                this.a.a(-3);
                                return;
                            } else if (i2 == -1) {
                                this.a.a(-3);
                                return;
                            } else {
                                b bVar10 = this.a;
                                if (bVar10.p) {
                                    return;
                                }
                                b.c(bVar10);
                                b bVar11 = this.a;
                                if (bVar11.p) {
                                    return;
                                }
                                if (bVar11.q && !bVar11.L) {
                                    b.a(bVar11);
                                }
                                b bVar12 = this.a;
                                if (bVar12.p) {
                                    return;
                                }
                                if (bVar12.d != null && (activity = bVar12.b) != null) {
                                    activity.runOnUiThread(new c(this));
                                }
                                b bVar13 = this.a;
                                if (bVar13.p) {
                                    return;
                                }
                                bVar13.f();
                                return;
                            }
                        }
                        i2 = -1;
                        bVar3 = this.a;
                        if (bVar3.d != null) {
                            activity2.runOnUiThread(new RunnableC0181b(this, i2));
                        }
                        if (c2 != 65534) {
                        }
                    }
                    c2 = 65535;
                    bVar2 = this.a;
                    if (!bVar2.p) {
                    }
                } catch (Throwable th) {
                    b bVar14 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar14.a, bVar14.o, 1, th);
                    this.a.a(-9);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                FaceProcessCallback faceProcessCallback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = this.a.a.d) != null) {
                    faceProcessCallback.onBeginBuildData();
                }
            }
        }

        public k(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Object> pair;
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b bVar = this.a;
                    if (bVar.p) {
                        return;
                    }
                    if (bVar.q && !bVar.L) {
                        b.a(bVar);
                    }
                    b bVar2 = this.a;
                    if (bVar2.p) {
                        return;
                    }
                    if (bVar2.d != null && (activity = bVar2.b) != null) {
                        activity.runOnUiThread(new a(this));
                    }
                    b bVar3 = this.a;
                    JSONObject jSONObject = null;
                    if (bVar3.s) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, bVar3.o, Boolean.FALSE, bVar3.b());
                        this.a.s = false;
                    } else {
                        pair = null;
                    }
                    if (this.a.p) {
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
                                b bVar4 = this.a;
                                if (bVar4.R > 0 && bVar4.k.d()) {
                                    b bVar5 = this.a;
                                    bVar5.getClass();
                                    try {
                                        bVar5.a(jSONObject, "g");
                                        bVar5.a(jSONObject, "l");
                                        bVar5.a(jSONObject, "d");
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    }
                    b bVar6 = this.a;
                    if (bVar6.p) {
                        return;
                    }
                    bVar6.a(bVar6.a(jSONObject));
                } catch (Throwable th) {
                    b bVar7 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar7.a, bVar7.o, 6, th);
                    this.a.a(-12);
                }
            }
        }
    }

    /* renamed from: com.baidu.sofire.face.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0182b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC0182b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.a;
                bVar.f1069T = com.baidu.sofire.face.b.b.b(bVar.a);
                b bVar2 = this.a;
                bVar2.S = com.baidu.sofire.face.b.b.a(bVar2.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b bVar = this.a;
                    if (bVar.p) {
                        return;
                    }
                    SurfaceHolder surfaceHolder = bVar.c;
                    if (surfaceHolder != null) {
                        surfaceHolder.addCallback(bVar);
                    }
                    b bVar2 = this.a;
                    if (bVar2.x == null && !bVar2.p) {
                        bVar2.x = b.b(bVar2, true);
                    }
                    b bVar3 = this.a;
                    Camera camera = bVar3.x;
                    if (camera == null) {
                        return;
                    }
                    if (bVar3.y == null) {
                        bVar3.y = camera.getParameters();
                    }
                    this.a.x.stopPreview();
                    this.a.D = false;
                    this.a.y.setPictureFormat(256);
                    b bVar4 = this.a;
                    int a = b.a(bVar4, bVar4.a);
                    try {
                        this.a.x.setDisplayOrientation(a);
                    } catch (Throwable unused) {
                    }
                    this.a.y.set("rotation", a);
                    this.a.C.set(a);
                    Camera.Parameters parameters = this.a.y;
                    b bVar5 = this.a;
                    Point a2 = com.baidu.sofire.face.c.a.a(parameters, new Point(bVar5.v, bVar5.w));
                    b bVar6 = this.a;
                    int i = a2.x;
                    bVar6.A = i;
                    int i2 = a2.y;
                    bVar6.B = i2;
                    bVar6.t.set(0, 0, i2, i);
                    b bVar7 = this.a;
                    float f = bVar7.v / 2;
                    float f2 = f - (0.33f * f);
                    float f3 = bVar7.B / 2;
                    float f4 = bVar7.A / 2;
                    float f5 = f4 - (0.1f * f4);
                    if (f3 <= f2) {
                        f2 = f3;
                    }
                    float f6 = (0.2f * f2) + f2;
                    bVar7.u.set((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
                    b bVar8 = this.a;
                    bVar8.y.setPreviewSize(bVar8.A, bVar8.B);
                    b bVar9 = this.a;
                    bVar9.x.setParameters(bVar9.y);
                    b bVar10 = this.a;
                    FaceProcessCallback faceProcessCallback = bVar10.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.onConfigCamera(bVar10.x, bVar10.t, bVar10.u, bVar10.C);
                    }
                    b bVar11 = this.a;
                    if (bVar11.h) {
                        ILivenessStrategy iLivenessStrategy = bVar11.N;
                        if (iLivenessStrategy != null) {
                            iLivenessStrategy.setPreviewDegree(bVar11.C.get());
                        }
                    } else {
                        IDetectStrategy iDetectStrategy = bVar11.O;
                        if (iDetectStrategy != null) {
                            iDetectStrategy.setPreviewDegree(bVar11.C.get());
                        }
                    }
                    b bVar12 = this.a;
                    bVar12.A = bVar12.y.getPreviewSize().width;
                    b bVar13 = this.a;
                    bVar13.B = bVar13.y.getPreviewSize().height;
                    b bVar14 = this.a;
                    bVar14.x.setPreviewDisplay(bVar14.c);
                    b bVar15 = this.a;
                    bVar15.x.setErrorCallback(bVar15);
                    b bVar16 = this.a;
                    bVar16.x.setPreviewCallback(bVar16);
                    b bVar17 = this.a;
                    if (bVar17.p) {
                        return;
                    }
                    bVar17.x.startPreview();
                    this.a.D = true;
                    Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.a.o);
                    if (callSync != null && ((Integer) callSync.first).intValue() == 0) {
                        this.a.s = true;
                    }
                } catch (Throwable th) {
                    b bVar18 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar18.a, bVar18.o, 2, th);
                    this.a.a(-5);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ b b;

        public d(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            FaceProcessCallback faceProcessCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = (bVar = this.b).d) != null) {
                int i = this.a;
                if (i == 1) {
                    faceProcessCallback.onEnd(i, bVar.X);
                } else {
                    faceProcessCallback.onEnd(i, null);
                }
                this.b.d = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b bVar = this.a;
                    if (bVar.p) {
                        return;
                    }
                    bVar.L = false;
                    b bVar2 = this.a;
                    SurfaceHolder surfaceHolder = bVar2.c;
                    if (surfaceHolder != null) {
                        surfaceHolder.addCallback(bVar2);
                    }
                    b bVar3 = this.a;
                    if (bVar3.E == null) {
                        bVar3.E = b.b(bVar3, false);
                    }
                    b bVar4 = this.a;
                    Camera camera = bVar4.E;
                    if (camera != null) {
                        if (bVar4.F == null) {
                            bVar4.F = camera.getParameters();
                        }
                        this.a.E.stopPreview();
                        this.a.F.setPictureFormat(256);
                        b bVar5 = this.a;
                        int a = b.a(bVar5, bVar5.a);
                        this.a.E.setDisplayOrientation(a);
                        this.a.F.set("rotation", a);
                        this.a.C.set(a);
                        Camera.Parameters parameters = this.a.F;
                        b bVar6 = this.a;
                        Point a2 = com.baidu.sofire.face.c.a.a(parameters, new Point(bVar6.v, bVar6.w));
                        b bVar7 = this.a;
                        int i = a2.x;
                        bVar7.A = i;
                        int i2 = a2.y;
                        bVar7.B = i2;
                        bVar7.F.setPreviewSize(i, i2);
                        b bVar8 = this.a;
                        bVar8.E.setParameters(bVar8.F);
                        b bVar9 = this.a;
                        bVar9.E.setPreviewDisplay(bVar9.c);
                        b bVar10 = this.a;
                        g gVar = new g(bVar10);
                        bVar10.E.setErrorCallback(gVar);
                        this.a.E.setPreviewCallback(gVar);
                        b bVar11 = this.a;
                        if (bVar11.p) {
                            return;
                        }
                        bVar11.E.startPreview();
                        return;
                    }
                    bVar4.L = true;
                    b.b(this.a);
                } catch (Throwable th) {
                    this.a.L = true;
                    b.b(this.a);
                    this.a.c();
                    b bVar12 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar12.a, bVar12.o, 5, th);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                this.a.G = false;
                Camera camera = this.a.E;
                if (camera != null) {
                    camera.setErrorCallback(null);
                    this.a.E.setPreviewCallback(null);
                    this.a.E.stopPreview();
                    com.baidu.sofire.face.a.a.a(this.a.E);
                    this.a.E = null;
                }
                b bVar = this.a;
                SurfaceHolder surfaceHolder = bVar.c;
                if (surfaceHolder != null) {
                    surfaceHolder.removeCallback(bVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Camera.ErrorCallback, Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, camera) != null) {
                return;
            }
            this.a.L = true;
            this.a.c();
            b.b(this.a);
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, camera) == null) {
                try {
                    b bVar = this.a;
                    int i = bVar.K;
                    if (i != 1) {
                        if (i == 2) {
                            bVar.J = bArr;
                        }
                    } else {
                        bVar.I = bArr;
                    }
                    bVar.c();
                    b.b(this.a);
                } catch (Throwable unused) {
                    this.a.c();
                    b.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements IDetectStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.pass.face.platform.IDetectStrategyCallback
        public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, faceStatusNewEnum, str, hashMap, hashMap2) == null) {
                try {
                    b bVar = this.a;
                    if (!bVar.m && !bVar.p) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            bVar.m = true;
                            Map<Long, String> a = b.a(bVar, hashMap, hashMap2);
                            if (a != null) {
                                this.a.P = a;
                            } else {
                                this.a.a(-8);
                            }
                            b bVar2 = this.a;
                            if (bVar2.d != null) {
                                b.b(bVar2, hashMap, hashMap2);
                                this.a.d.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, -1);
                            }
                            if (com.baidu.sofire.face.b.f.a().a(new k(this.a)) != 1) {
                                this.a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            FaceProcessCallback faceProcessCallback = bVar.d;
                            if (faceProcessCallback != null) {
                                faceProcessCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                            this.a.a(-18);
                        } else {
                            FaceProcessCallback faceProcessCallback2 = bVar.d;
                            if (faceProcessCallback2 != null) {
                                faceProcessCallback2.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                        }
                    }
                } catch (Throwable th) {
                    b bVar3 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar3.a, bVar3.o, 4, th);
                    this.a.a(-10);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ILivenessStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public i(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.pass.face.platform.ILivenessStrategyCallback
        public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i)}) == null) {
                try {
                    b bVar = this.a;
                    if (!bVar.m && !bVar.p) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            bVar.m = true;
                            Map<Long, String> a = b.a(bVar, hashMap, hashMap2);
                            if (a != null) {
                                this.a.P = a;
                            } else {
                                this.a.a(-8);
                            }
                            b bVar2 = this.a;
                            if (bVar2.d != null) {
                                b.b(bVar2, hashMap, hashMap2);
                                this.a.d.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i);
                            }
                            if (com.baidu.sofire.face.b.f.a().a(new k(this.a)) != 1) {
                                this.a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            FaceProcessCallback faceProcessCallback = bVar.d;
                            if (faceProcessCallback != null) {
                                faceProcessCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                            }
                            this.a.a(-18);
                        } else {
                            FaceProcessCallback faceProcessCallback2 = bVar.d;
                            if (faceProcessCallback2 != null) {
                                faceProcessCallback2.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                            }
                        }
                    }
                } catch (Throwable th) {
                    b bVar3 = this.a;
                    com.baidu.sofire.face.b.b.a(bVar3.a, bVar3.o, 4, th);
                    this.a.a(-10);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ILivenessViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public j(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void setCurrentLiveType(LivenessTypeEnum livenessTypeEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessTypeEnum) == null) {
                try {
                    FaceProcessCallback faceProcessCallback = this.a.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.setCurrentLiveType(livenessTypeEnum);
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void setFaceInfo(FaceExtInfo faceExtInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceExtInfo) == null) {
                try {
                    FaceProcessCallback faceProcessCallback = this.a.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.setFaceInfo(faceExtInfo);
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void animStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FaceProcessCallback faceProcessCallback = this.a.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.animStop();
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.baidu.pass.face.platform.ILivenessViewCallback
        public void viewReset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    FaceProcessCallback faceProcessCallback = this.a.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.viewReset();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public b(com.baidu.sofire.face.a.e eVar, Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i2, IFaceProcessInfo iFaceProcessInfo, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i2), iFaceProcessInfo, Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.m = false;
        this.n = 5;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = new Rect();
        this.u = new Rect();
        this.v = 0;
        this.w = 0;
        this.C = new Degree(0);
        this.D = false;
        this.G = false;
        this.K = 0;
        this.L = false;
        this.Q = 1;
        this.R = 0L;
        this.f1069T = -1;
        this.U = new HashMap();
        this.W = 0L;
        this.i = eVar;
        Context applicationContext = activity.getApplicationContext();
        this.a = applicationContext;
        this.b = activity;
        this.c = surfaceHolder;
        this.d = faceProcessCallback;
        this.n = i2;
        com.baidu.sofire.face.b.e a2 = com.baidu.sofire.face.b.e.a(applicationContext);
        this.k = a2;
        this.V = a2.c();
        this.j = iFaceProcessInfo;
        this.h = z;
        this.Q = i3;
    }

    public static int a(b bVar, Context context) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, context)) == null) {
            bVar.getClass();
            try {
                int rotation = bVar.b.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation != 3) {
                            i2 = 0;
                        } else {
                            i2 = 270;
                        }
                    } else {
                        i2 = 180;
                    }
                } else {
                    i2 = 90;
                }
                int i4 = ((0 - i2) + 360) % 360;
                if (Build.VERSION.SDK_INT >= 9) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(bVar.z, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        i3 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                    } else {
                        i3 = ((cameraInfo.orientation - i2) + 360) % 360;
                    }
                    return i3;
                }
                return i4;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static Map a(b bVar, HashMap hashMap, HashMap hashMap2) {
        InterceptResult invokeLLL;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bVar, hashMap, hashMap2)) == null) {
            bVar.getClass();
            try {
                if (bVar.M.getOutputImageType() == 0) {
                    hashMap = hashMap2;
                }
                if (hashMap != null && hashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(hashMap.entrySet());
                    Collections.sort(arrayList, new com.baidu.sofire.face.a.d(bVar));
                    if (arrayList.size() > 0) {
                        int i2 = bVar.Q;
                        if (i2 < 0) {
                            i2 = 1;
                        }
                        if (i2 > arrayList.size()) {
                            i2 = arrayList.size();
                        }
                        HashMap hashMap3 = new HashMap();
                        for (int i3 = 0; i3 < i2; i3++) {
                            String[] split = ((String) ((Map.Entry) arrayList.get(i3)).getKey()).split("_");
                            if (split.length > 3) {
                                currentTimeMillis = Long.valueOf(split[3]).longValue();
                            } else {
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            if (bVar.R == 0) {
                                bVar.R = currentTimeMillis;
                            }
                            String secBase64 = ((ImageInfo) ((Map.Entry) arrayList.get(i3)).getValue()).getSecBase64();
                            if (!TextUtils.isEmpty(secBase64)) {
                                secBase64 = secBase64.replace("\n", "").replace("\t", "").replace("\r", "");
                            }
                            hashMap3.put(Long.valueOf(currentTimeMillis), secBase64);
                        }
                        return hashMap3;
                    }
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (Map) invokeLLL.objValue;
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (bVar) {
                if (!bVar.L && !bVar.p) {
                    bVar.K++;
                    bVar.G = true;
                    bVar.e();
                    if (!bVar.L) {
                        try {
                            bVar.wait(2000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    bVar.G = false;
                }
            }
        }
    }

    @Override // com.baidu.pass.face.platform.listener.ISecurityCallback
    public void getFaceInfoForSecurity(FaceInfo[] faceInfoArr) {
        Map<Long, FaceInfo> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, faceInfoArr) == null) && faceInfoArr != null) {
            try {
                if (faceInfoArr.length == 0 || this.V == 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.W >= this.V && (map = this.U) != null) {
                    map.put(Long.valueOf(currentTimeMillis), faceInfoArr[0]);
                    this.W = currentTimeMillis;
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, camera) == null) {
            a(-5);
        }
    }

    public static Camera b(b bVar, boolean z) {
        InterceptResult invokeLZ;
        int numberOfCameras;
        Camera open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, bVar, z)) == null) {
            if (bVar.p || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
                return null;
            }
            int i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if ((z && cameraInfo.facing == 1) || (!z && cameraInfo.facing == 0)) {
                    break;
                }
                i2++;
            }
            if (i2 < numberOfCameras) {
                open = Camera.open(i2);
                bVar.z = i2;
            } else {
                open = Camera.open(0);
                bVar.z = 0;
            }
            return open;
        }
        return (Camera) invokeLZ.objValue;
    }

    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            synchronized (bVar) {
                try {
                    bVar.notifyAll();
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.baidu.sofire.face.a.j
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            try {
                if (this.h && !this.p) {
                    ILivenessStrategy iLivenessStrategy = this.N;
                    if (iLivenessStrategy != null) {
                        iLivenessStrategy.setLivenessStrategySoundEnable(z);
                        return;
                    }
                    return;
                }
                IDetectStrategy iDetectStrategy = this.O;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(z);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(b bVar, HashMap hashMap, HashMap hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, bVar, hashMap, hashMap2) == null) {
            bVar.getClass();
            if (hashMap != null) {
                try {
                    if (hashMap.size() > 0) {
                        for (ImageInfo imageInfo : hashMap.values()) {
                            imageInfo.setBase64("");
                        }
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            if (hashMap2 != null && hashMap2.size() > 0) {
                for (ImageInfo imageInfo2 : hashMap2.values()) {
                    imageInfo2.setBase64("");
                }
            }
        }
    }

    public static void c(b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            bVar.getClass();
            bVar.M = FaceSDKManager.getInstance().getFaceConfig();
            if (((AudioManager) bVar.a.getSystemService("audio")).getStreamVolume(3) > 0) {
                z = bVar.M.isSound();
            } else {
                z = false;
            }
            bVar.l = z;
            if (bVar.h) {
                if (bVar.e == null) {
                    bVar.e = new i(bVar);
                }
            } else if (bVar.f == null) {
                bVar.f = new h(bVar);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            bVar.b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            bVar.v = displayMetrics.widthPixels;
            bVar.w = displayMetrics.heightPixels;
            bVar.r = bVar.k.a.getBoolean("lt_sfff", false);
            bVar.q = bVar.k.a.getBoolean("lt_sbff", false);
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            try {
                this.m = true;
                this.p = true;
                this.b.runOnUiThread(new d(this, i2));
                try {
                    this.b.runOnUiThread(new com.baidu.sofire.face.a.c(this));
                } catch (Throwable unused) {
                }
                c();
                if (this.s) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.o, Boolean.TRUE, b());
                    this.s = false;
                }
                SurfaceHolder surfaceHolder = this.c;
                if (surfaceHolder != null) {
                    surfaceHolder.removeCallback(this);
                    this.c = null;
                }
                this.b = null;
                com.baidu.sofire.face.a.e eVar = this.i;
                if (eVar != null) {
                    com.baidu.sofire.face.a.j jVar = eVar.a;
                    if (jVar != null && this == jVar) {
                        eVar.a = null;
                    }
                    this.i = null;
                }
                Map<Long, String> map = this.P;
                if (map != null) {
                    map.clear();
                    this.P = null;
                }
                com.baidu.sofire.face.b.b.a(this.a, this.o, 2, i2, null);
            } catch (Throwable unused2) {
            }
        }
    }

    public int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("f_i", this.o);
                jSONObject4.put("t_c", this.R);
                if (this.r && (bArr3 = this.H) != null && bArr3.length > 0) {
                    jSONObject4.put("d_f", Base64.encodeToString(a(bArr3, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (this.q && (bArr2 = this.I) != null && bArr2.length > 0) {
                    jSONObject4.put("d_p", Base64.encodeToString(a(bArr2, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (this.q && (bArr = this.J) != null && bArr.length > 0) {
                    jSONObject4.put("d_a", Base64.encodeToString(a(bArr, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (jSONObject != null) {
                    jSONObject4.put("s", jSONObject);
                }
                JSONObject jSONObject5 = new JSONObject();
                IFaceProcessInfo iFaceProcessInfo = this.j;
                if (iFaceProcessInfo != null) {
                    jSONObject2 = iFaceProcessInfo.buildJson();
                } else {
                    jSONObject2 = null;
                }
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                Map<Long, String> map = this.P;
                if (map != null && map.size() == 1) {
                    jSONObject2.put("image", this.P.values().iterator().next());
                } else {
                    Map<Long, String> map2 = this.P;
                    if (map2 != null && map2.size() >= 2) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.P.values()) {
                            jSONArray.put(str);
                        }
                        jSONObject2.put("images", jSONArray);
                    }
                }
                jSONObject2.put("image_type", FaceEnum.ImageType.BASE64.name());
                jSONObject2.put("image_sec", true);
                jSONObject2.put("risk_identify", true);
                jSONObject2.put("app", "android");
                jSONObject5.put(UgcTranscoderConstant.URL_GET_FACE, jSONObject2);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("zid", FH.gzfi(this.a, "", 5002));
                jSONObject6.put(Config.EVENT_PART, UgcTranscoderConstant.URL_GET_FACE);
                jSONObject6.put(NotificationStyle.NOTIFICATION_STYLE, this.f1069T);
                jSONObject6.put("ts", System.currentTimeMillis());
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    jSONObject6.put("tz", timeZone.getID());
                }
                JSONArray jSONArray2 = this.S;
                if (jSONArray2 != null) {
                    jSONObject6.put("ce", jSONArray2);
                }
                jSONObject5.put("risk", jSONObject6);
                jSONObject4.put("e", jSONObject5);
                String str2 = com.baidu.sofire.face.a.e.d;
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split = str2.split("-");
                        if (split.length >= 3) {
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < split.length - 3; i2++) {
                                sb.append(split[i2]);
                                sb.append("-");
                            }
                            sb.append(split[split.length - 3]);
                            str2 = sb.toString();
                        }
                    }
                } catch (Throwable unused) {
                }
                jSONObject3.put("licenseId", str2);
                jSONObject3.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.a, jSONObject4.toString().getBytes()), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                jSONObject3.put("app", "android");
                String packageName = this.a.getPackageName();
                if (packageName != null) {
                    jSONObject3.put("pkg", packageName);
                    try {
                        Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
                        if (signatureArr != null && signatureArr.length > 0) {
                            jSONObject3.put("sign", com.baidu.sofire.face.b.c.b(signatureArr[0].toByteArray()));
                        }
                    } catch (Throwable unused2) {
                    }
                }
                this.X = com.baidu.sofire.face.b.b.a(this.a, jSONObject3.toString(), (byte[]) null, (String) null);
                return 1;
            } catch (Throwable unused3) {
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public final JSONObject a(FaceInfo faceInfo) {
        InterceptResult invokeL;
        String arrays;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        String name;
        String name2;
        String name3;
        String name4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceInfo)) == null) {
            if (faceInfo == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("faceID", faceInfo.faceID);
                jSONObject.put("centerX", faceInfo.centerX);
                jSONObject.put("centerY", faceInfo.centerY);
                jSONObject.put("width", faceInfo.width);
                jSONObject.put("height", faceInfo.height);
                jSONObject.put("angle", faceInfo.angle);
                jSONObject.put("score", faceInfo.score);
                float[] fArr = faceInfo.landmarks;
                String str = "";
                if (fArr == null) {
                    arrays = "";
                } else {
                    arrays = Arrays.toString(fArr);
                }
                jSONObject.put("landmarks", arrays);
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.p, faceInfo.yaw);
                jSONObject.put("roll", faceInfo.roll);
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.q, faceInfo.pitch);
                jSONObject.put("bluriness", faceInfo.bluriness);
                jSONObject.put("illum", faceInfo.illum);
                BDFaceOcclusion bDFaceOcclusion = faceInfo.occlusion;
                double d8 = 0.0d;
                if (bDFaceOcclusion == null) {
                    d2 = 0.0d;
                } else {
                    d2 = bDFaceOcclusion.leftEye;
                }
                jSONObject.put("occlusion_leftEye", d2);
                BDFaceOcclusion bDFaceOcclusion2 = faceInfo.occlusion;
                if (bDFaceOcclusion2 == null) {
                    d3 = 0.0d;
                } else {
                    d3 = bDFaceOcclusion2.rightEye;
                }
                jSONObject.put("occlusion_rightEye", d3);
                BDFaceOcclusion bDFaceOcclusion3 = faceInfo.occlusion;
                if (bDFaceOcclusion3 == null) {
                    d4 = 0.0d;
                } else {
                    d4 = bDFaceOcclusion3.leftCheek;
                }
                jSONObject.put("occlusion_leftCheek", d4);
                BDFaceOcclusion bDFaceOcclusion4 = faceInfo.occlusion;
                if (bDFaceOcclusion4 == null) {
                    d5 = 0.0d;
                } else {
                    d5 = bDFaceOcclusion4.rightCheek;
                }
                jSONObject.put("occlusion_rightCheek", d5);
                BDFaceOcclusion bDFaceOcclusion5 = faceInfo.occlusion;
                if (bDFaceOcclusion5 == null) {
                    d6 = 0.0d;
                } else {
                    d6 = bDFaceOcclusion5.mouth;
                }
                jSONObject.put("occlusion_mouth", d6);
                BDFaceOcclusion bDFaceOcclusion6 = faceInfo.occlusion;
                if (bDFaceOcclusion6 == null) {
                    d7 = 0.0d;
                } else {
                    d7 = bDFaceOcclusion6.nose;
                }
                jSONObject.put("occlusion_nose", d7);
                BDFaceOcclusion bDFaceOcclusion7 = faceInfo.occlusion;
                if (bDFaceOcclusion7 != null) {
                    d8 = bDFaceOcclusion7.chin;
                }
                jSONObject.put("occlusion_chin", d8);
                jSONObject.put("age", faceInfo.age);
                BDFaceSDKCommon.BDFaceRace bDFaceRace = faceInfo.race;
                if (bDFaceRace == null) {
                    name = "";
                } else {
                    name = bDFaceRace.name();
                }
                jSONObject.put("race", name);
                BDFaceSDKCommon.BDFaceGlasses bDFaceGlasses = faceInfo.glasses;
                if (bDFaceGlasses == null) {
                    name2 = "";
                } else {
                    name2 = bDFaceGlasses.name();
                }
                jSONObject.put("glasses", name2);
                BDFaceSDKCommon.BDFaceGender bDFaceGender = faceInfo.gender;
                if (bDFaceGender == null) {
                    name3 = "";
                } else {
                    name3 = bDFaceGender.name();
                }
                jSONObject.put("gender", name3);
                BDFaceSDKCommon.BDFaceEmotion bDFaceEmotion = faceInfo.emotionThree;
                if (bDFaceEmotion == null) {
                    name4 = "";
                } else {
                    name4 = bDFaceEmotion.name();
                }
                jSONObject.put("emotionThree", name4);
                BDFaceSDKCommon.BDFaceEmotionEnum bDFaceEmotionEnum = faceInfo.emotionSeven;
                if (bDFaceEmotionEnum != null) {
                    str = bDFaceEmotionEnum.name();
                }
                jSONObject.put("emotionSeven", str);
                jSONObject.put("mouthclose", faceInfo.mouthclose);
                jSONObject.put("leftEyeclose", faceInfo.leftEyeclose);
                jSONObject.put("rightEyeclose", faceInfo.rightEyeclose);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
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
                            if (split.length != 2) {
                                continue;
                            } else {
                                try {
                                    j2 = Long.valueOf(split[0]).longValue();
                                } catch (Throwable unused) {
                                    j2 = 0;
                                }
                                if (j2 <= 0) {
                                    continue;
                                } else if (j2 > this.R) {
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = string;
                                    }
                                } else {
                                    str2 = string;
                                }
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
            } catch (Throwable unused2) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.face.a.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.p) {
                    return;
                }
                this.p = true;
                FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.o, Boolean.TRUE, "");
                a(-6);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        RenderScript renderScript;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB;
        Allocation allocation;
        Allocation allocation2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i2, i3)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                renderScript = RenderScript.create(this.a);
            } catch (Throwable unused) {
                renderScript = null;
                scriptIntrinsicYuvToRGB = null;
            }
            try {
                scriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
                try {
                    Type.Builder x = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
                    Type.Builder y = new Type.Builder(renderScript, Element.RGBA_8888(renderScript)).setX(i2).setY(i3);
                    allocation = Allocation.createTyped(renderScript, x.create(), 1);
                    try {
                        allocation2 = Allocation.createTyped(renderScript, y.create(), 1);
                        try {
                            allocation.copyFrom(bArr);
                            scriptIntrinsicYuvToRGB.setInput(allocation);
                            scriptIntrinsicYuvToRGB.forEach(allocation2);
                            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                            allocation2.copyTo(createBitmap);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                if (renderScript != null) {
                                    try {
                                        renderScript.destroy();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                try {
                                    scriptIntrinsicYuvToRGB.destroy();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    allocation.destroy();
                                } catch (Throwable unused4) {
                                }
                                try {
                                    allocation2.destroy();
                                } catch (Throwable unused5) {
                                }
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Throwable unused6) {
                                }
                                return byteArray;
                            } catch (Throwable unused7) {
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (renderScript != null) {
                                    try {
                                        renderScript.destroy();
                                    } catch (Throwable unused8) {
                                    }
                                }
                                if (scriptIntrinsicYuvToRGB != null) {
                                    try {
                                        scriptIntrinsicYuvToRGB.destroy();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (allocation != null) {
                                    try {
                                        allocation.destroy();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (allocation2 != null) {
                                    try {
                                        allocation2.destroy();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable unused12) {
                                    }
                                }
                                return new byte[0];
                            }
                        } catch (Throwable unused13) {
                        }
                    } catch (Throwable unused14) {
                        allocation2 = null;
                    }
                } catch (Throwable unused15) {
                    allocation = null;
                    allocation2 = allocation;
                    if (renderScript != null) {
                    }
                    if (scriptIntrinsicYuvToRGB != null) {
                    }
                    if (allocation != null) {
                    }
                    if (allocation2 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return new byte[0];
                }
            } catch (Throwable unused16) {
                scriptIntrinsicYuvToRGB = null;
                allocation = scriptIntrinsicYuvToRGB;
                allocation2 = allocation;
                if (renderScript != null) {
                }
                if (scriptIntrinsicYuvToRGB != null) {
                }
                if (allocation != null) {
                }
                if (allocation2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return new byte[0];
            }
        } else {
            return (byte[]) invokeLII.objValue;
        }
    }

    public final String b() {
        JSONObject a2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                Map<Long, FaceInfo> map = this.U;
                if (map != null && map.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<Long, FaceInfo> entry : this.U.entrySet()) {
                        long longValue = entry.getKey().longValue();
                        FaceInfo value = entry.getValue();
                        if (longValue > 0 && (a2 = a(value)) != null) {
                            jSONObject.put(String.valueOf(longValue), a2);
                        }
                    }
                    return jSONObject.toString();
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.b.runOnUiThread(new f(this));
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                if (com.baidu.sofire.face.b.f.a().a(new a(this)) != 1) {
                    a(-7);
                }
                com.baidu.sofire.face.b.f.a().a(new RunnableC0182b(this));
            } catch (Throwable unused) {
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                this.b.runOnUiThread(new e(this));
            } catch (Throwable th) {
                this.L = true;
                synchronized (this) {
                    try {
                        notifyAll();
                    } catch (Throwable unused) {
                    }
                    c();
                    com.baidu.sofire.face.b.b.a(this.a, this.o, 5, th);
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.b.runOnUiThread(new c(this));
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.o, 2, th);
                a(-5);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bArr, camera) == null) {
            try {
                boolean z2 = this.m;
                if (!z2 && !(z = this.p)) {
                    if (this.r && this.H == null) {
                        this.H = bArr;
                    }
                    if (this.h) {
                        if (this.N == null && !z2 && !z) {
                            if (!com.baidu.sofire.face.a.e.b()) {
                                a(-20);
                            }
                            if (this.g == null) {
                                this.g = new j(this);
                            }
                            ILivenessStrategy livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this.g);
                            this.N = livenessStrategyModule;
                            livenessStrategyModule.setISecurityCallback(this);
                            this.N.setPreviewDegree(this.C.get());
                            this.N.setLivenessStrategySoundEnable(this.l);
                            this.N.setLivenessStrategyConfig(this.M.getLivenessTypeList(), this.t, this.u, this.e);
                        }
                        ILivenessStrategy iLivenessStrategy = this.N;
                        if (iLivenessStrategy != null && !this.m && !this.p) {
                            iLivenessStrategy.livenessStrategy(bArr);
                            return;
                        }
                        return;
                    }
                    if (this.O == null && !z2 && !z) {
                        if (!com.baidu.sofire.face.a.e.b()) {
                            a(-20);
                        }
                        IDetectStrategy detectStrategyModule = FaceSDKManager.getInstance().getDetectStrategyModule();
                        this.O = detectStrategyModule;
                        detectStrategyModule.setISecurityCallback(this);
                        this.O.setPreviewDegree(this.C.get());
                        this.O.setDetectStrategySoundEnable(this.l);
                        this.O.setDetectStrategyConfig(this.t, this.u, this.f);
                    }
                    IDetectStrategy iDetectStrategy = this.O;
                    if (iDetectStrategy != null && !this.m && !this.p) {
                        iDetectStrategy.detectStrategy(bArr);
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.o, 3, th);
                a(-11);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048591, this, surfaceHolder, i2, i3, i4) != null) || this.p || surfaceHolder.getSurface() == null) {
            return;
        }
        if (this.D) {
            f();
        } else if (this.G) {
            e();
        }
    }
}
