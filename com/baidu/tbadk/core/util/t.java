package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aUm;
    private long aUh = 0;
    private long aUi = 0;
    private String aUj = "";
    private String aUk = "";
    private final long aUl = 120000;

    public static t Ce() {
        if (aUm == null) {
            synchronized (t.class) {
                if (aUm == null) {
                    aUm = new t();
                }
            }
        }
        return aUm;
    }

    public String Cf() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUh > 120000) {
            if (com.baidu.adp.lib.util.l.oY()) {
                return "";
            }
            this.aUh = currentTimeMillis;
            this.aUj = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aUj;
    }

    public String dN(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUi > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oY()) {
                return "";
            }
            this.aUi = currentTimeMillis;
            this.aUk = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aUk;
        }
        return this.aUk;
    }
}
