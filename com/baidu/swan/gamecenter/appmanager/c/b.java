package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class b {
    private String dOs;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dOs = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aRI() {
        return TextUtils.equals(this.dOs, "onSuccess");
    }

    public String aRJ() {
        return this.dOs;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
