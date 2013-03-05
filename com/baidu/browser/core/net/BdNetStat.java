package com.baidu.browser.core.net;
/* loaded from: classes.dex */
public class BdNetStat {
    private static BdNetStat mStat;
    private String mNetmode = "no_net";
    private String mNetmodeExtra = "unknow";

    public static BdNetStat getInstance() {
        if (mStat == null) {
            mStat = new BdNetStat();
        }
        return mStat;
    }

    public String getNetmode() {
        return this.mNetmode;
    }

    public void setNetmode(String str) {
        this.mNetmode = str;
    }

    public String getNetmodeExtra() {
        return this.mNetmodeExtra;
    }

    public void setNetmodeExtra(String str) {
        this.mNetmodeExtra = str;
    }
}
