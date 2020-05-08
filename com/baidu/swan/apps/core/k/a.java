package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String bQE;
    public String bQF;
    public String bQG;
    public String bQH;
    public String bQI;
    public boolean bQJ;
    public String bQK;
    public boolean bQL;
    public String bQM;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bQE);
        treeMap.put("pageUrl", aVar.bQF);
        treeMap.put("devhook", aVar.bQH);
        treeMap.put("root", aVar.bQI);
        if (!TextUtils.isEmpty(aVar.bQG)) {
            treeMap.put("extraData", aVar.bQG);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bQJ));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bQK);
        treeMap.put("isT7Available", String.valueOf(aVar.bQL));
        if (!TextUtils.isEmpty(aVar.bQM)) {
            treeMap.put("masterPreload", aVar.bQM);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, aVar2, "app ready event");
        return new com.baidu.swan.apps.n.a.b("AppReady", treeMap);
    }

    public String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.mc(ag.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
