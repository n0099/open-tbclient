package com.baidu.swan.apps.core.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String bnl;
    public boolean bnn;
    public String bno;
    public boolean bnp;
    public String bnq;
    public String bnr;
    public String bns;
    public String bnt;
    public String bnu;

    public static com.baidu.swan.apps.n.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.bnr);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.bno);
        treeMap.put("devhook", bVar.bnl);
        if (!TextUtils.isEmpty(bVar.bnt)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.bnt);
            }
            treeMap.put("initData", bVar.bnt);
        }
        if (!TextUtils.isEmpty(bVar.bns)) {
            treeMap.put("onReachBottomDistance", bVar.bns);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.bnn));
        if (!TextUtils.isEmpty(bVar.bnu)) {
            treeMap.put("routeId", bVar.bnu);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.bnp));
        if (!TextUtils.isEmpty(bVar.bnq)) {
            treeMap.put("slavePreload", bVar.bnq);
        }
        com.baidu.swan.apps.ag.g.b.a(treeMap, (com.baidu.swan.apps.ag.b.a) null, "page ready event");
        return new com.baidu.swan.apps.n.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.bnr + "', pageType='" + this.bno + "', onReachBottomDistance='" + this.bns + "', sConsole='" + this.bnl + "', initData='" + this.bnt + "', showPerformancePanel=" + this.bnn + ", routeId='" + this.bnu + "', isT7Available=" + this.bnp + ", preloadFile='" + this.bnq + "'}";
    }
}
