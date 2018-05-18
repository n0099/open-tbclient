package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int IF;
    private final int IG;
    private final int IH;
    private final String II;
    private HashMap IJ;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.IF = i;
        this.IG = i2;
        this.IH = i3;
        this.II = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int lp() {
        return this.IF;
    }

    @Override // com.baidu.afd.g
    public int lq() {
        return this.IG;
    }

    @Override // com.baidu.afd.g
    public int lr() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ls() {
        return this.IJ;
    }

    @Override // com.baidu.afd.g
    public void h(HashMap hashMap) {
        this.IJ = hashMap;
    }
}
