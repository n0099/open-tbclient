package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cKa;
    public String cKb;
    public boolean cKc;
    public boolean cKd;
    public String cKe;
    public String cKf;
    public String cKg;
    public String cKh;
    public String cKi;
    private String cKj;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cKf);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cKa);
        if (!TextUtils.isEmpty(bVar.cKh)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cKh);
            }
            treeMap.put("initData", bVar.cKh);
        }
        if (!TextUtils.isEmpty(bVar.cKg)) {
            treeMap.put("onReachBottomDistance", bVar.cKg);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cKc));
        if (!TextUtils.isEmpty(bVar.cKi)) {
            treeMap.put("routeId", bVar.cKi);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cKd));
        if (!TextUtils.isEmpty(bVar.cKe)) {
            treeMap.put("slavePreload", bVar.cKe);
        }
        treeMap.put("root", bVar.cKb);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cKf, treeMap);
        bVar.cKj = com.baidu.swan.apps.runtime.config.a.cr(bVar.appPath, ai.delAllParamsFromUrl(j.sw(bVar.cKf)));
        if (!TextUtils.isEmpty(bVar.cKj)) {
            treeMap.put("pageConfig", bVar.cKj);
        }
        com.baidu.swan.apps.core.g.a apz = d.aph().apz();
        if (apz != null) {
            treeMap.put("masterId", apz.agj());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cKf + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cKg + "', sConsole='" + this.cKa + "', initData='" + this.cKh + "', showPerformancePanel=" + this.cKc + ", routeId='" + this.cKi + "', isT7Available=" + this.cKd + ", preloadFile='" + this.cKe + "', rootPath='" + this.cKb + "', pageConfig='" + this.cKj + "'}";
    }
}
