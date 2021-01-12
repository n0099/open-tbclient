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
    public String cVm;
    public String cVn;
    public boolean cVo;
    public boolean cVp;
    public String cVq;
    public String cVr;
    public String cVs;
    public String cVt;
    public String cVu;
    private String cVv;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cVr);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cVm);
        if (!TextUtils.isEmpty(bVar.cVt)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cVt);
            }
            treeMap.put("initData", bVar.cVt);
        }
        if (!TextUtils.isEmpty(bVar.cVs)) {
            treeMap.put("onReachBottomDistance", bVar.cVs);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cVo));
        if (!TextUtils.isEmpty(bVar.cVu)) {
            treeMap.put("routeId", bVar.cVu);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cVp));
        if (!TextUtils.isEmpty(bVar.cVq)) {
            treeMap.put("slavePreload", bVar.cVq);
        }
        treeMap.put("root", bVar.cVn);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.f(bVar.cVr, treeMap);
        bVar.cVv = com.baidu.swan.apps.runtime.config.a.cv(bVar.appPath, ai.delAllParamsFromUrl(j.rX(bVar.cVr)));
        if (!TextUtils.isEmpty(bVar.cVv)) {
            treeMap.put("pageConfig", bVar.cVv);
        }
        com.baidu.swan.apps.core.g.a arX = d.arG().arX();
        if (arX != null) {
            treeMap.put("masterId", arX.aiA());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cVr + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cVs + "', sConsole='" + this.cVm + "', initData='" + this.cVt + "', showPerformancePanel=" + this.cVo + ", routeId='" + this.cVu + "', isT7Available=" + this.cVp + ", preloadFile='" + this.cVq + "', rootPath='" + this.cVn + "', pageConfig='" + this.cVv + "'}";
    }
}
