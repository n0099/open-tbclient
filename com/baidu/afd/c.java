package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Xq;
    private final int Xr;
    private final int Xs;
    private HashMap Xt;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Xq = i;
        this.Xr = i2;
        this.Xs = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int pH() {
        return this.Xq;
    }

    @Override // com.baidu.afd.g
    public int pI() {
        return this.Xr;
    }

    @Override // com.baidu.afd.g
    public int pJ() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> pK() {
        return this.Xt;
    }

    @Override // com.baidu.afd.g
    public void w(HashMap hashMap) {
        this.Xt = hashMap;
        if (!this.Xt.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bmq());
        }
    }
}
