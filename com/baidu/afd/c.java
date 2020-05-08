package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int WD;
    private final int WE;
    private final int WF;
    private final String WG;
    private int WH;
    private HashMap WI;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.WD = i;
        this.WE = i2;
        this.WF = i3;
        this.WG = str;
        this.tabName = str2;
        this.WH = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pj() {
        return this.WD;
    }

    @Override // com.baidu.afd.g
    public int pk() {
        return this.WE;
    }

    @Override // com.baidu.afd.g
    public int pl() {
        return this.WH;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pm() {
        return this.WI;
    }

    @Override // com.baidu.afd.g
    public void w(HashMap hashMap) {
        this.WI = hashMap;
    }
}
