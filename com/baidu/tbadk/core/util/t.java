package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t cim;
    private long cih = 0;
    private long cii = 0;
    private String cij = "";
    private String cik = "";
    private final long cil = 120000;

    public static t amk() {
        if (cim == null) {
            synchronized (t.class) {
                if (cim == null) {
                    cim = new t();
                }
            }
        }
        return cim;
    }

    public String aml() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cih > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cih = currentTimeMillis;
            this.cij = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cij;
    }

    public String nM(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cii > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cii = currentTimeMillis;
            this.cik = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cik;
        }
        return this.cik;
    }
}
