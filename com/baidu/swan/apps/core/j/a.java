package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String aNQ;
    public String aNR;
    public String aNS;
    public String aNT;
    public String aNU;
    public String aNV;
    public String aNW;
    public boolean aNX;

    public static com.baidu.swan.apps.m.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.aNQ);
        treeMap.put("appPath", aVar.aNR);
        treeMap.put("wvID", aVar.aNS);
        treeMap.put("pageUrl", aVar.aNT);
        treeMap.put("devhook", aVar.aNV);
        treeMap.put("root", aVar.aNW);
        if (!TextUtils.isEmpty(aVar.aNU)) {
            treeMap.put("extraData", aVar.aNU);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.aNX));
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.hp(aa.iV(str));
        }
        return str2 == null ? "" : str2;
    }
}
