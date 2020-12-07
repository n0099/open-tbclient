package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eSJ;
    private long eSE = 0;
    private long eSF = 0;
    private String eSG = "";
    private String eSH = "";
    private final long eSI = 120000;

    public static v btq() {
        if (eSJ == null) {
            synchronized (v.class) {
                if (eSJ == null) {
                    eSJ = new v();
                }
            }
        }
        return eSJ;
    }

    public String btr() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eSE > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eSE = currentTimeMillis;
            this.eSG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eSG;
    }

    public String BT(String str) {
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

    public String BU(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eSF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eSF = currentTimeMillis;
            this.eSH = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eSH;
        }
        return this.eSH;
    }
}
