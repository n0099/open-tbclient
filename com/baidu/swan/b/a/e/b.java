package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cjy;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cjy = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean alf() {
        return TextUtils.equals(this.cjy, "onSuccess");
    }

    public String getFunctionType() {
        return this.cjy;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
