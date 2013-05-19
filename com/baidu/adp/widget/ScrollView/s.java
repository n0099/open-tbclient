package com.baidu.adp.widget.ScrollView;
/* loaded from: classes.dex */
public enum s {
    RESET(0),
    PULL_TO_REFRESH(1),
    RELEASE_TO_REFRESH(2),
    REFRESHING(8),
    MANUAL_REFRESHING(9),
    OVERSCROLLING(16);
    
    private int g;

    /* JADX DEBUG: Replace access to removed values field (h) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static s[] valuesCustom() {
        s[] valuesCustom = values();
        int length = valuesCustom.length;
        s[] sVarArr = new s[length];
        System.arraycopy(valuesCustom, 0, sVarArr, 0, length);
        return sVarArr;
    }

    s(int i) {
        this.g = i;
    }
}
