package com.baidu.swan.apps.ac.c.c;

import java.util.TreeMap;
/* loaded from: classes25.dex */
public class b {
    private com.baidu.swan.apps.event.a.b dqf;

    public b(String str, String str2, String str3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("functionPagePath", str);
        treeMap.put("paymentArgs", str2);
        treeMap.put("slaveId", str3);
        this.dqf = new com.baidu.swan.apps.event.a.b("beforeRequestPayment", treeMap);
    }

    public com.baidu.swan.apps.event.a.b aGV() {
        return this.dqf;
    }
}
