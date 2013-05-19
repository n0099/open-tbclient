package com.baidu.adp.lib.a;
/* loaded from: classes.dex */
public enum o {
    SERIAL,
    TWO_PARALLEL,
    THREE_PARALLEL,
    FOUR_PARALLEL,
    MAX_PARALLEL;

    /* JADX DEBUG: Replace access to removed values field (f) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static o[] valuesCustom() {
        o[] valuesCustom = values();
        int length = valuesCustom.length;
        o[] oVarArr = new o[length];
        System.arraycopy(valuesCustom, 0, oVarArr, 0, length);
        return oVarArr;
    }
}
