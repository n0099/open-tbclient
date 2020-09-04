package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cnm;
    public String cnn;
    public boolean cno;
    public boolean cnp;
    public String cnq;
    public String cnr;
    public String cns;
    public String cnu;
    public String cnv;
    private String cnw;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cnr);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cnm);
        if (!TextUtils.isEmpty(bVar.cnu)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cnu);
            }
            treeMap.put("initData", bVar.cnu);
        }
        if (!TextUtils.isEmpty(bVar.cns)) {
            treeMap.put("onReachBottomDistance", bVar.cns);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cno));
        if (!TextUtils.isEmpty(bVar.cnv)) {
            treeMap.put("routeId", bVar.cnv);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cnp));
        if (!TextUtils.isEmpty(bVar.cnq)) {
            treeMap.put("slavePreload", bVar.cnq);
        }
        treeMap.put("root", bVar.cnn);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cnr, treeMap);
        bVar.cnw = com.baidu.swan.apps.runtime.config.a.cf(bVar.appPath, ai.delAllParamsFromUrl(j.qX(bVar.cnr)));
        if (!TextUtils.isEmpty(bVar.cnw)) {
            treeMap.put("pageConfig", bVar.cnw);
        }
        com.baidu.swan.apps.core.g.a akj = d.ajS().akj();
        if (akj != null) {
            treeMap.put("masterId", akj.aaU());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cnr + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cns + "', sConsole='" + this.cnm + "', initData='" + this.cnu + "', showPerformancePanel=" + this.cno + ", routeId='" + this.cnv + "', isT7Available=" + this.cnp + ", preloadFile='" + this.cnq + "', rootPath='" + this.cnn + "', pageConfig='" + this.cnw + "'}";
    }
}
