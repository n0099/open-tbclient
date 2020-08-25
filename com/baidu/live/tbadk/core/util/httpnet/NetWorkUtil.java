package com.baidu.live.tbadk.core.util.httpnet;

import android.net.Proxy;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
/* loaded from: classes7.dex */
public class NetWorkUtil {
    public static final String NET_TYPE_NET = "1";
    public static final String NET_TYPE_WAP = "2";
    public static final String NET_TYPE_WIFI = "3";

    public static String getNetType() {
        try {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (BdNetTypeUtil.isWifiNet()) {
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
        } catch (Exception e) {
            return null;
        }
    }
}
