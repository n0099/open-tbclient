package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String cfg;
    public String cfh;
    public String cfi;
    public String cfj;
    public String cfk;
    public boolean cfl;
    public boolean cfm;
    public String cfn;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.cfg);
        treeMap.put("pageUrl", aVar.cfh);
        treeMap.put("devhook", aVar.cfj);
        treeMap.put("root", aVar.cfk);
        if (!TextUtils.isEmpty(aVar.cfi)) {
            treeMap.put("extraData", aVar.cfi);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.cfl));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.pageType);
        treeMap.put("isT7Available", String.valueOf(aVar.cfm));
        if (!TextUtils.isEmpty(aVar.cfn)) {
            treeMap.put("masterPreload", aVar.cfn);
        }
        com.baidu.swan.apps.ae.g.b.b(treeMap, "app ready event");
        j.f(aVar.cfh, treeMap);
        return new com.baidu.swan.apps.event.a.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.nF(ah.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
