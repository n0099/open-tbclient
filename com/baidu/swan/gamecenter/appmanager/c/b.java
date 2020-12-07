package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class b {
    private String dVq;
    private String dnD;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dVq = str;
        this.dnD = str2;
        this.mStatus = i;
    }

    public boolean aUN() {
        return TextUtils.equals(this.dVq, "onSuccess");
    }

    public String aUO() {
        return this.dVq;
    }

    public String getResult() {
        return this.dnD;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
