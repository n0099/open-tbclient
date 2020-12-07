package com.baidu.swan.pms.model;
/* loaded from: classes6.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long bdR() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean bdS() {
        return bdR() - this.updateTime > this.maxAge;
    }
}
