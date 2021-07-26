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
/* loaded from: classes2.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f6820a;

    /* renamed from: b  reason: collision with root package name */
    public static int f6821b;

    /* renamed from: g  reason: collision with root package name */
    public static int f6822g;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f6823h;

    /* renamed from: i  reason: collision with root package name */
    public int f6824i;
    public String j;
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
        f6822g = a.f6789g;
        f6820a = "10.0.0.172";
        f6821b = 80;
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
        this.f6823h = null;
        this.f6824i = 1;
        this.j = null;
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
                    f6820a = str2;
                    return a.f6786d;
                } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                    String defaultHost2 = Proxy.getDefaultHost();
                    if (defaultHost2 != null && !defaultHost2.equals("") && !defaultHost2.equals(StringUtil.NULL_STRING)) {
                        str = defaultHost2;
                    }
                    f6820a = str;
                    return a.f6786d;
                } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                    return a.f6787e;
                }
            }
            String defaultHost3 = Proxy.getDefaultHost();
            if (defaultHost3 != null && defaultHost3.length() > 0) {
                if (!"10.0.0.172".equals(defaultHost3.trim())) {
                }
                f6820a = str2;
                return a.f6786d;
            }
            return a.f6787e;
        }
        return invokeLL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            f6822g = c();
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
                    return a.f6789g;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() == 1) {
                        String defaultHost = Proxy.getDefaultHost();
                        return (defaultHost == null || defaultHost.length() <= 0) ? a.f6788f : a.f6790h;
                    }
                    return a(serviceContext, activeNetworkInfo);
                }
                return a.f6789g;
            } catch (Exception unused) {
                return a.f6789g;
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
