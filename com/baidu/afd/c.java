package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int OR;
    private final int OT;
    private final int OU;
    private final String OV;
    private HashMap OW;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.OR = i;
        this.OT = i2;
        this.OU = i3;
        this.OV = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int of() {
        return this.OR;
    }

    @Override // com.baidu.afd.g
    public int og() {
        return this.OT;
    }

    @Override // com.baidu.afd.g
    public int oh() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> oi() {
        return this.OW;
    }

    @Override // com.baidu.afd.g
    public void h(HashMap hashMap) {
        this.OW = hashMap;
    }
}
