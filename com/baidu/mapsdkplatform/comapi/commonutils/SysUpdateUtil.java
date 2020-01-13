package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.webkit.net.BdNetEngine;
/* loaded from: classes6.dex */
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
        if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
            AppEngine.SetProxyInfo(null, 0);
            b = false;
        } else if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            b = false;
            if (extraInfo != null) {
                String lowerCase2 = extraInfo.toLowerCase();
                if (lowerCase2.startsWith("cmwap") || lowerCase2.startsWith("uniwap") || lowerCase2.startsWith("3gwap")) {
                    c = BdNetEngine.URI_PROXY_CMWAP;
                    d = 80;
                    b = true;
                } else if (lowerCase2.startsWith("ctwap")) {
                    c = BdNetEngine.URI_PROXY_CTWAP;
                    d = 80;
                    b = true;
                } else if (lowerCase2.startsWith("cmnet") || lowerCase2.startsWith("uninet") || lowerCase2.startsWith("ctnet") || lowerCase2.startsWith("3gnet")) {
                    b = false;
                }
            } else {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if (BdNetEngine.URI_PROXY_CMWAP.equals(defaultHost.trim())) {
                        c = BdNetEngine.URI_PROXY_CMWAP;
                        d = defaultPort;
                        b = true;
                    } else if (BdNetEngine.URI_PROXY_CTWAP.equals(defaultHost.trim())) {
                        c = BdNetEngine.URI_PROXY_CTWAP;
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
