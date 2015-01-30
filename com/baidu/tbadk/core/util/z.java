package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class z {
    private static z Is;
    private long In = 0;
    private long Io = 0;
    private String Ip = "";
    private String Iq = "";
    private final long Ir = 120000;

    public static z oR() {
        if (Is == null) {
            synchronized (z.class) {
                if (Is == null) {
                    Is = new z();
                }
            }
        }
        return Is;
    }

    public String oS() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.In > 120000) {
            if (com.baidu.adp.lib.util.l.ft()) {
                return "";
            }
            this.In = currentTimeMillis;
            this.Ip = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.Ip;
    }

    public String cv(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Io > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ft()) {
                return "";
            }
            this.Io = currentTimeMillis;
            this.Iq = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.Iq;
        }
        return this.Iq;
    }
}
