package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bQC;
    public boolean bQE;
    public String bQF;
    public boolean bQG;
    public String bQH;
    public String bQI;
    public String bQJ;
    public String bQK;
    public String bQL;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bQI);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bQF);
        treeMap.put("devhook", bVar.bQC);
        if (!TextUtils.isEmpty(bVar.bQK)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bQK);
            }
            treeMap.put("initData", bVar.bQK);
        }
        if (!TextUtils.isEmpty(bVar.bQJ)) {
            treeMap.put("onReachBottomDistance", bVar.bQJ);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bQE));
        if (!TextUtils.isEmpty(bVar.bQL)) {
            treeMap.put("routeId", bVar.bQL);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bQG));
        if (!TextUtils.isEmpty(bVar.bQH)) {
            treeMap.put("slavePreload", bVar.bQH);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bQI + "', pageType='" + this.bQF + "', onReachBottomDistance='" + this.bQJ + "', sConsole='" + this.bQC + "', initData='" + this.bQK + "', showPerformancePanel=" + this.bQE + ", routeId='" + this.bQL + "', isT7Available=" + this.bQG + ", preloadFile='" + this.bQH + "'}";
    }
}
