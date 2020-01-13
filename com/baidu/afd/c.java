package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int CK;
    private final int CL;
    private final int CM;
    private final String CN;
    private int CO;
    private HashMap CP;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.CK = i;
        this.CL = i2;
        this.CM = i3;
        this.CN = str;
        this.tabName = str2;
        this.CO = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int kq() {
        return this.CK;
    }

    @Override // com.baidu.afd.g
    public int kr() {
        return this.CL;
    }

    @Override // com.baidu.afd.g
    public int ks() {
        return this.CO;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> kt() {
        return this.CP;
    }

    @Override // com.baidu.afd.g
    public void j(HashMap hashMap) {
        this.CP = hashMap;
    }
}
