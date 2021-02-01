package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
/* loaded from: classes4.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a  reason: collision with root package name */
    static com.baidu.mapsdkplatform.comjni.map.commonmemcache.a f3020a = new com.baidu.mapsdkplatform.comjni.map.commonmemcache.a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3021b = false;
    public static String c = "";
    public static int d = 0;

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init() {
        if (f3020a != null) {
            f3020a.a();
            f3020a.b();
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
            f3021b = false;
        } else if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            f3021b = false;
            if (extraInfo != null) {
                String lowerCase2 = extraInfo.toLowerCase();
                if (lowerCase2.startsWith("cmwap") || lowerCase2.startsWith("uniwap") || lowerCase2.startsWith("3gwap")) {
                    c = "10.0.0.172";
                    d = 80;
                    f3021b = true;
                } else if (lowerCase2.startsWith("ctwap")) {
                    c = "10.0.0.200";
                    d = 80;
                    f3021b = true;
                } else if (lowerCase2.startsWith("cmnet") || lowerCase2.startsWith("uninet") || lowerCase2.startsWith("ctnet") || lowerCase2.startsWith("3gnet")) {
                    f3021b = false;
                }
            } else {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if ("10.0.0.172".equals(defaultHost.trim())) {
                        c = "10.0.0.172";
                        d = defaultPort;
                        f3021b = true;
                    } else if ("10.0.0.200".equals(defaultHost.trim())) {
                        c = "10.0.0.200";
                        d = 80;
                        f3021b = true;
                    }
                }
            }
            if (f3021b) {
                AppEngine.SetProxyInfo(c, d);
            } else {
                AppEngine.SetProxyInfo(null, 0);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo() {
        if (f3020a != null) {
            f3020a.b();
        }
    }
}
