package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t cjd;
    private long ciY = 0;
    private long ciZ = 0;
    private String cja = "";
    private String cjb = "";
    private final long cjc = 120000;

    public static t amm() {
        if (cjd == null) {
            synchronized (t.class) {
                if (cjd == null) {
                    cjd = new t();
                }
            }
        }
        return cjd;
    }

    public String amn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ciY > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ciY = currentTimeMillis;
            this.cja = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cja;
    }

    public String nM(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ciZ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ciZ = currentTimeMillis;
            this.cjb = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cjb;
        }
        return this.cjb;
    }
}
