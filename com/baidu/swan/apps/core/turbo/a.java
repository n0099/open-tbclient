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
    public String cPR;
    public String cPS;
    public String cPT;
    public String cPU;
    public boolean cPV;
    public boolean cPW;
    public String cPX;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cPR);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cPT);
        treeMap.put("root", aVar.cPU);
        if (!TextUtils.isEmpty(aVar.cPS)) {
            treeMap.put("extraData", aVar.cPS);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cPV));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cPW));
        if (!TextUtils.isEmpty(aVar.cPX)) {
            treeMap.put("masterPreload", aVar.cPX);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kA(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
