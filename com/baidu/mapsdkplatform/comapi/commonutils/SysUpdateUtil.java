package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.sapi2.result.AddressManageResult;
/* loaded from: classes5.dex */
public class SysUpdateUtil implements SysUpdateObserver {
    static com.baidu.mapsdkplatform.comjni.map.commonmemcache.a a = new com.baidu.mapsdkplatform.comjni.map.commonmemcache.a();
    public static boolean b = false;
    public static String c = "";
    public static int d = 0;

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init() {
        if (a != null) {
            a.a();
            a.b();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkProxy(Context context) {
        NetworkInfo activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return;
        }
        String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
        if (lowerCase.equals(IXAdSystemUtils.NT_WIFI) && activeNetworkInfo.isConnected()) {
            AppEngine.SetProxyInfo(null, 0);
            b = false;
        } else if (lowerCase.equals(AddressManageResult.KEY_MOBILE) || (lowerCase.equals(IXAdSystemUtils.NT_WIFI) && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            b = false;
            if (extraInfo != null) {
                String lowerCase2 = extraInfo.toLowerCase();
                if (lowerCase2.startsWith("cmwap") || lowerCase2.startsWith("uniwap") || lowerCase2.startsWith("3gwap")) {
                    c = "10.0.0.172";
                    d = 80;
                    b = true;
                } else if (lowerCase2.startsWith("ctwap")) {
                    c = "10.0.0.200";
                    d = 80;
                    b = true;
                } else if (lowerCase2.startsWith("cmnet") || lowerCase2.startsWith("uninet") || lowerCase2.startsWith("ctnet") || lowerCase2.startsWith("3gnet")) {
                    b = false;
                }
            } else {
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
            if (b) {
                AppEngine.SetProxyInfo(c, d);
            } else {
                AppEngine.SetProxyInfo(null, 0);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo() {
        if (a != null) {
            a.b();
        }
    }
}
