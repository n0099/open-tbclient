package com.baidu.ar.statistic.performance;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.h.f;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.f;
import com.baidu.ar.statistic.performance.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes10.dex */
public class PerformanceStatisticApi implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int xc;
    public boolean xd;
    public a xe;
    public a.C1782a xf;
    public f.a xg;

    public PerformanceStatisticApi() {
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
        this.xc = 0;
        this.xd = false;
        this.xe = new a();
        this.xg = new f.a();
    }

    private void gs() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.xf == null) {
            a.C1782a c1782a = new a.C1782a();
            this.xf = c1782a;
            int i2 = this.xc + 1;
            this.xc = i2;
            c1782a.xn = i2;
            this.xe.xm.add(c1782a);
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.xd) {
                    gs();
                    this.xf.xo = SystemClock.elapsedRealtime();
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void onFrameOut() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.xd) {
                    gs();
                    this.xf.xp = SystemClock.elapsedRealtime();
                    if (this.xc >= 3) {
                        this.xe.xj = this.xg.xj;
                        this.xe.xi = this.xg.xi;
                        this.xe.xk = this.xg.xk;
                        this.xe.xl = this.xg.xl;
                        this.xe.xh = ARConfig.getARKey();
                        StatisticApi.onPerformance("performance_summary", this.xe.gt());
                        this.xe.gu();
                        this.xc = 0;
                        this.xd = false;
                    }
                    this.xf = null;
                }
                if (!this.xd && StatisticApi.isAllowPerformanceEvent("performance_summary") && new Random().nextInt(20) == 1) {
                    this.xd = true;
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ar.statistic.f
    public void recordAlgoTimeCost(String str, String str2, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            try {
                if (this.xd) {
                    gs();
                    a.C1782a.C1783a c1783a = new a.C1782a.C1783a();
                    c1783a.name = str;
                    c1783a.xr = str2;
                    c1783a.xs = j2;
                    c1783a.count = i2;
                    this.xf.xq.add(c1783a);
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void switchCase(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            try {
                this.xe.xh = str;
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }
}
