package com.baidu.swan.pms.model;
/* loaded from: classes6.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long bgn() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean bgo() {
        return bgn() - this.updateTime > this.maxAge;
    }
}
