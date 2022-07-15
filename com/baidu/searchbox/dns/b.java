package com.baidu.searchbox.dns;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.dns.c.a;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> i;
    public transient /* synthetic */ FieldHolder $fh;

    public static DnsParseResult a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, str, z)) == null) {
            List<String> list = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = 0;
            com.baidu.searchbox.dns.c.a k = new a.C0141a(System.currentTimeMillis(), com.baidu.searchbox.dns.d.b.o().a(str, false, 2), com.baidu.searchbox.dns.a.a.e().c(str)).k();
            com.baidu.searchbox.dns.d.a i3 = k.i();
            com.baidu.searchbox.dns.d.a.a h = k.h();
            int j = k.j();
            if (h != null) {
                list = a(h, DnsUtil.stackType);
                if (list == null || list.isEmpty()) {
                    j = 1006;
                } else {
                    if (j == 1001) {
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
                    j = 4;
                }
            }
            return new DnsParseResult(list, i2, j, DnsUtil.stackType);
        }
        return (DnsParseResult) invokeLZ.objValue;
    }

    public static DnsParseResult b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            DnsParseResult a = a(str, !z);
            if (a != null) {
                List<String> ipList = a.getIpList();
                int type = a.getType();
                int subType = a.getSubType();
                int stackType = a.getStackType();
                if (ipList == null || ipList.isEmpty()) {
                    if (z) {
                        int i2 = 2000;
                        int i3 = 2002;
                        List<String> g = com.baidu.searchbox.dns.b.a.g(str);
                        if (g == null || g.isEmpty()) {
                            i3 = 3;
                            i2 = 0;
                        }
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + a(g));
                        }
                        subType = i3;
                        ipList = g;
                        type = i2;
                    }
                    if (ipList == null || ipList.isEmpty()) {
                        Map<String, List<String>> h = com.baidu.searchbox.dns.b.b.h(str);
                        ipList = com.baidu.searchbox.dns.b.b.a(h);
                        if (com.baidu.searchbox.dns.b.b.b(h)) {
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
            return a;
        }
        return (DnsParseResult) invokeLZ.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            synchronized (b.class) {
                if (i != null && i.size() > 0) {
                    for (String str : i) {
                        b(str);
                    }
                }
            }
        }
    }

    public static void forceUpdateDomain(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            a(str);
            b(str);
        }
    }

    public static DnsParseResult getParseResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? b(str, false) : (DnsParseResult) invokeL.objValue;
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            synchronized (b.class) {
                if (i == null) {
                    i = new ArrayList(4);
                }
                if (!i.contains(str)) {
                    i.add(str);
                }
            }
        }
    }

    public static void b(String str) {
        com.baidu.searchbox.dns.d.a a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || (a = com.baidu.searchbox.dns.d.b.o().a(str, true, 1)) == null) {
            return;
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " start update domain task: " + str);
        }
        a.start();
    }

    public static String a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, aVar, i2)) == null) {
            boolean z = false;
            if (i2 == 3) {
                if (DnsUtil.iPv6TestEnable && DnsUtil.iPv6Perfer && com.baidu.searchbox.dns.a.a.e().isIPv6TestArea()) {
                    z = true;
                }
                return a(aVar, z);
            } else if (i2 == 1) {
                return a(aVar, false);
            } else {
                if (i2 == 2) {
                    return a(aVar, true);
                }
                return a(aVar, false);
            }
        }
        return (List) invokeLI.objValue;
    }

    public static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, aVar, z)) == null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                List<String> ipList = aVar.getIpList();
                List<String> z2 = aVar.z();
                if (z2 != null) {
                    arrayList.addAll(z2);
                }
                if (ipList != null) {
                    arrayList.addAll(ipList);
                }
                return arrayList;
            }
            return aVar.getIpList();
        }
        return (List) invokeLZ.objValue;
    }
}
