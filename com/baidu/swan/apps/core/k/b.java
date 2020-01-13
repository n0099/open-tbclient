package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bnZ;
    public boolean bob;
    public String boc;
    public boolean bod;
    public String boe;
    public String bof;
    public String bog;
    public String boh;
    public String boi;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bof);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.boc);
        treeMap.put("devhook", bVar.bnZ);
        if (!TextUtils.isEmpty(bVar.boh)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.boh);
            }
            treeMap.put("initData", bVar.boh);
        }
        if (!TextUtils.isEmpty(bVar.bog)) {
            treeMap.put("onReachBottomDistance", bVar.bog);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bob));
        if (!TextUtils.isEmpty(bVar.boi)) {
            treeMap.put("routeId", bVar.boi);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bod));
        if (!TextUtils.isEmpty(bVar.boe)) {
            treeMap.put("slavePreload", bVar.boe);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bof + "', pageType='" + this.boc + "', onReachBottomDistance='" + this.bog + "', sConsole='" + this.bnZ + "', initData='" + this.boh + "', showPerformancePanel=" + this.bob + ", routeId='" + this.boi + "', isT7Available=" + this.bod + ", preloadFile='" + this.boe + "'}";
    }
}
