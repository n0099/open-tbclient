package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import com.baidu.swan.apps.an.aa;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String aNA;
    public String aNB;
    public String aNC;
    public String aND;
    public String aNE;
    public boolean aNF;
    public String aNy;
    public String aNz;

    public static com.baidu.swan.apps.m.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.aNy);
        treeMap.put("appPath", aVar.aNz);
        treeMap.put("wvID", aVar.aNA);
        treeMap.put("pageUrl", aVar.aNB);
        treeMap.put("devhook", aVar.aND);
        treeMap.put("root", aVar.aNE);
        if (!TextUtils.isEmpty(aVar.aNC)) {
            treeMap.put("extraData", aVar.aNC);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.aNF));
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
