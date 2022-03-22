package com.baidu.searchbox.fluency.core;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class FrameRefreshMonitor$run$1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final FrameRefreshMonitor$run$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-813732912, "Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$run$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-813732912, "Lcom/baidu/searchbox/fluency/core/FrameRefreshMonitor$run$1;");
                return;
            }
        }
        INSTANCE = new FrameRefreshMonitor$run$1();
    }

    public FrameRefreshMonitor$run$1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FrameRefreshMonitor.INSTANCE.doQueueEnd(0);
            FrameRefreshMonitor frameRefreshMonitor = FrameRefreshMonitor.INSTANCE;
            i = FrameRefreshMonitor.CALLBACK_ANIMATION;
            frameRefreshMonitor.doQueueBegin(i);
        }
    }
}
