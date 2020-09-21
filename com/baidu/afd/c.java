package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int Yq;
    private final int Yr;
    private final int Ys;
    private HashMap Yt;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.Yq = i;
        this.Yr = i2;
        this.Ys = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int rl() {
        return this.Yq;
    }

    @Override // com.baidu.afd.g
    public int rm() {
        return this.Yr;
    }

    @Override // com.baidu.afd.g
    public int rn() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ro() {
        return this.Yt;
    }

    @Override // com.baidu.afd.g
    public void u(HashMap hashMap) {
        this.Yt = hashMap;
        if (!this.Yt.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bwi());
        }
    }
}
