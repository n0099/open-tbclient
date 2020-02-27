package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cjw;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cjw = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean ald() {
        return TextUtils.equals(this.cjw, "onSuccess");
    }

    public String getFunctionType() {
        return this.cjw;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
