package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int XX;
    private final int XY;
    private final int XZ;
    private HashMap Ya;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.XX = i;
        this.XY = i2;
        this.XZ = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int rg() {
        return this.XX;
    }

    @Override // com.baidu.afd.g
    public int rh() {
        return this.XY;
    }

    @Override // com.baidu.afd.g
    public int ri() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> rj() {
        return this.Ya;
    }

    @Override // com.baidu.afd.g
    public void u(HashMap hashMap) {
        this.Ya = hashMap;
        if (!this.Ya.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bve());
        }
    }
}
