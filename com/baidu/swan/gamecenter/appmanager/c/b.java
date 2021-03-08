package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class b {
    private String drB;
    private String edj;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.edj = str;
        this.drB = str2;
        this.mStatus = i;
    }

    public boolean aTD() {
        return TextUtils.equals(this.edj, "onSuccess");
    }

    public String aTE() {
        return this.edj;
    }

    public String getResult() {
        return this.drB;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
