package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String bnW;
    public String bnX;
    public String bnY;
    public String bnZ;
    public String boa;
    public boolean bob;
    public String boc;
    public boolean bod;
    public String boe;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bnW);
        treeMap.put("pageUrl", aVar.bnX);
        treeMap.put("devhook", aVar.bnZ);
        treeMap.put("root", aVar.boa);
        if (!TextUtils.isEmpty(aVar.bnY)) {
            treeMap.put("extraData", aVar.bnY);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bob));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.boc);
        treeMap.put("isT7Available", String.valueOf(aVar.bod));
        if (!TextUtils.isEmpty(aVar.boe)) {
            treeMap.put("masterPreload", aVar.boe);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, aVar2, "app ready event");
        return new com.baidu.swan.apps.n.a.b("AppReady", treeMap);
    }

    public String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kB(ag.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
