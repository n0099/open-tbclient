package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cOh;
    public String cOi;
    public String cOj;
    public String cOk;
    public boolean cOl;
    public boolean cOm;
    public String cOn;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cOh);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cOj);
        treeMap.put("root", aVar.cOk);
        if (!TextUtils.isEmpty(aVar.cOi)) {
            treeMap.put("extraData", aVar.cOi);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cOl));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cOm));
        if (!TextUtils.isEmpty(aVar.cOn)) {
            treeMap.put("masterPreload", aVar.cOn);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.f(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.ku(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
