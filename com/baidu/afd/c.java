package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Rs;
    private final int Rt;
    private final int Ru;
    private final String Rv;
    private HashMap Rw;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Rs = i;
        this.Rt = i2;
        this.Ru = i3;
        this.Rv = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pk() {
        return this.Rs;
    }

    @Override // com.baidu.afd.g
    public int pl() {
        return this.Rt;
    }

    @Override // com.baidu.afd.g
    public int pm() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pn() {
        return this.Rw;
    }

    @Override // com.baidu.afd.g
    public void m(HashMap hashMap) {
        this.Rw = hashMap;
    }
}
