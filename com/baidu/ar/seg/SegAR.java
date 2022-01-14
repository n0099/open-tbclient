package com.baidu.ar.seg;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.j;
import com.baidu.ar.arrender.l;
import com.baidu.ar.arrender.o;
import com.baidu.ar.c;
import com.baidu.ar.d.e;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
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
/* loaded from: classes10.dex */
public class SegAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SegAR";
    public static final float[] vo;
    public static final float[] vp;
    public static final float[] vq;
    public static final float[] vr;
    public static final float[] vs;
    public static final float[] vt;
    public static final float[] vu;
    public static final float[] vv;
    public transient /* synthetic */ FieldHolder $fh;
    public String bD;
    public AlgoHandleController cb;
    public LuaMsgListener cc;

    /* renamed from: io  reason: collision with root package name */
    public byte[] f32839io;
    public e mv;
    public int oU;
    public boolean pH;
    public SegDetector uY;
    public boolean uZ;
    public String va;
    public int vb;
    public Vector4f vc;
    public float vd;
    public float ve;
    public int vf;
    public float vg;
    public float vh;
    public float vi;
    public float vj;
    public float vk;
    public float vl;
    public float vm;
    public float vn;
    public int vw;
    public int vx;
    public long vy;
    public int vz;

    /* renamed from: com.baidu.ar.seg.SegAR$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] vB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1675521680, "Lcom/baidu/ar/seg/SegAR$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1675521680, "Lcom/baidu/ar/seg/SegAR$3;");
                    return;
                }
            }
            int[] iArr = new int[PixelRotation.values().length];
            vB = iArr;
            try {
                iArr[PixelRotation.RotateRight.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                vB[PixelRotation.RotateLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                vB[PixelRotation.FlipVertical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                vB[PixelRotation.FlipHorizontal.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                vB[PixelRotation.RotateRightFlipVertical.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                vB[PixelRotation.RotateRightFlipHorizontal.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                vB[PixelRotation.Rotate180.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                vB[PixelRotation.NoRotation.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(530099487, "Lcom/baidu/ar/seg/SegAR;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(530099487, "Lcom/baidu/ar/seg/SegAR;");
                return;
            }
        }
        vo = new float[]{0.0f, -1.0f, 1.0f, 0.0f};
        vp = new float[]{0.0f, 1.0f, -1.0f, 0.0f};
        vq = new float[]{1.0f, 0.0f, 0.0f, -1.0f};
        vr = new float[]{-1.0f, 0.0f, 0.0f, 1.0f};
        vs = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        vt = new float[]{0.0f, -1.0f, -1.0f, 0.0f};
        vu = new float[]{-1.0f, 0.0f, 0.0f, -1.0f};
        vv = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
    }

    public SegAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.oU = 2;
        this.bD = "ability_image_segmentation";
        this.uZ = true;
        this.pH = true;
        this.vb = 0;
        this.vc = new Vector4f();
        this.vd = 0.0f;
        this.ve = 0.0f;
        this.vf = 0;
        this.vg = 0.0f;
        this.vh = 0.0f;
        this.vi = 0.0f;
        this.vj = 0.0f;
        this.vk = 0.0f;
        this.vl = 0.0f;
        this.vm = 0.0f;
        this.vn = 1.0f;
        this.vw = 0;
        this.vx = 0;
        this.f32839io = null;
        this.vy = 0L;
        this.cb = null;
        this.vz = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, aVar)) == null) {
            int i2 = this.oU;
            if (i2 != 4) {
                if (i2 == 2) {
                    getImgSegOrientation(aVar.getOrientation());
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("u_maskRotate", this.vc);
                    return hashMap;
                } else if (i2 == 5) {
                    getSkySegOrientation(aVar.getOrientation());
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put("u_maskRotate", this.vc);
                    return hashMap2;
                } else {
                    return null;
                }
            }
            getHairSegOrientation(aVar.getOrientation());
            b(aVar.gc(), aVar.getWidth(), aVar.getHeight());
            HashMap<String, Object> hashMap3 = new HashMap<>();
            hashMap3.put("enableSeq", Float.valueOf(1.0f));
            hashMap3.put("cameraFront", Integer.valueOf(this.pH ? 1 : 0));
            hashMap3.put("deviceOrientation", Integer.valueOf(this.vb));
            hashMap3.put("u_maskRotate", this.vc);
            hashMap3.put("hairBlendType", Integer.valueOf(this.vf));
            hashMap3.put("hairThreshold", Float.valueOf(this.vd));
            hashMap3.put("hairBlendAlpha", Float.valueOf(this.ve));
            hashMap3.put("hairTopPos", Float.valueOf(this.vm));
            hashMap3.put("hairBottomPos", Float.valueOf(this.vn));
            hashMap3.put("hairTop", new Vector4f(this.vj, this.vk, this.vl, 1.0f));
            hashMap3.put("hairBottom", new Vector4f(this.vg, this.vh, this.vi, 1.0f));
            return hashMap3;
        }
        return (HashMap) invokeL.objValue;
    }

    private void a(PixelRotation pixelRotation) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, pixelRotation) == null) {
            switch (AnonymousClass3.vB[pixelRotation.ordinal()]) {
                case 1:
                    fArr = vo;
                    break;
                case 2:
                    fArr = vp;
                    break;
                case 3:
                    fArr = vq;
                    break;
                case 4:
                    fArr = vr;
                    break;
                case 5:
                    fArr = vs;
                    break;
                case 6:
                    fArr = vt;
                    break;
                case 7:
                    fArr = vu;
                    break;
                default:
                    fArr = vv;
                    break;
            }
            this.vc.setXYZW(fArr[0], fArr[1], fArr[2], fArr[3]);
        }
    }

    private void al() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.cc == null) {
                this.cc = new LuaMsgListener(this) { // from class: com.baidu.ar.seg.SegAR.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SegAR vA;

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
                        this.vA = this;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public List<String> getMsgKeyListened() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("event_name");
                            return arrayList;
                        }
                        return (List) invokeV.objValue;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public void onLuaMessage(HashMap<String, Object> hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) && "adjust_hair_segmentation".equals((String) hashMap.get("event_name"))) {
                            this.vA.m(hashMap);
                        }
                    }
                };
            }
            a(this.cc);
        }
    }

    private void b(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65551, this, j2) == null) || (algoHandleController = this.cb) == null || j2 <= 0) {
            return;
        }
        long handleType = algoHandleController.getHandleType(j2);
        SegDetector segDetector = this.uY;
        if (segDetector == null || handleType != this.vz) {
            return;
        }
        segDetector.b(j2);
    }

    private void b(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65553, this, bArr, i2, i3) == null) || bArr == null || i2 <= 0 || i3 <= 0 || bArr.length < i2 * i3) {
            return;
        }
        this.vm = c(bArr, i2, i3);
        this.vn = d(bArr, i2, i3);
        int i4 = this.vb;
        if (i4 == 1 || i4 == 3) {
            float f2 = i3;
            this.vm -= 16.0f / f2;
            this.vn += 12.0f / f2;
        }
    }

    private float c(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65555, this, bArr, i2, i3)) == null) {
            int i4 = 0;
            while (i4 < i3) {
                for (int i5 = 0; i5 < i2; i5++) {
                    if ((bArr[(i4 * i2) + i5] & 255) > ((int) (this.vd * 255.0f))) {
                        return (i4 >= 3 ? i4 - 3 : 0) / i3;
                    }
                }
                i4 += 3;
            }
            return 0.0f;
        }
        return invokeLII.floatValue;
    }

    private float d(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65557, this, bArr, i2, i3)) == null) {
            int i4 = i3 - 1;
            for (int i5 = i4; i5 > 0; i5 -= 3) {
                for (int i6 = 0; i6 < i2; i6++) {
                    if ((bArr[(i5 * i2) + i6] & 255) > ((int) (this.vd * 255.0f))) {
                        int i7 = i5 + 3;
                        if (i7 <= i4) {
                            i4 = i7;
                        }
                        return i4 / i3;
                    }
                }
            }
            return 1.0f;
        }
        return invokeLII.floatValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(HashMap<String, Object> hashMap) {
        String str;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, hashMap) == null) {
            if (com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1) == 5011) {
                StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                this.oU = 2;
                this.vz = 11;
                this.bD = "ability_image_segmentation";
                String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                this.va = a;
                return;
            }
            String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("event_name"), (String) null);
            if (a2 == null) {
                return;
            }
            if (a2.equals("start_hair_segmentation")) {
                StatisticApi.onEvent(StatisticConstants.MDL_HAIR_SEG_OPEN);
                m(hashMap);
                this.oU = 4;
                str = "ability_hair_segmentation";
            } else if (!a2.equals("start_sky_segmentation")) {
                if (a2.equals("start_image_segmentation")) {
                    StatisticApi.onEvent(StatisticConstants.MDL_IMG_SEG_OPEN);
                    String a3 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                    if (!TextUtils.isEmpty(a3)) {
                        this.va = a3;
                    }
                    this.oU = 2;
                    this.bD = "ability_image_segmentation";
                } else {
                    this.oU = -10;
                }
                i2 = this.oU;
                if (i2 != 4) {
                    i3 = 13;
                } else if (i2 != 5) {
                    this.vz = 11;
                    return;
                } else {
                    i3 = 12;
                }
                this.vz = i3;
            } else {
                StatisticApi.onEvent(StatisticConstants.MDL_SKY_SEG_OPEN);
                String a4 = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
                if (!TextUtils.isEmpty(a4)) {
                    this.va = a4;
                }
                this.oU = 5;
                str = "ability_sky_segmentation";
            }
            this.bD = str;
            i2 = this.oU;
            if (i2 != 4) {
            }
            this.vz = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, hashMap) == null) {
            String a = com.baidu.ar.arplay.c.c.a(hashMap.get("node_name"), "");
            this.vd = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_threshold"), 0.0f);
            this.ve = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_alpha"), 0.0f);
            this.vf = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_blend_type"), 0);
            this.vg = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_r"), 0.0f);
            this.vh = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_g"), 0.0f);
            this.vi = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_bottom_color_b"), 0.0f);
            this.vj = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_r"), 0.0f);
            this.vk = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_g"), 0.0f);
            this.vl = com.baidu.ar.arplay.c.c.a(hashMap.get("hair_top_color_b"), 0.0f);
            if (!TextUtils.isEmpty(a)) {
                this.va = a;
            }
            SegDetector segDetector = this.uY;
            if (segDetector != null) {
                segDetector.f(this.vd);
            }
        }
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j2) != this.vz) {
                return;
            }
            b(j2);
        }
    }

    public void getHairSegOrientation(int i2) {
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 90) {
                    this.vb = this.pH ? 2 : 0;
                    pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
                } else if (i2 != 180) {
                    this.vb = this.pH ? 0 : 2;
                    pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
                } else {
                    this.vb = 3;
                    pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
                }
            } else {
                this.vb = 1;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
            }
            a(pixelRotation);
        }
    }

    public void getImgSegOrientation(int i2) {
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    this.vb = this.pH ? 2 : 0;
                    pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
                } else if (i2 != 2) {
                    this.vb = this.pH ? 0 : 2;
                    pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
                } else {
                    this.vb = this.pH ? 3 : 1;
                    pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
                }
            } else {
                this.vb = this.pH ? 1 : 3;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
            }
            a(pixelRotation);
        }
    }

    public void getSkySegOrientation(int i2) {
        PixelRotation pixelRotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    this.vb = this.pH ? 2 : 0;
                    pixelRotation = this.pH ? PixelRotation.FlipVertical : PixelRotation.NoRotation;
                } else if (i2 != 2) {
                    this.vb = this.pH ? 0 : 2;
                    pixelRotation = this.pH ? PixelRotation.FlipHorizontal : PixelRotation.Rotate180;
                } else {
                    this.vb = this.pH ? 3 : 1;
                    pixelRotation = this.pH ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
                }
            } else {
                this.vb = this.pH ? 1 : 3;
                pixelRotation = this.pH ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
            }
            a(pixelRotation);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b(false);
            com.baidu.ar.h.b.k(TAG, "enableSyncRender false");
            SegDetector segDetector = this.uY;
            if (segDetector != null) {
                segDetector.y(false);
            }
            b(this.cc);
            SegDetector segDetector2 = this.uY;
            if (segDetector2 != null) {
                segDetector2.a((AlgoHandleController) null);
                this.uY.av();
                a(this.uY);
            }
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            l r = r();
            if (r != null) {
                r.q(this.vz);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            super.setup(hashMap);
            String str = TAG;
            com.baidu.ar.h.b.k(str, "setup(luaParams):" + hashMap.toString());
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            l(hashMap);
            if (this.oU < -1) {
                String str2 = TAG;
                com.baidu.ar.h.b.b(str2, "无法解析能力类型 mMdlType:" + this.oU);
                return;
            }
            SegDetector segDetector = new SegDetector(this.oU);
            this.uY = segDetector;
            segDetector.a(this.cb);
            this.mv = new e(this) { // from class: com.baidu.ar.seg.SegAR.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SegAR vA;

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
                    this.vA = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) && (bVar instanceof b)) {
                        b bVar2 = (b) bVar;
                        if (bVar2.gd() != null) {
                            if (this.vA.uZ) {
                                this.vA.uZ = false;
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("event_name", "first_bgseg_detect");
                                this.vA.d(hashMap2);
                            }
                            l r = this.vA.r();
                            long de = bVar.de();
                            if (de > 0 && r != null) {
                                r.a(de, this.vA.bD);
                                this.vA.a(de);
                            }
                            a gd = bVar2.gd();
                            if (gd != null) {
                                this.vA.pH = gd.isFrontCamera();
                                int width = gd.getWidth();
                                int height = gd.getHeight();
                                if (gd.getOrientation() == 0 || gd.getOrientation() == 180 || gd.getOrientation() == 2) {
                                    gd.setWidth(height);
                                    gd.setHeight(width);
                                }
                                if (r != null) {
                                    this.vA.vw = gd.getWidth();
                                    this.vA.vx = gd.getHeight();
                                    this.vA.f32839io = gd.gc();
                                    this.vA.vy = bVar.getTimestamp();
                                    if (this.vA.vw <= 0 || this.vA.vx <= 0 || this.vA.f32839io == null) {
                                        return;
                                    }
                                    j jVar = new j();
                                    jVar.r(this.vA.bD);
                                    jVar.P(this.vA.va);
                                    jVar.h(this.vA.a(gd));
                                    r.a(jVar);
                                    if (bVar.dd() instanceof o) {
                                        r.a((o) bVar.dd(), true);
                                    }
                                }
                            }
                        }
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    String str3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        String str4 = SegAR.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("SegDetector onSetup result:");
                        if (lVar != null) {
                            str3 = lVar.dc() + "," + lVar.dk();
                        } else {
                            str3 = null;
                        }
                        sb.append(str3);
                        com.baidu.ar.h.b.k(str4, sb.toString());
                        l r = this.vA.r();
                        if (r == null || this.vA.uY == null || lVar == null) {
                            return;
                        }
                        r.b(lVar.dk(), this.vA.uY.dj());
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        String str3 = SegAR.TAG;
                        com.baidu.ar.h.b.k(str3, "SegDetector onRelease aogoTyope = " + lVar.dk());
                    }
                }
            };
            b(true);
            com.baidu.ar.h.b.k(TAG, "enableSyncRender true");
            SegDetector segDetector2 = this.uY;
            if (segDetector2 != null) {
                segDetector2.y(true);
            }
            a(this.uY, this.mv);
            com.baidu.ar.b.a.as().a(getContext(), getMdlConfigs());
            SegDetector segDetector3 = this.uY;
            if (segDetector3 != null) {
                segDetector3.b((Bundle) null);
            }
            al();
        }
    }
}
