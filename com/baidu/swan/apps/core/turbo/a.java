package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cng;
    public String cnh;
    public String cni;
    public String cnj;
    public boolean cnk;
    public boolean cnl;
    public String cnm;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cng);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cni);
        treeMap.put("root", aVar.cnj);
        if (!TextUtils.isEmpty(aVar.cnh)) {
            treeMap.put("extraData", aVar.cnh);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cnk));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cnl));
        if (!TextUtils.isEmpty(aVar.cnm)) {
            treeMap.put("masterPreload", aVar.cnm);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.iM(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
