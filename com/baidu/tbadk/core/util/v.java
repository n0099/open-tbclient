package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aeJ;
    private long aeE = 0;
    private long aeF = 0;
    private String aeG = "";
    private String aeH = "";
    private final long aeI = 120000;

    public static v uQ() {
        if (aeJ == null) {
            synchronized (v.class) {
                if (aeJ == null) {
                    aeJ = new v();
                }
            }
        }
        return aeJ;
    }

    public String uR() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeE > 120000) {
            if (com.baidu.adp.lib.util.k.hu()) {
                return "";
            }
            this.aeE = currentTimeMillis;
            this.aeG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aeG;
    }

    public String di(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hu()) {
                return "";
            }
            this.aeF = currentTimeMillis;
            this.aeH = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeH;
        }
        return this.aeH;
    }
}
