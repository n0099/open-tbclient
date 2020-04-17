package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int WA;
    private final int WB;
    private final int WC;
    private final String WD;
    private int WE;
    private HashMap WF;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.WA = i;
        this.WB = i2;
        this.WC = i3;
        this.WD = str;
        this.tabName = str2;
        this.WE = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pj() {
        return this.WA;
    }

    @Override // com.baidu.afd.g
    public int pk() {
        return this.WB;
    }

    @Override // com.baidu.afd.g
    public int pl() {
        return this.WE;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pm() {
        return this.WF;
    }

    @Override // com.baidu.afd.g
    public void w(HashMap hashMap) {
        this.WF = hashMap;
    }
}
