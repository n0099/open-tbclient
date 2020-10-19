package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eyn;
    private long eyh = 0;
    private long eyi = 0;
    private String eyj = "";
    private String eyk = "";
    private final long eyl = 120000;

    public static v bmp() {
        if (eyn == null) {
            synchronized (v.class) {
                if (eyn == null) {
                    eyn = new v();
                }
            }
        }
        return eyn;
    }

    public String bmq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eyh > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eyh = currentTimeMillis;
            this.eyj = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eyj;
    }

    public String Bg(String str) {
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

    public String Bh(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eyi > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eyi = currentTimeMillis;
            this.eyk = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eyk;
        }
        return this.eyk;
    }
}
