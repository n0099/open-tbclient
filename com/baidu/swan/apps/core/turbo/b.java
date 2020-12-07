package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cVc;
    public String cVd;
    public boolean cVe;
    public boolean cVf;
    public String cVg;
    public String cVh;
    public String cVi;
    public String cVj;
    public String cVk;
    private String cVl;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cVh);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cVc);
        if (!TextUtils.isEmpty(bVar.cVj)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cVj);
            }
            treeMap.put("initData", bVar.cVj);
        }
        if (!TextUtils.isEmpty(bVar.cVi)) {
            treeMap.put("onReachBottomDistance", bVar.cVi);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cVe));
        if (!TextUtils.isEmpty(bVar.cVk)) {
            treeMap.put("routeId", bVar.cVk);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cVf));
        if (!TextUtils.isEmpty(bVar.cVg)) {
            treeMap.put("slavePreload", bVar.cVg);
        }
        treeMap.put("root", bVar.cVd);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.f(bVar.cVh, treeMap);
        bVar.cVl = com.baidu.swan.apps.runtime.config.a.cx(bVar.appPath, ai.delAllParamsFromUrl(j.tm(bVar.cVh)));
        if (!TextUtils.isEmpty(bVar.cVl)) {
            treeMap.put("pageConfig", bVar.cVl);
        }
        com.baidu.swan.apps.core.g.a auz = d.aui().auz();
        if (auz != null) {
            treeMap.put("masterId", auz.alj());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cVh + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cVi + "', sConsole='" + this.cVc + "', initData='" + this.cVj + "', showPerformancePanel=" + this.cVe + ", routeId='" + this.cVk + "', isT7Available=" + this.cVf + ", preloadFile='" + this.cVg + "', rootPath='" + this.cVd + "', pageConfig='" + this.cVl + "'}";
    }
}
