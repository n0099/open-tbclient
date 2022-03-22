package c.a.n0.a.u1.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.t1.e;
import c.a.n0.a.u.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.internal.Sets;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import okhttp3.CertificatePinner;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f6558b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-490200379, "Lc/a/n0/a/u1/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-490200379, "Lc/a/n0/a/u1/a/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f6558b = Sets.newHashSet("https", "wss");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a && !c.a.n0.a.n1.a.a.A()) {
                Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
                return true;
            } else if (TextUtils.isEmpty(str)) {
                d.i("WebSafeCheckers", "action is not in white list: action=" + str);
                return false;
            } else {
                e L = e.L();
                if (L == null) {
                    d.o("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> b2 = L.k0().b();
                if (b2 != null && b2.contains(str)) {
                    if (a) {
                        Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2);
                    }
                    return true;
                }
                d.i("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.equals(str, str2)) {
                            return true;
                        }
                        if (str2.startsWith(CertificatePinner.Pin.WILDCARD) && str.endsWith(str2.substring(2))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        boolean z;
        String host;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.i("WebSafeCheckers", "requestName : " + str);
                    Log.i("WebSafeCheckers", "requestUrl : " + str2);
                }
                boolean z2 = !c.a.n0.a.n1.a.a.w();
                boolean z3 = false;
                if (z2) {
                    if (a) {
                        Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                    }
                    return 0;
                }
                boolean i = i();
                if (!i) {
                    if (a) {
                        Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + i);
                    }
                    return 0;
                } else if (d(str2)) {
                    boolean s = c.a.n0.a.s0.a.g0().s();
                    if (!s) {
                        if (a) {
                            Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + s);
                        }
                        return 0;
                    }
                    e L = e.L();
                    if (L == null) {
                        return 1;
                    }
                    String str4 = L.f6344b;
                    if (TextUtils.isEmpty(str4)) {
                        return 1;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        if (!new File(c.i(str4)).exists()) {
                            if (a) {
                                Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                            }
                            return 0;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            host = new URI(str2).getHost();
                            list = L.k0().c(e.f0(), str, false).f6563b;
                            z = b(host, list);
                        } catch (URISyntaxException e2) {
                            e = e2;
                        }
                        try {
                            d.b("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", list);
                            StringBuilder sb = new StringBuilder();
                            sb.append("domain: ");
                            sb.append(host);
                            d.i("WebSafeCheckers", sb.toString());
                        } catch (URISyntaxException e3) {
                            e = e3;
                            z3 = z;
                            if (a) {
                                Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                            }
                            z = z3;
                            if (!z) {
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (a) {
                            }
                            return !z;
                        }
                        if (!z) {
                            d.i("WebSafeCheckers", "domain is not in white list");
                        }
                        long currentTimeMillis22 = System.currentTimeMillis();
                        if (a) {
                            Log.d("WebSafeCheckers", "serverDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                            if (z != 0) {
                                Log.d("WebSafeCheckers", "serverDomain in white list");
                            } else {
                                Log.d("WebSafeCheckers", "serverDomain not in white list");
                            }
                        }
                        return !z;
                    }
                    return !c.a.n0.a.m1.h.a.c(str, str2, c.a.n0.a.m1.h.b.h(str3)) ? 1 : 0;
                } else {
                    return 2;
                }
            }
            if (a) {
                Log.d("WebSafeCheckers", "server domains: requestName or requestUrl is empty");
            }
            return 1;
        }
        return invokeLLL.intValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            for (String str2 : f6558b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            if (c.a.n0.a.n1.a.a.o()) {
                return true;
            }
            boolean q = c.a.n0.a.s0.a.g0().q();
            if (a) {
                Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + q);
            }
            return !q && str.startsWith("http");
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay") : invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp") : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (a && !c.a.n0.a.n1.a.a.A()) {
                Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
                return true;
            } else if (TextUtils.isEmpty(str)) {
                d.o("WebSafeCheckers", "action is not in white list: action=" + str);
                return false;
            } else {
                e L = e.L();
                if (L == null) {
                    d.o("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> d2 = L.k0().d(false);
                if (d2 != null && d2.contains(str)) {
                    if (a) {
                        Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + d2);
                    }
                    return true;
                }
                d.b("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", d2);
                StringBuilder sb = new StringBuilder();
                sb.append("action is not in white list: action=");
                sb.append(str);
                d.i("WebSafeCheckers", sb.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(String str) {
        InterceptResult invokeL;
        boolean z;
        String host;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            e a0 = e.a0();
            boolean z2 = false;
            if (a0 == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (!c.a.n0.a.n1.a.a.A()) {
                if (a) {
                    Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
                }
                return true;
            }
            boolean A = c.a.n0.a.s0.a.g0().A();
            if (!A) {
                if (a) {
                    Log.w("WebSafeCheckers", "ABTest : webDomains switch " + A);
                }
                return true;
            } else if (!i()) {
                if (a) {
                    Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
                }
                return true;
            } else {
                String f0 = e.f0();
                if (c.n(f0)) {
                    List<String> e2 = a0.k0().e(f0, false);
                    if (lowerCase.startsWith("weixin://wap/pay") && e2.contains("wx.tenpay.com")) {
                        d.k("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + a0.Y());
                        n.K("wechatH5", "intoPayment", 0);
                        n.G("wechatH5", str, e2);
                        return true;
                    } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (e2.contains("*.alipay.com") || e2.contains("*.alipayobjects.com"))) {
                        d.k("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " whiteDomains: " + e2 + " name: " + a0.Y());
                        n.K("alipayH5", "intoPayment", 0);
                        n.G("alipayH5", str, e2);
                        return true;
                    } else {
                        long nanoTime = a ? System.nanoTime() : 0L;
                        if (TextUtils.isEmpty(str)) {
                            if (a) {
                                Log.w("WebSafeCheckers", "checkWebDomain: url is empty");
                            }
                            return false;
                        }
                        try {
                            host = new URL(str).getHost();
                            if (!TextUtils.isEmpty(host) && e2 != null) {
                                for (String str2 : e2) {
                                    if (str2 != null) {
                                        if (str2.startsWith(CertificatePinner.Pin.WILDCARD)) {
                                            if (host.endsWith(str2.substring(2))) {
                                                z = true;
                                                break;
                                            }
                                        } else if (TextUtils.equals(str2, host)) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            z = false;
                        } catch (MalformedURLException e3) {
                            e = e3;
                        }
                        try {
                            d.b("WebSafeCheckers", "domain: ", host, ", domains: ", e2);
                            d.i("WebSafeCheckers", "domain: " + host);
                        } catch (MalformedURLException e4) {
                            e = e4;
                            z2 = z;
                            if (a) {
                                Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                            }
                            z = z2;
                            if (!z) {
                            }
                            if (a) {
                            }
                            return z;
                        }
                        if (!z) {
                            d.i("WebSafeCheckers", "domain is not in white list：" + e2);
                        }
                        if (a) {
                            long nanoTime2 = System.nanoTime();
                            Log.d("WebSafeCheckers", z ? "Domain in white list" : "Domain not in white list");
                            Log.d("WebSafeCheckers", "checkWebDomain耗时(ms): " + (((float) (nanoTime2 - nanoTime)) / 1000000.0f));
                        }
                        return z;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (c.a.n0.a.t1.d.J().l() == 0 && SwanAppConfigData.j.d()) {
                if (a) {
                    Log.d("WebSafeCheckers", "授权跳过url校验");
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            return lowerCase.startsWith("weixin://wap/pay") || lowerCase.startsWith("alipays://platformapi/startapp");
        }
        return invokeL.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (e.L() == null) {
                return false;
            }
            return c.a.n0.a.c1.d.d.g().j(c.a.n0.a.t1.d.J().r().V().f0());
        }
        return invokeV.booleanValue;
    }
}
