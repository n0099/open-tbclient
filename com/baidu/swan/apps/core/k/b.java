package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bQH;
    public boolean bQJ;
    public String bQK;
    public boolean bQL;
    public String bQM;
    public String bQN;
    public String bQO;
    public String bQP;
    public String bQQ;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bQN);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bQK);
        treeMap.put("devhook", bVar.bQH);
        if (!TextUtils.isEmpty(bVar.bQP)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bQP);
            }
            treeMap.put("initData", bVar.bQP);
        }
        if (!TextUtils.isEmpty(bVar.bQO)) {
            treeMap.put("onReachBottomDistance", bVar.bQO);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bQJ));
        if (!TextUtils.isEmpty(bVar.bQQ)) {
            treeMap.put("routeId", bVar.bQQ);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bQL));
        if (!TextUtils.isEmpty(bVar.bQM)) {
            treeMap.put("slavePreload", bVar.bQM);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bQN + "', pageType='" + this.bQK + "', onReachBottomDistance='" + this.bQO + "', sConsole='" + this.bQH + "', initData='" + this.bQP + "', showPerformancePanel=" + this.bQJ + ", routeId='" + this.bQQ + "', isT7Available=" + this.bQL + ", preloadFile='" + this.bQM + "'}";
    }
}
