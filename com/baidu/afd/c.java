package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Td;
    private final int Te;
    private final int Tf;
    private final String Tg;
    private HashMap Th;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Td = i;
        this.Te = i2;
        this.Tf = i3;
        this.Tg = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pM() {
        return this.Td;
    }

    @Override // com.baidu.afd.g
    public int pN() {
        return this.Te;
    }

    @Override // com.baidu.afd.g
    public int pO() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pP() {
        return this.Th;
    }

    @Override // com.baidu.afd.g
    public void l(HashMap hashMap) {
        this.Th = hashMap;
    }
}
