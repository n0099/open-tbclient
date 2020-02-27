package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Df;
    private final int Dg;
    private final int Dh;
    private final String Di;
    private int Dj;
    private HashMap Dk;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Df = i;
        this.Dg = i2;
        this.Dh = i3;
        this.Di = str;
        this.tabName = str2;
        this.Dj = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int kF() {
        return this.Df;
    }

    @Override // com.baidu.afd.g
    public int kG() {
        return this.Dg;
    }

    @Override // com.baidu.afd.g
    public int kH() {
        return this.Dj;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> kI() {
        return this.Dk;
    }

    @Override // com.baidu.afd.g
    public void j(HashMap hashMap) {
        this.Dk = hashMap;
    }
}
