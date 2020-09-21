package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cpn;
    public String cpo;
    public String cpp;
    public String cpq;
    public boolean cpr;
    public boolean cps;
    public String cpt;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cpn);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cpp);
        treeMap.put("root", aVar.cpq);
        if (!TextUtils.isEmpty(aVar.cpo)) {
            treeMap.put("extraData", aVar.cpo);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cpr));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cps));
        if (!TextUtils.isEmpty(aVar.cpt)) {
            treeMap.put("masterPreload", aVar.cpt);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.jg(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
