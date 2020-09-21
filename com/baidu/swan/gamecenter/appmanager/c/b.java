package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class b {
    private String dpH;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dpH = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aLn() {
        return TextUtils.equals(this.dpH, "onSuccess");
    }

    public String aLo() {
        return this.dpH;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
