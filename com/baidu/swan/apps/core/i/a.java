package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String atk;
    public String atl;
    public String atm;
    public String atn;
    public String ato;
    public String atp;
    public String atq;

    public static com.baidu.swan.apps.m.a.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.atk);
        treeMap.put("appPath", aVar.atl);
        treeMap.put("wvID", aVar.atm);
        treeMap.put("pageUrl", aVar.atn);
        treeMap.put("devhook", aVar.atp);
        treeMap.put("root", aVar.atq);
        if (!TextUtils.isEmpty(aVar.ato)) {
            treeMap.put("extraData", aVar.ato);
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
