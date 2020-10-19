package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int YG;
    private final int YH;
    private final int YI;
    private HashMap YJ;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.YG = i;
        this.YH = i2;
        this.YI = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int rl() {
        return this.YG;
    }

    @Override // com.baidu.afd.g
    public int rm() {
        return this.YH;
    }

    @Override // com.baidu.afd.g
    public int rn() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ro() {
        return this.YJ;
    }

    @Override // com.baidu.afd.g
    public void u(HashMap hashMap) {
        this.YJ = hashMap;
        if (!this.YJ.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.byS());
        }
    }
}
