package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t afy;
    private long aft = 0;
    private long afu = 0;
    private String afv = "";
    private String afw = "";
    private final long afx = 120000;

    public static t uE() {
        if (afy == null) {
            synchronized (t.class) {
                if (afy == null) {
                    afy = new t();
                }
            }
        }
        return afy;
    }

    public String uF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aft > 120000) {
            if (com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.aft = currentTimeMillis;
            this.afv = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afv;
    }

    public String dB(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afu > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afu = currentTimeMillis;
            this.afw = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afw;
        }
        return this.afw;
    }
}
