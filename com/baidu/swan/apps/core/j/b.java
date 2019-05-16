package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String atD;
    public boolean atF;
    public String atG;
    public String atH;
    public String atI;
    public String atz;

    public static com.baidu.swan.apps.m.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.atz);
        treeMap.put("pagePath", bVar.atG);
        treeMap.put("devhook", bVar.atD);
        if (!TextUtils.isEmpty(bVar.atI)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.atI);
            }
            treeMap.put("initData", bVar.atI);
        }
        if (!TextUtils.isEmpty(bVar.atH)) {
            treeMap.put("onReachBottomDistance", bVar.atH);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.atF));
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.atz + "', pagePath='" + this.atG + "', onReachBottomDistance='" + this.atH + "'}";
    }
}
