package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Rf;
    private final int Rg;
    private final int Rh;
    private final String Ri;
    private int Rj;
    private HashMap Rk;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Rf = i;
        this.Rg = i2;
        this.Rh = i3;
        this.Ri = str;
        this.tabName = str2;
        this.Rj = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pc() {
        return this.Rf;
    }

    @Override // com.baidu.afd.g
    public int pd() {
        return this.Rg;
    }

    @Override // com.baidu.afd.g
    public int pe() {
        return this.Rj;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pf() {
        return this.Rk;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.Rk = hashMap;
    }
}
