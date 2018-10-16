package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t awy;
    private long awt = 0;
    private long awu = 0;
    private String awv = "";
    private String aww = "";
    private final long awx = 120000;

    public static t BP() {
        if (awy == null) {
            synchronized (t.class) {
                if (awy == null) {
                    awy = new t();
                }
            }
        }
        return awy;
    }

    public String BQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.awt > 120000) {
            if (com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.awt = currentTimeMillis;
            this.awv = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.awv;
    }

    public String fe(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.awu > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.awu = currentTimeMillis;
            this.aww = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aww;
        }
        return this.aww;
    }
}
