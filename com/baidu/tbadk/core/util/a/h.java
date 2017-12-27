package com.baidu.tbadk.core.util.a;

import android.net.Proxy;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class h {
    public static String getNetType() {
        try {
            if (j.oI()) {
                if (j.oJ()) {
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
