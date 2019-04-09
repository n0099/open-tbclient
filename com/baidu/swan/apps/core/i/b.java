package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String atl;
    public String atp;
    public String atr;
    public String ats;
    public String att;

    public static com.baidu.swan.apps.m.a.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.atl);
        treeMap.put("pagePath", bVar.atr);
        treeMap.put("devhook", bVar.atp);
        if (!TextUtils.isEmpty(bVar.att)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.att);
            }
            treeMap.put("initData", bVar.att);
        }
        if (!TextUtils.isEmpty(bVar.ats)) {
            treeMap.put("onReachBottomDistance", bVar.ats);
        }
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.atl + "', pagePath='" + this.atr + "', onReachBottomDistance='" + this.ats + "'}";
    }
}
