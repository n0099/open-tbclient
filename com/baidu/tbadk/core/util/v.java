package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eLx;
    private long eLs = 0;
    private long eLt = 0;
    private String eLu = "";
    private String eLv = "";
    private final long eLw = 120000;

    public static v bpV() {
        if (eLx == null) {
            synchronized (v.class) {
                if (eLx == null) {
                    eLx = new v();
                }
            }
        }
        return eLx;
    }

    public String bpW() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eLs > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eLs = currentTimeMillis;
            this.eLu = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eLu;
    }

    public String Bm(String str) {
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

    public String Bn(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eLt > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eLt = currentTimeMillis;
            this.eLv = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eLv;
        }
        return this.eLv;
    }
}
