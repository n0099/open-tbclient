package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cgR;
    public String cgS;
    public String cgT;
    public String cgU;
    public boolean cgV;
    public boolean cgW;
    public String cgX;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cgR);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cgT);
        treeMap.put("root", aVar.cgU);
        if (!TextUtils.isEmpty(aVar.cgS)) {
            treeMap.put("extraData", aVar.cgS);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cgV));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cgW));
        if (!TextUtils.isEmpty(aVar.cgX)) {
            treeMap.put("masterPreload", aVar.cgX);
        }
        com.baidu.swan.apps.ad.g.b.b(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.hq(aj.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
