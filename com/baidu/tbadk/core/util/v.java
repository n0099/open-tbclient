package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v ead;
    private long dZY = 0;
    private long dZZ = 0;
    private String eaa = "";
    private String eab = "";
    private final long eac = 120000;

    public static v baq() {
        if (ead == null) {
            synchronized (v.class) {
                if (ead == null) {
                    ead = new v();
                }
            }
        }
        return ead;
    }

    public String bar() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dZY > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dZY = currentTimeMillis;
            this.eaa = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eaa;
    }

    public String xJ(String str) {
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

    public String xK(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dZZ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dZZ = currentTimeMillis;
            this.eab = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eab;
        }
        return this.eab;
    }
}
