package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int RJ;
    private final int RK;
    private final int RL;
    private final String RO;
    private HashMap RP;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.RJ = i;
        this.RK = i2;
        this.RL = i3;
        this.RO = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pq() {
        return this.RJ;
    }

    @Override // com.baidu.afd.g
    public int pr() {
        return this.RK;
    }

    @Override // com.baidu.afd.g
    public int ps() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pt() {
        return this.RP;
    }

    @Override // com.baidu.afd.g
    public void m(HashMap hashMap) {
        this.RP = hashMap;
    }
}
