package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c implements g {
    private final int XV;
    private final int XW;
    private final int XX;
    private HashMap XY;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.XV = i;
        this.XW = i2;
        this.XX = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int rg() {
        return this.XV;
    }

    @Override // com.baidu.afd.g
    public int rh() {
        return this.XW;
    }

    @Override // com.baidu.afd.g
    public int ri() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> rj() {
        return this.XY;
    }

    @Override // com.baidu.afd.g
    public void u(HashMap hashMap) {
        this.XY = hashMap;
        if (!this.XY.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bvd());
        }
    }
}
