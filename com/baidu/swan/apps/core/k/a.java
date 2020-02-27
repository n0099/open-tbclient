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
    public String bsf;
    public String bsg;
    public String bsh;
    public String bsi;
    public String bsj;
    public boolean bsk;
    public String bsl;
    public boolean bsm;
    public String bsn;

    public static com.baidu.swan.apps.n.a.b a(a aVar, com.baidu.swan.apps.ag.b.a aVar2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appConfig", aVar.appConfig);
        treeMap.put("appPath", aVar.appPath);
        treeMap.put("wvID", aVar.bsf);
        treeMap.put("pageUrl", aVar.bsg);
        treeMap.put("devhook", aVar.bsi);
        treeMap.put("root", aVar.bsj);
        if (!TextUtils.isEmpty(aVar.bsh)) {
            treeMap.put("extraData", aVar.bsh);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.bsk));
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, aVar.bsl);
        treeMap.put("isT7Available", String.valueOf(aVar.bsm));
        if (!TextUtils.isEmpty(aVar.bsn)) {
            treeMap.put("masterPreload", aVar.bsn);
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
