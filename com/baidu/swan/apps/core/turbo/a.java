package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cBC;
    public String cBD;
    public String cBE;
    public String cBF;
    public boolean cBG;
    public boolean cBH;
    public String cBI;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cBC);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cBE);
        treeMap.put("root", aVar.cBF);
        if (!TextUtils.isEmpty(aVar.cBD)) {
            treeMap.put("extraData", aVar.cBD);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cBG));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cBH));
        if (!TextUtils.isEmpty(aVar.cBI)) {
            treeMap.put("masterPreload", aVar.cBI);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.jS(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
