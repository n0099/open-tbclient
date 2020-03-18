package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public boolean bsA;
    public String bsB;
    public String bsC;
    public String bsD;
    public String bsE;
    public String bsF;
    public String bsw;
    public boolean bsy;
    public String bsz;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bsC);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bsz);
        treeMap.put("devhook", bVar.bsw);
        if (!TextUtils.isEmpty(bVar.bsE)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bsE);
            }
            treeMap.put("initData", bVar.bsE);
        }
        if (!TextUtils.isEmpty(bVar.bsD)) {
            treeMap.put("onReachBottomDistance", bVar.bsD);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bsy));
        if (!TextUtils.isEmpty(bVar.bsF)) {
            treeMap.put("routeId", bVar.bsF);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bsA));
        if (!TextUtils.isEmpty(bVar.bsB)) {
            treeMap.put("slavePreload", bVar.bsB);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bsC + "', pageType='" + this.bsz + "', onReachBottomDistance='" + this.bsD + "', sConsole='" + this.bsw + "', initData='" + this.bsE + "', showPerformancePanel=" + this.bsy + ", routeId='" + this.bsF + "', isT7Available=" + this.bsA + ", preloadFile='" + this.bsB + "'}";
    }
}
