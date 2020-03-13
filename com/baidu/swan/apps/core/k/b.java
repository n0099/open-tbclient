package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bsk;
    public boolean bsm;
    public String bsn;
    public boolean bso;
    public String bsp;
    public String bsq;
    public String bsr;
    public String bss;
    public String bst;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bsq);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bsn);
        treeMap.put("devhook", bVar.bsk);
        if (!TextUtils.isEmpty(bVar.bss)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bss);
            }
            treeMap.put("initData", bVar.bss);
        }
        if (!TextUtils.isEmpty(bVar.bsr)) {
            treeMap.put("onReachBottomDistance", bVar.bsr);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bsm));
        if (!TextUtils.isEmpty(bVar.bst)) {
            treeMap.put("routeId", bVar.bst);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bso));
        if (!TextUtils.isEmpty(bVar.bsp)) {
            treeMap.put("slavePreload", bVar.bsp);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bsq + "', pageType='" + this.bsn + "', onReachBottomDistance='" + this.bsr + "', sConsole='" + this.bsk + "', initData='" + this.bss + "', showPerformancePanel=" + this.bsm + ", routeId='" + this.bst + "', isT7Available=" + this.bso + ", preloadFile='" + this.bsp + "'}";
    }
}
