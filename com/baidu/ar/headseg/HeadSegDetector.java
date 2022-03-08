package com.baidu.ar.headseg;

import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.b.b.b;
import com.baidu.ar.bus.CallBack;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
/* loaded from: classes3.dex */
public class HeadSegDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HeadSegDetector";
    public transient /* synthetic */ FieldHolder $fh;
    public int oU;
    public int qB;
    public int qC;
    public float qD;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1140238122, "Lcom/baidu/ar/headseg/HeadSegDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1140238122, "Lcom/baidu/ar/headseg/HeadSegDetector;");
        }
    }

    public HeadSegDetector() {
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
        this.qB = 256;
        this.qC = Cea708Decoder.COMMAND_SPA;
        this.oU = 8;
        this.qD = 0.5f;
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(this.qB);
        this.nk.setOutputHeight(this.qC);
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) ? new b(this, this.oU) { // from class: com.baidu.ar.headseg.HeadSegDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeadSegDetector qE;

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
                this.qE = this;
            }

            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    String str = aVar.tw[0];
                    return aVar.f31475tv ? ARMdlInterfaceJNI.initHeadSegFromAsset(str) : ARMdlInterfaceJNI.initHeadSeg(str);
                }
                return invokeL2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "headseg" : (String) invokeV.objValue;
            }
        } : (b) invokeL.objValue;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void ao() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(new l(getName(), true, 22));
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = this.mv;
            if (eVar != null) {
                eVar.b(new l(getName(), true, 22));
            }
            c.cd().b(this);
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.headseg.HeadSegDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeadSegDetector qE;

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
                this.qE = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? ARMdlInterfaceJNI.releaseHeadSeg() : invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "headseg" : (String) invokeV2.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, framePixels)) == null) ? new com.baidu.ar.b.b.c(this, this.oU, framePixels) { // from class: com.baidu.ar.headseg.HeadSegDetector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HeadSegDetector qE;

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
                this.qE = this;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "headseg" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: h */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a e(FramePixels framePixels2) {
                InterceptResult invokeL2;
                long j2;
                long j3;
                long j4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, framePixels2)) == null) {
                    a aVar = new a();
                    aVar.setTimestamp(framePixels2.getTimestamp());
                    aVar.W(this.qE.getName());
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        j3 = this.qE.cb.createHandle();
                        try {
                            this.qE.cb.setUsingHandle(j3);
                            j4 = j3;
                            try {
                                this.qE.cb.setHandleInput(j3, 22, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.isFrontCamera() ? 4 : 7, true, framePixels2.getPixelsAddress());
                                this.qE.cb.setHandleMaskThreshold(j4, this.qE.qD);
                                ARMdlInterfaceJNI.predictHeadSeg(j4, true);
                                StatisticApi.getPerformanceApi().recordAlgoTimeCost("head_seg", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                            } catch (Exception unused) {
                                j3 = j4;
                                j2 = 0;
                                if (j3 > j2) {
                                    AlgoHandleAdapter.destroyHandle(j3);
                                }
                                j4 = j2;
                                aVar.n(j4);
                                return aVar;
                            }
                            try {
                                this.qE.cb.setUsingHandle(0L);
                            } catch (Exception unused2) {
                                j3 = j4;
                                j2 = 0;
                                if (j3 > j2) {
                                }
                                j4 = j2;
                                aVar.n(j4);
                                return aVar;
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (Exception unused4) {
                        j2 = 0;
                        j3 = 0;
                    }
                    aVar.n(j4);
                    return aVar;
                }
                return (a) invokeL2.objValue;
            }
        } : (com.baidu.ar.b.b.c) invokeL.objValue;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @CallBack
    public void onMdlResult(a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(aVar);
    }
}
