package com.baidu.sofire.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.AudioManager;
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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.face.platform.utils.APIUtils;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IFaceProcessInfo;
import com.baidu.sofire.ac.RequestInfo;
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
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public final class a implements Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback, ISecurityCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IFaceProcessInfo A;
    public y B;
    public int C;
    public boolean D;
    public boolean E;
    public Rect F;
    public Camera G;
    public Camera.Parameters H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public Camera N;
    public Camera.Parameters O;
    public boolean P;
    public byte[] Q;
    public byte[] R;
    public byte[] S;
    public boolean T;
    public long U;
    public String V;
    public JSONArray W;
    public int X;
    public Map<Long, FaceInfo> Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42900a;
    public long aa;
    public RequestInfo ab;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f42901b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42902c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42903d;

    /* renamed from: e  reason: collision with root package name */
    public String f42904e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42905f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42906g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42907h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f42908i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public FaceConfig o;
    public com.baidu.pass.face.platform.c p;
    public com.baidu.pass.face.platform.a q;
    public Context r;
    public Activity s;
    public SurfaceHolder t;
    public FaceProcessCallback u;
    public c v;
    public b w;
    public d x;
    public com.baidu.sofire.b.b y;
    public int z;

    /* renamed from: com.baidu.sofire.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1675a implements Camera.ErrorCallback, Camera.PreviewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42922a;

        public C1675a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42922a = aVar;
        }

        @Override // android.hardware.Camera.ErrorCallback
        public final void onError(int i2, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, camera) == null) {
                this.f42922a.T = true;
                this.f42922a.b();
                this.f42922a.g();
            }
        }

        @Override // android.hardware.Camera.PreviewCallback
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, camera) == null) {
                try {
                    int i2 = this.f42922a.n;
                    if (i2 == 1) {
                        this.f42922a.R = bArr;
                    } else if (i2 == 2) {
                        this.f42922a.S = bArr;
                    }
                    this.f42922a.b();
                    this.f42922a.g();
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                    this.f42922a.b();
                    this.f42922a.g();
                }
            }
        }

        public /* synthetic */ C1675a(a aVar, byte b2) {
            this(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.pass.face.platform.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42923a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42923a = aVar;
        }

        @Override // com.baidu.pass.face.platform.b
        public final void a(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, faceStatusNewEnum, str, hashMap, hashMap2) == null) {
                try {
                    if (!this.f42923a.f42903d && !this.f42923a.f42905f) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            this.f42923a.f42903d = true;
                            Pair b2 = this.f42923a.b(hashMap, hashMap2);
                            if (b2 != null) {
                                this.f42923a.U = ((Long) b2.first).longValue();
                                this.f42923a.V = (String) b2.second;
                            } else {
                                this.f42923a.a(-8);
                            }
                            if (this.f42923a.u != null) {
                                a.a(hashMap, hashMap2);
                                this.f42923a.u.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, -1);
                            }
                            if (z.a(this.f42923a.r).b(new e(this.f42923a, (byte) 0)) != 1) {
                                this.f42923a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            if (this.f42923a.u != null) {
                                this.f42923a.u.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            }
                            this.f42923a.a(-18);
                        } else if (this.f42923a.u != null) {
                            this.f42923a.u.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.utility.c.a();
                    x.a(this.f42923a.r, this.f42923a.f42904e, 4, th);
                    this.f42923a.a(-10);
                }
            }
        }

        public /* synthetic */ b(a aVar, byte b2) {
            this(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.pass.face.platform.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42924a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42924a = aVar;
        }

        @Override // com.baidu.pass.face.platform.d
        public final void a(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{faceStatusNewEnum, str, hashMap, hashMap2, Integer.valueOf(i2)}) == null) {
                try {
                    if (!this.f42924a.f42903d && !this.f42924a.f42905f) {
                        if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                            this.f42924a.f42903d = true;
                            Pair b2 = this.f42924a.b(hashMap, hashMap2);
                            if (b2 != null) {
                                this.f42924a.U = ((Long) b2.first).longValue();
                                this.f42924a.V = (String) b2.second;
                            } else {
                                this.f42924a.a(-8);
                            }
                            if (this.f42924a.u != null) {
                                a.a(hashMap, hashMap2);
                                this.f42924a.u.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i2);
                            }
                            if (z.a(this.f42924a.r).b(new e(this.f42924a, (byte) 0)) != 1) {
                                this.f42924a.a(-7);
                            }
                        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                            if (this.f42924a.u != null) {
                                this.f42924a.u.onCollectCompletion(faceStatusNewEnum, str, null, null, i2);
                            }
                            this.f42924a.a(-18);
                        } else if (this.f42924a.u != null) {
                            this.f42924a.u.onCollectCompletion(faceStatusNewEnum, str, null, null, i2);
                        }
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.utility.c.a();
                    x.a(this.f42924a.r, this.f42924a.f42904e, 4, th);
                    this.f42924a.a(-10);
                }
            }
        }

        public /* synthetic */ c(a aVar, byte b2) {
            this(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements com.baidu.pass.face.platform.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42925a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42925a = aVar;
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a(LivenessTypeEnum livenessTypeEnum) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, livenessTypeEnum) == null) {
                try {
                    if (this.f42925a.u != null) {
                        this.f42925a.u.setCurrentLiveType(livenessTypeEnum);
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }

        public /* synthetic */ d(a aVar, byte b2) {
            this(aVar);
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f42925a.u != null) {
                        this.f42925a.u.viewReset();
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a(FaceExtInfo faceExtInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceExtInfo) == null) {
                try {
                    if (this.f42925a.u != null) {
                        this.f42925a.u.setFaceInfo(faceExtInfo);
                    }
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42926a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42926a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Pair<Integer, Object> pair;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f42926a.f42905f) {
                        return;
                    }
                    if (this.f42926a.D && !this.f42926a.T) {
                        this.f42926a.f();
                    }
                    if (this.f42926a.f42905f) {
                        return;
                    }
                    if (this.f42926a.u != null && this.f42926a.s != null) {
                        this.f42926a.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.e.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ e f42927a;

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
                                this.f42927a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f42927a.f42926a.u == null) {
                                    return;
                                }
                                this.f42927a.f42926a.u.onBeginBuildData();
                            }
                        });
                    }
                    JSONObject jSONObject = null;
                    if (this.f42926a.f42907h) {
                        pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.f42926a.f42904e, Boolean.FALSE, this.f42926a.e());
                        this.f42926a.f42907h = false;
                    } else {
                        pair = null;
                    }
                    if (this.f42926a.f42905f) {
                        return;
                    }
                    if (pair != null && ((Integer) pair.first).intValue() == 0) {
                        String str = (String) pair.second;
                        if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str).optJSONObject("s")) != null && this.f42926a.U > 0 && this.f42926a.B.c()) {
                            jSONObject = this.f42926a.b(jSONObject);
                        }
                    }
                    if (this.f42926a.f42905f) {
                        return;
                    }
                    this.f42926a.a(this.f42926a.a(jSONObject));
                } catch (Throwable th) {
                    com.baidu.sofire.utility.c.a();
                    x.a(this.f42926a.r, this.f42926a.f42904e, 6, th);
                    this.f42926a.a(-12);
                }
            }
        }

        public /* synthetic */ e(a aVar, byte b2) {
            this(aVar);
        }
    }

    public a(com.baidu.sofire.b.b bVar, Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i2, IFaceProcessInfo iFaceProcessInfo, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, activity, surfaceHolder, faceProcessCallback, Integer.valueOf(i2), iFaceProcessInfo, Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42901b = true;
        this.f42902c = false;
        this.f42903d = false;
        this.C = 5;
        this.D = false;
        this.E = false;
        this.f42906g = false;
        this.f42907h = false;
        this.F = new Rect();
        this.f42908i = new Rect();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.M = false;
        this.P = false;
        this.n = 0;
        this.T = false;
        this.X = -1;
        this.Y = new HashMap();
        this.aa = 0L;
        this.y = bVar;
        Context applicationContext = activity.getApplicationContext();
        this.r = applicationContext;
        this.s = activity;
        this.t = surfaceHolder;
        this.u = faceProcessCallback;
        this.C = i2;
        y a2 = y.a(applicationContext);
        this.B = a2;
        this.Z = a2.f43215a.getLong("lt_sfii", 1000L);
        this.A = iFaceProcessInfo;
        this.z = i3;
        this.f42900a = z;
    }

    public static /* synthetic */ void j(a aVar) {
        aVar.o = FaceSDKManager.getInstance().getFaceConfig();
        aVar.f42901b = ((AudioManager) aVar.r.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamVolume(3) > 0 ? aVar.o.isSound() : false;
        if (aVar.f42900a) {
            if (aVar.v == null) {
                aVar.v = new c(aVar, (byte) 0);
            }
        } else if (aVar.w == null) {
            aVar.w = new b(aVar, (byte) 0);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        aVar.s.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        aVar.l = displayMetrics.widthPixels;
        aVar.m = displayMetrics.heightPixels;
        aVar.E = aVar.B.f43215a.getBoolean("lt_sfff", false);
        aVar.D = aVar.B.f43215a.getBoolean("lt_sbff", false);
    }

    @Override // com.baidu.pass.face.platform.listener.ISecurityCallback
    public final void getFaceInfoForSecurity(FaceInfo[] faceInfoArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, faceInfoArr) == null) || faceInfoArr == null) {
            return;
        }
        try {
            if (faceInfoArr.length == 0 || this.Z == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.aa >= this.Z && this.Y != null) {
                this.Y.put(Long.valueOf(currentTimeMillis), faceInfoArr[0]);
                this.aa = currentTimeMillis;
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i2, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, camera) == null) {
            a(-5);
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bArr, camera) == null) {
            try {
                if (!this.f42903d && !this.f42905f) {
                    if (this.E && this.Q == null) {
                        this.Q = bArr;
                    }
                    if (this.f42900a) {
                        if (this.p == null && !this.f42903d && !this.f42905f) {
                            if (this.x == null) {
                                this.x = new d(this, (byte) 0);
                            }
                            com.baidu.pass.face.platform.c livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this.x);
                            this.p = livenessStrategyModule;
                            livenessStrategyModule.setISecurityCallback(this);
                            this.p.setPreviewDegree(this.L);
                            this.p.setLivenessStrategySoundEnable(this.f42901b);
                            this.p.setLivenessStrategyConfig(this.o.getLivenessTypeList(), this.F, this.f42908i, this.v);
                        }
                        if (this.p == null || this.f42903d || this.f42905f) {
                            return;
                        }
                        this.p.livenessStrategy(bArr);
                        return;
                    }
                    if (this.q == null && !this.f42903d && !this.f42905f) {
                        com.baidu.pass.face.platform.a detectStrategyModule = FaceSDKManager.getInstance().getDetectStrategyModule();
                        this.q = detectStrategyModule;
                        detectStrategyModule.setISecurityCallback(this);
                        this.q.setPreviewDegree(this.L);
                        this.q.setDetectStrategySoundEnable(this.f42901b);
                        this.q.setDetectStrategyConfig(this.F, this.f42908i, this.w);
                    }
                    if (this.q == null || this.f42903d || this.f42905f) {
                        return;
                    }
                    this.q.detectStrategy(bArr);
                }
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                x.a(this.r, this.f42904e, 3, th);
                a(-11);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, surfaceHolder, i2, i3, i4) == null) {
            this.j = i3;
            this.k = i4;
            if (this.f42905f || surfaceHolder.getSurface() == null) {
                return;
            }
            if (this.M) {
                c();
            } else if (this.P) {
                h();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceHolder) == null) {
            this.f42902c = true;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, surfaceHolder) == null) {
            this.f42902c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            synchronized (this) {
                if (!this.T && !this.f42905f) {
                    this.n++;
                    this.P = true;
                    h();
                    if (!this.T) {
                        try {
                            wait(2000L);
                        } catch (InterruptedException unused) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                    this.P = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            synchronized (this) {
                try {
                    notifyAll();
                } catch (Throwable unused) {
                    com.baidu.sofire.utility.c.a();
                }
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            try {
                this.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42920a;

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
                        this.f42920a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f42920a.f42905f) {
                                    return;
                                }
                                this.f42920a.T = false;
                                if (this.f42920a.t != null) {
                                    this.f42920a.t.addCallback(this.f42920a);
                                }
                                if (this.f42920a.N == null) {
                                    this.f42920a.N = a.b(this.f42920a, false);
                                }
                                if (this.f42920a.N != null) {
                                    if (this.f42920a.O == null) {
                                        this.f42920a.O = this.f42920a.N.getParameters();
                                    }
                                    this.f42920a.N.stopPreview();
                                    this.f42920a.O.setPictureFormat(256);
                                    int d2 = this.f42920a.d();
                                    this.f42920a.N.setDisplayOrientation(d2);
                                    this.f42920a.O.set(Key.ROTATION, d2);
                                    this.f42920a.L = d2;
                                    Point a2 = com.baidu.sofire.i.a.a(this.f42920a.O, new Point(this.f42920a.l, this.f42920a.m));
                                    this.f42920a.J = a2.x;
                                    this.f42920a.K = a2.y;
                                    this.f42920a.O.setPreviewSize(this.f42920a.J, this.f42920a.K);
                                    this.f42920a.N.setParameters(this.f42920a.O);
                                    this.f42920a.N.setPreviewDisplay(this.f42920a.t);
                                    C1675a c1675a = new C1675a(this.f42920a, (byte) 0);
                                    this.f42920a.N.setErrorCallback(c1675a);
                                    this.f42920a.N.setPreviewCallback(c1675a);
                                    if (this.f42920a.f42905f) {
                                        return;
                                    }
                                    this.f42920a.N.startPreview();
                                    return;
                                }
                                this.f42920a.T = true;
                                this.f42920a.g();
                            } catch (Throwable th) {
                                com.baidu.sofire.utility.c.a();
                                this.f42920a.T = true;
                                this.f42920a.g();
                                this.f42920a.b();
                                x.a(this.f42920a.r, this.f42920a.f42904e, 5, th);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                this.T = true;
                g();
                b();
                x.a(this.r, this.f42904e, 5, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x0005, B:17:0x0029, B:19:0x0035, B:21:0x0043, B:22:0x004d), top: B:30:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65573, this)) != null) {
            return invokeV.intValue;
        }
        try {
            int rotation = this.s.getWindowManager().getDefaultDisplay().getRotation();
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
                Camera.getCameraInfo(this.I, cameraInfo);
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
    public String e() {
        JSONObject a2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            try {
                if (this.Y == null || this.Y.size() <= 0) {
                    return "";
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Long, FaceInfo> entry : this.Y.entrySet()) {
                    long longValue = entry.getKey().longValue();
                    FaceInfo value = entry.getValue();
                    if (longValue > 0 && (a2 = a(value)) != null) {
                        jSONObject.put(String.valueOf(longValue), a2);
                    }
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            try {
                this.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42915a;

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
                        this.f42915a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                if (this.f42915a.f42905f) {
                                    return;
                                }
                                this.f42915a.M = true;
                                if (this.f42915a.t != null) {
                                    this.f42915a.t.addCallback(this.f42915a);
                                }
                                if (this.f42915a.G == null && !this.f42915a.f42905f) {
                                    this.f42915a.G = a.b(this.f42915a, true);
                                }
                                if (this.f42915a.G == null) {
                                    return;
                                }
                                if (this.f42915a.H == null) {
                                    this.f42915a.H = this.f42915a.G.getParameters();
                                }
                                this.f42915a.G.stopPreview();
                                this.f42915a.H.setPictureFormat(256);
                                int d2 = this.f42915a.d();
                                this.f42915a.G.setDisplayOrientation(d2);
                                this.f42915a.H.set(Key.ROTATION, d2);
                                this.f42915a.L = d2;
                                Point a2 = com.baidu.sofire.i.a.a(this.f42915a.H, new Point(this.f42915a.l, this.f42915a.m));
                                this.f42915a.J = a2.x;
                                this.f42915a.K = a2.y;
                                if (this.f42915a.f42900a) {
                                    if (this.f42915a.p != null) {
                                        this.f42915a.p.setPreviewDegree(d2);
                                    }
                                } else if (this.f42915a.q != null) {
                                    this.f42915a.q.setPreviewDegree(d2);
                                }
                                this.f42915a.F.set(0, 0, this.f42915a.K, this.f42915a.J);
                                a aVar = this.f42915a;
                                int i2 = this.f42915a.l;
                                int i3 = this.f42915a.K;
                                int i4 = this.f42915a.J;
                                float f2 = (i2 / 2) - ((i2 / 2) * 0.33f);
                                float f3 = i3 / 2;
                                float f4 = (i4 / 2) - ((i4 / 2) * 0.1f);
                                if (i3 / 2 <= f2) {
                                    f2 = i3 / 2;
                                }
                                float f5 = (0.2f * f2) + f2;
                                aVar.f42908i.set((int) (f3 - f2), (int) (f4 - f5), (int) (f3 + f2), (int) (f4 + f5));
                                this.f42915a.H.setPreviewSize(this.f42915a.J, this.f42915a.K);
                                this.f42915a.G.setParameters(this.f42915a.H);
                                if (this.f42915a.u != null) {
                                    this.f42915a.u.onConfigCamera(this.f42915a.G, this.f42915a.F, this.f42915a.f42908i);
                                }
                                this.f42915a.G.setPreviewDisplay(this.f42915a.t);
                                this.f42915a.G.setErrorCallback(this.f42915a);
                                this.f42915a.G.setPreviewCallback(this.f42915a);
                                if (this.f42915a.f42905f) {
                                    return;
                                }
                                this.f42915a.G.startPreview();
                                Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, this.f42915a.f42904e);
                                if (callSync == null || ((Integer) callSync.first).intValue() != 0) {
                                    return;
                                }
                                this.f42915a.f42907h = true;
                            } catch (Throwable th) {
                                com.baidu.sofire.utility.c.a();
                                x.a(this.f42915a.r, this.f42915a.f42904e, 2, th);
                                this.f42915a.a(-5);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                x.a(this.r, this.f42904e, 2, th);
                a(-5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Long, String> b(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        InterceptResult invokeLL;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, this, hashMap, hashMap2)) == null) {
            try {
                if (this.o.getOutputImageType() == 0) {
                    hashMap = hashMap2;
                }
                if (hashMap == null || hashMap.size() <= 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(hashMap.entrySet());
                Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>(this) { // from class: com.baidu.sofire.b.a.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42919a;

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
                        this.f42919a = this;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(Map.Entry<String, ImageInfo> entry, Map.Entry<String, ImageInfo> entry2) {
                        return Float.valueOf(entry2.getKey().split("_")[2]).compareTo(Float.valueOf(entry.getKey().split("_")[2]));
                    }
                });
                if (arrayList.size() > 0) {
                    String[] split = ((String) ((Map.Entry) arrayList.get(0)).getKey()).split("_");
                    if (split.length > 3) {
                        currentTimeMillis = Long.valueOf(split[3]).longValue();
                    } else {
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    String secBase64 = ((ImageInfo) ((Map.Entry) arrayList.get(0)).getValue()).getSecBase64();
                    if (!TextUtils.isEmpty(secBase64)) {
                        secBase64 = secBase64.replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, "");
                    }
                    return new Pair<>(Long.valueOf(currentTimeMillis), secBase64);
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (Pair) invokeLL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (z.a(this.r).b(new Runnable(this) { // from class: com.baidu.sofire.b.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42909a;

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
                        this.f42909a = this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:69:0x01ac A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:70:0x01ad  */
                    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2 A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:5:0x0007, B:8:0x0010, B:11:0x001b, B:16:0x0042, B:18:0x0085, B:20:0x008f, B:22:0x0099, B:24:0x009e, B:27:0x00a7, B:29:0x00af, B:33:0x00d6, B:35:0x00de, B:37:0x00e6, B:38:0x00f4, B:40:0x00fa, B:42:0x0106, B:44:0x010e, B:47:0x0117, B:50:0x0127, B:52:0x012f, B:67:0x01a4, B:72:0x01b1, B:77:0x01c1, B:79:0x01c9, B:81:0x01d1, B:84:0x01e2, B:87:0x01ea, B:89:0x01f0, B:92:0x01f9, B:95:0x0207, B:97:0x020f, B:99:0x0217, B:100:0x021c, B:103:0x0225, B:105:0x022d, B:107:0x0235, B:108:0x0243, B:111:0x024c, B:53:0x0151, B:55:0x015d, B:57:0x0165, B:59:0x0189, B:61:0x0193, B:30:0x00bf, B:32:0x00c7, B:12:0x0025, B:14:0x002d, B:15:0x0039), top: B:119:0x0007 }] */
                    /* JADX WARN: Removed duplicated region for block: B:86:0x01e8  */
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
                            if (this.f42909a.f42905f) {
                                return;
                            }
                            if (this.f42909a.z != 1) {
                                if (this.f42909a.z == 2) {
                                    this.f42909a.f42904e = j.a("2");
                                } else {
                                    this.f42909a.f42904e = j.a("1");
                                }
                            } else {
                                this.f42909a.f42904e = j.a("1");
                            }
                            Pair<Integer, Object> callSync2 = FH.callSync(1, "sfv", new Class[]{Activity.class, SurfaceHolder.class, Object.class, Integer.TYPE}, this.f42909a.s, this.f42909a.t, this.f42909a.u, Integer.valueOf(this.f42909a.C));
                            if (callSync2 == null || ((Integer) callSync2.first).intValue() != 0 || ((Integer) callSync2.second).intValue() != 1) {
                                if (this.f42909a.f42905f) {
                                    return;
                                }
                                if (this.f42909a.z == 2) {
                                    x.a(this.f42909a.r, this.f42909a.f42904e, 0, 0);
                                } else if (this.f42909a.z == 1) {
                                    x.a(this.f42909a.r, this.f42909a.f42904e, 1, 0);
                                }
                                if (this.f42909a.u != null && this.f42909a.s != null) {
                                    this.f42909a.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass1 f42910a;

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
                                            this.f42910a = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f42910a.f42909a.u == null) {
                                                return;
                                            }
                                            this.f42910a.f42909a.u.onBegin();
                                        }
                                    });
                                }
                                if (!FH.isInitSuc(1) && this.f42909a.B.d()) {
                                    this.f42909a.a(-15);
                                } else if (this.f42909a.f42905f) {
                                } else {
                                    if (!this.f42909a.B.a() || this.f42909a.C != 0) {
                                        if (this.f42909a.B.a() && this.f42909a.C > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.f42909a.f42904e, Integer.valueOf(this.f42909a.C))) != null && ((Integer) callSync.first).intValue() == 0) {
                                            int intValue = ((Integer) callSync.second).intValue();
                                            if (intValue == 1) {
                                                c2 = 1;
                                            } else if (intValue == 2) {
                                                c2 = 65534;
                                            }
                                            if (!this.f42909a.f42905f) {
                                                return;
                                            }
                                            if (c2 != 65534 && (c2 == 1 || !this.f42909a.B.b())) {
                                                i2 = 1;
                                                if (this.f42909a.u != null && this.f42909a.s != null) {
                                                    this.f42909a.s.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.a.1.2
                                                        public static /* synthetic */ Interceptable $ic;
                                                        public transient /* synthetic */ FieldHolder $fh;

                                                        /* renamed from: a  reason: collision with root package name */
                                                        public final /* synthetic */ int f42911a;

                                                        /* renamed from: b  reason: collision with root package name */
                                                        public final /* synthetic */ AnonymousClass1 f42912b;

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
                                                            this.f42912b = this;
                                                            this.f42911a = i2;
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            Interceptable interceptable3 = $ic;
                                                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f42912b.f42909a.u == null) {
                                                                return;
                                                            }
                                                            this.f42912b.f42909a.u.onDeviceCheckResult(this.f42911a);
                                                        }
                                                    });
                                                }
                                                if (c2 != 65534) {
                                                    this.f42909a.a(-3);
                                                    return;
                                                } else if (i2 == -1) {
                                                    this.f42909a.a(-3);
                                                    return;
                                                } else if (this.f42909a.f42905f) {
                                                    return;
                                                } else {
                                                    a.j(this.f42909a);
                                                    if (this.f42909a.f42905f) {
                                                        return;
                                                    }
                                                    if (this.f42909a.D && !this.f42909a.T) {
                                                        this.f42909a.f();
                                                    }
                                                    if (this.f42909a.f42905f) {
                                                        return;
                                                    }
                                                    if (this.f42909a.u != null && this.f42909a.s != null) {
                                                        this.f42909a.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.1.3
                                                            public static /* synthetic */ Interceptable $ic;
                                                            public transient /* synthetic */ FieldHolder $fh;

                                                            /* renamed from: a  reason: collision with root package name */
                                                            public final /* synthetic */ AnonymousClass1 f42913a;

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
                                                                this.f42913a = this;
                                                            }

                                                            @Override // java.lang.Runnable
                                                            public final void run() {
                                                                Interceptable interceptable3 = $ic;
                                                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f42913a.f42909a.u == null) {
                                                                    return;
                                                                }
                                                                this.f42913a.f42909a.u.onBeginCollectFaceInfo();
                                                            }
                                                        });
                                                    }
                                                    if (this.f42909a.f42905f) {
                                                        return;
                                                    }
                                                    this.f42909a.c();
                                                    return;
                                                }
                                            }
                                            i2 = -1;
                                            if (this.f42909a.u != null) {
                                                this.f42909a.s.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.a.1.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ int f42911a;

                                                    /* renamed from: b  reason: collision with root package name */
                                                    public final /* synthetic */ AnonymousClass1 f42912b;

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
                                                        this.f42912b = this;
                                                        this.f42911a = i2;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f42912b.f42909a.u == null) {
                                                            return;
                                                        }
                                                        this.f42912b.f42909a.u.onDeviceCheckResult(this.f42911a);
                                                    }
                                                });
                                            }
                                            if (c2 != 65534) {
                                            }
                                        }
                                    } else {
                                        FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, this.f42909a.f42904e, Integer.valueOf(this.f42909a.C));
                                    }
                                    c2 = 65535;
                                    if (!this.f42909a.f42905f) {
                                    }
                                }
                            } else {
                                this.f42909a.f42906g = true;
                            }
                        } catch (Throwable th) {
                            com.baidu.sofire.utility.c.a();
                            x.a(this.f42909a.r, this.f42909a.f42904e, 1, th);
                            this.f42909a.a(-9);
                        }
                    }
                }) != 1) {
                    a(-7);
                }
                z.a(this.r).a(new Runnable(this) { // from class: com.baidu.sofire.b.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42914a;

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
                        this.f42914a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            a aVar = this.f42914a;
                            aVar.X = n.b(aVar.r);
                            a aVar2 = this.f42914a;
                            aVar2.W = n.a(aVar2.r);
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            try {
                this.f42903d = true;
                this.s.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.sofire.b.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f42916a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f42917b;

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
                        this.f42917b = this;
                        this.f42916a = i2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f42917b.u == null) {
                            return;
                        }
                        if (this.f42916a == 1) {
                            this.f42917b.u.onEnd(this.f42916a, this.f42917b.ab);
                        } else {
                            this.f42917b.u.onEnd(this.f42916a, null);
                        }
                        this.f42917b.u = null;
                    }
                });
                this.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42918a;

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
                        this.f42918a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f42918a.M = false;
                                if (this.f42918a.G != null) {
                                    this.f42918a.G.setErrorCallback(null);
                                    this.f42918a.G.setPreviewCallback(null);
                                    this.f42918a.G.stopPreview();
                                    com.baidu.sofire.i.b.a(this.f42918a.G);
                                    this.f42918a.G = null;
                                }
                                if (this.f42918a.t != null) {
                                    this.f42918a.t.removeCallback(this.f42918a);
                                }
                                if (this.f42918a.f42900a) {
                                    if (this.f42918a.p != null) {
                                        this.f42918a.p.reset();
                                        this.f42918a.p = null;
                                    }
                                } else if (this.f42918a.q != null) {
                                    this.f42918a.q.reset();
                                    this.f42918a.q = null;
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    }
                });
                b();
                if (this.f42907h) {
                    FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.f42904e, Boolean.TRUE, e());
                    this.f42907h = false;
                }
                this.s = null;
                this.t = null;
                if (this.y != null) {
                    com.baidu.sofire.b.b bVar = this.y;
                    if (bVar.f42931b != null && this == bVar.f42931b) {
                        bVar.f42931b = null;
                    }
                    this.y = null;
                }
                x.a(this.r, this.f42904e, 2, i2);
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, this, jSONObject)) == null) {
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.s.runOnUiThread(new Runnable(this) { // from class: com.baidu.sofire.b.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f42921a;

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
                        this.f42921a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f42921a.P = false;
                                if (this.f42921a.N != null) {
                                    this.f42921a.N.setErrorCallback(null);
                                    this.f42921a.N.setPreviewCallback(null);
                                    this.f42921a.N.stopPreview();
                                    com.baidu.sofire.i.b.a(this.f42921a.N);
                                    this.f42921a.N = null;
                                }
                                if (this.f42921a.t != null) {
                                    this.f42921a.t.removeCallback(this.f42921a);
                                }
                            } catch (Throwable unused) {
                                com.baidu.sofire.utility.c.a();
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static /* synthetic */ Camera b(a aVar, boolean z) {
        int numberOfCameras;
        if (aVar.f42905f || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
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
            Camera open = Camera.open(i2);
            aVar.I = i2;
            return open;
        }
        Camera open2 = Camera.open(0);
        aVar.I = 0;
        return open2;
    }

    public static JSONObject a(FaceInfo faceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, faceInfo)) == null) {
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
                String str = "";
                jSONObject.put("landmarks", faceInfo.landmarks == null ? "" : Arrays.toString(faceInfo.landmarks));
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.p, faceInfo.yaw);
                jSONObject.put("roll", faceInfo.roll);
                jSONObject.put(SdkConfigOptions.LivenessConfigOption.q, faceInfo.pitch);
                jSONObject.put("bluriness", faceInfo.bluriness);
                jSONObject.put("illum", faceInfo.illum);
                double d2 = 0.0d;
                jSONObject.put("occlusion_leftEye", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.leftEye);
                jSONObject.put("occlusion_rightEye", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.rightEye);
                jSONObject.put("occlusion_leftCheek", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.leftCheek);
                jSONObject.put("occlusion_rightCheek", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.rightCheek);
                jSONObject.put("occlusion_mouth", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.mouth);
                jSONObject.put("occlusion_nose", faceInfo.occlusion == null ? 0.0d : faceInfo.occlusion.nose);
                if (faceInfo.occlusion != null) {
                    d2 = faceInfo.occlusion.chin;
                }
                jSONObject.put("occlusion_chin", d2);
                jSONObject.put("age", faceInfo.age);
                jSONObject.put("race", faceInfo.race == null ? "" : faceInfo.race.name());
                jSONObject.put("glasses", faceInfo.glasses == null ? "" : faceInfo.glasses.name());
                jSONObject.put("gender", faceInfo.gender == null ? "" : faceInfo.gender.name());
                jSONObject.put("emotionThree", faceInfo.emotionThree == null ? "" : faceInfo.emotionThree.name());
                if (faceInfo.emotionSeven != null) {
                    str = faceInfo.emotionSeven.name();
                }
                jSONObject.put("emotionSeven", str);
                jSONObject.put("mouthclose", faceInfo.mouthclose);
                jSONObject.put("leftEyeclose", faceInfo.leftEyeclose);
                jSONObject.put("rightEyeclose", faceInfo.rightEyeclose);
                return jSONObject;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, jSONObject, str)) == null) {
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
                                } else if (longValue <= this.U) {
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
                jSONObject3.put("f_i", this.f42904e);
                jSONObject3.put("t_c", this.U);
                if (this.E && this.Q != null && this.Q.length > 0) {
                    jSONObject3.put("d_f", Base64.encodeToString(a(this.Q), 8).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                }
                if (this.D && this.R != null && this.R.length > 0) {
                    jSONObject3.put("d_p", Base64.encodeToString(a(this.R), 8).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                }
                if (this.D && this.S != null && this.S.length > 0) {
                    jSONObject3.put("d_a", Base64.encodeToString(a(this.S), 8).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                }
                if (jSONObject != null) {
                    jSONObject3.put("s", jSONObject);
                }
                JSONObject jSONObject4 = new JSONObject();
                JSONObject buildJson = this.A != null ? this.A.buildJson() : null;
                if (buildJson == null) {
                    buildJson = new JSONObject();
                }
                buildJson.put("image", this.V);
                buildJson.put("image_type", FaceEnum.ImageType.BASE64.name());
                buildJson.put("image_sec", true);
                buildJson.put("risk_identify", true);
                buildJson.put("app", "android");
                jSONObject4.put("face", buildJson);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("zid", FH.gzfi(this.r, "", 5002));
                jSONObject5.put("ev", "face");
                jSONObject5.put(NotificationStyle.NOTIFICATION_STYLE, this.X);
                jSONObject5.put("ts", System.currentTimeMillis());
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    jSONObject5.put("tz", timeZone.getID());
                }
                if (this.W != null) {
                    jSONObject5.put("ce", this.W);
                }
                jSONObject4.put("risk", jSONObject5);
                jSONObject3.put("e", jSONObject4);
                String str = com.baidu.sofire.b.b.f42928d;
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
                jSONObject2.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.r, jSONObject3.toString().getBytes()), 8).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
                jSONObject2.put("app", "android");
                String packageName = this.r.getPackageName();
                if (packageName != null) {
                    jSONObject2.put("pkg", packageName);
                    Signature[] signatureArr = this.r.getPackageManager().getPackageInfo(packageName, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        jSONObject2.put("sign", q.a(signatureArr[0].toByteArray()));
                    }
                }
                this.ab = f.a(this.r, jSONObject2.toString(), null, null);
                return 1;
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return -2;
            }
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x009f */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB;
        Allocation allocation;
        Allocation allocation2;
        ByteArrayOutputStream byteArrayOutputStream;
        RenderScript create;
        ByteArrayOutputStream byteArrayOutputStream2;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, bArr)) == null) {
            RenderScript renderScript = null;
            try {
                create = RenderScript.create(this.r);
                try {
                    scriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
                    try {
                        Type.Builder x = new Type.Builder(create, Element.U8(create)).setX(bArr.length);
                        Type.Builder y = new Type.Builder(create, Element.RGBA_8888(create)).setX(400).setY(300);
                        allocation = Allocation.createTyped(create, x.create(), 1);
                        try {
                            allocation2 = Allocation.createTyped(create, y.create(), 1);
                            try {
                                allocation.copyFrom(bArr);
                                scriptIntrinsicYuvToRGB.setInput(allocation);
                                scriptIntrinsicYuvToRGB.forEach(allocation2);
                                createBitmap = Bitmap.createBitmap(400, 300, Bitmap.Config.ARGB_8888);
                                allocation2.copyTo(createBitmap);
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                            } catch (Throwable unused) {
                                byteArrayOutputStream2 = 0;
                            }
                        } catch (Throwable unused2) {
                            allocation2 = null;
                            byteArrayOutputStream2 = allocation2;
                            renderScript = create;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                com.baidu.sofire.utility.c.a();
                                return new byte[0];
                            } finally {
                                if (renderScript != null) {
                                    try {
                                        renderScript.destroy();
                                    } catch (Throwable unused3) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                                if (scriptIntrinsicYuvToRGB != null) {
                                    try {
                                        scriptIntrinsicYuvToRGB.destroy();
                                    } catch (Throwable unused4) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                                if (allocation != null) {
                                    try {
                                        allocation.destroy();
                                    } catch (Throwable unused5) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                                if (allocation2 != null) {
                                    try {
                                        allocation2.destroy();
                                    } catch (Throwable unused6) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable unused7) {
                                        com.baidu.sofire.utility.c.a();
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused8) {
                        allocation = null;
                        allocation2 = allocation;
                        byteArrayOutputStream2 = allocation2;
                        renderScript = create;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.baidu.sofire.utility.c.a();
                        return new byte[0];
                    }
                } catch (Throwable unused9) {
                    scriptIntrinsicYuvToRGB = null;
                    allocation = null;
                }
            } catch (Throwable unused10) {
                scriptIntrinsicYuvToRGB = null;
                allocation = null;
                allocation2 = null;
                byteArrayOutputStream = null;
            }
            try {
                createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (create != null) {
                    try {
                        create.destroy();
                    } catch (Throwable unused11) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (scriptIntrinsicYuvToRGB != null) {
                    try {
                        scriptIntrinsicYuvToRGB.destroy();
                    } catch (Throwable unused12) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (allocation != null) {
                    try {
                        allocation.destroy();
                    } catch (Throwable unused13) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (allocation2 != 0) {
                    try {
                        allocation2.destroy();
                    } catch (Throwable unused14) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable unused15) {
                    com.baidu.sofire.utility.c.a();
                }
                return byteArray;
            } catch (Throwable unused16) {
                renderScript = create;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.baidu.sofire.utility.c.a();
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static /* synthetic */ void a(HashMap hashMap, HashMap hashMap2) {
        if (hashMap != null) {
            try {
                if (hashMap.size() > 0) {
                    for (ImageInfo imageInfo : hashMap.values()) {
                        imageInfo.setBase64("");
                    }
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                return;
            }
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            return;
        }
        for (ImageInfo imageInfo2 : hashMap2.values()) {
            imageInfo2.setBase64("");
        }
    }
}
