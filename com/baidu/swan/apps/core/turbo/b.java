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
    public String cZY;
    public String cZZ;
    public boolean daa;
    public boolean dab;
    public String dac;
    public String dad;
    public String dae;
    public String daf;
    public String dag;
    private String dah;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.dad);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cZY);
        if (!TextUtils.isEmpty(bVar.daf)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.daf);
            }
            treeMap.put("initData", bVar.daf);
        }
        if (!TextUtils.isEmpty(bVar.dae)) {
            treeMap.put("onReachBottomDistance", bVar.dae);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.daa));
        if (!TextUtils.isEmpty(bVar.dag)) {
            treeMap.put("routeId", bVar.dag);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.dab));
        if (!TextUtils.isEmpty(bVar.dac)) {
            treeMap.put("slavePreload", bVar.dac);
        }
        treeMap.put("root", bVar.cZZ);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.f(bVar.dad, treeMap);
        bVar.dah = com.baidu.swan.apps.runtime.config.a.cw(bVar.appPath, ai.delAllParamsFromUrl(j.tj(bVar.dad)));
        if (!TextUtils.isEmpty(bVar.dah)) {
            treeMap.put("pageConfig", bVar.dah);
        }
        com.baidu.swan.apps.core.g.a avS = d.avB().avS();
        if (avS != null) {
            treeMap.put("masterId", avS.amu());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.dad + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.dae + "', sConsole='" + this.cZY + "', initData='" + this.daf + "', showPerformancePanel=" + this.daa + ", routeId='" + this.dag + "', isT7Available=" + this.dab + ", preloadFile='" + this.dac + "', rootPath='" + this.cZZ + "', pageConfig='" + this.dah + "'}";
    }
}
