package com.baidu.tbadk.core.util.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class g {
    public static String a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.m252getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                    return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT;
                    }
                }
                return TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
