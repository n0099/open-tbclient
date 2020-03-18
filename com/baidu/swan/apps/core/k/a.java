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
    public boolean bsA;
    public String bsB;
    public String bst;
    public String bsu;
    public String bsv;
    public String bsw;
    public String bsx;
    public boolean bsy;
    public String bsz;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bst);
        treeMap.put("pageUrl", aVar.bsu);
        treeMap.put("devhook", aVar.bsw);
        treeMap.put("root", aVar.bsx);
        if (!TextUtils.isEmpty(aVar.bsv)) {
            treeMap.put("extraData", aVar.bsv);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bsy));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bsz);
        treeMap.put("isT7Available", String.valueOf(aVar.bsA));
        if (!TextUtils.isEmpty(aVar.bsB)) {
            treeMap.put("masterPreload", aVar.bsB);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, aVar2, "app ready event");
        return new com.baidu.swan.apps.n.a.b("AppReady", treeMap);
    }

    public String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.kP(ag.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
