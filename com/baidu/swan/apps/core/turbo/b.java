package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cpp;
    public String cpq;
    public boolean cpr;
    public boolean cps;
    public String cpt;
    public String cpv;
    public String cpw;
    public String cpx;
    public String cpy;
    private String cpz;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cpv);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cpp);
        if (!TextUtils.isEmpty(bVar.cpx)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cpx);
            }
            treeMap.put("initData", bVar.cpx);
        }
        if (!TextUtils.isEmpty(bVar.cpw)) {
            treeMap.put("onReachBottomDistance", bVar.cpw);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cpr));
        if (!TextUtils.isEmpty(bVar.cpy)) {
            treeMap.put("routeId", bVar.cpy);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cps));
        if (!TextUtils.isEmpty(bVar.cpt)) {
            treeMap.put("slavePreload", bVar.cpt);
        }
        treeMap.put("root", bVar.cpq);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cpv, treeMap);
        bVar.cpz = com.baidu.swan.apps.runtime.config.a.cf(bVar.appPath, ai.delAllParamsFromUrl(j.rq(bVar.cpv)));
        if (!TextUtils.isEmpty(bVar.cpz)) {
            treeMap.put("pageConfig", bVar.cpz);
        }
        com.baidu.swan.apps.core.g.a akT = d.akC().akT();
        if (akT != null) {
            treeMap.put("masterId", akT.abD());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cpv + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cpw + "', sConsole='" + this.cpp + "', initData='" + this.cpx + "', showPerformancePanel=" + this.cpr + ", routeId='" + this.cpy + "', isT7Available=" + this.cps + ", preloadFile='" + this.cpt + "', rootPath='" + this.cpq + "', pageConfig='" + this.cpz + "'}";
    }
}
