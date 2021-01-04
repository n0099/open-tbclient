package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class u {
    private static u fck;
    private long fcf = 0;
    private long fcg = 0;
    private String fch = "";
    private String fci = "";
    private final long fcj = 120000;

    public static u bvL() {
        if (fck == null) {
            synchronized (u.class) {
                if (fck == null) {
                    fck = new u();
                }
            }
        }
        return fck;
    }

    public String bvM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.fcf > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.fcf = currentTimeMillis;
            this.fch = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.fch;
    }

    public String BS(String str) {
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

    public String BT(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.fcg > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.fcg = currentTimeMillis;
            this.fci = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.fci;
        }
        return this.fci;
    }
}
