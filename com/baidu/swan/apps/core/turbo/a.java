package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cVk;
    public String cVl;
    public String cVm;
    public String cVn;
    public boolean cVo;
    public boolean cVp;
    public String cVq;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cVk);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cVm);
        treeMap.put("root", aVar.cVn);
        if (!TextUtils.isEmpty(aVar.cVl)) {
            treeMap.put("extraData", aVar.cVl);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cVo));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cVp));
        if (!TextUtils.isEmpty(aVar.cVq)) {
            treeMap.put("masterPreload", aVar.cVq);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.f(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.jJ(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
