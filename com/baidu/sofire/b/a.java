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
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.FaceEnum;
import com.baidu.sofire.ac.FaceProcessCallback;
import com.baidu.sofire.ac.IFaceProcessInfo;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.sofire.core.h;
import com.baidu.sofire.utility.WbEncryptUtil;
import com.baidu.sofire.utility.i;
import com.baidu.sofire.utility.l;
import com.baidu.sofire.utility.o;
import com.baidu.sofire.utility.v;
import com.baidu.sofire.utility.w;
import com.baidu.sofire.utility.x;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.qq.e.comm.constants.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a implements Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback, ISecurityCallback {
    public IFaceProcessInfo A;
    public w B;
    public int C;
    public Camera G;
    public Camera.Parameters H;
    public int I;
    public int J;
    public int K;
    public int L;
    public Camera N;
    public Camera.Parameters O;
    public byte[] Q;
    public byte[] R;
    public byte[] S;
    public long U;
    public String V;
    public JSONArray W;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10177a;
    public RequestInfo ab;

    /* renamed from: e  reason: collision with root package name */
    public String f10181e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10182f;
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

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f10178b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10179c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10180d = false;
    public boolean D = false;
    public boolean E = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10183g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10184h = false;
    public Rect F = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public Rect f10185i = new Rect();
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public boolean M = false;
    public boolean P = false;
    public int n = 0;
    public boolean T = false;
    public int X = -1;
    public Map<Long, FaceInfo> Y = new HashMap();
    public long aa = 0;

    /* renamed from: com.baidu.sofire.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0141a implements Camera.ErrorCallback, Camera.PreviewCallback {
        public C0141a() {
        }

        @Override // android.hardware.Camera.ErrorCallback
        public final void onError(int i2, Camera camera) {
            a.this.T = true;
            a.this.c();
            a.this.j();
        }

        @Override // android.hardware.Camera.PreviewCallback
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            try {
                int i2 = a.this.n;
                if (i2 == 1) {
                    a.this.R = bArr;
                } else if (i2 == 2) {
                    a.this.S = bArr;
                }
                a.this.c();
                a.this.j();
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
                a.this.c();
                a.this.j();
            }
        }

        public /* synthetic */ C0141a(a aVar, byte b2) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements com.baidu.pass.face.platform.b {
        public b() {
        }

        @Override // com.baidu.pass.face.platform.b
        public final void a(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
            try {
                if (!a.this.f10180d && !a.this.f10182f) {
                    if (faceStatusNewEnum != FaceStatusNewEnum.OK) {
                        if (a.this.u != null) {
                            a.this.u.onCollectCompletion(faceStatusNewEnum, str, null, null, -1);
                            return;
                        }
                        return;
                    }
                    a.this.f10180d = true;
                    Pair b2 = a.this.b(hashMap, hashMap2);
                    if (b2 != null) {
                        a.this.U = ((Long) b2.first).longValue();
                        a.this.V = (String) b2.second;
                    } else {
                        a.this.a(-8);
                    }
                    if (a.this.u != null) {
                        a.a(hashMap, hashMap2);
                        a.this.u.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, -1);
                    }
                    a.this.b();
                    if (x.a(a.this.r).b(new e(a.this, (byte) 0)) != 1) {
                        a.this.a(-7);
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                v.a(a.this.r, a.this.f10181e, 4, th);
                a.this.a(-10);
            }
        }

        public /* synthetic */ b(a aVar, byte b2) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements com.baidu.pass.face.platform.d {
        public c() {
        }

        @Override // com.baidu.pass.face.platform.d
        public final void a(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2, int i2) {
            try {
                if (!a.this.f10180d && !a.this.f10182f) {
                    if (faceStatusNewEnum != FaceStatusNewEnum.OK) {
                        if (a.this.u != null) {
                            a.this.u.onCollectCompletion(faceStatusNewEnum, str, null, null, i2);
                            return;
                        }
                        return;
                    }
                    a.this.f10180d = true;
                    Pair b2 = a.this.b(hashMap, hashMap2);
                    if (b2 != null) {
                        a.this.U = ((Long) b2.first).longValue();
                        a.this.V = (String) b2.second;
                    } else {
                        a.this.a(-8);
                    }
                    if (a.this.u != null) {
                        a.a(hashMap, hashMap2);
                        a.this.u.onCollectCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i2);
                    }
                    a.this.b();
                    if (x.a(a.this.r).b(new e(a.this, (byte) 0)) != 1) {
                        a.this.a(-7);
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                v.a(a.this.r, a.this.f10181e, 4, th);
                a.this.a(-10);
            }
        }

        public /* synthetic */ c(a aVar, byte b2) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements com.baidu.pass.face.platform.e {
        public d() {
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a(LivenessTypeEnum livenessTypeEnum) {
            try {
                if (a.this.u != null) {
                    a.this.u.setCurrentLiveType(livenessTypeEnum);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }

        @Override // com.baidu.pass.face.platform.e
        public final void b() {
            try {
                if (a.this.u != null) {
                    a.this.u.animStop();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }

        public /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a() {
            try {
                if (a.this.u != null) {
                    a.this.u.viewReset();
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }

        @Override // com.baidu.pass.face.platform.e
        public final void a(FaceExtInfo faceExtInfo) {
            try {
                if (a.this.u != null) {
                    a.this.u.setFaceInfo(faceExtInfo);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Pair<Integer, Object> pair;
            try {
                if (a.this.f10182f) {
                    return;
                }
                if (a.this.D && !a.this.T) {
                    a.this.i();
                }
                if (a.this.f10182f) {
                    return;
                }
                if (a.this.u != null) {
                    a.this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.e.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.u.onBeginBuildData();
                        }
                    });
                }
                JSONObject jSONObject = null;
                if (a.this.f10184h) {
                    pair = FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, a.this.f10181e, Boolean.FALSE, a.this.h());
                    a.this.f10184h = false;
                } else {
                    pair = null;
                }
                if (a.this.f10182f) {
                    return;
                }
                if (pair != null && ((Integer) pair.first).intValue() == 0) {
                    String str = (String) pair.second;
                    if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str).optJSONObject("s")) != null && a.this.U > 0 && a.this.B.f10452a.getBoolean("lt_sssf", true)) {
                        jSONObject = a.this.b(jSONObject);
                    }
                }
                if (a.this.f10182f) {
                    return;
                }
                a.this.a(a.this.a(jSONObject));
            } catch (Throwable th) {
                com.baidu.sofire.utility.c.a();
                v.a(a.this.r, a.this.f10181e, 6, th);
                a.this.a(-12);
            }
        }

        public /* synthetic */ e(a aVar, byte b2) {
            this();
        }
    }

    public a(com.baidu.sofire.b.b bVar, Activity activity, SurfaceHolder surfaceHolder, FaceProcessCallback faceProcessCallback, int i2, IFaceProcessInfo iFaceProcessInfo, int i3, boolean z) {
        this.C = 5;
        this.y = bVar;
        Context applicationContext = activity.getApplicationContext();
        this.r = applicationContext;
        this.s = activity;
        this.t = surfaceHolder;
        this.u = faceProcessCallback;
        this.C = i2;
        w a2 = w.a(applicationContext);
        this.B = a2;
        this.Z = a2.f10452a.getLong("lt_sfii", 1000L);
        this.A = iFaceProcessInfo;
        this.z = i3;
        this.f10177a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        try {
            notifyAll();
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    @Override // com.baidu.pass.face.platform.listener.ISecurityCallback
    public final void getFaceInfoForSecurity(FaceInfo[] faceInfoArr) {
        if (faceInfoArr != null) {
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
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i2, Camera camera) {
        a(-5);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        try {
            if (!this.f10180d && !this.f10182f) {
                if (this.E && this.Q == null) {
                    this.Q = bArr;
                }
                if (this.f10177a) {
                    if (this.p == null) {
                        if (this.x == null) {
                            this.x = new d(this, (byte) 0);
                        }
                        com.baidu.pass.face.platform.c livenessStrategyModule = FaceSDKManager.getInstance().getLivenessStrategyModule(this.x);
                        this.p = livenessStrategyModule;
                        livenessStrategyModule.setISecurityCallback(this);
                        this.p.setPreviewDegree(this.L);
                        this.p.setLivenessStrategySoundEnable(this.f10178b);
                        this.p.setLivenessStrategyConfig(this.o.getLivenessTypeList(), this.F, this.f10185i, this.v);
                    }
                    if (this.p != null) {
                        this.p.livenessStrategy(bArr);
                        return;
                    }
                    return;
                }
                if (this.q == null) {
                    com.baidu.pass.face.platform.a detectStrategyModule = FaceSDKManager.getInstance().getDetectStrategyModule();
                    this.q = detectStrategyModule;
                    detectStrategyModule.setISecurityCallback(this);
                    this.q.setPreviewDegree(this.L);
                    this.q.setDetectStrategySoundEnable(this.f10178b);
                    this.q.setDetectStrategyConfig(this.F, this.f10185i, this.w);
                }
                if (this.q != null) {
                    this.q.detectStrategy(bArr);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.utility.c.a();
            v.a(this.r, this.f10181e, 3, th);
            a(-11);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.j = i3;
        this.k = i4;
        if (this.f10182f || surfaceHolder.getSurface() == null) {
            return;
        }
        if (this.M) {
            f();
        } else if (this.P) {
            k();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f10179c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f10179c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (a.this.f10182f) {
                            return;
                        }
                        a.this.M = true;
                        if (a.this.t != null) {
                            a.this.t.addCallback(a.this);
                        }
                        if (a.this.G == null && !a.this.f10182f) {
                            a.this.G = a.b(a.this, true);
                        }
                        if (a.this.G == null) {
                            return;
                        }
                        if (a.this.H == null) {
                            a.this.H = a.this.G.getParameters();
                        }
                        a.this.G.stopPreview();
                        a.this.H.setPictureFormat(256);
                        int g2 = a.this.g();
                        a.this.G.setDisplayOrientation(g2);
                        a.this.H.set("rotation", g2);
                        a.this.L = g2;
                        Point a2 = com.baidu.sofire.i.a.a(a.this.H, new Point(a.this.l, a.this.m));
                        a.this.J = a2.x;
                        a.this.K = a2.y;
                        if (a.this.f10177a) {
                            if (a.this.p != null) {
                                a.this.p.setPreviewDegree(g2);
                            }
                        } else if (a.this.q != null) {
                            a.this.q.setPreviewDegree(g2);
                        }
                        a.this.F.set(0, 0, a.this.K, a.this.J);
                        a aVar = a.this;
                        int i2 = a.this.l;
                        int i3 = a.this.K;
                        int i4 = a.this.J;
                        float f2 = (i2 / 2) - ((i2 / 2) * 0.33f);
                        float f3 = i3 / 2;
                        float f4 = (i4 / 2) - ((i4 / 2) * 0.1f);
                        if (i3 / 2 <= f2) {
                            f2 = i3 / 2;
                        }
                        float f5 = (0.2f * f2) + f2;
                        aVar.f10185i.set((int) (f3 - f2), (int) (f4 - f5), (int) (f3 + f2), (int) (f4 + f5));
                        a.this.H.setPreviewSize(a.this.J, a.this.K);
                        a.this.G.setParameters(a.this.H);
                        if (a.this.u != null) {
                            a.this.u.onConfigCamera(a.this.G, a.this.F, a.this.f10185i);
                        }
                        a.this.G.setPreviewDisplay(a.this.t);
                        a.this.G.setErrorCallback(a.this);
                        a.this.G.setPreviewCallback(a.this);
                        if (a.this.f10182f) {
                            return;
                        }
                        a.this.G.startPreview();
                        Pair<Integer, Object> callSync = FH.callSync(1, "scrc", new Class[]{String.class}, a.this.f10181e);
                        if (callSync == null || ((Integer) callSync.first).intValue() != 0) {
                            return;
                        }
                        a.this.f10184h = true;
                    } catch (Throwable th) {
                        com.baidu.sofire.utility.c.a();
                        v.a(a.this.r, a.this.f10181e, 2, th);
                        a.this.a(-5);
                    }
                }
            });
        } catch (Throwable th) {
            com.baidu.sofire.utility.c.a();
            v.a(this.r, this.f10181e, 2, th);
            a(-5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:3:0x0001, B:15:0x0025, B:17:0x0031, B:19:0x003f, B:20:0x0049), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g() {
        int i2;
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
    public String h() {
        JSONObject a2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (!this.T && !this.f10182f) {
            this.n++;
            this.P = true;
            k();
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

    private void k() {
        try {
            this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (a.this.f10182f) {
                            return;
                        }
                        a.this.T = false;
                        if (a.this.t != null) {
                            a.this.t.addCallback(a.this);
                        }
                        if (a.this.N == null) {
                            a.this.N = a.b(a.this, false);
                        }
                        if (a.this.N != null) {
                            if (a.this.O == null) {
                                a.this.O = a.this.N.getParameters();
                            }
                            a.this.N.stopPreview();
                            a.this.O.setPictureFormat(256);
                            int g2 = a.this.g();
                            a.this.N.setDisplayOrientation(g2);
                            a.this.O.set("rotation", g2);
                            a.this.L = g2;
                            Point a2 = com.baidu.sofire.i.a.a(a.this.O, new Point(a.this.l, a.this.m));
                            a.this.J = a2.x;
                            a.this.K = a2.y;
                            a.this.O.setPreviewSize(a.this.J, a.this.K);
                            a.this.N.setParameters(a.this.O);
                            a.this.N.setPreviewDisplay(a.this.t);
                            C0141a c0141a = new C0141a(a.this, (byte) 0);
                            a.this.N.setErrorCallback(c0141a);
                            a.this.N.setPreviewCallback(c0141a);
                            if (a.this.f10182f) {
                                return;
                            }
                            a.this.N.startPreview();
                            return;
                        }
                        a.this.T = true;
                        a.this.j();
                    } catch (Throwable th) {
                        com.baidu.sofire.utility.c.a();
                        a.this.T = true;
                        a.this.j();
                        a.this.c();
                        v.a(a.this.r, a.this.f10181e, 5, th);
                    }
                }
            });
        } catch (Throwable th) {
            com.baidu.sofire.utility.c.a();
            this.T = true;
            j();
            c();
            v.a(this.r, this.f10181e, 5, th);
        }
    }

    public static String e() {
        try {
            return Base64.encodeToString((UUID.randomUUID() + "_" + System.currentTimeMillis()).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", "");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final void c() {
        try {
            this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.P = false;
                        if (a.this.N != null) {
                            a.this.N.setErrorCallback(null);
                            a.this.N.setPreviewCallback(null);
                            a.this.N.stopPreview();
                            com.baidu.sofire.i.b.a(a.this.N);
                            a.this.N = null;
                        }
                        if (a.this.t != null) {
                            a.this.t.removeCallback(a.this);
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
            });
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public static /* synthetic */ void j(a aVar) {
        aVar.o = FaceSDKManager.getInstance().getFaceConfig();
        aVar.f10178b = ((AudioManager) aVar.r.getSystemService("audio")).getStreamVolume(3) > 0 ? aVar.o.isSound() : false;
        if (aVar.f10177a) {
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
        aVar.E = aVar.B.f10452a.getBoolean("lt_sfff", false);
        aVar.D = aVar.B.f10452a.getBoolean("lt_sbff", false);
    }

    public final void b() {
        try {
            this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.M = false;
                        if (a.this.G != null) {
                            a.this.G.setErrorCallback(null);
                            a.this.G.setPreviewCallback(null);
                            a.this.G.stopPreview();
                            com.baidu.sofire.i.b.a(a.this.G);
                            a.this.G = null;
                        }
                        if (a.this.t != null) {
                            a.this.t.removeCallback(a.this);
                        }
                        if (a.this.f10177a) {
                            if (a.this.p != null) {
                                a.this.p.reset();
                                a.this.p = null;
                            }
                        } else if (a.this.q != null) {
                            a.this.q.reset();
                            a.this.q = null;
                        }
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
            });
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Long, String> b(HashMap<String, ImageInfo> hashMap, HashMap<String, ImageInfo> hashMap2) {
        long currentTimeMillis;
        try {
            if (this.o.getOutputImageType() == 0) {
                hashMap = hashMap2;
            }
            if (hashMap == null || hashMap.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, ImageInfo>>() { // from class: com.baidu.sofire.b.a.6
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
                    secBase64 = secBase64.replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", "");
                }
                return new Pair<>(Long.valueOf(currentTimeMillis), secBase64);
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    public final void a() {
        x.a(this.r).b(new Runnable() { // from class: com.baidu.sofire.b.a.1
            /* JADX WARN: Removed duplicated region for block: B:57:0x017d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x019e A[Catch: all -> 0x0217, TryCatch #0 {all -> 0x0217, blocks: (B:3:0x0003, B:6:0x000c, B:8:0x005a, B:10:0x0064, B:12:0x006e, B:14:0x0073, B:17:0x007c, B:19:0x0084, B:23:0x00ab, B:25:0x00b3, B:26:0x00c1, B:28:0x00c7, B:30:0x00d7, B:32:0x00df, B:35:0x00e8, B:38:0x00f8, B:40:0x0100, B:55:0x0175, B:60:0x0182, B:65:0x0196, B:67:0x019e, B:70:0x01af, B:73:0x01b7, B:75:0x01bd, B:78:0x01c6, B:81:0x01d4, B:83:0x01dc, B:85:0x01e4, B:86:0x01e9, B:89:0x01f2, B:91:0x01fa, B:92:0x0208, B:95:0x0211, B:41:0x0122, B:43:0x012e, B:45:0x0136, B:47:0x015a, B:49:0x0164, B:20:0x0094, B:22:0x009c), top: B:100:0x0003 }] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x01af A[Catch: all -> 0x0217, TryCatch #0 {all -> 0x0217, blocks: (B:3:0x0003, B:6:0x000c, B:8:0x005a, B:10:0x0064, B:12:0x006e, B:14:0x0073, B:17:0x007c, B:19:0x0084, B:23:0x00ab, B:25:0x00b3, B:26:0x00c1, B:28:0x00c7, B:30:0x00d7, B:32:0x00df, B:35:0x00e8, B:38:0x00f8, B:40:0x0100, B:55:0x0175, B:60:0x0182, B:65:0x0196, B:67:0x019e, B:70:0x01af, B:73:0x01b7, B:75:0x01bd, B:78:0x01c6, B:81:0x01d4, B:83:0x01dc, B:85:0x01e4, B:86:0x01e9, B:89:0x01f2, B:91:0x01fa, B:92:0x0208, B:95:0x0211, B:41:0x0122, B:43:0x012e, B:45:0x0136, B:47:0x015a, B:49:0x0164, B:20:0x0094, B:22:0x009c), top: B:100:0x0003 }] */
            /* JADX WARN: Removed duplicated region for block: B:72:0x01b5  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                Pair<Integer, Object> callSync;
                char c2;
                final int i2;
                try {
                    if (a.this.f10182f) {
                        return;
                    }
                    a.this.f10181e = a.e();
                    Pair<Integer, Object> callSync2 = FH.callSync(1, "sfv", new Class[]{Activity.class, SurfaceHolder.class, Object.class, Integer.TYPE}, a.this.s, a.this.t, a.this.u, Integer.valueOf(a.this.C));
                    if (callSync2 == null || ((Integer) callSync2.first).intValue() != 0 || ((Integer) callSync2.second).intValue() != 1) {
                        if (a.this.f10182f) {
                            return;
                        }
                        if (a.this.z == 2) {
                            v.a(a.this.r, a.this.f10181e, 0, 0);
                        } else if (a.this.z == 1) {
                            v.a(a.this.r, a.this.f10181e, 1, 0);
                        }
                        if (a.this.u != null) {
                            a.this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a.this.u.onBegin();
                                }
                            });
                        }
                        if (!FH.isInitSuc(1) && a.this.B.f10452a.getBoolean("lt_sbwnp", true)) {
                            a.this.a(-15);
                        } else if (a.this.f10182f) {
                        } else {
                            if (!a.this.B.a() || a.this.C != 0) {
                                if (a.this.B.a() && a.this.C > 0 && (callSync = FH.callSync(1, "fdrv", new Class[]{String.class, Integer.TYPE}, a.this.f10181e, Integer.valueOf(a.this.C))) != null && ((Integer) callSync.first).intValue() == 0) {
                                    int intValue = ((Integer) callSync.second).intValue();
                                    if (intValue == 1) {
                                        c2 = 1;
                                    } else if (intValue == 2) {
                                        c2 = 65534;
                                    }
                                    if (!a.this.f10182f) {
                                        return;
                                    }
                                    if (c2 != 65534 && (c2 == 1 || !a.this.B.f10452a.getBoolean("lt_sucf", false))) {
                                        i2 = 1;
                                        if (a.this.u != null) {
                                            a.this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.1.2
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    a.this.u.onDeviceCheckResult(i2);
                                                }
                                            });
                                        }
                                        if (c2 != 65534) {
                                            a.this.a(-3);
                                            return;
                                        } else if (i2 == -1) {
                                            a.this.a(-3);
                                            return;
                                        } else if (a.this.f10182f) {
                                            return;
                                        } else {
                                            a.j(a.this);
                                            if (a.this.f10182f) {
                                                return;
                                            }
                                            if (a.this.D && !a.this.T) {
                                                a.this.i();
                                            }
                                            if (a.this.f10182f) {
                                                return;
                                            }
                                            if (a.this.u != null) {
                                                a.this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.1.3
                                                    @Override // java.lang.Runnable
                                                    public final void run() {
                                                        a.this.u.onBeginCollectFaceInfo();
                                                    }
                                                });
                                            }
                                            if (a.this.f10182f) {
                                                return;
                                            }
                                            a.this.f();
                                            return;
                                        }
                                    }
                                    i2 = -1;
                                    if (a.this.u != null) {
                                    }
                                    if (c2 != 65534) {
                                    }
                                }
                            } else {
                                FH.call(1, "fdrv", new Class[]{String.class, Integer.TYPE}, a.this.f10181e, Integer.valueOf(a.this.C));
                            }
                            c2 = 65535;
                            if (!a.this.f10182f) {
                            }
                        }
                    } else {
                        a.this.f10183g = true;
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.utility.c.a();
                    v.a(a.this.r, a.this.f10181e, 1, th);
                    a.this.a(-9);
                }
            }
        });
        x.a(this.r).a(new Runnable() { // from class: com.baidu.sofire.b.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                aVar.X = l.b(aVar.r);
                a aVar2 = a.this;
                aVar2.W = l.a(aVar2.r);
            }
        });
    }

    public final void a(final int i2) {
        try {
            this.f10180d = false;
            this.s.runOnUiThread(new Runnable() { // from class: com.baidu.sofire.b.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.u != null) {
                        if (i2 == 1) {
                            a.this.u.onEnd(i2, a.this.ab);
                        } else {
                            a.this.u.onEnd(i2, null);
                        }
                        a.this.u = null;
                    }
                }
            });
            b();
            c();
            if (this.f10184h) {
                FH.callSync(1, "ecrc", new Class[]{String.class, Boolean.TYPE, String.class}, this.f10181e, Boolean.TRUE, h());
                this.f10184h = false;
            }
            this.s = null;
            this.t = null;
            if (this.y != null) {
                com.baidu.sofire.b.b bVar = this.y;
                if (bVar.f10208b != null && this == bVar.f10208b) {
                    bVar.f10208b = null;
                }
                this.y = null;
            }
            v.a(this.r, this.f10181e, 2, i2);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject b(JSONObject jSONObject) {
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

    public static /* synthetic */ Camera b(a aVar, boolean z) {
        int numberOfCameras;
        if (aVar.f10182f || (numberOfCameras = Camera.getNumberOfCameras()) == 0) {
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

    private JSONObject a(JSONObject jSONObject, String str) {
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

    public final int a(JSONObject jSONObject) {
        byte[] bytes;
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("f_i", this.f10181e);
            jSONObject3.put("t_c", this.U);
            if (this.E && this.Q != null && this.Q.length > 0) {
                jSONObject3.put("d_f", Base64.encodeToString(a(this.Q), 8).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            }
            if (this.D && this.R != null && this.R.length > 0) {
                jSONObject3.put("d_p", Base64.encodeToString(a(this.R), 8).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            }
            if (this.D && this.S != null && this.S.length > 0) {
                jSONObject3.put("d_a", Base64.encodeToString(a(this.S), 8).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
            }
            if (jSONObject != null) {
                jSONObject3.put("s", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject buildJson = this.A.buildJson();
            if (buildJson != null) {
                buildJson.put("image", this.V);
                buildJson.put("image_type", FaceEnum.ImageType.BASE64.name());
                buildJson.put("image_sec", true);
                buildJson.put("risk_identify", true);
                buildJson.put("app", "android");
                jSONObject4.put("face", buildJson);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("zid", FH.gzfi(this.r, "", ErrorCode.VIDEO_DOWNLOAD_FAIL));
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
                String str = com.baidu.sofire.b.b.f10205c;
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
                jSONObject2.put("data", Base64.encodeToString(WbEncryptUtil.wbEncrypt(this.r, jSONObject3.toString().getBytes()), 8).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                jSONObject2.put("app", "android");
                String packageName = this.r.getPackageName();
                if (packageName != null) {
                    jSONObject2.put("pkg", packageName);
                    Signature[] signatureArr = this.r.getPackageManager().getPackageInfo(packageName, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        jSONObject2.put("sign", o.a(signatureArr[0].toByteArray()));
                    }
                }
                Context context = this.r;
                String jSONObject6 = jSONObject2.toString();
                byte[] a2 = h.a();
                if (!TextUtils.isEmpty(jSONObject6)) {
                    bytes = F.getInstance().ae(i.a(jSONObject6.getBytes()), a2);
                } else {
                    bytes = "".getBytes();
                }
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("data", Base64.encodeToString(bytes, 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                jSONObject7.put("app", "android");
                this.ab = new RequestInfo(Base64.encodeToString(F.getInstance().re(a2, o.a(com.baidu.sofire.utility.e.b(context)).getBytes()), 0), o.a(com.baidu.sofire.utility.e.b(context)), jSONObject7);
                return 1;
            }
            throw new RuntimeException("FaceJsonObj build error.");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return -2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x009b */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(byte[] bArr) {
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB;
        Allocation allocation;
        Allocation allocation2;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Bitmap createBitmap;
        RenderScript renderScript = null;
        try {
            RenderScript create = RenderScript.create(this.r);
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
            try {
                createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (create != null) {
                    try {
                        create.destroy();
                    } catch (Throwable unused10) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (scriptIntrinsicYuvToRGB != null) {
                    try {
                        scriptIntrinsicYuvToRGB.destroy();
                    } catch (Throwable unused11) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (allocation != null) {
                    try {
                        allocation.destroy();
                    } catch (Throwable unused12) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                if (allocation2 != 0) {
                    try {
                        allocation2.destroy();
                    } catch (Throwable unused13) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (Throwable unused14) {
                    com.baidu.sofire.utility.c.a();
                }
                return byteArray;
            } catch (Throwable unused15) {
                renderScript = create;
                byteArrayOutputStream = byteArrayOutputStream2;
                com.baidu.sofire.utility.c.a();
                return new byte[0];
            }
        } catch (Throwable unused16) {
            scriptIntrinsicYuvToRGB = null;
            allocation = null;
            allocation2 = null;
            byteArrayOutputStream = null;
        }
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
