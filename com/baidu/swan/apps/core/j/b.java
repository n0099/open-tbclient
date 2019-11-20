package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aND;
    public boolean aNF;
    public String aNG;
    public String aNH;
    public String aNI;
    public String aNz;

    public static com.baidu.swan.apps.m.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.aNz);
        treeMap.put("pagePath", bVar.aNG);
        treeMap.put("devhook", bVar.aND);
        if (!TextUtils.isEmpty(bVar.aNI)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.aNI);
            }
            treeMap.put("initData", bVar.aNI);
        }
        if (!TextUtils.isEmpty(bVar.aNH)) {
            treeMap.put("onReachBottomDistance", bVar.aNH);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.aNF));
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.aNz + "', pagePath='" + this.aNG + "', onReachBottomDistance='" + this.aNH + "'}";
    }
}
