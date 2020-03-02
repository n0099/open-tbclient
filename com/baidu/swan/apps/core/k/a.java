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
    public String bsg;
    public String bsh;
    public String bsi;
    public String bsj;
    public String bsk;
    public boolean bsl;
    public String bsm;
    public boolean bsn;
    public String bso;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bsg);
        treeMap.put("pageUrl", aVar.bsh);
        treeMap.put("devhook", aVar.bsj);
        treeMap.put("root", aVar.bsk);
        if (!TextUtils.isEmpty(aVar.bsi)) {
            treeMap.put("extraData", aVar.bsi);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bsl));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bsm);
        treeMap.put("isT7Available", String.valueOf(aVar.bsn));
        if (!TextUtils.isEmpty(aVar.bso)) {
            treeMap.put("masterPreload", aVar.bso);
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
