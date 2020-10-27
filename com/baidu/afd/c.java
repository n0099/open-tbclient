package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int YH;
    private final int YI;
    private final int YJ;
    private HashMap YK;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.YH = i;
        this.YI = i2;
        this.YJ = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int rl() {
        return this.YH;
    }

    @Override // com.baidu.afd.g
    public int rm() {
        return this.YI;
    }

    @Override // com.baidu.afd.g
    public int rn() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> ro() {
        return this.YK;
    }

    @Override // com.baidu.afd.g
    public void u(HashMap hashMap) {
        this.YK = hashMap;
        if (!this.YK.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bAL());
        }
    }
}
