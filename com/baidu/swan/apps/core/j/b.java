package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String auc;
    public String aug;
    public boolean aui;
    public String auj;
    public String auk;
    public String aul;

    public static com.baidu.swan.apps.m.a.b b(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.auc);
        treeMap.put("pagePath", bVar.auj);
        treeMap.put("devhook", bVar.aug);
        if (!TextUtils.isEmpty(bVar.aul)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.aul);
            }
            treeMap.put("initData", bVar.aul);
        }
        if (!TextUtils.isEmpty(bVar.auk)) {
            treeMap.put("onReachBottomDistance", bVar.auk);
        }
        treeMap.put("showPerformancePanel", String.valueOf(bVar.aui));
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.auc + "', pagePath='" + this.auj + "', onReachBottomDistance='" + this.auk + "'}";
    }
}
