package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String atA;
    public String atB;
    public String atC;
    public String atD;
    public String atE;
    public boolean atF;
    public String aty;
    public String atz;

    public static com.baidu.swan.apps.m.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.aty);
        treeMap.put("appPath", aVar.atz);
        treeMap.put("wvID", aVar.atA);
        treeMap.put("pageUrl", aVar.atB);
        treeMap.put("devhook", aVar.atD);
        treeMap.put("root", aVar.atE);
        if (!TextUtils.isEmpty(aVar.atC)) {
            treeMap.put("extraData", aVar.atC);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.atF));
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.gD(aa.ik(str));
        }
        return str2 == null ? "" : str2;
    }
}
