package com.baidu.afd;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    private final int ZJ;
    private final int ZK;
    private final int ZL;
    private HashMap ZM;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.ZJ = i;
        this.ZK = i2;
        this.ZL = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static h a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.h
    public int rn() {
        return this.ZJ;
    }

    @Override // com.baidu.afd.h
    public int ro() {
        return this.ZK;
    }

    @Override // com.baidu.afd.h
    public int rp() {
        return this.floor;
    }

    @Override // com.baidu.afd.h
    public Map<String, String> rq() {
        return this.ZM;
    }

    @Override // com.baidu.afd.h
    public void u(HashMap hashMap) {
        this.ZM = hashMap;
        if (!this.ZM.containsKey(AdExtParam.KEY_IADEX)) {
            hashMap.put(AdExtParam.KEY_IADEX, com.baidu.tbadk.util.c.bGe());
        }
    }
}
