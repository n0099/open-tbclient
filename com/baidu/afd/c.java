package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int QN;
    private final int QO;
    private final int QP;
    private final String QR;
    private int QS;
    private HashMap QT;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.QN = i;
        this.QO = i2;
        this.QP = i3;
        this.QR = str;
        this.tabName = str2;
        this.QS = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int oH() {
        return this.QN;
    }

    @Override // com.baidu.afd.g
    public int oI() {
        return this.QO;
    }

    @Override // com.baidu.afd.g
    public int oJ() {
        return this.QS;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> oK() {
        return this.QT;
    }

    @Override // com.baidu.afd.g
    public void k(HashMap hashMap) {
        this.QT = hashMap;
    }
}
