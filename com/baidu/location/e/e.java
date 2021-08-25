package com.baidu.location.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f41165a;

    /* renamed from: b  reason: collision with root package name */
    public static int f41166b;

    /* renamed from: g  reason: collision with root package name */
    public static int f41167g;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f41168h;

    /* renamed from: i  reason: collision with root package name */
    public int f41169i;

    /* renamed from: j  reason: collision with root package name */
    public String f41170j;
    public Map<String, Object> k;
    public String l;
    public byte[] m;
    public byte[] n;
    public String o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037812780, "Lcom/baidu/location/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037812780, "Lcom/baidu/location/e/e;");
                return;
            }
        }
        f41167g = a.f41132g;
        f41165a = "10.0.0.172";
        f41166b = 80;
        p = 0;
    }

    public e() {
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
        this.f41168h = null;
        this.f41169i = 1;
        this.f41170j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        if ("10.0.0.200".equals(r5.trim()) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, NetworkInfo networkInfo) {
        InterceptResult invokeLL;
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, networkInfo)) == null) {
            String str = "10.0.0.200";
            String str2 = "10.0.0.172";
            if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && !defaultHost.equals("") && !defaultHost.equals(StringUtil.NULL_STRING)) {
                        str2 = defaultHost;
                    }
                    f41165a = str2;
                    return a.f41129d;
                } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                    String defaultHost2 = Proxy.getDefaultHost();
                    if (defaultHost2 != null && !defaultHost2.equals("") && !defaultHost2.equals(StringUtil.NULL_STRING)) {
                        str = defaultHost2;
                    }
                    f41165a = str;
                    return a.f41129d;
                } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                    return a.f41130e;
                }
            }
            String defaultHost3 = Proxy.getDefaultHost();
            if (defaultHost3 != null && defaultHost3.length() > 0) {
                if (!"10.0.0.172".equals(defaultHost3.trim())) {
                }
                f41165a = str2;
                return a.f41129d;
            }
            return a.f41130e;
        }
        return invokeLL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            f41167g = c();
        }
    }

    private int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return a.f41132g;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() == 1) {
                        String defaultHost = Proxy.getDefaultHost();
                        return (defaultHost == null || defaultHost.length() <= 0) ? a.f41131f : a.f41133h;
                    }
                    return a(serviceContext, activeNetworkInfo);
                }
                return a.f41132g;
            } catch (Exception unused) {
                return a.f41132g;
            }
        }
        return invokeV.intValue;
    }

    public abstract void a();

    public void a(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, executorService) == null) {
            try {
                executorService.execute(new f(this));
            } catch (Throwable unused) {
                a(false);
            }
        }
    }

    public void a(ExecutorService executorService, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, executorService, str) == null) {
            try {
                executorService.execute(new i(this, str));
            } catch (Throwable unused) {
                a(false);
            }
        }
    }

    public void a(ExecutorService executorService, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{executorService, Boolean.valueOf(z), str}) == null) {
            try {
                executorService.execute(new g(this, str, z));
            } catch (Throwable unused) {
                a(false);
            }
        }
    }

    public abstract void a(boolean z);

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                new h(this, str).start();
            } catch (Throwable unused) {
                a(false);
            }
        }
    }

    public void b(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, executorService) == null) {
            a(executorService, false, "loc.map.baidu.com");
        }
    }
}
