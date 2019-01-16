package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aBn;
    private long aBi = 0;
    private long aBj = 0;
    private String aBk = "";
    private String aBl = "";
    private final long aBm = 120000;

    public static t Dn() {
        if (aBn == null) {
            synchronized (t.class) {
                if (aBn == null) {
                    aBn = new t();
                }
            }
        }
        return aBn;
    }

    public String Do() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aBi > 120000) {
            if (com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aBi = currentTimeMillis;
            this.aBk = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aBk;
    }

    public String fJ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aBj > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aBj = currentTimeMillis;
            this.aBl = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aBl;
        }
        return this.aBl;
    }
}
