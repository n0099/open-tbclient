package com.baidu.ar.stretch;

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
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class StretchDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "StretchDetector";
    public transient /* synthetic */ FieldHolder $fh;
    public int oU;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(688692714, "Lcom/baidu/ar/stretch/StretchDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(688692714, "Lcom/baidu/ar/stretch/StretchDetector;");
        }
    }

    public StretchDetector() {
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
        this.oU = -1;
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.BGR);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(640);
        this.nk.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
        if (r7 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0025, code lost:
        r1 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = 0;
            if (i2 != -90) {
                if (i2 != 0) {
                    if (i2 != 90) {
                        if (i2 != 180 || z) {
                            return 1;
                        }
                    }
                } else if (!z) {
                    return 1;
                }
                return 3;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) ? new b(this, this.oU) { // from class: com.baidu.ar.stretch.StretchDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StretchDetector xQ;

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
                this.xQ = this;
            }

            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    String[] strArr = aVar.tw;
                    if (strArr == null || strArr.length == 0) {
                        return -1;
                    }
                    return aVar.f4229tv ? ARMdlInterfaceJNI.initBodyKeyPointFromAssetDir(strArr[0]) : ARMdlInterfaceJNI.initBodyKeyPoint(strArr[0]);
                }
                return invokeL2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "stretch" : (String) invokeV.objValue;
            }
        } : (b) invokeL.objValue;
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            c.cd().b(this);
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.stretch.StretchDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StretchDetector xQ;

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
                this.xQ = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? ARMdlInterfaceJNI.releaseBodyKeyPoint() : invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "stretch" : (String) invokeV2.objValue;
            }
        } : (com.baidu.ar.b.b.a) invokeV.objValue;
    }

    @Override // com.baidu.ar.b.a.a
    public int au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.c d(FramePixels framePixels) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, framePixels)) == null) ? new com.baidu.ar.b.b.c(this, this.oU, framePixels) { // from class: com.baidu.ar.stretch.StretchDetector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StretchDetector xQ;

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
                this.xQ = this;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "stretch" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: l */
            public a e(FramePixels framePixels2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, framePixels2)) == null) {
                    int i2 = this.xQ.i(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                    a aVar = new a();
                    aVar.setTimestamp(framePixels2.getTimestamp());
                    aVar.W(this.xQ.getName());
                    float[] fArr = new float[54];
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    ARMdlInterfaceJNI.predictBodyKeyPoint(framePixels2.getPixelsAddress(), framePixels2.getWidth(), framePixels2.getHeight(), i2, fArr);
                    StatisticApi.getPerformanceApi().recordAlgoTimeCost("body_beauty", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                    aVar.o(fArr);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @CallBack
    public void onMdlResult(a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || (eVar = this.mv) == null) {
            return;
        }
        eVar.a(aVar);
    }
}
