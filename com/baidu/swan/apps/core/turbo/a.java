package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String caq;
    public String car;
    public String cas;
    public String cat;
    public String cau;
    public boolean cav;
    public String caw;
    public boolean cax;
    public String cay;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.caq);
        treeMap.put("pageUrl", aVar.car);
        treeMap.put("devhook", aVar.cat);
        treeMap.put("root", aVar.cau);
        if (!TextUtils.isEmpty(aVar.cas)) {
            treeMap.put("extraData", aVar.cas);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cav));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.caw);
        treeMap.put("isT7Available", String.valueOf(aVar.cax));
        if (!TextUtils.isEmpty(aVar.cay)) {
            treeMap.put("masterPreload", aVar.cay);
        }
        com.baidu.swan.apps.ae.g.b.b(treeMap, "app ready event");
        j.f(aVar.car, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.nx(ah.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
