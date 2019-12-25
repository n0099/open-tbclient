package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class a {
    public String appConfig;
    public String appPath;
    public String bni;
    public String bnj;
    public String bnk;
    public String bnl;
    public String bnm;
    public boolean bnn;
    public String bno;
    public boolean bnp;
    public String bnq;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bni);
        treeMap.put("pageUrl", aVar.bnj);
        treeMap.put("devhook", aVar.bnl);
        treeMap.put("root", aVar.bnm);
        if (!TextUtils.isEmpty(aVar.bnk)) {
            treeMap.put("extraData", aVar.bnk);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bnn));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bno);
        treeMap.put("isT7Available", String.valueOf(aVar.bnp));
        if (!TextUtils.isEmpty(aVar.bnq)) {
            treeMap.put("masterPreload", aVar.bnq);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, aVar2, "app ready event");
        return new com.baidu.swan.apps.n.a.b("AppReady", treeMap);
    }

    public String b(e eVar, String str) {
        String str2 = null;
        if (eVar != null) {
            str2 = eVar.ky(ag.delAllParamsFromUrl(str));
        }
        return str2 == null ? "" : str2;
    }
}
