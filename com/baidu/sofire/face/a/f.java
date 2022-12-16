package com.baidu.sofire.face.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.TextureView;
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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements TextureView.SurfaceTextureListener, Camera.ErrorCallback, ISecurityCallback, com.baidu.sofire.face.a.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera A;
    public Camera.Parameters B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public Camera G;
    public Camera.Parameters H;
    public boolean I;
    public Bitmap J;
    public volatile int K;
    public Bitmap L;
    public byte[] M;
    public byte[] N;
    public int O;
    public boolean P;
    public FaceConfig Q;
    public ILivenessStrategy R;
    public IDetectStrategy S;
    public Map<Long, String> T;
    public int U;
    public long V;
    public JSONArray W;
    public int X;
    public Map<Long, FaceInfo> Y;
    public long Z;
    public Context a;
    public long a0;
    public Activity b;
    public RequestInfo b0;
    public TextureView c;
    public h c0;
    public FaceProcessCallback d;
    public com.baidu.sofire.face.d.c d0;
    public j e;
    public String e0;
    public i f;
    public String f0;
    public k g;
    public boolean g0;
    public boolean h;
    public long h0;
    public boolean i;
    public boolean i0;
    public com.baidu.sofire.face.a.e j;
    public Timer j0;
    public int k;
    public int l;
    public IFaceProcessInfo m;
    public com.baidu.sofire.face.b.d n;
    public volatile boolean o;
    public boolean p;
    public int q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public Degree w;
    public Rect x;
    public Rect y;
    public int z;

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: com.baidu.sofire.face.a.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0183a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0183a(a aVar) {
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

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public b(a aVar, int i) {
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

        /* loaded from: classes3.dex */
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

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00cd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00f4 A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:5:0x0007, B:8:0x000e, B:11:0x001d, B:13:0x002c, B:15:0x0030, B:16:0x0038, B:18:0x003e, B:20:0x0048, B:22:0x0050, B:25:0x0057, B:28:0x0064, B:30:0x006a, B:45:0x00c7, B:56:0x00df, B:58:0x00e5, B:60:0x00e9, B:63:0x00f4, B:66:0x00fc, B:68:0x0102, B:71:0x0109, B:74:0x0113, B:76:0x0117, B:78:0x011b, B:79:0x011e, B:82:0x0125, B:84:0x0129, B:86:0x012d, B:87:0x0135, B:90:0x013c, B:51:0x00d3, B:31:0x0082, B:33:0x008c, B:35:0x0092, B:37:0x00ac, B:39:0x00b6), top: B:98:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            f fVar;
            int i;
            Pair<Integer, Object> callSync;
            char c2;
            f fVar2;
            int i2;
            f fVar3;
            Activity activity;
            Activity activity2;
            f fVar4;
            int i3;
            Activity activity3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    f fVar5 = this.a;
                    if (fVar5.s) {
                        return;
                    }
                    fVar5.r = com.baidu.sofire.face.b.b.a("5");
                    f fVar6 = this.a;
                    if (fVar6.s) {
                        return;
                    }
                    com.baidu.sofire.face.b.b.a(fVar6.a, fVar6.r, 1, 0, null);
                    f fVar7 = this.a;
                    if (fVar7.d != null && (activity3 = fVar7.b) != null) {
                        activity3.runOnUiThread(new RunnableC0183a(this));
                    }
                    if (!FH.isInitSuc(1) && this.a.n.a()) {
                        this.a.a(-15);
                        return;
                    }
                    f fVar8 = this.a;
                    if (fVar8.s) {
                        return;
                    }
                    if (fVar8.n.b() && (i3 = (fVar4 = this.a).q) == 0) {
                        FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, fVar4.r, Integer.valueOf(i3));
                    } else if (this.a.n.b() && (i = (fVar = this.a).q) > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, fVar.r, Integer.valueOf(i))) != null && ((Integer) callSync.first).intValue() == 0) {
                        int intValue = ((Integer) callSync.second).intValue();
                        if (intValue == 1) {
                            c2 = 1;
                        } else if (intValue == 2) {
                            c2 = 65534;
                        }
                        fVar2 = this.a;
                        if (!fVar2.s) {
                            return;
                        }
                        if (c2 != 65534) {
                            if (c2 == 65535 && fVar2.n.e()) {
                            }
                            i2 = 1;
                            fVar3 = this.a;
                            if (fVar3.d != null && (activity2 = fVar3.b) != null) {
                                activity2.runOnUiThread(new b(this, i2));
                            }
                            if (c2 != 65534) {
                                this.a.a(-3);
                                return;
                            } else if (i2 == -1) {
                                this.a.a(-3);
                                return;
                            } else {
                                f fVar9 = this.a;
                                if (fVar9.s) {
                                    return;
                                }
                                f.e(fVar9);
                                f fVar10 = this.a;
                                if (fVar10.s) {
                                    return;
                                }
                                if (fVar10.t && !fVar10.P) {
                                    f.a(fVar10);
                                }
                                f fVar11 = this.a;
                                if (fVar11.s) {
                                    return;
                                }
                                if (fVar11.d != null && (activity = fVar11.b) != null) {
                                    activity.runOnUiThread(new c(this));
                                }
                                f fVar12 = this.a;
                                if (fVar12.s) {
                                    return;
                                }
                                fVar12.f();
                                return;
                            }
                        }
                        i2 = -1;
                        fVar3 = this.a;
                        if (fVar3.d != null) {
                            activity2.runOnUiThread(new b(this, i2));
                        }
                        if (c2 != 65534) {
                        }
                    }
                    c2 = 65535;
                    fVar2 = this.a;
                    if (!fVar2.s) {
                    }
                } catch (Throwable th) {
                    f fVar13 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar13.a, fVar13.r, 1, th);
                    this.a.a(-9);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* loaded from: classes3.dex */
        public class a extends TimerTask {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f.c(this.a.a);
                }
            }
        }

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    f fVar = this.a;
                    boolean z = fVar.s;
                    if (z) {
                        return;
                    }
                    if (fVar.A == null && !z) {
                        fVar.A = f.b(fVar, true);
                    }
                    f fVar2 = this.a;
                    Camera camera = fVar2.A;
                    if (camera == null) {
                        return;
                    }
                    if (fVar2.B == null) {
                        fVar2.B = camera.getParameters();
                    }
                    this.a.A.stopPreview();
                    this.a.F = false;
                    this.a.B.setPictureFormat(256);
                    f fVar3 = this.a;
                    int a2 = f.a(fVar3, fVar3.a);
                    try {
                        this.a.A.setDisplayOrientation(a2);
                    } catch (Throwable unused) {
                    }
                    this.a.B.set("rotation", a2);
                    this.a.w.set(a2);
                    f fVar4 = this.a;
                    Point a3 = com.baidu.sofire.face.c.a.a(fVar4.B, fVar4.k, fVar4.l);
                    f fVar5 = this.a;
                    fVar5.D = a3.x;
                    fVar5.E = a3.y;
                    if (fVar5.h) {
                        ILivenessStrategy iLivenessStrategy = fVar5.R;
                        if (iLivenessStrategy != null) {
                            iLivenessStrategy.setPreviewDegree(fVar5.w.get());
                        }
                    } else {
                        IDetectStrategy iDetectStrategy = fVar5.S;
                        if (iDetectStrategy != null) {
                            iDetectStrategy.setPreviewDegree(fVar5.w.get());
                        }
                    }
                    f fVar6 = this.a;
                    fVar6.x.set(0, 0, fVar6.E, fVar6.D);
                    f fVar7 = this.a;
                    float f = fVar7.z / 2;
                    float f2 = f - (0.33f * f);
                    float f3 = fVar7.E / 2;
                    float f4 = fVar7.D / 2;
                    float f5 = f4 - (0.1f * f4);
                    if (f3 <= f2) {
                        f2 = f3;
                    }
                    float f6 = (0.2f * f2) + f2;
                    fVar7.y.set((int) (f3 - f2), (int) (f5 - f6), (int) (f3 + f2), (int) (f5 + f6));
                    f fVar8 = this.a;
                    fVar8.B.setPreviewSize(fVar8.D, fVar8.E);
                    f fVar9 = this.a;
                    fVar9.A.setParameters(fVar9.B);
                    f fVar10 = this.a;
                    FaceProcessCallback faceProcessCallback = fVar10.d;
                    if (faceProcessCallback != null) {
                        faceProcessCallback.onConfigCamera(fVar10.A, fVar10.x, fVar10.y, fVar10.w);
                    }
                    f fVar11 = this.a;
                    fVar11.D = fVar11.B.getPreviewSize().width;
                    f fVar12 = this.a;
                    fVar12.E = fVar12.B.getPreviewSize().height;
                    f fVar13 = this.a;
                    fVar13.A.setErrorCallback(fVar13);
                    TextureView textureView = this.a.c;
                    if (textureView != null && textureView.isAvailable()) {
                        f fVar14 = this.a;
                        fVar14.getClass();
                        try {
                            TextureView textureView2 = fVar14.c;
                            if (textureView2 != null) {
                                textureView2.setSurfaceTextureListener(fVar14);
                            }
                        } catch (Throwable unused2) {
                        }
                        f fVar15 = this.a;
                        fVar15.A.setPreviewTexture(fVar15.c.getSurfaceTexture());
                    }
                    f fVar16 = this.a;
                    if (fVar16.s) {
                        return;
                    }
                    fVar16.A.startPreview();
                    this.a.F = true;
                    if (this.a.K > 0) {
                        this.a.K = 0;
                    }
                    this.a.c0 = new h(this.a);
                    this.a.c0.start();
                    f fVar17 = this.a;
                    if (fVar17.i) {
                        f.b(fVar17);
                        f fVar18 = this.a;
                        if (fVar18.j0 == null) {
                            fVar18.j0 = new Timer();
                        }
                        this.a.j0.schedule(new a(this), 20000L);
                    }
                    Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.a.r);
                    if (callSync != null && ((Integer) callSync.first).intValue() == 0) {
                        this.a.v = true;
                    }
                } catch (Throwable th) {
                    f fVar19 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar19.a, fVar19.r, 2, th);
                    this.a.a(-5);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
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

        public l(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Object> pair;
            Activity activity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    f fVar = this.a;
                    if (fVar.s) {
                        return;
                    }
                    if (fVar.t && !fVar.P) {
                        f.a(fVar);
                    }
                    f fVar2 = this.a;
                    if (fVar2.s) {
                        return;
                    }
                    if (fVar2.d != null && (activity = fVar2.b) != null) {
                        activity.runOnUiThread(new a(this));
                    }
                    f fVar3 = this.a;
                    JSONObject jSONObject = null;
                    if (fVar3.v) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, fVar3.r, Boolean.FALSE, fVar3.b());
                        this.a.v = false;
                    } else {
                        pair = null;
                    }
                    if (this.a.s) {
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
                                f fVar4 = this.a;
                                if (fVar4.V > 0 && fVar4.n.d()) {
                                    f fVar5 = this.a;
                                    fVar5.getClass();
                                    try {
                                        fVar5.a(jSONObject, "g");
                                        fVar5.a(jSONObject, "l");
                                        fVar5.a(jSONObject, "d");
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        }
                    }
                    f fVar6 = this.a;
                    if (fVar6.s) {
                        return;
                    }
                    fVar6.a(fVar6.a(jSONObject));
                } catch (Throwable th) {
                    f fVar7 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar7.a, fVar7.r, 6, th);
                    this.a.a(-12);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.a;
                fVar.X = com.baidu.sofire.face.b.b.b(fVar.a);
                f fVar2 = this.a;
                fVar2.W = com.baidu.sofire.face.b.b.a(fVar2.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f b;

        public d(f fVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            FaceProcessCallback faceProcessCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (faceProcessCallback = (fVar = this.b).d) != null) {
                int i = this.a;
                if (i == 1) {
                    faceProcessCallback.onEnd(i, fVar.b0);
                } else {
                    faceProcessCallback.onEnd(i, null);
                }
                this.b.d = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    f fVar = this.a;
                    if (fVar.s) {
                        return;
                    }
                    fVar.P = false;
                    f fVar2 = this.a;
                    TextureView textureView = fVar2.c;
                    if (textureView != null) {
                        textureView.setSurfaceTextureListener(fVar2);
                    }
                    f fVar3 = this.a;
                    if (fVar3.G == null) {
                        fVar3.G = f.b(fVar3, false);
                    }
                    f fVar4 = this.a;
                    Camera camera = fVar4.G;
                    if (camera != null) {
                        if (fVar4.H == null) {
                            fVar4.H = camera.getParameters();
                        }
                        this.a.G.stopPreview();
                        this.a.H.setPictureFormat(256);
                        f fVar5 = this.a;
                        int a = f.a(fVar5, fVar5.a);
                        this.a.G.setDisplayOrientation(a);
                        this.a.H.set("rotation", a);
                        this.a.w.set(a);
                        f fVar6 = this.a;
                        Point a2 = com.baidu.sofire.face.c.a.a(fVar6.H, fVar6.k, fVar6.l);
                        f fVar7 = this.a;
                        int i = a2.x;
                        fVar7.D = i;
                        int i2 = a2.y;
                        fVar7.E = i2;
                        fVar7.H.setPreviewSize(i, i2);
                        f fVar8 = this.a;
                        fVar8.G.setParameters(fVar8.H);
                        f fVar9 = this.a;
                        TextureView textureView2 = fVar9.c;
                        if (textureView2 != null) {
                            fVar9.G.setPreviewTexture(textureView2.getSurfaceTexture());
                        } else {
                            fVar9.G.setPreviewTexture(null);
                        }
                        f fVar10 = this.a;
                        g gVar = new g(fVar10);
                        fVar10.G.setErrorCallback(gVar);
                        this.a.G.setPreviewCallback(gVar);
                        f fVar11 = this.a;
                        if (fVar11.s) {
                            return;
                        }
                        fVar11.G.startPreview();
                        return;
                    }
                    fVar4.P = true;
                    f.d(this.a);
                } catch (Throwable th) {
                    this.a.P = true;
                    f.d(this.a);
                    this.a.c();
                    f fVar12 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar12.a, fVar12.r, 5, th);
                }
            }
        }
    }

    /* renamed from: com.baidu.sofire.face.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0184f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public RunnableC0184f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                this.a.I = false;
                Camera camera = this.a.G;
                if (camera != null) {
                    camera.setErrorCallback(null);
                    this.a.G.setPreviewCallback(null);
                    this.a.G.stopPreview();
                    com.baidu.sofire.face.a.a.a(this.a.G);
                    this.a.G = null;
                }
                TextureView textureView = this.a.c;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Camera.ErrorCallback, Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, camera) != null) {
                return;
            }
            this.a.P = true;
            this.a.c();
            f.d(this.a);
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, camera) == null) {
                try {
                    f fVar = this.a;
                    int i = fVar.O;
                    if (i != 1) {
                        if (i == 2) {
                            fVar.N = bArr;
                        }
                    } else {
                        fVar.M = bArr;
                    }
                    fVar.c();
                    f.d(this.a);
                } catch (Throwable unused) {
                    this.a.c();
                    f.d(this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public final /* synthetic */ f b;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fVar;
            this.a = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (this.a) {
                    if (this.b.K > 0) {
                        if (this.b.p || !this.a) {
                            return;
                        }
                        f fVar = this.b;
                        if (fVar.L != null && fVar.R != null) {
                            FaceSDKManager faceSDKManager = FaceSDKManager.getInstance();
                            f fVar2 = this.b;
                            fVar.L = faceSDKManager.scaleImage(fVar2.L, fVar2.E, fVar2.D);
                            f fVar3 = this.b;
                            fVar3.R.livenessStrategy(fVar3.L);
                            f fVar4 = this.b;
                            Bitmap bitmap = fVar4.L;
                            if (bitmap != fVar4.J) {
                                bitmap.recycle();
                            }
                            f fVar5 = this.b;
                            fVar5.K--;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements IDetectStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public i(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.pass.face.platform.IDetectStrategyCallback
        public void onDetectCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, faceStatusNewEnum, str, hashMap, hashMap2) == null) {
                try {
                    f fVar = this.a;
                    if (!fVar.p && !fVar.s) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            fVar.p = true;
                            Map<Long, String> a = f.a(fVar, hashMap, hashMap2);
                            if (a != null) {
                                this.a.T = a;
                            } else {
                                this.a.a(-8);
                            }
                            f fVar2 = this.a;
                            if (fVar2.d != null) {
                                f.b(fVar2, hashMap, hashMap2);
                                this.a.d.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, -1);
                            }
                            if (com.baidu.sofire.face.b.e.a().a(new l(this.a)) != 1) {
                                this.a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            FaceProcessCallback faceProcessCallback = fVar.d;
                            if (faceProcessCallback != null) {
                                faceProcessCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                            this.a.a(-18);
                        } else {
                            FaceProcessCallback faceProcessCallback2 = fVar.d;
                            if (faceProcessCallback2 != null) {
                                faceProcessCallback2.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                        }
                    }
                } catch (Throwable th) {
                    f fVar3 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar3.a, fVar3.r, 4, th);
                    this.a.a(-10);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ILivenessStrategyCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public j(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.pass.face.platform.ILivenessStrategyCallback
        public void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i)}) == null) {
                try {
                    f fVar = this.a;
                    if (!fVar.p && !fVar.s) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            fVar.p = true;
                            Map<Long, String> a = f.a(fVar, hashMap, hashMap2);
                            if (a != null) {
                                this.a.T = a;
                            } else {
                                this.a.a(-8);
                            }
                            f fVar2 = this.a;
                            if (fVar2.d != null) {
                                f.b(fVar2, hashMap, hashMap2);
                                this.a.d.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i);
                            }
                            f.c(this.a);
                            if (com.baidu.sofire.face.b.e.a().a(new l(this.a)) != 1) {
                                this.a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            FaceProcessCallback faceProcessCallback = fVar.d;
                            if (faceProcessCallback != null) {
                                faceProcessCallback.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                            }
                            this.a.a(-18);
                        } else {
                            FaceProcessCallback faceProcessCallback2 = fVar.d;
                            if (faceProcessCallback2 != null) {
                                faceProcessCallback2.onCollectCompletion(faceStatusNewEnum, str, null, null, i);
                            }
                        }
                    }
                } catch (Throwable th) {
                    f fVar3 = this.a;
                    com.baidu.sofire.face.b.b.a(fVar3.a, fVar3.r, 4, th);
                    this.a.a(-10);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ILivenessViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public k(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
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

    public f(com.baidu.sofire.face.a.e eVar, Activity activity, TextureView textureView, FaceProcessCallback faceProcessCallback, int i2, IFaceProcessInfo iFaceProcessInfo, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, activity, textureView, faceProcessCallback, Integer.valueOf(i2), iFaceProcessInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = false;
        this.q = 5;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = new Degree(0);
        this.x = new Rect();
        this.y = new Rect();
        this.z = 0;
        this.F = false;
        this.I = false;
        this.K = 0;
        this.O = 0;
        this.P = false;
        this.U = 1;
        this.V = 0L;
        this.X = -1;
        this.Y = new HashMap();
        this.a0 = 0L;
        this.h0 = 0L;
        this.i0 = false;
        this.j0 = null;
        this.j = eVar;
        this.a = activity.getApplicationContext();
        this.b = activity;
        this.c = textureView;
        if (textureView != null) {
            this.k = textureView.getLayoutParams().height;
            this.l = this.c.getLayoutParams().width;
        }
        this.d = faceProcessCallback;
        this.q = i2;
        com.baidu.sofire.face.b.d a2 = com.baidu.sofire.face.b.d.a(this.a);
        this.n = a2;
        this.Z = a2.c();
        this.m = iFaceProcessInfo;
        this.h = z;
        this.d0 = com.baidu.sofire.face.d.c.a(this.a);
        this.e0 = new File(this.a.getFilesDir(), "record_tmp_dir").getAbsolutePath();
        this.i = z2;
        this.U = i3;
    }

    public static int a(f fVar, Context context) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fVar, context)) == null) {
            fVar.getClass();
            try {
                int rotation = fVar.b.getWindowManager().getDefaultDisplay().getRotation();
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
                    Camera.getCameraInfo(fVar.C, cameraInfo);
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

    public static Map a(f fVar, HashMap hashMap, HashMap hashMap2) {
        InterceptResult invokeLLL;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, fVar, hashMap, hashMap2)) == null) {
            fVar.getClass();
            try {
                if (fVar.Q.getOutputImageType() == 0) {
                    hashMap = hashMap2;
                }
                if (hashMap != null && hashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(hashMap.entrySet());
                    Collections.sort(arrayList, new com.baidu.sofire.face.a.h(fVar));
                    if (arrayList.size() > 0) {
                        int i2 = fVar.U;
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
                            if (fVar.V == 0) {
                                fVar.V = currentTimeMillis;
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

    public static void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fVar) == null) {
            synchronized (fVar) {
                if (!fVar.P && !fVar.s) {
                    fVar.O++;
                    fVar.I = true;
                    fVar.e();
                    if (!fVar.P) {
                        try {
                            fVar.wait(2000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    fVar.I = false;
                }
            }
        }
    }

    @Override // com.baidu.pass.face.platform.listener.ISecurityCallback
    public void getFaceInfoForSecurity(FaceInfo[] faceInfoArr) {
        Map<Long, FaceInfo> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, faceInfoArr) == null) && faceInfoArr != null) {
            try {
                if (faceInfoArr.length == 0 || this.Z == 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.a0 >= this.Z && (map = this.Y) != null) {
                    map.put(Long.valueOf(currentTimeMillis), faceInfoArr[0]);
                    this.a0 = currentTimeMillis;
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048588, this, i2, camera) != null) || this.i0) {
            return;
        }
        a(-5);
    }

    public static int b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fVar)) == null) {
            if (fVar.g0) {
                return -2;
            }
            if (fVar.A == null) {
                return -4;
            }
            System.currentTimeMillis();
            if (fVar.d0.a(fVar.A, fVar.e0, fVar.C, new com.baidu.sofire.face.a.i(fVar)) < 0) {
                fVar.a(-17);
            } else {
                fVar.h0 = System.currentTimeMillis();
            }
            fVar.g0 = true;
            com.baidu.sofire.face.b.b.a(fVar.a, fVar.r, 102, 0, null);
            return 1;
        }
        return invokeL.intValue;
    }

    public static int c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fVar)) == null) {
            if (!fVar.g0) {
                return -3;
            }
            fVar.g0 = false;
            if (System.currentTimeMillis() - fVar.h0 < 2000) {
                fVar.d0.a();
                return -7;
            }
            String b2 = fVar.d0.b();
            fVar.f0 = b2;
            if (!TextUtils.isEmpty(b2) && new File(fVar.f0).exists()) {
                fVar.i0 = true;
                return 1;
            }
            fVar.a(-7);
            fVar.i0 = false;
            return -8;
        }
        return invokeL.intValue;
    }

    public static Camera b(f fVar, boolean z) {
        InterceptResult invokeLZ;
        int numberOfCameras;
        Camera open;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, fVar, z)) == null) {
            if (fVar.s || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
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
                fVar.C = i2;
            } else {
                open = Camera.open(0);
                fVar.C = 0;
            }
            return open;
        }
        return (Camera) invokeLZ.objValue;
    }

    public static void b(f fVar, HashMap hashMap, HashMap hashMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, fVar, hashMap, hashMap2) == null) {
            fVar.getClass();
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

    public static void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, fVar) == null) {
            synchronized (fVar) {
                try {
                    fVar.notifyAll();
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
                if (this.h && !this.s) {
                    ILivenessStrategy iLivenessStrategy = this.R;
                    if (iLivenessStrategy != null) {
                        iLivenessStrategy.setLivenessStrategySoundEnable(z);
                        return;
                    }
                    return;
                }
                IDetectStrategy iDetectStrategy = this.S;
                if (iDetectStrategy != null) {
                    iDetectStrategy.setDetectStrategySoundEnable(z);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(f fVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, fVar) == null) {
            fVar.getClass();
            fVar.Q = FaceSDKManager.getInstance().getFaceConfig();
            if (((AudioManager) fVar.a.getSystemService("audio")).getStreamVolume(3) > 0) {
                z = fVar.Q.isSound();
            } else {
                z = false;
            }
            fVar.o = z;
            if (fVar.h) {
                if (fVar.e == null) {
                    fVar.e = new j(fVar);
                }
            } else if (fVar.f == null) {
                fVar.f = new i(fVar);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            fVar.b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            fVar.z = displayMetrics.widthPixels;
            fVar.u = fVar.n.a.getBoolean("lt_sfff", false);
            fVar.t = fVar.n.a.getBoolean("lt_sbff", false);
            try {
                TextureView textureView = fVar.c;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(fVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            try {
                this.p = true;
                this.s = true;
                this.b.runOnUiThread(new d(this, i2));
                com.baidu.sofire.face.d.c cVar = this.d0;
                if (cVar != null && this.g0) {
                    cVar.a();
                }
                Timer timer = this.j0;
                if (timer != null) {
                    timer.cancel();
                    this.j0 = null;
                }
                try {
                    this.b.runOnUiThread(new com.baidu.sofire.face.a.g(this));
                } catch (Throwable unused) {
                }
                c();
                if (this.v) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.r, Boolean.TRUE, b());
                    this.v = false;
                }
                TextureView textureView = this.c;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                    this.c = null;
                }
                this.b = null;
                com.baidu.sofire.face.a.e eVar = this.j;
                if (eVar != null) {
                    com.baidu.sofire.face.a.j jVar = eVar.a;
                    if (jVar != null && this == jVar) {
                        eVar.a = null;
                    }
                    this.j = null;
                }
                Map<Long, String> map = this.T;
                if (map != null) {
                    map.clear();
                    this.T = null;
                }
                com.baidu.sofire.face.b.b.a(this.a, this.r, 2, i2, null);
            } catch (Throwable unused2) {
            }
        }
    }

    public int a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        byte[] bArr;
        byte[] bArr2;
        String str;
        JSONObject jSONObject3;
        byte[] bArr3;
        byte[] bArr4;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("f_i", this.r);
                JSONObject jSONObject6 = new JSONObject();
                if (this.i) {
                    File file = new File(this.f0);
                    if (file.exists()) {
                        byte[][] a2 = com.baidu.sofire.face.d.b.a(com.baidu.sofire.face.a.a.a(file));
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                        if (a2 != null && a2.length == 2) {
                            byte[] bArr5 = a2[1];
                            byte[] bArr6 = a2[0];
                            if (bArr6 != null && bArr6.length != 0) {
                                if (bArr5 != null && bArr5.length != 0) {
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject2 = jSONObject4;
                                    jSONObject7.put("transcheckdata", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.a, bArr6), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                                    jSONObject6.put("video", jSONObject7);
                                    bArr = bArr5;
                                } else {
                                    throw new RuntimeException("empty mediaData");
                                }
                            } else {
                                throw new RuntimeException("empty mediaSafeInfo");
                            }
                        } else {
                            throw new RuntimeException("transformResult unexpected");
                        }
                    } else {
                        throw new RuntimeException("mediaFile not exists");
                    }
                } else {
                    jSONObject2 = jSONObject4;
                    bArr = null;
                }
                byte[] bArr7 = bArr;
                jSONObject5.put("t_c", this.V);
                if (this.u && (bitmap = this.J) != null) {
                    bArr2 = bArr7;
                    jSONObject5.put("d_f", Base64.encodeToString(com.baidu.sofire.face.a.a.a(bitmap, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                    this.J.recycle();
                    this.J = null;
                } else {
                    bArr2 = bArr7;
                }
                if (!this.t || (bArr4 = this.M) == null || bArr4.length <= 0) {
                    str = "-";
                } else {
                    str = "-";
                    jSONObject5.put("d_p", Base64.encodeToString(com.baidu.sofire.face.a.a.a(this.a, bArr4, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (this.t && (bArr3 = this.N) != null && bArr3.length > 0) {
                    jSONObject5.put("d_a", Base64.encodeToString(com.baidu.sofire.face.a.a.a(this.a, bArr3, 400, 300), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                }
                if (jSONObject != null) {
                    jSONObject5.put("s", jSONObject);
                }
                IFaceProcessInfo iFaceProcessInfo = this.m;
                if (iFaceProcessInfo != null) {
                    jSONObject3 = iFaceProcessInfo.buildJson();
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                }
                if (this.T.size() == 1) {
                    jSONObject3.put("image", this.T.values().iterator().next());
                } else if (this.T.size() >= 2) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : this.T.values()) {
                        jSONArray.put(str2);
                    }
                    jSONObject3.put("images", jSONArray);
                }
                jSONObject3.put("image_type", FaceEnum.ImageType.BASE64.name());
                jSONObject3.put("image_sec", true);
                jSONObject3.put("risk_identify", true);
                jSONObject3.put("app", "android");
                jSONObject6.put("face", jSONObject3);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("zid", FH.gzfi(this.a, "", 5002));
                jSONObject8.put(Config.EVENT_PART, "face");
                jSONObject8.put(NotificationStyle.NOTIFICATION_STYLE, this.X);
                jSONObject8.put("ts", System.currentTimeMillis());
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    jSONObject8.put("tz", timeZone.getID());
                }
                JSONArray jSONArray2 = this.W;
                if (jSONArray2 != null) {
                    jSONObject8.put("ce", jSONArray2);
                }
                jSONObject6.put("risk", jSONObject8);
                jSONObject5.put("e", jSONObject6);
                String str3 = com.baidu.sofire.face.a.e.d;
                try {
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = str;
                        String[] split = str3.split(str4);
                        if (split.length >= 3) {
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < split.length - 3; i2++) {
                                sb.append(split[i2]);
                                sb.append(str4);
                            }
                            sb.append(split[split.length - 3]);
                            str3 = sb.toString();
                        }
                    }
                } catch (Throwable unused2) {
                }
                JSONObject jSONObject9 = jSONObject2;
                jSONObject9.put("licenseId", str3);
                jSONObject9.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.a, jSONObject5.toString().getBytes()), 8).replace("\n", "").replace("\t", "").replace("\r", ""));
                jSONObject9.put("app", "android");
                String packageName = this.a.getPackageName();
                if (packageName != null) {
                    jSONObject9.put("pkg", packageName);
                    try {
                        Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
                        if (signatureArr != null && signatureArr.length > 0) {
                            jSONObject9.put("sign", com.baidu.sofire.face.b.c.b(signatureArr[0].toByteArray()));
                        }
                    } catch (Throwable unused3) {
                    }
                }
                this.b0 = com.baidu.sofire.face.b.b.a(this.a, jSONObject9.toString(), bArr2, this.e0);
                return 1;
            } catch (Throwable unused4) {
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
                                } else if (j2 > this.V) {
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
                if (this.s) {
                    return;
                }
                this.s = true;
                FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.r, Boolean.TRUE, "");
                a(-6);
            } catch (Throwable unused) {
            }
        }
    }

    public final String b() {
        JSONObject a2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Map<Long, FaceInfo> map = this.Y;
                if (map != null && map.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<Long, FaceInfo> entry : this.Y.entrySet()) {
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                Activity activity = this.b;
                if (activity != null) {
                    activity.runOnUiThread(new RunnableC0184f(this));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                if (com.baidu.sofire.face.b.e.a().a(new a(this)) != 1) {
                    a(-7);
                }
                com.baidu.sofire.face.b.e.a().a(new b(this));
            } catch (Throwable unused) {
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.b.runOnUiThread(new e(this));
            } catch (Throwable th) {
                this.P = true;
                synchronized (this) {
                    try {
                        notifyAll();
                    } catch (Throwable unused) {
                    }
                    c();
                    com.baidu.sofire.face.b.b.a(this.a, this.r, 5, th);
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                this.b.runOnUiThread(new c(this));
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.r, 2, th);
                a(-5);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048589, this, surfaceTexture, i2, i3) == null) && !this.s && surfaceTexture != null) {
            TextureView textureView = this.c;
            if (textureView != null) {
                this.k = textureView.getHeight();
                this.l = this.c.getWidth();
            }
            Camera camera = this.A;
            if (camera != null) {
                try {
                    camera.setPreviewTexture(surfaceTexture);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048591, this, surfaceTexture, i2, i3) != null) || this.s || surfaceTexture == null) {
            return;
        }
        if (this.F) {
            f();
        } else if (this.I) {
            e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView textureView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, surfaceTexture) == null) {
            try {
                if (this.p || this.s || this.K > 0 || (textureView = this.c) == null) {
                    return;
                }
                Bitmap bitmap = textureView.getBitmap();
                this.L = bitmap;
                if (this.u && this.J == null) {
                    this.J = bitmap;
                }
                if (this.R == null && !this.p && !this.s) {
                    if (!com.baidu.sofire.face.a.e.b()) {
                        a(-20);
                    }
                    if (this.g == null) {
                        this.g = new k(this);
                    }
                    ILivenessStrategy livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this.g);
                    this.R = livenessStrategyModule;
                    livenessStrategyModule.setISecurityCallback(this);
                    this.R.setPreviewDegree(this.w.get());
                    this.R.setLivenessStrategySoundEnable(this.o);
                    this.R.setLivenessStrategyConfig(this.Q.getLivenessTypeList(), this.x, this.y, this.e);
                }
                this.K++;
            } catch (Throwable th) {
                com.baidu.sofire.face.b.b.a(this.a, this.r, 3, th);
                a(-11);
            }
        }
    }
}
