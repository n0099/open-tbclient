package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes25.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cVa;
    public String cVb;
    public String cVc;
    public String cVd;
    public boolean cVe;
    public boolean cVf;
    public String cVg;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cVa);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cVc);
        treeMap.put("root", aVar.cVd);
        if (!TextUtils.isEmpty(aVar.cVb)) {
            treeMap.put("extraData", aVar.cVb);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cVe));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cVf));
        if (!TextUtils.isEmpty(aVar.cVg)) {
            treeMap.put("masterPreload", aVar.cVg);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.f(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.lb(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
