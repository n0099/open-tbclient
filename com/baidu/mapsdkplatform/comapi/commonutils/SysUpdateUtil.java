package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.platform.comapi.util.f;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
/* loaded from: classes3.dex */
public class SysUpdateUtil implements SysUpdateObserver {
    public static /* synthetic */ Interceptable $ic = null;
    public static NACommonMemCache a = null;
    public static boolean b = false;
    public static String c = "";
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1917727474, "Lcom/baidu/mapsdkplatform/comapi/commonutils/SysUpdateUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1917727474, "Lcom/baidu/mapsdkplatform/comapi/commonutils/SysUpdateUtil;");
        }
    }

    public SysUpdateUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a = f.b();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && a != null) {
            if (TextUtils.isEmpty(str)) {
                str = SyncSysInfo.getPhoneInfoCache();
            }
            a.a(str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            NetworkUtil.updateNetworkProxy(context);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo(String str) {
        NACommonMemCache nACommonMemCache;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (nACommonMemCache = a) != null) {
            nACommonMemCache.a(str);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkProxy(Context context) {
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && (activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context)) != null && activeNetworkInfo.isAvailable()) {
            String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
            if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
                b = false;
            } else if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                b = false;
                if (extraInfo != null) {
                    String lowerCase2 = extraInfo.toLowerCase();
                    if (!lowerCase2.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase2.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase2.startsWith(ConectivityUtils.APN_3GWAP)) {
                        if (lowerCase2.startsWith(ConectivityUtils.APN_CTWAP)) {
                            c = "10.0.0.200";
                            d = 80;
                            b = true;
                            return;
                        } else if (lowerCase2.startsWith(ConectivityUtils.APN_CMNET) || lowerCase2.startsWith(ConectivityUtils.APN_UNINET) || lowerCase2.startsWith(ConectivityUtils.APN_CTNET) || lowerCase2.startsWith(ConectivityUtils.APN_3GNET)) {
                            b = false;
                            return;
                        } else {
                            return;
                        }
                    }
                    c = "10.0.0.172";
                    d = 80;
                    b = true;
                    return;
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if ("10.0.0.172".equals(defaultHost.trim())) {
                        c = "10.0.0.172";
                        d = defaultPort;
                        b = true;
                    } else if ("10.0.0.200".equals(defaultHost.trim())) {
                        c = "10.0.0.200";
                        d = 80;
                        b = true;
                    }
                }
            }
        }
    }
}
