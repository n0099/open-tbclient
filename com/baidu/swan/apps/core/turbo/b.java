package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cPT;
    public String cPU;
    public boolean cPV;
    public boolean cPW;
    public String cPX;
    public String cPY;
    public String cPZ;
    public String cQa;
    public String cQb;
    private String cQc;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cPY);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cPT);
        if (!TextUtils.isEmpty(bVar.cQa)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cQa);
            }
            treeMap.put("initData", bVar.cQa);
        }
        if (!TextUtils.isEmpty(bVar.cPZ)) {
            treeMap.put("onReachBottomDistance", bVar.cPZ);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cPV));
        if (!TextUtils.isEmpty(bVar.cQb)) {
            treeMap.put("routeId", bVar.cQb);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cPW));
        if (!TextUtils.isEmpty(bVar.cPX)) {
            treeMap.put("slavePreload", bVar.cPX);
        }
        treeMap.put("root", bVar.cPU);
        com.baidu.swan.apps.ac.g.b.c(treeMap, "page ready event");
        j.g(bVar.cPY, treeMap);
        bVar.cQc = com.baidu.swan.apps.runtime.config.a.cr(bVar.appPath, ai.delAllParamsFromUrl(j.sK(bVar.cPY)));
        if (!TextUtils.isEmpty(bVar.cQc)) {
            treeMap.put("pageConfig", bVar.cQc);
        }
        com.baidu.swan.apps.core.g.a arZ = d.arI().arZ();
        if (arZ != null) {
            treeMap.put("masterId", arZ.aiJ());
        }
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cPY + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cPZ + "', sConsole='" + this.cPT + "', initData='" + this.cQa + "', showPerformancePanel=" + this.cPV + ", routeId='" + this.cQb + "', isT7Available=" + this.cPW + ", preloadFile='" + this.cPX + "', rootPath='" + this.cPU + "', pageConfig='" + this.cQc + "'}";
    }
}
