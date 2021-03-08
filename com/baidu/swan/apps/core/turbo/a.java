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
    public String cYX;
    public String cYY;
    public String cYZ;
    public boolean cZa;
    public boolean cZb;
    public String cZc;
    public String extraData;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cYX);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cYY);
        treeMap.put("root", aVar.cYZ);
        if (!TextUtils.isEmpty(aVar.extraData)) {
            treeMap.put("extraData", aVar.extraData);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cZa));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cZb));
        if (!TextUtils.isEmpty(aVar.cZc)) {
            treeMap.put("masterPreload", aVar.cZc);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.e(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.ki(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
