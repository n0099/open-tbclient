package com.baidu.live.tbadk.core.atomdata;
/* loaded from: classes11.dex */
public class BDxdConfig {
    public static final String EXTRA_BDXD = "bdxd";
    private static final BDxdConfig con = new BDxdConfig();
    private String mBdxd;

    private BDxdConfig() {
    }

    public static BDxdConfig getIns() {
        return con;
    }

    public void setBdxd(String str) {
        this.mBdxd = str;
    }

    public String getBdxd() {
        return this.mBdxd;
    }

    public void clearConfig() {
        this.mBdxd = null;
    }
}
