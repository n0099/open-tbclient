package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aei;
    private long aed = 0;
    private long aee = 0;
    private String aef = "";
    private String aeg = "";
    private final long aeh = 120000;

    public static v uw() {
        if (aei == null) {
            synchronized (v.class) {
                if (aei == null) {
                    aei = new v();
                }
            }
        }
        return aei;
    }

    public String ux() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aed > 120000) {
            if (com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.aed = currentTimeMillis;
            this.aef = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aef;
    }

    public String dk(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aee > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.aee = currentTimeMillis;
            this.aeg = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeg;
        }
        return this.aeg;
    }
}
