package com.baidu.swan.pms.model;
/* loaded from: classes11.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long atJ() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean atK() {
        return atJ() - this.updateTime > this.maxAge;
    }
}
