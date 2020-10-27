package com.baidu.swan.pms.model;
/* loaded from: classes15.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aYT() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aYU() {
        return aYT() - this.updateTime > this.maxAge;
    }
}
