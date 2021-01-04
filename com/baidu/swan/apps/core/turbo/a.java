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
    public String cZW;
    public String cZX;
    public String cZY;
    public String cZZ;
    public boolean daa;
    public boolean dab;
    public String dac;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cZW);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cZY);
        treeMap.put("root", aVar.cZZ);
        if (!TextUtils.isEmpty(aVar.cZX)) {
            treeMap.put("extraData", aVar.cZX);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.daa));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.dab));
        if (!TextUtils.isEmpty(aVar.dac)) {
            treeMap.put("masterPreload", aVar.dac);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.f(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kU(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
