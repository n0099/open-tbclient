package com.baidu.adp.lib.a;
/* loaded from: classes.dex */
public enum e {
    PENDING,
    RUNNING,
    FINISHED;

    /* JADX DEBUG: Replace access to removed values field (d) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] valuesCustom = values();
        int length = valuesCustom.length;
        e[] eVarArr = new e[length];
        System.arraycopy(valuesCustom, 0, eVarArr, 0, length);
        return eVarArr;
    }
}
