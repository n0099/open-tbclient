package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class z {
    private static z Ip;
    private long Ik = 0;
    private long Il = 0;
    private String Im = "";
    private String In = "";
    private final long Io = 120000;

    public static z oK() {
        if (Ip == null) {
            synchronized (z.class) {
                if (Ip == null) {
                    Ip = new z();
                }
            }
        }
        return Ip;
    }

    public String oL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Ik > 120000) {
            if (com.baidu.adp.lib.util.l.ft()) {
                return "";
            }
            this.Ik = currentTimeMillis;
            this.Im = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.Im;
    }

    public String cs(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Il > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ft()) {
                return "";
            }
            this.Il = currentTimeMillis;
            this.In = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.In;
        }
        return this.In;
    }
}
