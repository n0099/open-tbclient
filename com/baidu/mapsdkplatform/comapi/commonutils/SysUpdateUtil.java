package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.webkit.internal.ConectivityUtils;
/* loaded from: classes2.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a  reason: collision with root package name */
    public static com.baidu.mapsdkplatform.comjni.map.commonmemcache.a f7627a = new com.baidu.mapsdkplatform.comjni.map.commonmemcache.a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7628b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f7629c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f7630d = 0;

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init() {
        com.baidu.mapsdkplatform.comjni.map.commonmemcache.a aVar = f7627a;
        if (aVar != null) {
            aVar.a();
            f7627a.b();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c5, code lost:
        if ("10.0.0.200".equals(r9.trim()) != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8  */
    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateNetworkProxy(Context context) {
        NetworkInfo activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return;
        }
        String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
        if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
            AppEngine.SetProxyInfo(null, 0);
            f7628b = false;
        } else if (!lowerCase.equals("mobile") && (!lowerCase.equals("wifi") || NetworkUtil.isWifiConnected(activeNetworkInfo))) {
        } else {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            f7628b = false;
            if (extraInfo != null) {
                String lowerCase2 = extraInfo.toLowerCase();
                if (lowerCase2.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase2.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase2.startsWith(ConectivityUtils.APN_3GWAP)) {
                    f7629c = "10.0.0.172";
                } else {
                    if (!lowerCase2.startsWith(ConectivityUtils.APN_CTWAP)) {
                        if (lowerCase2.startsWith(ConectivityUtils.APN_CMNET) || lowerCase2.startsWith(ConectivityUtils.APN_UNINET) || lowerCase2.startsWith(ConectivityUtils.APN_CTNET) || lowerCase2.startsWith(ConectivityUtils.APN_3GNET)) {
                            f7628b = false;
                        }
                        if (f7628b) {
                            AppEngine.SetProxyInfo(f7629c, f7630d);
                            return;
                        } else {
                            AppEngine.SetProxyInfo(null, 0);
                            return;
                        }
                    }
                    f7629c = "10.0.0.200";
                }
            } else {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    if ("10.0.0.172".equals(defaultHost.trim())) {
                        f7629c = "10.0.0.172";
                        f7630d = defaultPort;
                        f7628b = true;
                    }
                }
                if (f7628b) {
                }
            }
            f7630d = 80;
            f7628b = true;
            if (f7628b) {
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo() {
        com.baidu.mapsdkplatform.comjni.map.commonmemcache.a aVar = f7627a;
        if (aVar != null) {
            aVar.b();
        }
    }
}
