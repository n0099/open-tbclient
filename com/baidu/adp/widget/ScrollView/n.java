package com.baidu.adp.widget.ScrollView;
/* loaded from: classes.dex */
public enum n {
    DISABLED(0),
    PULL_FROM_START(1),
    PULL_FROM_END(2),
    BOTH(3),
    MANUAL_REFRESH_ONLY(4);
    
    private int f;

    /* JADX DEBUG: Replace access to removed values field (g) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static n[] valuesCustom() {
        n[] valuesCustom = values();
        int length = valuesCustom.length;
        n[] nVarArr = new n[length];
        System.arraycopy(valuesCustom, 0, nVarArr, 0, length);
        return nVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(int i) {
        n[] valuesCustom;
        for (n nVar : valuesCustom()) {
            if (i == nVar.e()) {
                return nVar;
            }
        }
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a() {
        return PULL_FROM_START;
    }

    n(int i) {
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
    }

    public boolean c() {
        return this == PULL_FROM_START || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }

    public boolean d() {
        return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
    }

    int e() {
        return this.f;
    }
}
