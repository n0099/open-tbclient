package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int CF;
    private final int CG;
    private final int CH;
    private final String CI;
    private int CJ;
    private HashMap CK;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.CF = i;
        this.CG = i2;
        this.CH = i3;
        this.CI = str;
        this.tabName = str2;
        this.CJ = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int kp() {
        return this.CF;
    }

    @Override // com.baidu.afd.g
    public int kq() {
        return this.CG;
    }

    @Override // com.baidu.afd.g
    public int kr() {
        return this.CJ;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ks() {
        return this.CK;
    }

    @Override // com.baidu.afd.g
    public void j(HashMap hashMap) {
        this.CK = hashMap;
    }
}
