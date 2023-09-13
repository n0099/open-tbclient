package com.baidu.cyberplayer.sdk.statistics;
/* loaded from: classes3.dex */
public class DpStatItem {
    public int mActionType;
    public String mKey;
    public String mValue;

    public DpStatItem(int i, String str, long j) {
        this.mActionType = i;
        this.mKey = str;
        this.mValue = Long.toString(j);
    }

    public DpStatItem(int i, String str, String str2) {
        this.mActionType = i;
        this.mKey = str;
        this.mValue = str2;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getType() {
        return this.mActionType;
    }

    public String getValue() {
        return this.mValue;
    }
}
