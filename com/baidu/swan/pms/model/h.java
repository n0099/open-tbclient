package com.baidu.swan.pms.model;
/* loaded from: classes11.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aBW() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aBX() {
        return aBW() - this.updateTime > this.maxAge;
    }
}
