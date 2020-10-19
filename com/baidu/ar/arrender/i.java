package com.baidu.ar.arrender;

import java.util.HashMap;
/* loaded from: classes14.dex */
public class i extends com.baidu.ar.ability.c {
    private HashMap<String, Object> hN;
    private String mNodeName;

    public void M(String str) {
        this.mNodeName = str;
    }

    public HashMap<String, Object> bU() {
        return this.hN;
    }

    public String getNodeName() {
        return this.mNodeName;
    }

    public void h(HashMap<String, Object> hashMap) {
        this.hN = hashMap;
    }
}
