package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class b {
    private String dQa;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dQa = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aSq() {
        return TextUtils.equals(this.dQa, "onSuccess");
    }

    public String aSr() {
        return this.dQa;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
