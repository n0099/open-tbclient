package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String auA;
    public String auE;
    public boolean auG;
    public String auH;
    public String auI;
    public String auJ;

    public static com.baidu.swan.apps.m.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.auA);
        treeMap.put("pagePath", bVar.auH);
        treeMap.put("devhook", bVar.auE);
        if (!TextUtils.isEmpty(bVar.auJ)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.auJ);
            }
            treeMap.put("initData", bVar.auJ);
        }
        if (!TextUtils.isEmpty(bVar.auI)) {
            treeMap.put("onReachBottomDistance", bVar.auI);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.auG));
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.auA + "', pagePath='" + this.auH + "', onReachBottomDistance='" + this.auI + "'}";
    }
}
