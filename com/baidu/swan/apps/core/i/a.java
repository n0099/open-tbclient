package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import com.baidu.swan.apps.an.y;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class a {
    public String atf;
    public String atg;
    public String ath;
    public String ati;
    public String atj;
    public String atk;
    public String atl;

    public static com.baidu.swan.apps.m.a.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.atf);
        treeMap.put("appPath", aVar.atg);
        treeMap.put("wvID", aVar.ath);
        treeMap.put("pageUrl", aVar.ati);
        treeMap.put("devhook", aVar.atk);
        treeMap.put("root", aVar.atl);
        if (!TextUtils.isEmpty(aVar.atj)) {
            treeMap.put("extraData", aVar.atj);
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
