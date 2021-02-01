package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public boolean cXA;
    public boolean cXB;
    public String cXC;
    public String cXD;
    public String cXE;
    public String cXF;
    public String cXG;
    private String cXH;
    public String cXy;
    public String cXz;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cXD);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cXy);
        if (!TextUtils.isEmpty(bVar.cXF)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cXF);
            }
            treeMap.put("initData", bVar.cXF);
        }
        if (!TextUtils.isEmpty(bVar.cXE)) {
            treeMap.put("onReachBottomDistance", bVar.cXE);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cXA));
        if (!TextUtils.isEmpty(bVar.cXG)) {
            treeMap.put("routeId", bVar.cXG);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cXB));
        if (!TextUtils.isEmpty(bVar.cXC)) {
            treeMap.put("slavePreload", bVar.cXC);
        }
        treeMap.put("root", bVar.cXz);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.e(bVar.cXD, treeMap);
        bVar.cXH = com.baidu.swan.apps.runtime.config.a.cp(bVar.appPath, ai.delAllParamsFromUrl(j.sq(bVar.cXD)));
        if (!TextUtils.isEmpty(bVar.cXH)) {
            treeMap.put("pageConfig", bVar.cXH);
        }
        com.baidu.swan.apps.core.g.a asw = d.ase().asw();
        if (asw != null) {
            treeMap.put("masterId", asw.aiY());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cXD + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cXE + "', sConsole='" + this.cXy + "', initData='" + this.cXF + "', showPerformancePanel=" + this.cXA + ", routeId='" + this.cXG + "', isT7Available=" + this.cXB + ", preloadFile='" + this.cXC + "', rootPath='" + this.cXz + "', pageConfig='" + this.cXH + "'}";
    }
}
