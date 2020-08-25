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
    public String cni;
    public String cnj;
    public boolean cnk;
    public boolean cnl;
    public String cnm;
    public String cnn;
    public String cno;
    public String cnp;
    public String cnq;
    private String cnr;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cnn);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cni);
        if (!TextUtils.isEmpty(bVar.cnp)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cnp);
            }
            treeMap.put("initData", bVar.cnp);
        }
        if (!TextUtils.isEmpty(bVar.cno)) {
            treeMap.put("onReachBottomDistance", bVar.cno);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cnk));
        if (!TextUtils.isEmpty(bVar.cnq)) {
            treeMap.put("routeId", bVar.cnq);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cnl));
        if (!TextUtils.isEmpty(bVar.cnm)) {
            treeMap.put("slavePreload", bVar.cnm);
        }
        treeMap.put("root", bVar.cnj);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cnn, treeMap);
        bVar.cnr = com.baidu.swan.apps.runtime.config.a.cf(bVar.appPath, ai.delAllParamsFromUrl(j.qW(bVar.cnn)));
        if (!TextUtils.isEmpty(bVar.cnr)) {
            treeMap.put("pageConfig", bVar.cnr);
        }
        com.baidu.swan.apps.core.g.a akj = d.ajS().akj();
        if (akj != null) {
            treeMap.put("masterId", akj.aaU());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cnn + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cno + "', sConsole='" + this.cni + "', initData='" + this.cnp + "', showPerformancePanel=" + this.cnk + ", routeId='" + this.cnq + "', isT7Available=" + this.cnl + ", preloadFile='" + this.cnm + "', rootPath='" + this.cnj + "', pageConfig='" + this.cnr + "'}";
    }
}
