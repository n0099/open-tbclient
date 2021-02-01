package com.baidu.afd;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    private final int aam;
    private final int aan;
    private final int aao;
    private HashMap aap;
    private int floor;
    private final String tabId;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.aam = i;
        this.aan = i2;
        this.aao = i3;
        this.tabId = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static h a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.h
    public int qN() {
        return this.aam;
    }

    @Override // com.baidu.afd.h
    public int qO() {
        return this.aan;
    }

    @Override // com.baidu.afd.h
    public int qP() {
        return this.floor;
    }

    @Override // com.baidu.afd.h
    public Map<String, String> qQ() {
        return this.aap;
    }

    @Override // com.baidu.afd.h
    public void u(HashMap hashMap) {
        this.aap = hashMap;
        if (!this.aap.containsKey(AdExtParam.KEY_IADEX)) {
            hashMap.put(AdExtParam.KEY_IADEX, com.baidu.tbadk.util.d.bFb());
        }
    }
}
