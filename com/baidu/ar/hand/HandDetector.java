package com.baidu.ar.hand;

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
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HandDetector extends com.baidu.ar.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HandDetector";
    public transient /* synthetic */ FieldHolder $fh;
    public int oU;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1960651754, "Lcom/baidu/ar/hand/HandDetector;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1960651754, "Lcom/baidu/ar/hand/HandDetector;");
        }
    }

    public HandDetector() {
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
        this.oU = 7;
        c.cd().a(this);
        PixelReadParams pixelReadParams = new PixelReadParams(PixelType.NV21);
        this.nk = pixelReadParams;
        pixelReadParams.setOutputWidth(640);
        this.nk.setOutputHeight(360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 != -90) {
                if (i2 != 90) {
                    if (i2 != 180) {
                        if (z) {
                            return 3;
                        }
                    } else if (!z) {
                        return 3;
                    }
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.ar.b.a.a
    public b a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) ? new b(this, this.oU) { // from class: com.baidu.ar.hand.HandDetector.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HandDetector qw;

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
                this.qw = this;
            }

            @Override // com.baidu.ar.b.b.b
            public int a(com.baidu.ar.mdl.a aVar) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, aVar)) == null) {
                    boolean z = aVar.f31475tv;
                    String[] strArr = aVar.tw;
                    return z ? ARMdlInterfaceJNI.initHandSkeletonFromAsset(strArr[0], strArr[1]) : ARMdlInterfaceJNI.initHandSkeleton(strArr[0], strArr[1]);
                }
                return invokeL2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "hand" : (String) invokeV.objValue;
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
        eVar.a(new l(getName(), true, 19));
    }

    @Override // com.baidu.ar.b.a.a, com.baidu.ar.d.j
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e eVar = this.mv;
            if (eVar != null) {
                eVar.b(new l(getName(), true, 19));
            }
            c.cd().b(this);
        }
    }

    @Override // com.baidu.ar.b.a.a
    public com.baidu.ar.b.b.a at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new com.baidu.ar.b.b.a(this, this.oU) { // from class: com.baidu.ar.hand.HandDetector.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HandDetector qw;

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
                this.qw = this;
            }

            @Override // com.baidu.ar.b.b.a
            public int ax() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? ARMdlInterfaceJNI.releaseHandSkeleton() : invokeV2.intValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "hand" : (String) invokeV2.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, framePixels)) == null) ? new com.baidu.ar.b.b.c(this, this.oU, framePixels, framePixels) { // from class: com.baidu.ar.hand.HandDetector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HandDetector qw;
            public final /* synthetic */ FramePixels qx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, framePixels);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r9), framePixels, framePixels};
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
                this.qw = this;
                this.qx = framePixels;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.ar.b.b.c
            /* renamed from: g */
            public a e(FramePixels framePixels2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, framePixels2)) == null) {
                    long timestamp = framePixels2.getTimestamp();
                    int d2 = this.qw.d(framePixels2.getOrientation().getDegree(), framePixels2.isFrontCamera());
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        long createHandle = this.qw.cb.createHandle();
                        this.qw.cb.setHandleInput(createHandle, 19, framePixels2.getTimestamp(), 0, framePixels2.getWidth(), framePixels2.getHeight(), framePixels2.isFrontCamera(), framePixels2.getSegOrientation().getValue(), false, framePixels2.getPixelsAddress());
                        ARMdlInterfaceJNI.predictHandSkeletonByHandle(createHandle, d2);
                        StatisticApi.getPerformanceApi().recordAlgoTimeCost("finger_gesture", "predict", SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                        return new a(this.qw.getName(), createHandle, timestamp);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return (a) invokeL2.objValue;
            }

            @Override // com.baidu.ar.c.a
            public String getTag() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "hand" : (String) invokeV.objValue;
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
