package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class b {
    private String cfs;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cfs = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aiP() {
        return TextUtils.equals(this.cfs, "onSuccess");
    }

    public String getFunctionType() {
        return this.cfs;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
