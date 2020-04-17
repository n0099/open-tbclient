package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t dyL;
    private long dyG = 0;
    private long dyH = 0;
    private String dyI = "";
    private String dyJ = "";
    private final long dyK = 120000;

    public static t aOt() {
        if (dyL == null) {
            synchronized (t.class) {
                if (dyL == null) {
                    dyL = new t();
                }
            }
        }
        return dyL;
    }

    public String aOu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dyG > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dyG = currentTimeMillis;
            this.dyI = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.dyI;
    }

    public String uC(String str) {
        try {
            String host = new URL(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                return UtilHelper.getIpFromDomain(host);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    public String uD(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dyH > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dyH = currentTimeMillis;
            this.dyJ = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.dyJ;
        }
        return this.dyJ;
    }
}
