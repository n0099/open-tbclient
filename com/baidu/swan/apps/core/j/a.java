package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String auA;
    public String auB;
    public String auC;
    public String auD;
    public String auE;
    public String auF;
    public boolean auG;
    public String auz;

    public static com.baidu.swan.apps.m.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.auz);
        treeMap.put("appPath", aVar.auA);
        treeMap.put("wvID", aVar.auB);
        treeMap.put("pageUrl", aVar.auC);
        treeMap.put("devhook", aVar.auE);
        treeMap.put("root", aVar.auF);
        if (!TextUtils.isEmpty(aVar.auD)) {
            treeMap.put("extraData", aVar.auD);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.auG));
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.gL(aa.is(str));
        }
        return str2 == null ? "" : str2;
    }
}
