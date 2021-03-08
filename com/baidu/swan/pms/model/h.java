package com.baidu.swan.pms.model;
/* loaded from: classes3.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long bcJ() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean bcK() {
        return bcJ() - this.updateTime > this.maxAge;
    }
}
