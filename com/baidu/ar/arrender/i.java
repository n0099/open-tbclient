package com.baidu.ar.arrender;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class i extends com.baidu.ar.ability.c {
    private HashMap<String, Object> iv;
    private String mNodeName;

    public void M(String str) {
        this.mNodeName = str;
    }

    public HashMap<String, Object> bJ() {
        return this.iv;
    }

    public String getNodeName() {
        return this.mNodeName;
    }

    public void i(HashMap<String, Object> hashMap) {
        this.iv = hashMap;
    }
}
