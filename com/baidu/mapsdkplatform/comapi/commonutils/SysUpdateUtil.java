package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.platform.comapi.util.e;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
/* loaded from: classes26.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a  reason: collision with root package name */
    private static NACommonMemCache f2208a;
    private static boolean b = false;
    private static String c = "";
    private static int d = 0;

    public SysUpdateUtil() {
        f2208a = e.b();
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init(String str) {
        if (f2208a != null) {
            if (TextUtils.isEmpty(str)) {
                str = SyncSysInfo.getPhoneInfoCache();
            }
            f2208a.a(str);
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
            b = false;
        } else if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(activeNetworkInfo))) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            b = false;
            if (extraInfo == null) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                if ("10.0.0.172".equals(defaultHost.trim())) {
                    c = "10.0.0.172";
                    d = defaultPort;
                    b = true;
                    return;
                } else if ("10.0.0.200".equals(defaultHost.trim())) {
                    c = "10.0.0.200";
                    d = 80;
                    b = true;
                    return;
                } else {
                    return;
                }
            }
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
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo(String str) {
        if (f2208a != null) {
            f2208a.a(str);
        }
    }
}
