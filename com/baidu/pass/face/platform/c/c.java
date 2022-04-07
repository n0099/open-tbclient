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
/* loaded from: classes2.dex */
public class c implements ILivenessStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "c";
    public static volatile int u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Context b;
    public Rect c;
    public Rect d;
    public com.baidu.pass.face.platform.c.a e;
    public d f;
    public com.baidu.pass.face.platform.b.a g;
    public ILivenessStrategyCallback h;
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
    public volatile EnumC0119c x;
    public long y;
    public int z;

    /* renamed from: com.baidu.pass.face.platform.c.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
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
            int[] iArr = new int[EnumC0119c.values().length];
            b = iArr;
            try {
                iArr[EnumC0119c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC0119c.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC0119c.c.ordinal()] = 3;
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public byte[] b;

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
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.b);
                c.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public Bitmap b;

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
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.b);
                c.a();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.pass.face.platform.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class EnumC0119c {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC0119c a;
        public static final EnumC0119c b;
        public static final EnumC0119c c;
        public static final EnumC0119c d;
        public static final EnumC0119c e;
        public static final /* synthetic */ EnumC0119c[] f;
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
            a = new EnumC0119c("LivenessReady", 0);
            b = new EnumC0119c("LivenessTips", 1);
            c = new EnumC0119c("LivenessOK", 2);
            d = new EnumC0119c("LivenessCourse", 3);
            EnumC0119c enumC0119c = new EnumC0119c("LivenessCrop", 4);
            e = enumC0119c;
            f = new EnumC0119c[]{a, b, c, d, enumC0119c};
        }

        public EnumC0119c(String str, int i) {
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

        public static EnumC0119c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0119c) Enum.valueOf(EnumC0119c.class, str) : (EnumC0119c) invokeL.objValue;
        }

        public static EnumC0119c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0119c[]) f.clone() : (EnumC0119c[]) invokeV.objValue;
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
        this.x = EnumC0119c.e;
        this.y = -1L;
        com.baidu.pass.face.platform.a.a.b();
        com.baidu.pass.face.platform.a.a.b("ca", "Baidu-IDL-FaceSDK4.1.1");
        com.baidu.pass.face.platform.a.a.b("version", "4.1.1");
        com.baidu.pass.face.platform.a.a.b("stm", Long.valueOf(System.currentTimeMillis()));
        this.b = context;
        this.e = new com.baidu.pass.face.platform.c.a();
        this.f = new d();
        this.g = new com.baidu.pass.face.platform.b.a();
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
            FaceExtInfo[] a2 = this.g.a(faceInfoArr);
            com.baidu.pass.face.platform.model.a aVar = new com.baidu.pass.face.platform.model.a();
            aVar.a(a2);
            aVar.a(this.e.a(this.d, a2, this.t));
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
            if (tipsId <= 0 || (context = this.b) == null) {
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

    private void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f)}) == null) || (a2 = this.g.a(faceExtInfo, bDFaceImageInstance)) == null || a2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.r;
        hashMap.put("bestCropImage_" + i + "_" + f + "_" + System.currentTimeMillis(), a2.get(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x019c, code lost:
        if (r11.f.e() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.pass.face.platform.model.a aVar, BDFaceImageInstance bDFaceImageInstance) {
        EnumC0119c enumC0119c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, aVar, bDFaceImageInstance) == null) || bDFaceImageInstance == null) {
            return;
        }
        if (this.o) {
            bDFaceImageInstance.destory();
        } else if (aVar == null || aVar.b() == null || aVar.b().length == 0) {
            bDFaceImageInstance.destory();
            com.baidu.pass.face.platform.c.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.c();
            }
        } else {
            FaceStatusNewEnum a2 = aVar.a();
            FaceExtInfo faceExtInfo = aVar.b()[0];
            if (a2 != FaceStatusNewEnum.OK) {
                if (!this.e.a()) {
                    if (AnonymousClass1.a[a2.ordinal()] != 1) {
                        bDFaceImageInstance.destory();
                        a(a2, faceExtInfo);
                        this.e.c();
                        this.f.j();
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
                        this.e.c();
                        this.f.j();
                        a(a2, (FaceExtInfo) null);
                        return;
                    }
                }
            } else if (faceExtInfo == null) {
                return;
            } else {
                this.i.setFaceInfo(faceExtInfo);
                if (this.x == EnumC0119c.e) {
                    if (this.z >= this.t.getCacheImageNum()) {
                        this.x = EnumC0119c.a;
                    } else if (a(bDFaceImageInstance, faceExtInfo, this.f.a(), this.z)) {
                        this.z++;
                    }
                }
                if (this.x == EnumC0119c.a || this.x == EnumC0119c.b) {
                    if (faceExtInfo.getFaceId() != this.y) {
                        this.f.i();
                        FaceSDKManager.getInstance().a();
                        if (this.y != -1) {
                            this.x = EnumC0119c.e;
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
                    this.f.a(faceExtInfo, bDFaceImageInstance, this.c);
                }
                this.v = 0L;
                com.baidu.pass.face.platform.a.a.a("btm", Long.valueOf(System.currentTimeMillis()));
                int i = AnonymousClass1.b[this.x.ordinal()];
                if (i == 1) {
                    if (a(this.f.b(), faceExtInfo)) {
                        enumC0119c = EnumC0119c.b;
                        this.x = enumC0119c;
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (i != 2) {
                    if (i == 3 && a(FaceStatusNewEnum.FaceLivenessActionComplete, faceExtInfo)) {
                        if (!this.w) {
                            this.w = true;
                        }
                        if (this.f.f()) {
                            this.f.h();
                            enumC0119c = EnumC0119c.a;
                            this.x = enumC0119c;
                        } else if (this.f.c()) {
                            b(FaceStatusNewEnum.OK, faceExtInfo);
                        }
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (this.f.d()) {
                    enumC0119c = EnumC0119c.c;
                    this.x = enumC0119c;
                    bDFaceImageInstance.destory();
                    return;
                } else {
                    a(this.f.b(), faceExtInfo);
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
            FaceStatusNewEnum a3 = this.e.a(faceExtInfo, this.t);
            if (a3 != FaceStatusNewEnum.OK) {
                this.h.onLivenessCompletion(a3, a(a3), null, null, 0);
                return false;
            } else if (this.t.isNoBlackCropImage() && (a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.t.getCropHeight(), this.t.getCropWidth())) != FaceStatusNewEnum.OK) {
                this.h.onLivenessCompletion(a2, a(a2), null, null, 0);
                return false;
            } else {
                float b2 = this.e.b();
                this.g.a(this.t);
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
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.f.a(this.t) && !this.A) {
            ILivenessViewCallback iLivenessViewCallback = this.i;
            if (iLivenessViewCallback != null) {
                iLivenessViewCallback.setCurrentLiveType(this.f.a());
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
        int g;
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
                iLivenessStrategyCallback = this.h;
                if (iLivenessStrategyCallback == null) {
                    return;
                }
            } else if (faceStatusNewEnum != FaceStatusNewEnum.FaceLivenessActionComplete) {
                iLivenessStrategyCallback = this.h;
                if (iLivenessStrategyCallback != null) {
                    a2 = a(faceStatusNewEnum);
                    HashMap<String, ImageInfo> hashMap3 = this.r;
                    faceStatusNewEnum2 = faceStatusNewEnum;
                    hashMap = hashMap3;
                    hashMap2 = this.s;
                    g = this.f.g() - 1;
                    iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g);
                }
                return;
            } else {
                iLivenessStrategyCallback = this.h;
                if (iLivenessStrategyCallback == null) {
                    return;
                }
            }
            a2 = a(faceStatusNewEnum);
            hashMap = this.r;
            hashMap2 = this.s;
            g = this.f.g();
            faceStatusNewEnum2 = faceStatusNewEnum;
            iLivenessStrategyCallback.onLivenessCompletion(faceStatusNewEnum2, a2, hashMap, hashMap2, g);
        }
    }

    private void b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f)}) == null) || (b2 = this.g.b(faceExtInfo, bDFaceImageInstance)) == null || b2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.s;
        hashMap.put("bestSrcImage_" + i + "_" + f + "_" + System.currentTimeMillis(), b2.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, bArr) == null) {
            try {
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.c.width(), this.c.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.m, 1);
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
            d dVar = this.f;
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
            this.f.a(list);
            this.c = rect;
            this.d = rect2;
            this.h = iLivenessStrategyCallback;
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
