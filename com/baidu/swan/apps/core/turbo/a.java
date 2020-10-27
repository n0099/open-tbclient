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
    public String cJY;
    public String cJZ;
    public String cKa;
    public String cKb;
    public boolean cKc;
    public boolean cKd;
    public String cKe;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cJY);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cKa);
        treeMap.put("root", aVar.cKb);
        if (!TextUtils.isEmpty(aVar.cJZ)) {
            treeMap.put("extraData", aVar.cJZ);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cKc));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cKd));
        if (!TextUtils.isEmpty(aVar.cKe)) {
            treeMap.put("masterPreload", aVar.cKe);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kl(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
