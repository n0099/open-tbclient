package com.baidu.afd;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    private final int aaq;
    private final int aar;
    private final int aas;
    private HashMap aat;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.aaq = i;
        this.aar = i2;
        this.aas = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static h a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.h
    public int qP() {
        return this.aaq;
    }

    @Override // com.baidu.afd.h
    public int qQ() {
        return this.aar;
    }

    @Override // com.baidu.afd.h
    public int qR() {
        return this.floor;
    }

    @Override // com.baidu.afd.h
    public Map<String, String> qS() {
        return this.aat;
    }

    @Override // com.baidu.afd.h
    public void u(HashMap hashMap) {
        this.aat = hashMap;
        if (!this.aat.containsKey(AdExtParam.KEY_IADEX)) {
            hashMap.put(AdExtParam.KEY_IADEX, com.baidu.tbadk.util.c.bEI());
        }
    }
}
