package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class z {
    private static z f;
    private long a = 0;
    private long b = 0;
    private String c = "";
    private String d = "";
    private final long e = 120000;

    public static z a() {
        if (f == null) {
            synchronized (z.class) {
                if (f == null) {
                    f = new z();
                }
            }
        }
        return f;
    }

    public String b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.a > 120000) {
            this.a = currentTimeMillis;
            this.c = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.c;
    }

    public String a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > 120000) {
            this.b = currentTimeMillis;
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf > 0) {
                return UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            }
            return "";
        }
        return this.d;
    }
}
