package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Re;
    private final int Rf;
    private final int Rg;
    private final String Rh;
    private int Ri;
    private HashMap Rj;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Re = i;
        this.Rf = i2;
        this.Rg = i3;
        this.Rh = str;
        this.tabName = str2;
        this.Ri = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pd() {
        return this.Re;
    }

    @Override // com.baidu.afd.g
    public int pe() {
        return this.Rf;
    }

    @Override // com.baidu.afd.g
    public int pf() {
        return this.Ri;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pg() {
        return this.Rj;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.Rj = hashMap;
    }
}
