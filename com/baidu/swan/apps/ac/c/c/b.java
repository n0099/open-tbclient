package com.baidu.swan.apps.ac.c.c;

import java.util.TreeMap;
/* loaded from: classes7.dex */
public class b {
    private com.baidu.swan.apps.event.a.b djg;

    public b(String str, String str2, String str3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("functionPagePath", str);
        treeMap.put("paymentArgs", str2);
        treeMap.put("slaveId", str3);
        this.djg = new com.baidu.swan.apps.event.a.b("beforeRequestPayment", treeMap);
    }

    public com.baidu.swan.apps.event.a.b aDN() {
        return this.djg;
    }
}
