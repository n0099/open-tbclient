package com.baidu.searchbox.dns.b;

import com.baidu.searchbox.dns.d.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<String> g(String str) {
        InterceptResult invokeL;
        Map<String, com.baidu.searchbox.dns.d.a.a> A;
        com.baidu.searchbox.dns.d.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            com.baidu.searchbox.dns.d.a.b x = new c(false, str, 2).x();
            if (x == null || x.A() == null || (A = x.A()) == null || A.isEmpty() || (aVar = A.get(str)) == null) {
                return null;
            }
            com.baidu.searchbox.dns.a.a.e().a(str, aVar);
            return aVar.getIpList();
        }
        return (List) invokeL.objValue;
    }
}
