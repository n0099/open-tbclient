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
    public String cfj;
    public String cfk;
    public boolean cfl;
    public boolean cfm;
    public String cfn;
    public String cfo;
    public String cfp;
    public String cfq;
    public String cfr;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cfo);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cfj);
        if (!TextUtils.isEmpty(bVar.cfq)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cfq);
            }
            treeMap.put("initData", bVar.cfq);
        }
        if (!TextUtils.isEmpty(bVar.cfp)) {
            treeMap.put("onReachBottomDistance", bVar.cfp);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cfl));
        if (!TextUtils.isEmpty(bVar.cfr)) {
            treeMap.put("routeId", bVar.cfr);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cfm));
        if (!TextUtils.isEmpty(bVar.cfn)) {
            treeMap.put("slavePreload", bVar.cfn);
        }
        treeMap.put("root", bVar.cfk);
        com.baidu.swan.apps.ae.g.b.b(treeMap, "page ready event");
        j.f(bVar.cfo, treeMap);
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cfo + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cfp + "', sConsole='" + this.cfj + "', initData='" + this.cfq + "', showPerformancePanel=" + this.cfl + ", routeId='" + this.cfr + "', isT7Available=" + this.cfm + ", preloadFile='" + this.cfn + "', rootPath='" + this.cfk + "'}";
    }
}
