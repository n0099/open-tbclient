package com.baidu.swan.apps.core.turbo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String appPath;
    public String cgT;
    public String cgU;
    public boolean cgV;
    public boolean cgW;
    public String cgX;
    public String cgY;
    public String cgZ;
    public String cha;
    public String chb;
    public String pageType;

    public static com.baidu.swan.apps.event.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.appPath);
        treeMap.put("pagePath", bVar.cgY);
        treeMap.put(InvokeNewImMessageCenterFragmentConfig.PAGE_TYPE, bVar.pageType);
        treeMap.put("devhook", bVar.cgT);
        if (!TextUtils.isEmpty(bVar.cha)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.cha);
            }
            treeMap.put("initData", bVar.cha);
        }
        if (!TextUtils.isEmpty(bVar.cgZ)) {
            treeMap.put("onReachBottomDistance", bVar.cgZ);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.cgV));
        if (!TextUtils.isEmpty(bVar.chb)) {
            treeMap.put("routeId", bVar.chb);
        }
        treeMap.put("isT7Available", String.valueOf(bVar.cgW));
        if (!TextUtils.isEmpty(bVar.cgX)) {
            treeMap.put("slavePreload", bVar.cgX);
        }
        treeMap.put("root", bVar.cgU);
        com.baidu.swan.apps.ad.g.b.b(treeMap, "page ready event");
        j.g(bVar.cgY, treeMap);
        return new com.baidu.swan.apps.event.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.cgY + "', pageType='" + this.pageType + "', onReachBottomDistance='" + this.cgZ + "', sConsole='" + this.cgT + "', initData='" + this.cha + "', showPerformancePanel=" + this.cgV + ", routeId='" + this.chb + "', isT7Available=" + this.cgW + ", preloadFile='" + this.cgX + "', rootPath='" + this.cgU + "'}";
    }
}
