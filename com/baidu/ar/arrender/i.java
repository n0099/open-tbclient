package com.baidu.ar.arrender;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class i extends com.baidu.ar.ability.c {
    private HashMap<String, Object> ig;
    private String mNodeName;

    public void M(String str) {
        this.mNodeName = str;
    }

    public HashMap<String, Object> bu() {
        return this.ig;
    }

    public String getNodeName() {
        return this.mNodeName;
    }

    public void i(HashMap<String, Object> hashMap) {
        this.ig = hashMap;
    }
}
