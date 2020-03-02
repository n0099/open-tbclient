package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cjx;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cjx = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean alf() {
        return TextUtils.equals(this.cjx, "onSuccess");
    }

    public String getFunctionType() {
        return this.cjx;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
