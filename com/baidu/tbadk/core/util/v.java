package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v fbq;
    private long fbl = 0;
    private long fbm = 0;
    private String fbn = "";
    private String fbo = "";
    private final long fbp = 120000;

    public static v bsp() {
        if (fbq == null) {
            synchronized (v.class) {
                if (fbq == null) {
                    fbq = new v();
                }
            }
        }
        return fbq;
    }

    public String bsq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.fbl > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.fbl = currentTimeMillis;
            this.fbn = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.fbn;
    }

    public String Be(String str) {
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

    public String Bf(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.fbm > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.fbm = currentTimeMillis;
            this.fbo = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.fbo;
        }
        return this.fbo;
    }
}
