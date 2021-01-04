package com.baidu.swan.gamecenter.appmanager.c;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class b {
    private String dsD;
    private String een;
    private int mStatus;

    public b(String str, int i, String str2) {
        this.een = str;
        this.dsD = str2;
        this.mStatus = i;
    }

    public boolean aXh() {
        return TextUtils.equals(this.een, "onSuccess");
    }

    public String aXi() {
        return this.een;
    }

    public String getResult() {
        return this.dsD;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
