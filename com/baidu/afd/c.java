package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private int XA;
    private HashMap XB;
    private final int Xx;
    private final int Xy;
    private final int Xz;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Xx = i;
        this.Xy = i2;
        this.Xz = i3;
        this.tabId = str;
        this.tabName = str2;
        this.XA = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pG() {
        return this.Xx;
    }

    @Override // com.baidu.afd.g
    public int pH() {
        return this.Xy;
    }

    @Override // com.baidu.afd.g
    public int pI() {
        return this.XA;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pJ() {
        return this.XB;
    }

    @Override // com.baidu.afd.g
    public void w(HashMap hashMap) {
        this.XB = hashMap;
    }
}
