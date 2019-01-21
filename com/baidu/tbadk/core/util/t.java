package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aBo;
    private long aBj = 0;
    private long aBk = 0;
    private String aBl = "";
    private String aBm = "";
    private final long aBn = 120000;

    public static t Dn() {
        if (aBo == null) {
            synchronized (t.class) {
                if (aBo == null) {
                    aBo = new t();
                }
            }
        }
        return aBo;
    }

    public String Do() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aBj > 120000) {
            if (com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aBj = currentTimeMillis;
            this.aBl = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aBl;
    }

    public String fJ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aBk > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aBk = currentTimeMillis;
            this.aBm = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aBm;
        }
        return this.aBm;
    }
}
