package com.baidu.searchbox.dns.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.dns.a.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class DnsUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "SMART_HTTP_DNS";
    public static String httpDnsDebugAddress;
    public static String httpDnsDebugExtraQueryParams;
    public static boolean iPv6Perfer;
    public static boolean iPv6TestEnable;
    public static int stackType;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1214779843, "Lcom/baidu/searchbox/dns/util/DnsUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1214779843, "Lcom/baidu/searchbox/dns/util/DnsUtil;");
        }
    }

    public DnsUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void initNetworkStackType() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                z = DnsChecker.isIPv4Reachable();
            } catch (Throwable th) {
                th = th;
                z = false;
            }
            try {
                z2 = DnsChecker.isIPv6Reachable();
            } catch (Throwable th2) {
                th = th2;
                if (DEBUG) {
                    th.printStackTrace();
                }
                z2 = false;
                if (DEBUG) {
                }
                if (!z) {
                }
                if (!z) {
                }
            }
            if (DEBUG) {
                String str = " IPv4Reachable: " + z + ", isIPv6Reachable: " + z2;
            }
            if (!z && z2) {
                stackType = 3;
            } else if (!z) {
                stackType = 1;
            } else if (z2) {
                stackType = 2;
            } else {
                stackType = 0;
            }
        }
    }

    public static boolean isIPv6TestArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.e().isIPv6TestArea() : invokeV.booleanValue;
    }

    public static List<InetAddress> parseInetAddressList(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                arrayList.add(InetAddress.getByName(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> parseRawAddressList(List<InetAddress> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (InetAddress inetAddress : list) {
                arrayList.add(inetAddress.getHostAddress());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
