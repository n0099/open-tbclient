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
    public String cnk;
    public String cnl;
    public String cnm;
    public String cnn;
    public boolean cno;
    public boolean cnp;
    public String cnq;
    public String pageType;
    public String pageUrl;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cnk);
        treeMap.put("pageUrl", aVar.pageUrl);
        treeMap.put("devhook", aVar.cnm);
        treeMap.put("root", aVar.cnn);
        if (!TextUtils.isEmpty(aVar.cnl)) {
            treeMap.put("extraData", aVar.cnl);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cno));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cnp));
        if (!TextUtils.isEmpty(aVar.cnq)) {
            treeMap.put("masterPreload", aVar.cnq);
        }
        com.baidu.swan.apps.ac.g.b.c(treeMap, "app ready event");
        j.g(aVar.pageUrl, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.iN(ai.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
