package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t axl;
    private long axg = 0;
    private long axh = 0;
    private String axi = "";
    private String axj = "";
    private final long axk = 120000;

    public static t BW() {
        if (axl == null) {
            synchronized (t.class) {
                if (axl == null) {
                    axl = new t();
                }
            }
        }
        return axl;
    }

    public String BX() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.axg > 120000) {
            if (com.baidu.adp.lib.util.l.ll()) {
                return "";
            }
            this.axg = currentTimeMillis;
            this.axi = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.axi;
    }

    public String fe(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.axh > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ll()) {
                return "";
            }
            this.axh = currentTimeMillis;
            this.axj = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.axj;
        }
        return this.axj;
    }
}
