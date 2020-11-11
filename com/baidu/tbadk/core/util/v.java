package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eMy;
    private long eMt = 0;
    private long eMu = 0;
    private String eMv = "";
    private String eMw = "";
    private final long eMx = 120000;

    public static v bqI() {
        if (eMy == null) {
            synchronized (v.class) {
                if (eMy == null) {
                    eMy = new v();
                }
            }
        }
        return eMy;
    }

    public String bqJ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eMt > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eMt = currentTimeMillis;
            this.eMv = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eMv;
    }

    public String BN(String str) {
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

    public String BO(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eMu > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eMu = currentTimeMillis;
            this.eMw = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eMw;
        }
        return this.eMw;
    }
}
