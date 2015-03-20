package com.baidu.tbadk.core.util.httpNet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class g {
    public static String getNetType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkCoreApplication.m411getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                    return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
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
