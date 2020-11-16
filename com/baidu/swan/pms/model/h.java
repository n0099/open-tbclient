package com.baidu.swan.pms.model;
/* loaded from: classes6.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long baM() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean baN() {
        return baM() - this.updateTime > this.maxAge;
    }
}
