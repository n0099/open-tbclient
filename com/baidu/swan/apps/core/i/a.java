package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String ate;
    public String atf;
    public String atg;
    public String ath;
    public String ati;
    public String atj;
    public String atk;

    public static com.baidu.swan.apps.m.a.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.ate);
        treeMap.put("appPath", aVar.atf);
        treeMap.put("wvID", aVar.atg);
        treeMap.put("pageUrl", aVar.ath);
        treeMap.put("devhook", aVar.atj);
        treeMap.put("root", aVar.atk);
        if (!TextUtils.isEmpty(aVar.ati)) {
            treeMap.put("extraData", aVar.ati);
        }
        return new com.baidu.swan.apps.m.a.b("AppReady", treeMap);
    }

    public String a(com.baidu.swan.apps.ae.b bVar, String str) {
        String str2 = null;
        if (bVar != null) {
            str2 = bVar.gh(y.hF(str));
        }
        return str2 == null ? "" : str2;
    }
}
