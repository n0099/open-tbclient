package com.baidu.tbadk.core.util.a;

import android.net.Proxy;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j {
    public static String getNetType() {
        try {
            if (com.baidu.adp.lib.util.i.hk()) {
                if (com.baidu.adp.lib.util.i.hl()) {
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
