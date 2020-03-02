package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bsj;
    public boolean bsl;
    public String bsm;
    public boolean bsn;
    public String bso;
    public String bsp;
    public String bsq;
    public String bsr;
    public String bss;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bsp);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bsm);
        treeMap.put("devhook", bVar.bsj);
        if (!TextUtils.isEmpty(bVar.bsr)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bsr);
            }
            treeMap.put("initData", bVar.bsr);
        }
        if (!TextUtils.isEmpty(bVar.bsq)) {
            treeMap.put("onReachBottomDistance", bVar.bsq);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bsl));
        if (!TextUtils.isEmpty(bVar.bss)) {
            treeMap.put("routeId", bVar.bss);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bsn));
        if (!TextUtils.isEmpty(bVar.bso)) {
            treeMap.put("slavePreload", bVar.bso);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bsp + "', pageType='" + this.bsm + "', onReachBottomDistance='" + this.bsq + "', sConsole='" + this.bsj + "', initData='" + this.bsr + "', showPerformancePanel=" + this.bsl + ", routeId='" + this.bss + "', isT7Available=" + this.bsn + ", preloadFile='" + this.bso + "'}";
    }
}
