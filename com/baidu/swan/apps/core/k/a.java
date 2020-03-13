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
    public String bsh;
    public String bsi;
    public String bsj;
    public String bsk;
    public String bsl;
    public boolean bsm;
    public String bsn;
    public boolean bso;
    public String bsp;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bsh);
        treeMap.put("pageUrl", aVar.bsi);
        treeMap.put("devhook", aVar.bsk);
        treeMap.put("root", aVar.bsl);
        if (!TextUtils.isEmpty(aVar.bsj)) {
            treeMap.put("extraData", aVar.bsj);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bsm));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bsn);
        treeMap.put("isT7Available", String.valueOf(aVar.bso));
        if (!TextUtils.isEmpty(aVar.bsp)) {
            treeMap.put("masterPreload", aVar.bsp);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, aVar2, "app ready event");
        return new com.baidu.swan.apps.n.a.b("AppReady", treeMap);
    }

    public String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kQ(ag.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
