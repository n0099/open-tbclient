package com.baidu.searchbox.dns.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class DnsChecker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(695878370, "Lcom/baidu/searchbox/dns/util/DnsChecker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(695878370, "Lcom/baidu/searchbox/dns/util/DnsChecker;");
                return;
            }
        }
        try {
            System.loadLibrary("DnsChecker");
        } catch (UnsatisfiedLinkError e2) {
            if (DnsUtil.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static native boolean isIPv4Reachable();

    public static native boolean isIPv6Reachable();
}
