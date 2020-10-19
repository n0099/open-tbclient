package com.baidu.platform.comapi.util;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.platform.comjni.engine.NAEngine;
/* loaded from: classes7.dex */
public class k {
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        String str;
        int i = 80;
        boolean z = true;
        NetworkInfo activeNetworkInfo = NetworkUtil.getActiveNetworkInfo(context);
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
            if (lowerCase.equals("wifi") && activeNetworkInfo.isConnected()) {
                NAEngine.a((String) null, 0);
                return;
            } else if (lowerCase.equals("mobile") || (lowerCase.equals("wifi") && !NetworkUtil.isWifiConnected(context))) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null) {
                    String lowerCase2 = extraInfo.toLowerCase();
                    if (lowerCase2.startsWith("cmwap") || lowerCase2.startsWith("uniwap") || lowerCase2.startsWith("3gwap") || lowerCase2.startsWith("cuwap")) {
                        str = "10.0.0.172";
                    } else if (lowerCase2.startsWith("ctwap")) {
                        str = "10.0.0.200";
                    } else if (lowerCase2.startsWith("cmnet") || lowerCase2.startsWith("uninet") || lowerCase2.startsWith("ctnet") || lowerCase2.startsWith("3gnet")) {
                        z = false;
                        i = defaultPort;
                        str = defaultHost;
                    } else {
                        z = false;
                        i = defaultPort;
                        str = defaultHost;
                    }
                    defaultHost = str;
                    defaultPort = i;
                } else {
                    String defaultHost2 = Proxy.getDefaultHost();
                    int defaultPort2 = Proxy.getDefaultPort();
                    if (defaultHost2 != null && defaultHost2.length() > 0) {
                        if ("10.0.0.172".equals(defaultHost2.trim())) {
                            defaultHost = "10.0.0.172";
                            defaultPort = defaultPort2;
                        } else if ("10.0.0.200".equals(defaultHost2.trim())) {
                            defaultHost = "10.0.0.200";
                            defaultPort = 80;
                        }
                    }
                }
                if (z) {
                    NAEngine.a((String) null, 0);
                    return;
                } else {
                    NAEngine.a(defaultHost, defaultPort);
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
