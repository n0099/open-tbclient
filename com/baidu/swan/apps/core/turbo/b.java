package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String caA;
    public String caB;
    public String caC;
    public String cat;
    public String cau;
    public boolean cav;
    public String caw;
    public boolean cax;
    public String cay;
    public String caz;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.caz);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.caw);
        treeMap.put("devhook", bVar.cat);
        if (!TextUtils.isEmpty(bVar.caB)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.caB);
            }
            treeMap.put("initData", bVar.caB);
        }
        if (!TextUtils.isEmpty(bVar.caA)) {
            treeMap.put("onReachBottomDistance", bVar.caA);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cav));
        if (!TextUtils.isEmpty(bVar.caC)) {
            treeMap.put("routeId", bVar.caC);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cax));
        if (!TextUtils.isEmpty(bVar.cay)) {
            treeMap.put("slavePreload", bVar.cay);
        }
        treeMap.put("root", bVar.cau);
        com.baidu.swan.apps.ae.g.b.b(treeMap, "page ready event");
        j.f(bVar.caz, treeMap);
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.caz + "', pageType='" + this.caw + "', onReachBottomDistance='" + this.caA + "', sConsole='" + this.cat + "', initData='" + this.caB + "', showPerformancePanel=" + this.cav + ", routeId='" + this.caC + "', isT7Available=" + this.cax + ", preloadFile='" + this.cay + "', rootPath='" + this.cau + "'}";
    }
}
