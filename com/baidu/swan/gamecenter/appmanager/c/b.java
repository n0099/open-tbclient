package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    private String dZB;
    private String dnM;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.dZB = str;
        this.dnM = str2;
        this.mStatus = i;
    }

    public boolean aTo() {
        return TextUtils.equals(this.dZB, "onSuccess");
    }

    public String aTp() {
        return this.dZB;
    }

    public String getResult() {
        return this.dnM;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
