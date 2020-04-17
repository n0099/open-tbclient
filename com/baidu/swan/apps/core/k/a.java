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
    public String bQA;
    public String bQB;
    public String bQC;
    public String bQD;
    public boolean bQE;
    public String bQF;
    public boolean bQG;
    public String bQH;
    public String bQz;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bQz);
        treeMap.put("pageUrl", aVar.bQA);
        treeMap.put("devhook", aVar.bQC);
        treeMap.put("root", aVar.bQD);
        if (!TextUtils.isEmpty(aVar.bQB)) {
            treeMap.put("extraData", aVar.bQB);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bQE));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bQF);
        treeMap.put("isT7Available", String.valueOf(aVar.bQG));
        if (!TextUtils.isEmpty(aVar.bQH)) {
            treeMap.put("masterPreload", aVar.bQH);
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
