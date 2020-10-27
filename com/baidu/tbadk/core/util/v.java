package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eGJ;
    private long eGE = 0;
    private long eGF = 0;
    private String eGG = "";
    private String eGH = "";
    private final long eGI = 120000;

    public static v boi() {
        if (eGJ == null) {
            synchronized (v.class) {
                if (eGJ == null) {
                    eGJ = new v();
                }
            }
        }
        return eGJ;
    }

    public String boj() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eGE > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eGE = currentTimeMillis;
            this.eGG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eGG;
    }

    public String Bz(String str) {
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

    public String BA(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eGF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eGF = currentTimeMillis;
            this.eGH = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eGH;
        }
        return this.eGH;
    }
}
