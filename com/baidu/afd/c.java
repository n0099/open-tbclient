package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int WR;
    private final int WS;
    private final int WT;
    private final String WU;
    private int WV;
    private HashMap WW;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.WR = i;
        this.WS = i2;
        this.WT = i3;
        this.WU = str;
        this.tabName = str2;
        this.WV = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pp() {
        return this.WR;
    }

    @Override // com.baidu.afd.g
    public int pq() {
        return this.WS;
    }

    @Override // com.baidu.afd.g
    public int pr() {
        return this.WV;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ps() {
        return this.WW;
    }

    @Override // com.baidu.afd.g
    public void w(HashMap hashMap) {
        this.WW = hashMap;
    }
}
