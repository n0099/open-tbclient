package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class a {
    public String appConfig;
    public String appPath;
    public boolean cXA;
    public boolean cXB;
    public String cXC;
    public String cXx;
    public String cXy;
    public String cXz;
    public String extraData;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cXx);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cXy);
        treeMap.put("root", aVar.cXz);
        if (!TextUtils.isEmpty(aVar.extraData)) {
            treeMap.put("extraData", aVar.extraData);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cXA));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cXB));
        if (!TextUtils.isEmpty(aVar.cXC)) {
            treeMap.put("masterPreload", aVar.cXC);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.e(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kb(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
