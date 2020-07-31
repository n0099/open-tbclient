package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes20.dex */
public class b {
    private String dds;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dds = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aBN() {
        return TextUtils.equals(this.dds, "onSuccess");
    }

    public String aBO() {
        return this.dds;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
