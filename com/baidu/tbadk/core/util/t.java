package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aUl;
    private long aUg = 0;
    private long aUh = 0;
    private String aUi = "";
    private String aUj = "";
    private final long aUk = 120000;

    public static t BW() {
        if (aUl == null) {
            synchronized (t.class) {
                if (aUl == null) {
                    aUl = new t();
                }
            }
        }
        return aUl;
    }

    public String BX() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUg > 120000) {
            if (com.baidu.adp.lib.util.l.oY()) {
                return "";
            }
            this.aUg = currentTimeMillis;
            this.aUi = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aUi;
    }

    public String dN(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUh > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oY()) {
                return "";
            }
            this.aUh = currentTimeMillis;
            this.aUj = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aUj;
        }
        return this.aUj;
    }
}
