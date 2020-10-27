package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class b {
    private String dKi;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dKi = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aPQ() {
        return TextUtils.equals(this.dKi, "onSuccess");
    }

    public String aPR() {
        return this.dKi;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
