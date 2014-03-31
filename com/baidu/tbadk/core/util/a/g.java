package com.baidu.tbadk.core.util.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class g {
    public static String a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.j().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
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
