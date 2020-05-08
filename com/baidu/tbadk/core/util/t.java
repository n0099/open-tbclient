package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t dyP;
    private long dyK = 0;
    private long dyL = 0;
    private String dyM = "";
    private String dyN = "";
    private final long dyO = 120000;

    public static t aOr() {
        if (dyP == null) {
            synchronized (t.class) {
                if (dyP == null) {
                    dyP = new t();
                }
            }
        }
        return dyP;
    }

    public String aOs() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dyK > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dyK = currentTimeMillis;
            this.dyM = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.dyM;
    }

    public String uF(String str) {
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

    public String uG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dyL > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dyL = currentTimeMillis;
            this.dyN = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.dyN;
        }
        return this.dyN;
    }
}
