package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aNR;
    public String aNV;
    public boolean aNX;
    public String aNY;
    public String aNZ;
    public String aOa;

    public static com.baidu.swan.apps.m.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.aNR);
        treeMap.put("pagePath", bVar.aNY);
        treeMap.put("devhook", bVar.aNV);
        if (!TextUtils.isEmpty(bVar.aOa)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.aOa);
            }
            treeMap.put("initData", bVar.aOa);
        }
        if (!TextUtils.isEmpty(bVar.aNZ)) {
            treeMap.put("onReachBottomDistance", bVar.aNZ);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.aNX));
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.aNR + "', pagePath='" + this.aNY + "', onReachBottomDistance='" + this.aNZ + "'}";
    }
}
