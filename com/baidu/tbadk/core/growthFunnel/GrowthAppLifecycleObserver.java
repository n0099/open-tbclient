package com.baidu.tbadk.core.growthFunnel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.g85;
import com.baidu.tieba.k85;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GrowthAppLifecycleObserver implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static long b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1870252624, "Lcom/baidu/tbadk/core/growthFunnel/GrowthAppLifecycleObserver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1870252624, "Lcom/baidu/tbadk/core/growthFunnel/GrowthAppLifecycleObserver;");
        }
    }

    public GrowthAppLifecycleObserver() {
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

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g85.o();
            g85.r(null, true);
            k85.a().j(true);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g85.r(null, true);
            b = System.currentTimeMillis();
            g85.b = false;
            k85.a().j(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            if (a) {
                a = false;
                g85.k("lifecycle-1st-create", false);
                g85.v();
                return;
            }
            g85.b = true;
            long currentTimeMillis = System.currentTimeMillis() - b;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = -1;
            }
            g85.j(currentTimeMillis);
            g85.k("lifecycle", true);
            g85.v();
        }
    }
}
