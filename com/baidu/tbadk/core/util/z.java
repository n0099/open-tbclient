package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class z {
    private static z Ij;
    private long Ie = 0;
    private long If = 0;
    private String Ig = "";
    private String Ih = "";
    private final long Ii = 120000;

    public static z oO() {
        if (Ij == null) {
            synchronized (z.class) {
                if (Ij == null) {
                    Ij = new z();
                }
            }
        }
        return Ij;
    }

    public String oP() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Ie > 120000) {
            if (com.baidu.adp.lib.util.l.fu()) {
                return "";
            }
            this.Ie = currentTimeMillis;
            this.Ig = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.Ig;
    }

    public String cx(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.If > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.fu()) {
                return "";
            }
            this.If = currentTimeMillis;
            this.Ih = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.Ih;
        }
        return this.Ih;
    }
}
