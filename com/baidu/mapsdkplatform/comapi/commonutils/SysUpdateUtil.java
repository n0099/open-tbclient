package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
/* loaded from: classes7.dex */
public class SysUpdateUtil implements SysUpdateObserver {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comjni.map.commonmemcache.a f40023a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40024b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40025c;

    /* renamed from: d  reason: collision with root package name */
    public static int f40026d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1917727474, "Lcom/baidu/mapsdkplatform/comapi/commonutils/SysUpdateUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1917727474, "Lcom/baidu/mapsdkplatform/comapi/commonutils/SysUpdateUtil;");
                return;
            }
        }
        f40023a = new com.baidu.mapsdkplatform.comjni.map.commonmemcache.a();
        f40024b = false;
        f40025c = "";
        f40026d = 0;
    }

    public SysUpdateUtil() {
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

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init() {
        com.baidu.mapsdkplatform.comjni.map.commonmemcache.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = f40023a) == null) {
            return;
        }
        aVar.a();
        f40023a.b();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            NetworkUtil.updateNetworkProxy(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c9, code lost:
        if ("10.0.0.200".equals(r9.trim()) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc  */
    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateNetworkProxy(Context context) {
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) != null) || (activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isAvailable()) {
            return;
        }
        String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
        if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
            AppEngine.SetProxyInfo(null, 0);
            f40024b = false;
        } else if (!lowerCase.equals("mobile") && (!lowerCase.equals("wifi") || NetworkUtil.isWifiConnected(activeNetworkInfo))) {
        } else {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            f40024b = false;
            if (extraInfo != null) {
                String lowerCase2 = extraInfo.toLowerCase();
                if (lowerCase2.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase2.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase2.startsWith(ConectivityUtils.APN_3GWAP)) {
                    f40025c = "10.0.0.172";
                } else {
                    if (!lowerCase2.startsWith(ConectivityUtils.APN_CTWAP)) {
                        if (lowerCase2.startsWith(ConectivityUtils.APN_CMNET) || lowerCase2.startsWith(ConectivityUtils.APN_UNINET) || lowerCase2.startsWith(ConectivityUtils.APN_CTNET) || lowerCase2.startsWith(ConectivityUtils.APN_3GNET)) {
                            f40024b = false;
                        }
                        if (f40024b) {
                            AppEngine.SetProxyInfo(f40025c, f40026d);
                            return;
                        } else {
                            AppEngine.SetProxyInfo(null, 0);
                            return;
                        }
                    }
                    f40025c = "10.0.0.200";
                }
            } else {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if ("10.0.0.172".equals(defaultHost.trim())) {
                        f40025c = "10.0.0.172";
                        f40026d = defaultPort;
                        f40024b = true;
                    }
                }
                if (f40024b) {
                }
            }
            f40026d = 80;
            f40024b = true;
            if (f40024b) {
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo() {
        com.baidu.mapsdkplatform.comjni.map.commonmemcache.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = f40023a) == null) {
            return;
        }
        aVar.b();
    }
}
