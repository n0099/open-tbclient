package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    private String dnF;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dnF = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aKC() {
        return TextUtils.equals(this.dnF, "onSuccess");
    }

    public String aKD() {
        return this.dnF;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
