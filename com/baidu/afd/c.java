package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    private final int YM;
    private final int YN;
    private final int YO;
    private HashMap YP;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.YM = i;
        this.YN = i2;
        this.YO = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static h a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.h
    public int rl() {
        return this.YM;
    }

    @Override // com.baidu.afd.h
    public int rm() {
        return this.YN;
    }

    @Override // com.baidu.afd.h
    public int rn() {
        return this.floor;
    }

    @Override // com.baidu.afd.h
    public Map<String, String> ro() {
        return this.YP;
    }

    @Override // com.baidu.afd.h
    public void u(HashMap hashMap) {
        this.YP = hashMap;
        if (!this.YP.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bCD());
        }
    }
}
