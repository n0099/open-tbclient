package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cOj;
    public String cOk;
    public boolean cOl;
    public boolean cOm;
    public String cOn;
    public String cOo;
    public String cOp;
    public String cOq;
    public String cOr;
    private String cOs;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cOo);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cOj);
        if (!TextUtils.isEmpty(bVar.cOq)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cOq);
            }
            treeMap.put("initData", bVar.cOq);
        }
        if (!TextUtils.isEmpty(bVar.cOp)) {
            treeMap.put("onReachBottomDistance", bVar.cOp);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cOl));
        if (!TextUtils.isEmpty(bVar.cOr)) {
            treeMap.put("routeId", bVar.cOr);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cOm));
        if (!TextUtils.isEmpty(bVar.cOn)) {
            treeMap.put("slavePreload", bVar.cOn);
        }
        treeMap.put("root", bVar.cOk);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.f(bVar.cOo, treeMap);
        bVar.cOs = com.baidu.swan.apps.runtime.config.a.cq(bVar.appPath, ai.delAllParamsFromUrl(j.sF(bVar.cOo)));
        if (!TextUtils.isEmpty(bVar.cOs)) {
            treeMap.put("pageConfig", bVar.cOs);
        }
        com.baidu.swan.apps.core.g.a arr = d.ara().arr();
        if (arr != null) {
            treeMap.put("masterId", arr.aib());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cOo + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cOp + "', sConsole='" + this.cOj + "', initData='" + this.cOq + "', showPerformancePanel=" + this.cOl + ", routeId='" + this.cOr + "', isT7Available=" + this.cOm + ", preloadFile='" + this.cOn + "', rootPath='" + this.cOk + "', pageConfig='" + this.cOs + "'}";
    }
}
