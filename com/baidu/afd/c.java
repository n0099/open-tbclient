package com.baidu.afd;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    private final int abG;
    private final int abH;
    private final int abI;
    private HashMap abJ;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.abG = i;
        this.abH = i2;
        this.abI = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static h a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.h
    public int qN() {
        return this.abG;
    }

    @Override // com.baidu.afd.h
    public int qO() {
        return this.abH;
    }

    @Override // com.baidu.afd.h
    public int qP() {
        return this.floor;
    }

    @Override // com.baidu.afd.h
    public Map<String, String> qQ() {
        return this.abJ;
    }

    @Override // com.baidu.afd.h
    public void u(HashMap hashMap) {
        this.abJ = hashMap;
        if (!this.abJ.containsKey(AdExtParam.KEY_IADEX)) {
            hashMap.put(AdExtParam.KEY_IADEX, com.baidu.tbadk.util.d.bFf());
        }
    }
}
