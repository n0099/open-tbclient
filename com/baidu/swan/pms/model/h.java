package com.baidu.swan.pms.model;
/* loaded from: classes14.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aTF() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aTG() {
        return aTF() - this.updateTime > this.maxAge;
    }
}
