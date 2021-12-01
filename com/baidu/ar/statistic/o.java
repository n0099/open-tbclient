package com.baidu.ar.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
/* loaded from: classes8.dex */
public class o implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f wR;

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Constructor<?> a = com.baidu.ar.h.n.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", new Class[0]);
        if (a != null) {
            this.wR = (f) com.baidu.ar.h.n.a(a, new Object[0]);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.wR) == null) {
            return;
        }
        fVar.onFrameIn();
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.wR) == null) {
            return;
        }
        fVar.onFrameOut();
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j2, int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j2), Integer.valueOf(i2)}) == null) || (fVar = this.wR) == null) {
            return;
        }
        fVar.recordAlgoTimeCost(str, str2, j2, i2);
    }
}
