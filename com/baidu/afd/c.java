package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int RH;
    private final int RI;
    private final int RJ;
    private final String RK;
    private HashMap RL;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.RH = i;
        this.RI = i2;
        this.RJ = i3;
        this.RK = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int ps() {
        return this.RH;
    }

    @Override // com.baidu.afd.g
    public int pt() {
        return this.RI;
    }

    @Override // com.baidu.afd.g
    public int pu() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pv() {
        return this.RL;
    }

    @Override // com.baidu.afd.g
    public void m(HashMap hashMap) {
        this.RL = hashMap;
    }
}
