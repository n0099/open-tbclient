package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String aub;
    public String auc;
    public String aud;
    public String aue;
    public String auf;
    public String aug;
    public String auh;
    public boolean aui;

    public static com.baidu.swan.apps.m.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.aub);
        treeMap.put("appPath", aVar.auc);
        treeMap.put("wvID", aVar.aud);
        treeMap.put("pageUrl", aVar.aue);
        treeMap.put("devhook", aVar.aug);
        treeMap.put("root", aVar.auh);
        if (!TextUtils.isEmpty(aVar.auf)) {
            treeMap.put("extraData", aVar.auf);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.aui));
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.gJ(aa.iq(str));
        }
        return str2 == null ? "" : str2;
    }
}
