package com.baidu.ar.arrender;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class j extends com.baidu.ar.ability.c {
    private HashMap<String, Object> ib;
    private String mNodeName;

    public void P(String str) {
        this.mNodeName = str;
    }

    public HashMap<String, Object> bT() {
        return this.ib;
    }

    public String getNodeName() {
        return this.mNodeName;
    }

    public void h(HashMap<String, Object> hashMap) {
        this.ib = hashMap;
    }
}
