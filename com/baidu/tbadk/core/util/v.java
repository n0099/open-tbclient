package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v emc;
    private long elX = 0;
    private long elY = 0;
    private String elZ = "";
    private String ema = "";
    private final long emb = 120000;

    public static v bjG() {
        if (emc == null) {
            synchronized (v.class) {
                if (emc == null) {
                    emc = new v();
                }
            }
        }
        return emc;
    }

    public String bjH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.elX > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.elX = currentTimeMillis;
            this.elZ = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.elZ;
    }

    public String Au(String str) {
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

    public String Av(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.elY > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.elY = currentTimeMillis;
            this.ema = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.ema;
        }
        return this.ema;
    }
}
