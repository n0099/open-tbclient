package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class b {
    private String bCk;
    private String cff;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cff = str;
        this.bCk = str2;
        this.mStatus = i;
    }

    public boolean aiw() {
        return TextUtils.equals(this.cff, "onSuccess");
    }

    public String getFunctionType() {
        return this.cff;
    }

    public String getResult() {
        return this.bCk;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
