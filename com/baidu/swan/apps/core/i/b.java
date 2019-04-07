package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
import android.util.Log;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String atk;
    public String ato;
    public String atq;
    public String atr;
    public String ats;

    public static com.baidu.swan.apps.m.a.b a(b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("appPath", bVar.atk);
        treeMap.put("pagePath", bVar.atq);
        treeMap.put("devhook", bVar.ato);
        if (!TextUtils.isEmpty(bVar.ats)) {
            if (DEBUG) {
                Log.d("PageReadyEvent", "add initData: " + bVar.ats);
            }
            treeMap.put("initData", bVar.ats);
        }
        if (!TextUtils.isEmpty(bVar.atr)) {
            treeMap.put("onReachBottomDistance", bVar.atr);
        }
        return new com.baidu.swan.apps.m.a.b("PageReady", treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.atk + "', pagePath='" + this.atq + "', onReachBottomDistance='" + this.atr + "'}";
    }
}
