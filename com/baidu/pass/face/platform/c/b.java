package com.baidu.pass.face.platform.c;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.IDetectStrategy;
import com.baidu.pass.face.platform.IDetectStrategyCallback;
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
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements IDetectStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.baidu.pass.face.platform.c.b";
    public static volatile int p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public Rect c;
    public Rect d;
    public IDetectStrategyCallback e;
    public ISecurityCallback f;
    public int g;
    public final com.baidu.pass.face.platform.b.a h;
    public boolean i;
    public volatile boolean j;
    public volatile boolean k;
    public FaceConfig l;
    public volatile boolean m;
    public final com.baidu.pass.face.platform.c.a n;
    public final com.baidu.pass.face.platform.a.b o;
    public int q;
    public long r;
    public Map<FaceStatusNewEnum, String> s;
    public HashMap<String, ImageInfo> t;
    public HashMap<String, ImageInfo> u;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public byte[] b;

        public a(b bVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bArr};
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
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(this.b);
                b.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360275681, "Lcom/baidu/pass/face/platform/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360275681, "Lcom/baidu/pass/face/platform/c/b;");
        }
    }

    public b(Context context) {
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
        this.i = false;
        this.k = false;
        this.m = true;
        this.q = 0;
        this.r = 0L;
        this.s = new HashMap();
        this.t = new HashMap<>();
        this.u = new HashMap<>();
        com.baidu.pass.face.platform.a.a.b();
        com.baidu.pass.face.platform.a.a.b("ca", "Baidu-IDL-FaceSDK4.1.1");
        com.baidu.pass.face.platform.a.a.b("version", "4.1.1");
        com.baidu.pass.face.platform.a.a.b("stm", Long.valueOf(System.currentTimeMillis()));
        this.b = context;
        this.n = new com.baidu.pass.face.platform.c.a();
        this.o = new com.baidu.pass.face.platform.a.b(context);
        this.h = new com.baidu.pass.face.platform.b.a();
    }

    public static /* synthetic */ int a() {
        int i = p - 1;
        p = i;
        return i;
    }

    private com.baidu.pass.face.platform.model.a a(FaceInfo[] faceInfoArr, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, faceInfoArr, bDFaceImageInstance)) == null) {
            if (bDFaceImageInstance == null) {
                return null;
            }
            com.baidu.pass.face.platform.model.a aVar = new com.baidu.pass.face.platform.model.a();
            FaceExtInfo[] a2 = this.h.a(faceInfoArr);
            aVar.a(this.n.a(a2, this.d, false, this.l));
            aVar.a(a2);
            aVar.a(System.currentTimeMillis());
            return aVar;
        }
        return (com.baidu.pass.face.platform.model.a) invokeLL.objValue;
    }

    private String a(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, faceStatusNewEnum)) == null) {
            if (this.s.containsKey(faceStatusNewEnum)) {
                return this.s.get(faceStatusNewEnum);
            }
            int tipsId = FaceEnvironment.getTipsId(faceStatusNewEnum);
            if (tipsId <= 0 || (context = this.b) == null) {
                return "";
            }
            String string = context.getResources().getString(tipsId);
            this.s.put(faceStatusNewEnum, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    private void a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f)}) == null) || (a2 = this.h.a(faceExtInfo, bDFaceImageInstance)) == null || a2.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.t;
        hashMap.put("bestCropDetectImage_" + i + "_" + f + "_" + System.currentTimeMillis(), a2.get(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.baidu.pass.face.platform.model.a aVar, BDFaceImageInstance bDFaceImageInstance) {
        FaceExtInfo faceExtInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, aVar, bDFaceImageInstance) == null) || bDFaceImageInstance == null) {
            return;
        }
        if (this.j) {
            bDFaceImageInstance.destory();
            return;
        }
        if (aVar == null || aVar.b() == null || aVar.b().length <= 0) {
            com.baidu.pass.face.platform.c.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.c();
            }
            faceExtInfo = null;
        } else {
            faceExtInfo = aVar.b()[0];
            com.baidu.pass.face.platform.a.a.a("ftm", Long.valueOf(System.currentTimeMillis()));
        }
        if (faceExtInfo != null) {
            if (this.n == null) {
                bDFaceImageInstance.destory();
                return;
            } else if (this.k) {
                a(FaceStatusNewEnum.OK, faceExtInfo);
                bDFaceImageInstance.destory();
                return;
            } else if (aVar == null) {
                return;
            } else {
                FaceStatusNewEnum a2 = aVar.a();
                if (a2 == FaceStatusNewEnum.OK) {
                    com.baidu.pass.face.platform.a.a.a("btm", Long.valueOf(System.currentTimeMillis()));
                    if (this.q >= this.l.getCacheImageNum()) {
                        this.k = true;
                        a(FaceStatusNewEnum.OK, faceExtInfo);
                    } else if (a(bDFaceImageInstance, faceExtInfo, this.q)) {
                        this.q++;
                    }
                    bDFaceImageInstance.destory();
                    return;
                } else if (this.n.a()) {
                    this.j = true;
                    bDFaceImageInstance.destory();
                    b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                    return;
                } else {
                    a(a2, faceExtInfo);
                }
            }
        } else if (this.n == null) {
            bDFaceImageInstance.destory();
            return;
        } else {
            long j = 0;
            if (aVar != null && (aVar.a() == FaceStatusNewEnum.DetectRemindCodeNoFaceDetected || aVar.a() == FaceStatusNewEnum.DetectRemindCodeBeyondPreviewFrame)) {
                this.n.c();
                int i = (this.r > 0L ? 1 : (this.r == 0L ? 0 : -1));
                j = System.currentTimeMillis();
                if (i != 0) {
                    if (j - this.r > this.l.getTimeDetectModule()) {
                        this.j = true;
                        bDFaceImageInstance.destory();
                        b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                        return;
                    }
                    if (!this.n.a()) {
                        bDFaceImageInstance.destory();
                        this.j = true;
                        b(FaceStatusNewEnum.DetectRemindCodeTimeout, null);
                        return;
                    }
                    a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
                }
            }
            this.r = j;
            if (!this.n.a()) {
            }
        }
        bDFaceImageInstance.destory();
    }

    private void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, bArr) == null) || p > 0) {
            return;
        }
        p++;
        new a(this, bArr).run();
    }

    private boolean a(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, faceStatusNewEnum, faceExtInfo)) == null) {
            if (faceStatusNewEnum != null) {
                this.o.a(this.m);
                boolean a2 = this.o.a(faceStatusNewEnum);
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

    private boolean a(BDFaceImageInstance bDFaceImageInstance, FaceExtInfo faceExtInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, this, bDFaceImageInstance, faceExtInfo, i)) == null) {
            float b = this.n.b();
            this.h.a(this.l);
            BDFaceImageInstance b2 = FaceSDKManager.getInstance().b(bDFaceImageInstance, faceExtInfo.getmLandmarks(), this.l.getCropHeight(), this.l.getCropWidth());
            if (b2 == null) {
                return false;
            }
            a(faceExtInfo, b2, i, b);
            b2.destory();
            b(faceExtInfo, bDFaceImageInstance, i, b);
            return true;
        }
        return invokeLLI.booleanValue;
    }

    private void b(FaceStatusNewEnum faceStatusNewEnum, FaceExtInfo faceExtInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, faceStatusNewEnum, faceExtInfo) == null) {
            if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
                com.baidu.pass.face.platform.a.a.a();
            }
            IDetectStrategyCallback iDetectStrategyCallback = this.e;
            if (iDetectStrategyCallback != null) {
                if (faceStatusNewEnum != FaceStatusNewEnum.OK) {
                    iDetectStrategyCallback.onDetectCompletion(faceStatusNewEnum, a(faceStatusNewEnum), null, null);
                    return;
                }
                this.j = true;
                this.k = true;
                com.baidu.pass.face.platform.a.a.a("etm", Long.valueOf(System.currentTimeMillis()));
                com.baidu.pass.face.platform.a.a.a("finish", 1);
                com.baidu.pass.face.platform.a.a.a();
                this.e.onDetectCompletion(faceStatusNewEnum, a(faceStatusNewEnum), this.t, this.u);
            }
        }
    }

    private void b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance, int i, float f) {
        ArrayList<ImageInfo> b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{faceExtInfo, bDFaceImageInstance, Integer.valueOf(i), Float.valueOf(f)}) == null) || (b = this.h.b(faceExtInfo, bDFaceImageInstance)) == null || b.size() <= 0) {
            return;
        }
        HashMap<String, ImageInfo> hashMap = this.u;
        hashMap.put("bestSrcDetectImage_" + i + "_" + f + "_" + System.currentTimeMillis(), b.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, bArr) == null) {
            try {
                BDFaceImageInstance bDFaceImageInstance = new BDFaceImageInstance(bArr, this.c.width(), this.c.height(), BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21, 360 - this.g, 1);
                FaceInfo[] a2 = FaceSDKManager.getInstance().a(bDFaceImageInstance);
                com.baidu.pass.face.platform.model.a a3 = a(a2, bDFaceImageInstance);
                if (this.f != null) {
                    this.f.getFaceInfoForSecurity(a2);
                }
                a(a3, bDFaceImageInstance);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, faceConfig) == null) {
            this.l = faceConfig;
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void detectStrategy(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            if (!this.i) {
                this.i = true;
                a(FaceStatusNewEnum.DetectRemindCodeNoFaceDetected, (FaceExtInfo) null);
            } else if (this.j) {
            } else {
                a(bArr);
            }
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = 0;
            com.baidu.pass.face.platform.a.b bVar = this.o;
            if (bVar != null) {
                bVar.a();
            }
            HashMap<String, ImageInfo> hashMap = this.t;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, ImageInfo> hashMap2 = this.u;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            this.i = false;
            this.j = false;
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setDetectStrategyConfig(Rect rect, Rect rect2, IDetectStrategyCallback iDetectStrategyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, rect, rect2, iDetectStrategyCallback) == null) {
            this.c = rect;
            this.d = rect2;
            this.e = iDetectStrategyCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setDetectStrategySoundEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setISecurityCallback(ISecurityCallback iSecurityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iSecurityCallback) == null) {
            this.f = iSecurityCallback;
        }
    }

    @Override // com.baidu.pass.face.platform.IDetectStrategy
    public void setPreviewDegree(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g = i;
        }
    }
}
