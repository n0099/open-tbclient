package com.baidu.apollon.restnet;

import androidx.core.view.InputDeviceCompat;
import c.d.b.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.http.OkHttpFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class RestDebugConfig {
    public static /* synthetic */ Interceptable $ic;
    public static RestDebugConfig a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f33572b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f33573c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f33574d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f33575e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f33576f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33577g;

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
        f33572b = new HashSet();
        f33576f = true;
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
        this.f33577g = false;
    }

    public static boolean allowUseOkHttp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? !f33572b.contains(str) : invokeL.booleanValue;
    }

    public static synchronized void disableUseOkHttpPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            synchronized (RestDebugConfig.class) {
                f33572b.add(str);
            }
        }
    }

    public static synchronized RestDebugConfig getInstance() {
        InterceptResult invokeV;
        RestDebugConfig restDebugConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (RestDebugConfig.class) {
                if (a == null) {
                    a = new RestDebugConfig();
                }
                restDebugConfig = a;
            }
            return restDebugConfig;
        }
        return (RestDebugConfig) invokeV.objValue;
    }

    public static boolean isEnableNetworkStats() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f33573c : invokeV.booleanValue;
    }

    public static boolean isEnableOkHttp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f33576f : invokeV.booleanValue;
    }

    public static void setEnableHappyEyeballs(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, null, z) == null) || f33574d == z) {
            return;
        }
        f33574d = z;
        w client = OkHttpFactory.getInstance().client();
        OkHttpFactory okHttpFactory = OkHttpFactory.getInstance();
        w.b t = client.t();
        t.g(z);
        okHttpFactory.setClient(t.a());
    }

    public static void setEnableNetworkStats(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            f33573c = z;
        }
    }

    public static void setEnableOkHttp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            f33576f = z;
        }
    }

    public static void setOkHttpAttemptConnectionDelay(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, null, i2) == null) || f33575e == i2) {
            return;
        }
        f33575e = i2;
        w client = OkHttpFactory.getInstance().client();
        OkHttpFactory okHttpFactory = OkHttpFactory.getInstance();
        w.b t = client.t();
        t.d(i2);
        okHttpFactory.setClient(t.a());
    }

    public static void updateOkHttpEventListenerFactory(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Double.valueOf(d2)}) == null) {
            com.baidu.apollon.restnet.http.b.f33634e.a(d2);
        }
    }

    public boolean isQAEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33577g : invokeV.booleanValue;
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
            this.f33577g = z;
        }
    }
}
