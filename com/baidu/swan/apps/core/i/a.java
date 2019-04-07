package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String atj;
    public String atk;
    public String atl;
    public String atm;
    public String atn;
    public String ato;
    public String atp;

    public static com.baidu.swan.apps.m.a.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.atj);
        treeMap.put("appPath", aVar.atk);
        treeMap.put("wvID", aVar.atl);
        treeMap.put("pageUrl", aVar.atm);
        treeMap.put("devhook", aVar.ato);
        treeMap.put("root", aVar.atp);
        if (!TextUtils.isEmpty(aVar.atn)) {
            treeMap.put("extraData", aVar.atn);
        }
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.gi(y.hG(str));
        }
        return str2 == null ? "" : str2;
    }
}
