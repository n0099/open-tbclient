package com.baidu.apollon.restnet;

import androidx.core.view.InputDeviceCompat;
import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.http.OkHttpFactory;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class RestDebugConfig {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f37759a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f37760b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f37761c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f37762d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f37763e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f37764f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37765g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1567997726, "Lcom/baidu/apollon/restnet/RestDebugConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1567997726, "Lcom/baidu/apollon/restnet/RestDebugConfig;");
                return;
            }
        }
        f37760b = new HashSet();
        f37764f = true;
    }

    public RestDebugConfig() {
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
        this.f37765g = false;
    }

    public static boolean allowUseOkHttp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? !f37760b.contains(str) : invokeL.booleanValue;
    }

    public static synchronized void disableUseOkHttpPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (RestDebugConfig.class) {
                f37760b.add(str);
            }
        }
    }

    public static synchronized RestDebugConfig getInstance() {
        InterceptResult invokeV;
        RestDebugConfig restDebugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (RestDebugConfig.class) {
                if (f37759a == null) {
                    f37759a = new RestDebugConfig();
                }
                restDebugConfig = f37759a;
            }
            return restDebugConfig;
        }
        return (RestDebugConfig) invokeV.objValue;
    }

    public static boolean isEnableNetworkStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f37761c : invokeV.booleanValue;
    }

    public static boolean isEnableOkHttp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f37764f : invokeV.booleanValue;
    }

    public static void setEnableHappyEyeballs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, null, z) == null) || f37762d == z) {
            return;
        }
        f37762d = z;
        w client = OkHttpFactory.getInstance().client();
        OkHttpFactory okHttpFactory = OkHttpFactory.getInstance();
        w.b v = client.v();
        v.g(z);
        okHttpFactory.setClient(v.a());
    }

    public static void setEnableNetworkStats(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            f37761c = z;
        }
    }

    public static void setEnableOkHttp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            f37764f = z;
        }
    }

    public static void setOkHttpAttemptConnectionDelay(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, null, i2) == null) || f37763e == i2) {
            return;
        }
        f37763e = i2;
        w client = OkHttpFactory.getInstance().client();
        OkHttpFactory okHttpFactory = OkHttpFactory.getInstance();
        w.b v = client.v();
        v.d(i2);
        okHttpFactory.setClient(v.a());
    }

    public boolean isQAEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37765g : invokeV.booleanValue;
    }

    public void setDebugOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ApollonConstants.DEBUG = z;
        }
    }

    public void setQAEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f37765g = z;
        }
    }
}
