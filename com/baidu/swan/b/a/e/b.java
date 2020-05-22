package com.baidu.swan.b.a.e;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class b {
    private String cSZ;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.cSZ = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean axc() {
        return TextUtils.equals(this.cSZ, "onSuccess");
    }

    public String axd() {
        return this.cSZ;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
