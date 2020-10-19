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
    public String cBE;
    public String cBF;
    public boolean cBG;
    public boolean cBH;
    public String cBI;
    public String cBJ;
    public String cBK;
    public String cBL;
    public String cBM;
    private String cBN;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cBJ);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cBE);
        if (!TextUtils.isEmpty(bVar.cBL)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cBL);
            }
            treeMap.put("initData", bVar.cBL);
        }
        if (!TextUtils.isEmpty(bVar.cBK)) {
            treeMap.put("onReachBottomDistance", bVar.cBK);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cBG));
        if (!TextUtils.isEmpty(bVar.cBM)) {
            treeMap.put("routeId", bVar.cBM);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cBH));
        if (!TextUtils.isEmpty(bVar.cBI)) {
            treeMap.put("slavePreload", bVar.cBI);
        }
        treeMap.put("root", bVar.cBF);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cBJ, treeMap);
        bVar.cBN = com.baidu.swan.apps.runtime.config.a.ck(bVar.appPath, ai.delAllParamsFromUrl(j.sc(bVar.cBJ)));
        if (!TextUtils.isEmpty(bVar.cBN)) {
            treeMap.put("pageConfig", bVar.cBN);
        }
        com.baidu.swan.apps.core.g.a anE = d.ann().anE();
        if (anE != null) {
            treeMap.put("masterId", anE.aep());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cBJ + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cBK + "', sConsole='" + this.cBE + "', initData='" + this.cBL + "', showPerformancePanel=" + this.cBG + ", routeId='" + this.cBM + "', isT7Available=" + this.cBH + ", preloadFile='" + this.cBI + "', rootPath='" + this.cBF + "', pageConfig='" + this.cBN + "'}";
    }
}
