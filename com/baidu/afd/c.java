package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Aa;
    private final int Ab;
    private final int Ac;
    private final String Ae;
    private int Af;
    private HashMap Ag;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Aa = i;
        this.Ab = i2;
        this.Ac = i3;
        this.Ae = str;
        this.tabName = str2;
        this.Af = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int jY() {
        return this.Aa;
    }

    @Override // com.baidu.afd.g
    public int jZ() {
        return this.Ab;
    }

    @Override // com.baidu.afd.g
    public int ka() {
        return this.Af;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> kb() {
        return this.Ag;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.Ag = hashMap;
    }
}
