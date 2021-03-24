package com.baidu.tbadk.core.util.httpNet;

import android.net.Proxy;
import d.b.b.e.p.j;
/* loaded from: classes3.dex */
public class NetWorkUtil {
    public static final String NET_TYPE_NET = "1";
    public static final String NET_TYPE_WAP = "2";
    public static final String NET_TYPE_WIFI = "3";

    public static String getNetType() {
        try {
            if (j.z()) {
                if (j.H()) {
                    return "3";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return "2";
                    }
                }
                return "1";
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
