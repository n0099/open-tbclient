package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class b {
    private String dpZ;
    private String ebI;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.ebI = str;
        this.dpZ = str2;
        this.mStatus = i;
    }

    public boolean aTA() {
        return TextUtils.equals(this.ebI, "onSuccess");
    }

    public String aTB() {
        return this.ebI;
    }

    public String getResult() {
        return this.dpZ;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
