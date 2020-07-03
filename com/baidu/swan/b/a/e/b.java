package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cXJ;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cXJ = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean ayi() {
        return TextUtils.equals(this.cXJ, "onSuccess");
    }

    public String ayj() {
        return this.cXJ;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
