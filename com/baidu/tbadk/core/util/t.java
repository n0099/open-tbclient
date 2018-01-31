package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aUo;
    private long aUj = 0;
    private long aUk = 0;
    private String aUl = "";
    private String aUm = "";
    private final long aUn = 120000;

    public static t BX() {
        if (aUo == null) {
            synchronized (t.class) {
                if (aUo == null) {
                    aUo = new t();
                }
            }
        }
        return aUo;
    }

    public String BY() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUj > 120000) {
            if (com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aUj = currentTimeMillis;
            this.aUl = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aUl;
    }

    public String dS(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUk > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aUk = currentTimeMillis;
            this.aUm = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aUm;
        }
        return this.aUm;
    }
}
