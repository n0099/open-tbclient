package com.baidu.ar.seg;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.arrender.o;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class SegDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SegDetector";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsFrontCamera;
    public boolean oK;
    public int oU;
    public boolean oz;
    public float qD;
    public int vC;
    public int vD;
    public int vE;
    public int vF;
    public int vG;
    public int vH;
    public int vI;
    public int vJ;
    public int vK;
    public int vL;
    public int vM;
    public int vN;
    public int vO;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-145890230, "Lcom/baidu/ar/seg/SegDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-145890230, "Lcom/baidu/ar/seg/SegDetector;");
        }
    }

    public SegDetector(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.vC = 192;
        this.vD = 192;
        this.vE = 192;
        this.vF = 192;
        this.vG = 256;
        this.vH = Cea708Decoder.COMMAND_SPA;
        this.vI = 128;
        this.vJ = 224;
        this.vK = 192;
        this.vL = 192;
        this.vM = 160;
        this.vN = 160;
        this.oU = 2;
        this.qD = 0.0f;
        this.oz = true;
        this.oK = true;
        c.cd().a(this);
        this.oU = i2;
        this.nk = new PixelReadParams(PixelType.BGR);
        fY();
    }

    private int dk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int i2 = this.oU;
            if (i2 != 4) {
                return i2 != 5 ? 11 : 12;
            }
            return 13;
        }
        return invokeV.intValue;
    }

    private void fY() {
        PixelReadParams pixelReadParams;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            int i3 = this.oU;
            if (i3 == 4) {
                this.nk.setPixelType(PixelType.NV21);
                this.nk.setOutputWidth(this.vG);
                pixelReadParams = this.nk;
                i2 = this.vH;
            } else if (i3 != 5) {
                this.nk.setPixelType(PixelType.BGR);
                this.nk.setOutputWidth(this.vC);
                pixelReadParams = this.nk;
                i2 = this.vD;
            } else {
                this.nk.setPixelType(PixelType.NV21);
                this.nk.setOutputWidth(this.vK);
                pixelReadParams = this.nk;
                i2 = this.vL;
            }
            pixelReadParams.setOutputHeight(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int i2 = this.vO;
            if (i2 != -90) {
                if (i2 != 90) {
                    if (i2 != 180) {
                        if (this.mIsFrontCamera) {
                            return 3;
                        }
                    } else if (!this.mIsFrontCamera) {
                        return 3;
                    }
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ga() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i2 = this.vO;
            if (i2 != -90) {
                if (i2 != 90) {
                    if (i2 != 180) {
                        if (this.mIsFrontCamera) {
                            return 3;
                        }
                    } else if (!this.mIsFrontCamera) {
                        return 3;
                    }
                    return 1;
                } else if (!this.mIsFrontCamera) {
                    return 2;
                }
            } else if (this.mIsFrontCamera) {
                return 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            int i2 = this.vO;
            if (i2 != -90) {
                if (i2 != 90) {
                    return (i2 == 180 ? !this.mIsFrontCamera : this.mIsFrontCamera) ? 270 : 90;
                }
                return 180;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) ? new com.baidu.ar.b.b.b(this, this.oU) { // from class: com.baidu.ar.seg.SegDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SegDetector vP;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.vP = this;
            }

            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    String str = aVar.tw[0];
                    int i2 = this.vP.oU;
                    if (i2 == 2) {
                        int[] iArr = new int[2];
                        return aVar.f31475tv ? ARMdlInterfaceJNI.initHumanSegFromAssetDir(str, 1, iArr) : ARMdlInterfaceJNI.initHumanSeg(str, 1, iArr);
                    } else if (i2 == 4) {
                        return aVar.f31475tv ? ARMdlInterfaceJNI.initHairSegFromAssetDir(str) : ARMdlInterfaceJNI.initHairSeg(str);
                    } else if (i2 != 5) {
                        return -1;
                    } else {
                        return aVar.f31475tv ? ARMdlInterfaceJNI.initSkySegFromAssetDir(str) : ARMdlInterfaceJNI.initSkySeg(str);
                    }
                }
                return invokeL2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "seg" : (String) invokeV.objValue;
            }
        } : (com.baidu.ar.b.b.b) invokeL.objValue;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(new l(getName(), true, dk()));
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = this.mv;
            if (eVar != null) {
                eVar.b(new l(getName(), true, dk()));
            }
            c.cd().b(this);
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.seg.SegDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SegDetector vP;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.vP = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                    int i2 = this.vP.oU;
                    if (i2 == 2) {
                        ARMdlInterfaceJNI.releaseHumanSeg();
                        return 0;
                    } else if (i2 == 4) {
                        ARMdlInterfaceJNI.releaseHairSeg();
                        return 0;
                    } else if (i2 != 5) {
                        return 0;
                    } else {
                        ARMdlInterfaceJNI.releaseSkySeg();
                        return 0;
                    }
                }
                return invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "seg" : (String) invokeV2.objValue;
            }
        } : (com.baidu.ar.b.b.a) invokeV.objValue;
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.oU : invokeV.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, framePixels)) == null) ? new com.baidu.ar.b.b.c(this, this.oU, framePixels) { // from class: com.baidu.ar.seg.SegDetector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SegDetector vP;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, framePixels);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r9), framePixels};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super(((Integer) objArr2[0]).intValue(), (FramePixels) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.vP = this;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "seg" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Not initialized variable reg: 10, insn: 0x0207: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:37:0x0206 */
            /* JADX WARN: Not initialized variable reg: 23, insn: 0x0212: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:42:0x0211 */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: k */
            public b e(FramePixels framePixels2) {
                InterceptResult invokeL2;
                byte[] bArr;
                Exception exc;
                byte[] bArr2;
                byte[] bArr3;
                byte[] bArr4;
                int i2;
                int i3;
                int i4;
                Exception exc2;
                byte[] bArr5;
                byte[] bArr6;
                byte[] bArr7;
                int i5;
                int i6;
                int gb;
                byte[] bArr8;
                byte[] bArr9;
                f performanceApi;
                long elapsedRealtime;
                int i7;
                String str;
                byte[] bArr10;
                byte[] bArr11;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, framePixels2)) == null) {
                    b bVar = new b();
                    ByteBuffer pixelsAddress = framePixels2.getPixelsAddress();
                    int width = framePixels2.getWidth();
                    int height = framePixels2.getHeight();
                    long timestamp = framePixels2.getTimestamp();
                    boolean isFrontCamera = framePixels2.isFrontCamera();
                    int degree = framePixels2.getOrientation().getDegree();
                    int value = framePixels2.getSegOrientation().getValue();
                    bVar.setTimestamp(timestamp);
                    SegDetector segDetector = this.vP;
                    segDetector.mIsFrontCamera = isFrontCamera;
                    segDetector.vO = degree;
                    int i8 = segDetector.oU;
                    if (i8 != 2) {
                        try {
                            try {
                                if (i8 == 4) {
                                    byte[] bArr12 = new byte[this.vP.vI * this.vP.vJ];
                                    i5 = this.vP.vI;
                                    i6 = this.vP.vJ;
                                    gb = this.vP.gb();
                                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                    if (this.vP.oK) {
                                        bArr8 = bArr12;
                                        if (this.vP.cb != null) {
                                            long createHandle = this.vP.cb.createHandle();
                                            this.vP.cb.setHandleInput(createHandle, 13, timestamp, 0, width, height, isFrontCamera, value, this.vP.oz, pixelsAddress);
                                            this.vP.cb.setUsingHandle(createHandle);
                                            this.vP.cb.setHandleMaskThreshold(createHandle, this.vP.qD);
                                            ARMdlInterfaceJNI.predictHairSeg(null, width, height, this.vP.vI, this.vP.vJ, 1, gb, false, null, createHandle);
                                            if (this.vP.cb != null) {
                                                this.vP.cb.setUsingHandle(0L);
                                                bArr9 = this.vP.cb.getHandleMaskData(createHandle);
                                                bVar.n(createHandle);
                                            } else {
                                                AlgoHandleAdapter.destroyHandle(createHandle);
                                                bArr9 = bArr8;
                                            }
                                            bArr6 = bArr9;
                                            performanceApi = StatisticApi.getPerformanceApi();
                                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                            i7 = 0;
                                            str = "hair_seg";
                                        }
                                    } else {
                                        bArr8 = bArr12;
                                        ARMdlInterfaceJNI.predictHairSeg(pixelsAddress, width, height, this.vP.vI, this.vP.vJ, 1, gb, false, bArr8, 0L);
                                    }
                                    bArr6 = bArr8;
                                    performanceApi = StatisticApi.getPerformanceApi();
                                    elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                    i7 = 0;
                                    str = "hair_seg";
                                } else if (i8 != 5) {
                                    bArr4 = null;
                                    i4 = degree;
                                    i2 = 0;
                                    i3 = 0;
                                } else {
                                    byte[] bArr13 = new byte[this.vP.vM * this.vP.vN];
                                    i5 = this.vP.vM;
                                    i6 = this.vP.vN;
                                    gb = this.vP.ga();
                                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                    if (this.vP.oK) {
                                        bArr10 = bArr13;
                                        if (this.vP.cb != null) {
                                            long createHandle2 = this.vP.cb.createHandle();
                                            this.vP.cb.setHandleInput(createHandle2, 12, timestamp, 0, width, height, isFrontCamera, value, this.vP.oz, pixelsAddress);
                                            this.vP.cb.setUsingHandle(createHandle2);
                                            ARMdlInterfaceJNI.predictSkySeg(null, width, height, this.vP.vM, this.vP.vN, 1, gb, false, null, createHandle2);
                                            if (this.vP.cb != null) {
                                                this.vP.cb.setUsingHandle(0L);
                                                bArr11 = this.vP.cb.getHandleMaskData(createHandle2);
                                                bVar.n(createHandle2);
                                            } else {
                                                AlgoHandleAdapter.destroyHandle(createHandle2);
                                                bArr11 = bArr10;
                                            }
                                            bArr6 = bArr11;
                                            performanceApi = StatisticApi.getPerformanceApi();
                                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                            i7 = 0;
                                            str = "sky_seg";
                                        }
                                    } else {
                                        bArr10 = bArr13;
                                        ARMdlInterfaceJNI.predictSkySeg(pixelsAddress, width, height, this.vP.vM, this.vP.vN, 1, gb, false, bArr10, 0L);
                                    }
                                    bArr6 = bArr10;
                                    performanceApi = StatisticApi.getPerformanceApi();
                                    elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                    i7 = 0;
                                    str = "sky_seg";
                                }
                                performanceApi.recordAlgoTimeCost(str, "predict", elapsedRealtime, i7);
                            } catch (Exception e2) {
                                exc2 = e2;
                                bArr6 = bArr7;
                                exc2.printStackTrace();
                                bArr4 = bArr6;
                                i2 = i5;
                                i3 = i6;
                                i4 = gb;
                                bVar.b(new a(bArr4, i2, i3, i4, framePixels2.isFrontCamera()));
                                bVar.W(this.vP.getName());
                                return bVar;
                            }
                        } catch (Exception e3) {
                            exc2 = e3;
                            bArr6 = bArr5;
                            exc2.printStackTrace();
                            bArr4 = bArr6;
                            i2 = i5;
                            i3 = i6;
                            i4 = gb;
                            bVar.b(new a(bArr4, i2, i3, i4, framePixels2.isFrontCamera()));
                            bVar.W(this.vP.getName());
                            return bVar;
                        }
                        bArr4 = bArr6;
                        i2 = i5;
                        i3 = i6;
                        i4 = gb;
                    } else {
                        int[] iArr = new int[2];
                        byte[] bArr14 = new byte[this.vP.vE * this.vP.vF];
                        int i9 = this.vP.vE;
                        int i10 = this.vP.vF;
                        int fZ = this.vP.fZ();
                        long elapsedRealtime4 = SystemClock.elapsedRealtime();
                        if (this.vP.oK) {
                            bArr = bArr14;
                            if (this.vP.cb != null) {
                                try {
                                    long createHandle3 = this.vP.cb.createHandle();
                                    this.vP.cb.setHandleInput(createHandle3, 11, timestamp, 2, width, height, isFrontCamera, value, this.vP.oz, pixelsAddress);
                                    this.vP.cb.setUsingHandle(createHandle3);
                                    ARMdlInterfaceJNI.predictHumanSeg(null, width, height, fZ, isFrontCamera, null, iArr, createHandle3);
                                    if (this.vP.cb != null) {
                                        this.vP.cb.setUsingHandle(0L);
                                        ReserveHandleData reserveHandleData = new ReserveHandleData();
                                        this.vP.cb.getHandleReserveData(createHandle3, reserveHandleData);
                                        bArr3 = (reserveHandleData.getByteArrayListData() == null || reserveHandleData.getByteArrayListData().size() <= 0) ? bArr : reserveHandleData.getByteArrayListData().get(0);
                                        try {
                                            bVar.n(createHandle3);
                                        } catch (Exception e4) {
                                            exc = e4;
                                            bArr2 = bArr3;
                                            exc.printStackTrace();
                                            bArr4 = bArr2;
                                            i2 = i9;
                                            i3 = i10;
                                            i4 = fZ;
                                            bVar.b(new a(bArr4, i2, i3, i4, framePixels2.isFrontCamera()));
                                            bVar.W(this.vP.getName());
                                            return bVar;
                                        }
                                    } else {
                                        AlgoHandleAdapter.destroyHandle(createHandle3);
                                        bArr3 = bArr;
                                    }
                                    bArr2 = bArr3;
                                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime4, 0);
                                } catch (Exception e5) {
                                    exc = e5;
                                    bArr2 = bArr;
                                }
                                bArr4 = bArr2;
                                i2 = i9;
                                i3 = i10;
                                i4 = fZ;
                            }
                        } else {
                            bArr = bArr14;
                            ARMdlInterfaceJNI.predictHumanSeg(pixelsAddress, width, height, fZ, isFrontCamera, bArr, iArr, 0L);
                        }
                        bArr2 = bArr;
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("bg_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime4, 0);
                        bArr4 = bArr2;
                        i2 = i9;
                        i3 = i10;
                        i4 = fZ;
                    }
                    bVar.b(new a(bArr4, i2, i3, i4, framePixels2.isFrontCamera()));
                    bVar.W(this.vP.getName());
                    return bVar;
                }
                return (b) invokeL2.objValue;
            }
        } : (com.baidu.ar.b.b.c) invokeL.objValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.qD = f2;
        }
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @CallBack
    public void onMdlResult(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            int width = bVar.gd().getWidth();
            int height = bVar.gd().getHeight();
            byte[] gc = bVar.gd().gc();
            int orientation = bVar.gd().getOrientation();
            if (width > 0 && height > 0 && gc != null && gc.length > 0) {
                int i2 = this.oU;
                String str = i2 != 4 ? i2 != 5 ? "ability_image_segmentation" : "ability_sky_segmentation" : "ability_hair_segmentation";
                if (orientation == 0 || orientation == 180 || orientation == 2) {
                    height = width;
                    width = height;
                }
                o oVar = new o();
                oVar.r(str);
                oVar.setWidth(width);
                oVar.setHeight(height);
                oVar.a(gc);
                bVar.g(oVar);
            }
            e eVar = this.mv;
            if (eVar != null) {
                eVar.a(bVar);
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.oz = z;
        }
    }
}
