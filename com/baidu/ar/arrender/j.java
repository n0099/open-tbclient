package com.baidu.ar.arrender;

import java.util.HashMap;
/* loaded from: classes.dex */
public class j extends com.baidu.ar.ability.c {
    public HashMap<String, Object> ib;
    public String mNodeName;

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
