package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Tc;
    private final int Td;
    private final int Te;
    private final String Tf;
    private HashMap Tg;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Tc = i;
        this.Td = i2;
        this.Te = i3;
        this.Tf = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pM() {
        return this.Tc;
    }

    @Override // com.baidu.afd.g
    public int pN() {
        return this.Td;
    }

    @Override // com.baidu.afd.g
    public int pO() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pP() {
        return this.Tg;
    }

    @Override // com.baidu.afd.g
    public void l(HashMap hashMap) {
        this.Tg = hashMap;
    }
}
