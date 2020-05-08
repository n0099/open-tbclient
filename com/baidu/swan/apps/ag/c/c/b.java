package com.baidu.swan.apps.ag.c.c;

import java.util.TreeMap;
/* loaded from: classes11.dex */
public class b {
    private com.baidu.swan.apps.n.a.b chy;

    public b(String str, String str2, String str3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("functionPagePath", str);
        treeMap.put("paymentArgs", str2);
        treeMap.put("slaveId", str3);
        this.chy = new com.baidu.swan.apps.n.a.b("beforeRequestPayment", treeMap);
    }

    public com.baidu.swan.apps.n.a.b aio() {
        return this.chy;
    }
}
