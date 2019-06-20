package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int QM;
    private final int QN;
    private final int QO;
    private final String QP;
    private int QR;
    private HashMap QS;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.QM = i;
        this.QN = i2;
        this.QO = i3;
        this.QP = str;
        this.tabName = str2;
        this.QR = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int oH() {
        return this.QM;
    }

    @Override // com.baidu.afd.g
    public int oI() {
        return this.QN;
    }

    @Override // com.baidu.afd.g
    public int oJ() {
        return this.QR;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> oK() {
        return this.QS;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.QS = hashMap;
    }
}
