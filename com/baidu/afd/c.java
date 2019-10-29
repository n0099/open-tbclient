package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int AB;
    private final int AC;
    private final int AD;
    private final String AE;
    private int AF;
    private HashMap AG;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.AB = i;
        this.AC = i2;
        this.AD = i3;
        this.AE = str;
        this.tabName = str2;
        this.AF = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int jY() {
        return this.AB;
    }

    @Override // com.baidu.afd.g
    public int jZ() {
        return this.AC;
    }

    @Override // com.baidu.afd.g
    public int ka() {
        return this.AF;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> kb() {
        return this.AG;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.AG = hashMap;
    }
}
