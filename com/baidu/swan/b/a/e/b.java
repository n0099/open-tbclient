package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cIK;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cIK = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean atv() {
        return TextUtils.equals(this.cIK, "onSuccess");
    }

    public String atw() {
        return this.cIK;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
