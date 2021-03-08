package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cYY;
    public String cYZ;
    public boolean cZa;
    public boolean cZb;
    public String cZc;
    public String cZd;
    public String cZe;
    public String cZf;
    public String cZg;
    private String cZh;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cZd);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cYY);
        if (!TextUtils.isEmpty(bVar.cZf)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cZf);
            }
            treeMap.put("initData", bVar.cZf);
        }
        if (!TextUtils.isEmpty(bVar.cZe)) {
            treeMap.put("onReachBottomDistance", bVar.cZe);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cZa));
        if (!TextUtils.isEmpty(bVar.cZg)) {
            treeMap.put("routeId", bVar.cZg);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cZb));
        if (!TextUtils.isEmpty(bVar.cZc)) {
            treeMap.put("slavePreload", bVar.cZc);
        }
        treeMap.put("root", bVar.cYZ);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.e(bVar.cZd, treeMap);
        bVar.cZh = com.baidu.swan.apps.runtime.config.a.cp(bVar.appPath, ai.delAllParamsFromUrl(j.sy(bVar.cZd)));
        if (!TextUtils.isEmpty(bVar.cZh)) {
            treeMap.put("pageConfig", bVar.cZh);
        }
        com.baidu.swan.apps.core.g.a asz = d.ash().asz();
        if (asz != null) {
            treeMap.put("masterId", asz.ajb());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cZd + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cZe + "', sConsole='" + this.cYY + "', initData='" + this.cZf + "', showPerformancePanel=" + this.cZa + ", routeId='" + this.cZg + "', isT7Available=" + this.cZb + ", preloadFile='" + this.cZc + "', rootPath='" + this.cYZ + "', pageConfig='" + this.cZh + "'}";
    }
}
