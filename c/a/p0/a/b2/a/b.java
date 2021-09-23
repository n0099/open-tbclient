package c.a.p0.a.b2.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a2.e;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4633a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f4634b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113893455, "Lc/a/p0/a/b2/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(113893455, "Lc/a/p0/a/b2/a/b;");
                return;
            }
        }
        f4633a = k.f7085a;
        f4634b = Sets.newHashSet("https", "wss");
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!f4633a || c.a.p0.a.u1.a.a.z()) {
                if (TextUtils.isEmpty(str)) {
                    d.g("WebSafeCheckers", "action is not in white list: action=" + str);
                    return false;
                }
                e i2 = e.i();
                if (i2 == null) {
                    d.l("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> b2 = i2.a0().b();
                if (b2 != null && b2.contains(str)) {
                    if (f4633a) {
                        String str2 = "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2;
                    }
                    return true;
                }
                d.g("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
                return false;
            }
            return true;
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

    /* JADX WARN: Removed duplicated region for block: B:59:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138  */
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
                if (f4633a) {
                    String str4 = "requestName : " + str;
                    String str5 = "requestUrl : " + str2;
                }
                boolean z2 = !c.a.p0.a.u1.a.a.v();
                boolean z3 = false;
                if (z2) {
                    if (f4633a) {
                        String str6 = "debug包serverDomains鉴权关闭： " + z2;
                    }
                    return 0;
                }
                boolean i2 = i();
                if (!i2) {
                    if (f4633a) {
                        String str7 = "开发包serverDomains鉴权关闭： " + i2;
                    }
                    return 0;
                } else if (d(str2)) {
                    boolean t = c.a.p0.a.c1.a.Z().t();
                    if (!t) {
                        if (f4633a) {
                            String str8 = "AB实验serverDomains鉴权关闭： " + t;
                        }
                        return 0;
                    }
                    e i3 = e.i();
                    if (i3 == null) {
                        return 1;
                    }
                    String str9 = i3.f4566f;
                    if (TextUtils.isEmpty(str9)) {
                        return 1;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        if (!new File(c.i(str9)).exists()) {
                            boolean z4 = f4633a;
                            return 0;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            host = new URI(str2).getHost();
                            list = i3.a0().c(e.V(), str, false).f4644b;
                            z = b(host, list);
                        } catch (URISyntaxException e2) {
                            e = e2;
                        }
                        try {
                            d.a("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", list);
                            StringBuilder sb = new StringBuilder();
                            sb.append("domain: ");
                            sb.append(host);
                            d.g("WebSafeCheckers", sb.toString());
                        } catch (URISyntaxException e3) {
                            e = e3;
                            z3 = z;
                            if (f4633a) {
                                Log.getStackTraceString(e);
                            }
                            z = z3;
                            if (!z) {
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (f4633a) {
                            }
                            return !z;
                        }
                        if (!z) {
                            d.g("WebSafeCheckers", "domain is not in white list");
                        }
                        long currentTimeMillis22 = System.currentTimeMillis();
                        if (f4633a) {
                            String str10 = "serverDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms";
                        }
                        return !z;
                    }
                    return !c.a.p0.a.t1.g.a.c(str, str2, c.a.p0.a.t1.g.b.h(str3)) ? 1 : 0;
                } else {
                    return 2;
                }
            }
            boolean z5 = f4633a;
            return 1;
        }
        return invokeLLL.intValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            for (String str2 : f4634b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            if (c.a.p0.a.u1.a.a.o()) {
                return true;
            }
            boolean r = c.a.p0.a.c1.a.Z().r();
            if (f4633a) {
                String str3 = "abTestHttpsProtocolSwitch=" + r;
            }
            return !r && str.startsWith("http");
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay") : invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp") : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!f4633a || c.a.p0.a.u1.a.a.z()) {
                if (TextUtils.isEmpty(str)) {
                    d.l("WebSafeCheckers", "action is not in white list: action=" + str);
                    return false;
                }
                e i2 = e.i();
                if (i2 == null) {
                    d.l("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> d2 = i2.a0().d(false);
                if (d2 != null && d2.contains(str)) {
                    if (f4633a) {
                        String str2 = "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + d2;
                    }
                    return true;
                }
                d.a("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", d2);
                StringBuilder sb = new StringBuilder();
                sb.append("action is not in white list: action=");
                sb.append(str);
                d.g("WebSafeCheckers", sb.toString());
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            e i2 = e.i();
            boolean z2 = false;
            if (i2 == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (!c.a.p0.a.u1.a.a.z()) {
                boolean z3 = f4633a;
                return true;
            }
            boolean B = c.a.p0.a.c1.a.Z().B();
            if (!B) {
                if (f4633a) {
                    r0 = "ABTest : webDomains switch " + B;
                }
                return true;
            } else if (!i()) {
                boolean z4 = f4633a;
                return true;
            } else {
                String V = e.V();
                if (c.n(V)) {
                    List<String> e2 = i2.a0().e(V, false);
                    if (lowerCase.startsWith("weixin://wap/pay") && e2.contains("wx.tenpay.com")) {
                        d.h("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + i2.O());
                        c.a.p0.a.j2.k.F("wechatH5", "intoPayment", 0);
                        c.a.p0.a.j2.k.C("wechatH5", str, e2);
                        return true;
                    } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (e2.contains("*.alipay.com") || e2.contains("*.alipayobjects.com"))) {
                        d.h("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " whiteDomains: " + e2 + " name: " + i2.O());
                        c.a.p0.a.j2.k.F("alipayH5", "intoPayment", 0);
                        c.a.p0.a.j2.k.C("alipayH5", str, e2);
                        return true;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (TextUtils.isEmpty(str)) {
                            boolean z5 = f4633a;
                            return false;
                        }
                        try {
                            String host = new URL(str).getHost();
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
                            try {
                                d.a("WebSafeCheckers", "domain: " + host + ", domains: ", e2);
                                StringBuilder sb = new StringBuilder();
                                sb.append("domain: ");
                                sb.append(host);
                                d.g("WebSafeCheckers", sb.toString());
                            } catch (MalformedURLException e3) {
                                e = e3;
                                z2 = z;
                                if (f4633a) {
                                    Log.getStackTraceString(e);
                                }
                                z = z2;
                                boolean z6 = f4633a;
                                if (!z) {
                                }
                                long currentTimeMillis2 = System.currentTimeMillis();
                                if (f4633a) {
                                }
                                return z;
                            }
                        } catch (MalformedURLException e4) {
                            e = e4;
                        }
                        boolean z62 = f4633a;
                        if (!z) {
                            d.g("WebSafeCheckers", "domain is not in white list：" + e2);
                        }
                        long currentTimeMillis22 = System.currentTimeMillis();
                        if (f4633a) {
                            String str3 = "checkWebDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms";
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
            if (c.a.p0.a.a2.d.g().l() == 0 && SwanAppConfigData.h.d()) {
                boolean z = f4633a;
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
