package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bsi;
    public boolean bsk;
    public String bsl;
    public boolean bsm;
    public String bsn;
    public String bso;
    public String bsp;
    public String bsq;
    public String bsr;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bso);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bsl);
        treeMap.put("devhook", bVar.bsi);
        if (!TextUtils.isEmpty(bVar.bsq)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bsq);
            }
            treeMap.put("initData", bVar.bsq);
        }
        if (!TextUtils.isEmpty(bVar.bsp)) {
            treeMap.put("onReachBottomDistance", bVar.bsp);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bsk));
        if (!TextUtils.isEmpty(bVar.bsr)) {
            treeMap.put("routeId", bVar.bsr);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bsm));
        if (!TextUtils.isEmpty(bVar.bsn)) {
            treeMap.put("slavePreload", bVar.bsn);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bso + "', pageType='" + this.bsl + "', onReachBottomDistance='" + this.bsp + "', sConsole='" + this.bsi + "', initData='" + this.bsq + "', showPerformancePanel=" + this.bsk + ", routeId='" + this.bsr + "', isT7Available=" + this.bsm + ", preloadFile='" + this.bsn + "'}";
    }
}
