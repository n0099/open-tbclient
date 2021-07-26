package com.baidu.searchbox.dns;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.dns.c.a;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static List<String> f10225i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(727494201, "Lcom/baidu/searchbox/dns/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(727494201, "Lcom/baidu/searchbox/dns/b;");
        }
    }

    public static DnsParseResult a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, str, z)) == null) {
            List<String> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = 0;
            com.baidu.searchbox.dns.c.a k = new a.C0154a(System.currentTimeMillis(), com.baidu.searchbox.dns.d.b.o().a(str, false, 2), com.baidu.searchbox.dns.a.a.e().c(str)).k();
            com.baidu.searchbox.dns.d.a i3 = k.i();
            com.baidu.searchbox.dns.d.a.a h2 = k.h();
            int j2 = k.j();
            if (h2 != null) {
                list = a(h2, DnsUtil.stackType);
                if (list == null || list.isEmpty()) {
                    j2 = 1006;
                } else {
                    if (j2 == 1001) {
                        z = true;
                    }
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "DnsEngine getIplist -> cache response hit: " + str + " ip: " + a(list));
                    }
                    i2 = 2000;
                }
            }
            if (i3 != null && z) {
                if (i2 != 2000) {
                    i2 = 1000;
                }
                i3.start();
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " DnsEngine getIplist -> trasmitTask start: " + str);
                }
            } else if (i3 == null) {
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " DnsEngine getIplist -> no need start transmitTask: " + str);
                }
                if (i2 == 0) {
                    j2 = 4;
                }
            }
            return new DnsParseResult(list, i2, j2, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeLZ.objValue;
    }

    public static DnsParseResult b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            DnsParseResult a2 = a(str, !z);
            if (a2 != null) {
                List<String> ipList = a2.getIpList();
                int type = a2.getType();
                int subType = a2.getSubType();
                int stackType = a2.getStackType();
                if (ipList == null || ipList.isEmpty()) {
                    if (z) {
                        int i2 = 2000;
                        int i3 = 2002;
                        List<String> g2 = com.baidu.searchbox.dns.b.a.g(str);
                        if (g2 == null || g2.isEmpty()) {
                            i3 = 3;
                            i2 = 0;
                        }
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + a(g2));
                        }
                        subType = i3;
                        ipList = g2;
                        type = i2;
                    }
                    if (ipList == null || ipList.isEmpty()) {
                        Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
                        ipList = com.baidu.searchbox.dns.b.b.a(h2);
                        if (com.baidu.searchbox.dns.b.b.b(h2)) {
                            subType = 5;
                        }
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, "DnsEngine getIplist -> use local dns:" + str + " ip: " + a(ipList));
                        }
                    }
                }
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "Dns parse result type: " + type + " subtype: " + subType);
                }
                return new DnsParseResult(ipList, type, subType, stackType);
            }
            return a2;
        }
        return (DnsParseResult) invokeLZ.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized (b.class) {
                if (f10225i != null && f10225i.size() > 0) {
                    for (String str : f10225i) {
                        b(str);
                    }
                }
            }
        }
    }

    public static void forceUpdateDomain(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            a(str);
            b(str);
        }
    }

    public static DnsParseResult getParseResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? b(str, false) : (DnsParseResult) invokeL.objValue;
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            synchronized (b.class) {
                if (f10225i == null) {
                    f10225i = new ArrayList(4);
                }
                if (!f10225i.contains(str)) {
                    f10225i.add(str);
                }
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            DnsUtil.initNetworkStackType();
            com.baidu.searchbox.dns.d.a a2 = com.baidu.searchbox.dns.d.b.o().a(str, true, 1);
            if (a2 != null) {
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " start update domain task: " + str);
                }
                a2.start();
            }
        }
    }

    public static String a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (!DnsUtil.DEBUG || list == null || list.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str);
                sb.append(" | ");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, aVar, i2)) == null) {
            if (i2 == 3) {
                return a(aVar, j);
            }
            if (i2 == 1) {
                return a(aVar, false);
            }
            if (i2 == 2) {
                return a(aVar, true);
            }
            return a(aVar, false);
        }
        return (List) invokeLI.objValue;
    }

    public static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, z)) == null) ? aVar.getIpList() : (List) invokeLZ.objValue;
    }
}
