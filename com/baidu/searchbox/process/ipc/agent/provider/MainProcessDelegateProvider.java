package com.baidu.searchbox.process.ipc.agent.provider;

import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MainProcessDelegateProvider extends ProcessDelegateBaseProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final String PROVIDER_AUTHORITIES;
    public static final Uri PROVIDER_URI;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2106928330, "Lcom/baidu/searchbox/process/ipc/agent/provider/MainProcessDelegateProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2106928330, "Lcom/baidu/searchbox/process/ipc/agent/provider/MainProcessDelegateProvider;");
                return;
            }
        }
        PROVIDER_AUTHORITIES = AppRuntime.getAppContext().getPackageName() + ".SwanAppDelegateProvider";
        PROVIDER_URI = Uri.parse("content://" + PROVIDER_AUTHORITIES);
    }

    public MainProcessDelegateProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
