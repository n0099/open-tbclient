package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int OU;
    private final int OV;
    private final int OW;
    private final String OX;
    private HashMap OY;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.OU = i;
        this.OV = i2;
        this.OW = i3;
        this.OX = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int of() {
        return this.OU;
    }

    @Override // com.baidu.afd.g
    public int og() {
        return this.OV;
    }

    @Override // com.baidu.afd.g
    public int oh() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> oi() {
        return this.OY;
    }

    @Override // com.baidu.afd.g
    public void h(HashMap hashMap) {
        this.OY = hashMap;
    }
}
