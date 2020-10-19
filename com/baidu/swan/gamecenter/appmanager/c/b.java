package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class b {
    private String dBL;
    private String mResult;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dBL = str;
        this.mResult = str2;
        this.mStatus = i;
    }

    public boolean aNW() {
        return TextUtils.equals(this.dBL, "onSuccess");
    }

    public String aNX() {
        return this.dBL;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
