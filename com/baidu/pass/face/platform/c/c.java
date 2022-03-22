package com.baidu.pass.face.platform.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.ILivenessStrategy;
import com.baidu.pass.face.platform.ILivenessStrategyCallback;
import com.baidu.pass.face.platform.ILivenessViewCallback;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.pass.face.platform.listener.ISecurityCallback;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements ILivenessStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "c";
    public static volatile int u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;

    /* renamed from: b  reason: collision with root package name */
    public Context f28086b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f28087c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f28088d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.pass.face.platform.c.a f28089e;

    /* renamed from: f  reason: collision with root package name */
    public d f28090f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.pass.face.platform.b.a f28091g;

    /* renamed from: h  reason: collision with root package name */
    public ILivenessStrategyCallback f28092h;
    public ILivenessViewCallback i;
    public ISecurityCallback j;
    public volatile boolean k;
    public com.baidu.pass.face.platform.a.b l;
    public int m;
    public boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public Map<FaceStatusNewEnum, String> q;
    public HashMap<String, ImageInfo> r;
    public HashMap<String, ImageInfo> s;
    public FaceConfig t;
    public long v;
    public boolean w;
    public volatile EnumC1778c x;
    public long y;
    public int z;

    /* renamed from: com.baidu.pass.face.platform.c.c$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f28093b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1667430801, "Lcom/baidu/pass/face/platform/c/c$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1667430801, "Lcom/baidu/pass/face/platform/c/c$1;");
                    return;
                }
            }
            int[] iArr = new int[EnumC1778c.values().length];
            f28093b = iArr;
            try {
                iArr[EnumC1778c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28093b[EnumC1778c.f28096b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28093b[EnumC1778c.f28097c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[FaceStatusNewEnum.values().length];
            a = iArr2;
            try {
                iArr2[FaceStatusNewEnum.DetectRemindCodeNoFaceDetected.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f28094b;

        public a(c cVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bArr};
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
            this.f28094b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.f28094b);
                c.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f28095b;

        public b(c cVar, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bitmap};
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
            this.f28095b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.f28095b);
                c.a();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.pass.face.platform.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class EnumC1778c {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC1778c a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1778c f28096b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1778c f28097c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1778c f28098d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1778c f28099e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ EnumC1778c[] f28100f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1667432351, "Lcom/baidu/pass/face/platform/c/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1667432351, "Lcom/baidu/pass/face/platform/c/c$c;");
                    return;
                }
            }
            a = new EnumC1778c("LivenessReady", 0);
            f28096b = new EnumC1778c("LivenessTips", 1);
            f28097c = new EnumC1778c("LivenessOK", 2);
            f28098d = new EnumC1778c("LivenessCourse", 3);
            EnumC1778c enumC1778c = new EnumC1778c("LivenessCrop", 4);
            f28099e = enumC1778c;
            f28100f = new EnumC1778c[]{a, f28096b, f28097c, f28098d, enumC1778c};
        }

        public EnumC1778c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EnumC1778c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1778c) Enum.valueOf(EnumC1778c.class, str) : (EnumC1778c) invokeL.objValue;
        }

        public static EnumC1778c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1778c[]) f28100f.clone() : (EnumC1778c[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360275650, "Lcom/baidu/pass/face/platform/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360275650, "Lcom/baidu/pass/face/platform/c/c;");
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = null;
        this.q = new HashMap();
        this.r = new HashMap<>();
        this.s = new HashMap<>();
        this.v = 0L;
        this.x = EnumC1778c.f28099e;
        this.y = -1L;
        com.baidu.pass.face.platform.a.a.b();
        com.baidu.pass.face.platform.a.a.b("ca", "Baidu-IDL-FaceSDK4.1.1");
        com.baidu.pass.face.platform.a.a.b("version", "4.1.1");
        com.baidu.pass.face.platform.a.a.b("stm", Long.valueOf(System.currentTimeMillis()));
        this.f28086b = context;
        this.f28089e = new com.baidu.pass.face.platform.c.a();
        this.f28090f = new d();
        this.f28091g = new com.baidu.pass.face.platform.b.a();
        this.l = new com.baidu.pass.face.platform.a.b(context);
    }

    public static /* synthetic */ int a() {
        int i = u - 1;
        u = i;
        return i;
    }

    private com.baidu.pass.face.platform.model.a a(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, faceInfoArr)) == null) {
            FaceExtInfo[] a2 = this.f28091g.a(faceInfoArr);
            com.baidu.pass.face.platform.model.a aVar = new com.baidu.pass.face.platform.model.a();
            aVar.a(a2);
            aVar.a(this.f28089e.a(this.f28088d, a2, this.t));
            aVar.a(System.currentTimeMillis());
            return aVar;
        }
        return (com.baidu.pass.face.platform.model.a) invokeL.objValue;
    }

    private String a(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, faceStatusNewEnum)) == null) {
            if (this.q.containsKey(faceStatusNewEnum)) {
                return this.q.get(faceStatusNewEnum);
            }
            int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
            if (tipsId <= 0 || (context = this.f28086b) == null) {
                return "";
            }
            String string = context.getResources().getString(tipsId);
            this.q.put(faceStatusNewEnum, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    private void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, bitmap) == null) || u > 0) {
            return;
        }
        u++;
        new b(this, bitmap).run();
    }

    private void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f2) {
        ArrayList<ImageInfo> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f2)}) == null) || (a2 = this.f28091g.a(faceExtInfo, bDFaceImageInstance)) == null || a2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.r;
        hashMap.put("bestCropImage_" + i + "_" + f2 + "_" + System.currentTimeMillis(), a2.get(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x019c, code lost:
        if (r11.f28090f.e() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.pass.face.platform.model.a aVar, BDFaceImageInstance bDFaceImageInstance) {
        EnumC1778c enumC1778c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, aVar, bDFaceImageInstance) == null) || bDFaceImageInstance == null) {
            return;
        }
        if (this.o) {
            bDFaceImageInstance.destory();
        } else if (aVar == null || aVar.b() == null || aVar.b().length == 0) {
            bDFaceImageInstance.destory();
            com.baidu.pass.face.platform.c.a aVar2 = this.f28089e;
            if (aVar2 != null) {
                aVar2.c();
            }
        } else {
            FaceStatusNewEnum a2 = aVar.a();
            FaceExtInfo faceExtInfo = aVar.b()[0];
            if (a2 != FaceStatusNewEnum.OK) {
                if (!this.f28089e.a()) {
                    if (AnonymousClass1.a[a2.ordinal()] != 1) {
                        bDFaceImageInstance.destory();
                        a(a2, faceExtInfo);
                        this.f28089e.c();
                        this.f28090f.j();
                        return;
                    }
                    if (this.v == 0) {
                        this.v = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.v <= this.t.getTimeDetectModule()) {
                        if (this.w && this.v != 0 && System.currentTimeMillis() - this.v < FaceEnvironment.TIME_DETECT_NO_FACE_CONTINUOUS) {
                            bDFaceImageInstance.destory();
                            return;
                        }
                        this.w = false;
                        bDFaceImageInstance.destory();
                        this.f28089e.c();
                        this.f28090f.j();
                        a(a2, (FaceExtInfo) null);
                        return;
                    }
                }
            } else if (faceExtInfo == null) {
                return;
            } else {
                this.i.setFaceInfo(faceExtInfo);
                if (this.x == EnumC1778c.f28099e) {
                    if (this.z >= this.t.getCacheImageNum()) {
                        this.x = EnumC1778c.a;
                    } else if (a(bDFaceImageInstance, faceExtInfo, this.f28090f.a(), this.z)) {
                        this.z++;
                    }
                }
                if (this.x == EnumC1778c.a || this.x == EnumC1778c.f28096b) {
                    if (faceExtInfo.getFaceId() != this.y) {
                        this.f28090f.i();
                        FaceSDKManager.getInstance().a();
                        if (this.y != -1) {
                            this.x = EnumC1778c.f28099e;
                            this.z = 0;
                            HashMap<String, ImageInfo> hashMap = this.r;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            HashMap<String, ImageInfo> hashMap2 = this.s;
                            if (hashMap2 != null) {
                                hashMap2.clear();
                            }
                        }
                        this.i.viewReset();
                        this.y = faceExtInfo.getFaceId();
                    }
                    this.f28090f.a(faceExtInfo, bDFaceImageInstance, this.f28087c);
                }
                this.v = 0L;
                com.baidu.pass.face.platform.a.a.a("btm", Long.valueOf(System.currentTimeMillis()));
                int i = AnonymousClass1.f28093b[this.x.ordinal()];
                if (i == 1) {
                    if (a(this.f28090f.b(), faceExtInfo)) {
                        enumC1778c = EnumC1778c.f28096b;
                        this.x = enumC1778c;
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (i != 2) {
                    if (i == 3 && a(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                        if (!this.w) {
                            this.w = true;
                        }
                        if (this.f28090f.f()) {
                            this.f28090f.h();
                            enumC1778c = EnumC1778c.a;
                            this.x = enumC1778c;
                        } else if (this.f28090f.c()) {
                            b(FaceStatusNewEnum.OK, faceExtInfo);
                        }
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (this.f28090f.d()) {
                    enumC1778c = EnumC1778c.f28097c;
                    this.x = enumC1778c;
                    bDFaceImageInstance.destory();
                    return;
                } else {
                    a(this.f28090f.b(), faceExtInfo);
                    b();
                }
            }
            bDFaceImageInstance.destory();
            this.o = true;
            b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
        }
    }

    private void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, bArr) == null) || u > 0) {
            return;
        }
        u++;
        new a(this, bArr).run();
    }

    private boolean a(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, faceStatusNewEnum, faceExtInfo)) == null) {
            if (faceStatusNewEnum != null) {
                this.l.a(this.k);
                boolean a2 = this.l.a(faceStatusNewEnum);
                if (a2) {
                    com.baidu.pass.face.platform.a.a.a(faceStatusNewEnum.name());
                    b(faceStatusNewEnum, faceExtInfo);
                    return a2;
                }
                return a2;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private boolean a(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, LivenessTypeEnum livenessTypeEnum, int i) {
        InterceptResult invokeLLLI;
        FaceStatusNewEnum a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65548, this, bDFaceImageInstance, faceExtInfo, livenessTypeEnum, i)) == null) {
            FaceStatusNewEnum a3 = this.f28089e.a(faceExtInfo, this.t);
            if (a3 != FaceStatusNewEnum.OK) {
                this.f28092h.onLivenessCompletion(a3, a(a3), null, null, 0);
                return false;
            } else if (this.t.isNoBlackCropImage() && (a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.t.getCropHeight(), this.t.getCropWidth())) != FaceStatusNewEnum.OK) {
                this.f28092h.onLivenessCompletion(a2, a(a2), null, null, 0);
                return false;
            } else {
                float b2 = this.f28089e.b();
                this.f28091g.a(this.t);
                BDFaceImageInstance b3 = FaceSDKManager.getInstance().b(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.t.getCropHeight(), this.t.getCropWidth());
                if (b3 == null) {
                    return false;
                }
                a(faceExtInfo, b3, i, b2);
                b3.destory();
                b(faceExtInfo, bDFaceImageInstance, i, b2);
                return true;
            }
        }
        return invokeLLLI.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f28090f.a(this.t) && !this.A) {
            ILivenessViewCallback iLivenessViewCallback = this.i;
            if (iLivenessViewCallback != null) {
                iLivenessViewCallback.setCurrentLiveType(this.f28090f.a());
            }
            b(FaceStatusNewEnum.FaceLivenessActionCodeTimeout, null);
            this.A = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, bitmap) == null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bitmap);
                a(a(FaceSDKManager.getInstance().a(bDFaceImageInstance)), bDFaceImageInstance);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        ILivenessStrategyCallback iLivenessStrategyCallback;
        String a2;
        FaceStatusNewEnum faceStatusNewEnum2;
        HashMap<String, ImageInfo> hashMap;
        HashMap<String, ImageInfo> hashMap2;
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, faceStatusNewEnum, faceExtInfo) == null) {
            if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
                com.baidu.pass.face.platform.a.a.a();
            }
            if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                this.o = true;
                this.p = true;
                com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
                com.baidu.pass.face.platform.a.a.a("finish", 1);
                com.baidu.pass.face.platform.a.a.a();
                iLivenessStrategyCallback = this.f28092h;
                if (iLivenessStrategyCallback == null) {
                    return;
                }
            } else if (faceStatusNewEnum != FaceStatusNewEnum.FaceLivenessActionComplete) {
                iLivenessStrategyCallback = this.f28092h;
                if (iLivenessStrategyCallback != null) {
                    a2 = a(faceStatusNewEnum);
                    HashMap<String, ImageInfo> hashMap3 = this.r;
                    faceStatusNewEnum2 = faceStatusNewEnum;
                    hashMap = hashMap3;
                    hashMap2 = this.s;
                    g2 = this.f28090f.g() - 1;
                    iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g2);
                }
                return;
            } else {
                iLivenessStrategyCallback = this.f28092h;
                if (iLivenessStrategyCallback == null) {
                    return;
                }
            }
            a2 = a(faceStatusNewEnum);
            hashMap = this.r;
            hashMap2 = this.s;
            g2 = this.f28090f.g();
            faceStatusNewEnum2 = faceStatusNewEnum;
            iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g2);
        }
    }

    private void b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f2) {
        ArrayList<ImageInfo> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f2)}) == null) || (b2 = this.f28091g.b(faceExtInfo, bDFaceImageInstance)) == null || b2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.s;
        hashMap.put("bestSrcImage_" + i + "_" + f2 + "_" + System.currentTimeMillis(), b2.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, bArr) == null) {
            try {
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.f28087c.width(), this.f28087c.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.m, 1);
                FaceInfo[] a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance);
                if (this.j != null) {
                    this.j.getFaceInfoForSecurity(a2);
                }
                a(a(a2), bDFaceImageInstance);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, faceConfig) == null) {
            this.t = faceConfig;
        }
    }

    public void a(ILivenessViewCallback iLivenessViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iLivenessViewCallback) == null) {
            this.i = iLivenessViewCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void livenessStrategy(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            if (!this.n) {
                this.n = true;
                a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
            } else if (this.o) {
            } else {
                a(bitmap);
            }
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void livenessStrategy(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            if (!this.n) {
                this.n = true;
                a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
            } else if (this.o) {
            } else {
                a(bArr);
            }
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FaceSDKManager.getInstance().a();
            d dVar = this.f28090f;
            if (dVar != null) {
                dVar.i();
            }
            HashMap<String, ImageInfo> hashMap = this.r;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, ImageInfo> hashMap2 = this.s;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            com.baidu.pass.face.platform.a.b bVar = this.l;
            if (bVar != null) {
                bVar.a();
            }
            this.n = false;
            this.o = false;
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iSecurityCallback) == null) {
            this.j = iSecurityCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setLivenessStrategyConfig(List<LivenessTypeEnum> list, Rect rect, Rect rect2, ILivenessStrategyCallback iLivenessStrategyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, list, rect, rect2, iLivenessStrategyCallback) == null) {
            this.f28090f.a(list);
            this.f28087c = rect;
            this.f28088d = rect2;
            this.f28092h = iLivenessStrategyCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setLivenessStrategySoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.pass.face.platform.ILivenessStrategy
    public void setPreviewDegree(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }
}
