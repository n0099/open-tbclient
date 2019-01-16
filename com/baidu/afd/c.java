package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int RV;
    private final int RW;
    private final int RX;
    private final String RY;
    private HashMap RZ;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.RV = i;
        this.RW = i2;
        this.RX = i3;
        this.RY = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pt() {
        return this.RV;
    }

    @Override // com.baidu.afd.g
    public int pu() {
        return this.RW;
    }

    @Override // com.baidu.afd.g
    public int pv() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pw() {
        return this.RZ;
    }

    @Override // com.baidu.afd.g
    public void m(HashMap hashMap) {
        this.RZ = hashMap;
    }
}
