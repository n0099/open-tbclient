package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cjJ;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cjJ = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean ali() {
        return TextUtils.equals(this.cjJ, "onSuccess");
    }

    public String getFunctionType() {
        return this.cjJ;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
